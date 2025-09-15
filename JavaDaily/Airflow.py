import os
import requests
from requests.auth import HTTPBasicAuth

# Airflow API configuration
AIRFLOW_BASE_URL = os.getenv("AIRFLOW_BASE_URL", "http://localhost:8080/api/v1")
AIRFLOW_USERNAME = os.getenv("AIRFLOW_USERNAME", "admin")
AIRFLOW_PASSWORD = os.getenv("AIRFLOW_PASSWORD", "admin")

def push_all_env_vars():
    url = f"{AIRFLOW_BASE_URL}/variables"
    headers = {"Content-Type": "application/json"}
    
    # Build actions payload
    actions = [
        {
            "action": "create",
            "entities": [{"key": key, "value": value}],
            "action_on_existence": "update"  # update if exists
        }
        for key, value in os.environ.items()
        if not key.startswith("AIRFLOW_") and not key.startswith("_")
    ]

    payload = {"actions": actions}

    response = requests.patch(
        url,
        headers=headers,
        json=payload,
        auth=HTTPBasicAuth(AIRFLOW_USERNAME, AIRFLOW_PASSWORD)
    )

    if response.ok:
        print(f"✅ Successfully synced {len(actions)} environment variables to Airflow")
    else:
        print(f"❌ Failed: {response.status_code}, {response.text}")


if __name__ == "__main__":
    push_all_env_vars()
