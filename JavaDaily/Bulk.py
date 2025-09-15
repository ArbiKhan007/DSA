import os
import airflow_client.client
from airflow_client.client.models.bulk_body_variable_body import BulkBodyVariableBody
from airflow_client.client.rest import ApiException
from pprint import pprint

# Configure API client
configuration = airflow_client.client.Configuration(
    host="http://<your-company-airflow-domain>/api/v1"  # <-- Adjust host
)

# ---- Username/Password auth ----
configuration.username = os.environ.get("AIRFLOW_USERNAME", "your-username")
configuration.password = os.environ.get("AIRFLOW_PASSWORD", "your-password")

# Convert all env variables into Airflow variable format
variables = [{"key": k, "value": v} for k, v in os.environ.items()]

# Enter a context with an instance of the API client
with airflow_client.client.ApiClient(configuration) as api_client:
    api_instance = airflow_client.client.VariableApi(api_client)

    bulk_body_variable_body = BulkBodyVariableBody(variables=variables)

    try:
        api_response = api_instance.bulk_variables(bulk_body_variable_body)
        print("✅ Successfully pushed environment variables to Airflow")
        pprint(api_response)
    except ApiException as e:
        print("❌ Exception when calling VariableApi->bulk_variables: %s\n" % e)
