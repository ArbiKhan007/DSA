Airflow Variable Sync via Kubernetes CronJob

This guide explains how to sync Airflow Variables from a Kubernetes ConfigMap into your Airflow instance automatically, using a CronJob.

📌 Why?

Airflow UI → Variables must be created manually.

We already store variables in a ConfigMap (edp-airflow-app-config).

We want to automate syncing ConfigMap → Airflow Variables UI.

This CronJob:

Mounts your edp-airflow-app-config ConfigMap (your variables).

Reads key/value pairs from the ConfigMap.

Inserts them into Airflow Variables using the Airflow CLI.

Connects to the Airflow metadata DB via secret edp-airflow-metadata-connection.

🛠️ Prerequisites

Airflow deployed on Kubernetes (with metadata DB reachable).

ConfigMap containing your variables, e.g.:

apiVersion: v1
kind: ConfigMap
metadata:
  name: edp-airflow-app-config
  namespace: <your-namespace>
data:
  VAR1: "value1"
  VAR2: "value2"


Secret containing DB connection, e.g.:

apiVersion: v1
kind: Secret
metadata:
  name: edp-airflow-metadata-connection
  namespace: <your-namespace>
stringData:
  connection: postgresql+psycopg2://airflow:password@postgres-service:5432/airflow

📋 CronJob Manifest

Save this as airflow-variable-sync.yaml:

apiVersion: batch/v1
kind: CronJob
metadata:
  name: airflow-variable-sync
  namespace: <your-namespace>
spec:
  # Run every 6 hours (adjust as needed)
  schedule: "0 */6 * * *"
  jobTemplate:
    spec:
      template:
        spec:
          restartPolicy: OnFailure
          containers:
          - name: variable-sync
            image: apache/airflow:2.9.0   # match your Airflow version
            command: ["/bin/bash", "-c"]
            args:
              - |
                echo "Syncing ConfigMap variables into Airflow..."
                for file in /opt/airflow/config/*; do
                  key=$(basename $file)
                  value=$(cat $file)
                  echo "Setting variable: $key"
                  airflow variables set "$key" "$value"
                done
                echo "✅ Sync complete"
            env:
              - name: AIRFLOW__CORE__SQL_ALCHEMY_CONN
                valueFrom:
                  secretKeyRef:
                    name: edp-airflow-metadata-connection   # your secret
                    key: connection                        # 👈 confirm key name
            volumeMounts:
              - name: airflow-config
                mountPath: /opt/airflow/config
          volumes:
            - name: airflow-config
              configMap:
                name: edp-airflow-app-config   # your ConfigMap name

🚀 Deployment

Verify your secret contains the right key:

kubectl get secret edp-airflow-metadata-connection -n <your-namespace> -o yaml


Update key: connection if needed.

Apply the CronJob:

kubectl apply -f airflow-variable-sync.yaml


Check if job runs:

kubectl get jobs -n <your-namespace>
kubectl logs job/<job-name> -n <your-namespace>

✅ Verification

Go to Airflow UI → Admin → Variables.

You should see variables like VAR1, VAR2 from your ConfigMap.

🔄 Notes

Adjust schedule: "0 */6 * * *" for your desired sync frequency.

If Airflow uses RBAC / network policies, ensure this job can access the metadata DB.

This job overwrites variables in Airflow if the same key exists in the ConfigMap.
