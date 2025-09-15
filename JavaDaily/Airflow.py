import os
import requests
from requests.auth import HTTPBasicAuth

# Airflow API configuration
AIRFLOW_BASE_URL = os.getenv("AIRFLOW_BASE_URL", "http://localhost:8080/api/v1")
AIRFLOW_USERNAME = os.getenv("AIRFLOW_USERNAME", "admin")
AIRFLOW_PASSWORD = os.getenv("AIRFLOW_PASSWORD", "admin")

def set_airflow_variable(key: str, value: str):
    url = f"{AIRFLOW_BASE_URL}/variables"
    headers = {"Content-Type": "application/json"}
    payload = {
        "key": key,
        "value": value
    }

    response = requests.post(
        url,
        headers=headers,
        json=payload,
        auth=HTTPBasicAuth(AIRFLOW_USERNAME, AIRFLOW_PASSWORD)
    )

    if response.status_code == 409:
        # Variable already exists → update it
        update_url = f"{url}/{key}"
        response = requests.patch(
            update_url,
            headers=headers,
            json={"value": value},
            auth=HTTPBasicAuth(AIRFLOW_USERNAME, AIRFLOW_PASSWORD)
        )

    if response.ok:
        print(f"✅ Airflow variable set: {key}={value}")
    else:
        print(f"❌ Failed to set {key}: {response.status_code}, {response.text}")


if __name__ == "__main__":
    for key, value in os.environ.items():
        # Skip Airflow’s own config/env variables if you don’t want to overwrite them
        if key.startswith("AIRFLOW_"):
            continue

        set_airflow_variable(key, value)
