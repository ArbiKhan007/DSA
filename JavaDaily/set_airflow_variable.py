import logging
from airflow_client.client.api.variable_api import VariableApi
from airflow_client.client.model.variable import Variable
from airflow_client import AirflowClient


# -----------------------------
# Configure Logging
# -----------------------------
logging.basicConfig(
    level=logging.INFO,
    format="%(asctime)s [%(levelname)s] %(name)s - %(message)s",
)
logger = logging.getLogger("AirflowVariableManager")


class AirflowVariableManager:
    """
    Handles creation, update, and listing of Airflow variables.
    """

    def __init__(self, api_client):
        self.variable_api = VariableApi(api_client)

    def create_or_update_variable(self, key: str, value: str) -> None:
        var_obj = Variable(key=key, value=value)
        try:
            self.variable_api.post_variables(var_obj)
            logger.info("Created variable: %s", key)
        except Exception:
            try:
                self.variable_api.patch_variable(key, var_obj)
                logger.info("Updated variable: %s", key)
            except Exception as e:
                logger.error("Failed to create/update variable %s: %s", key, e)

    def bulk_create_or_update_variables(self, variables: dict) -> None:
        for key, value in variables.items():
            self.create_or_update_variable(key, str(value))

    def list_variables(self, limit: int = 100) -> list:
        try:
            result = self.variable_api.get_variables(limit=limit)
            keys = [v.key for v in result.variables]
            logger.info("Variables found: %s", keys)
            return keys
        except Exception as e:
            logger.error("Error listing variables: %s", e)
            return []


# -----------------------------
# Example Usage
# -----------------------------
if __name__ == "__main__":
    airflow_client = AirflowClient(
        host="https://airflow.mycompany.com/api/v1",
        username="admin",
        password="admin",
        insecure=True,
        debug=True
    )

    client = airflow_client.get_client()
    manager = AirflowVariableManager(client)

    # Create or update single variable
    manager.create_or_update_variable("MY_TEST_KEY", "12345")

    # Bulk update
    manager.bulk_create_or_update_variables({
        "ENV": "prod",
        "MAX_RETRIES": "5"
    })

    # List variables
    manager.list_variables(limit=10)
