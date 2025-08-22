Mounts your edp-airflow-app-config ConfigMap (your variables).

Reads values from that ConfigMap and syncs them into Airflow Variables.

Injects the metadata DB connection string from your secret edp-airflow-metadata-connection.

✅ Updated CronJob Manifest
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
                    key: connection                        # 👈 replace with actual key inside the secret
            volumeMounts:
              - name: airflow-config
                mountPath: /opt/airflow/config
          volumes:
            - name: airflow-config
              configMap:
                name: edp-airflow-app-config   # your ConfigMap name

🔑 Steps for you

Run:

kubectl get secret edp-airflow-metadata-connection -n <your-namespace> -o yaml


and confirm the key name (likely connection or sql_alchemy_conn).
Update the manifest accordingly.

Apply the CronJob:

kubectl apply -f airflow-variable-sync.yaml


Check if it works:

kubectl get jobs -n <your-namespace>
kubectl logs job/<job-name> -n <your-namespace>
