import os
import logging
from airflow_client.client.api.variable_api import VariableApi
from airflow_client.client.exceptions import ApiException
from airflow_client.client.model.variable import Variable
from airflow_connection import AirflowConnectionClass
from concurrent.futures import ThreadPoolExecutor, as_completed


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

    def create_or_update_variable(self, key: str, value: str) -> bool:
        var_obj = Variable(key=key, value=value)
        try:
            self.variable_api.post_variables(var_obj)
            logger.info("Created variable: %s", key)
            return True
        except ApiException:
            try:
                self.variable_api.patch_variable(key, var_obj)
                logger.info("Updated variable: %s", key)
                return True
            except ApiException as e:
                logger.error("Failed to create/update variable %s: %s", key, e)
                return False

    def bulk_create_or_update_variables(self, variables: dict) -> None:
         with ThreadPoolExecutor(max_workers=max_workers) as executor:
            futures = {
                executor.submit(self.create_or_update_variable, key, str(value)): key
                for key, value in variables.items()
            }
            for future in as_completed(futures):
                key = futures[future]
                try:
                    future.result()
                except Exception as e:
                    logger.error("Error syncing variable %s: %s", key, e)


    def list_variables(self, limit: int = 100) -> list[str]:
        try:
            result = self.variable_api.get_variables(limit=limit)
            keys = [v.key for v in result.variables]
            logger.info("Variables found: %s", keys)
            return keys
        except ApiException as e:
            logger.error("Error listing variables: %s", e)
            return []

    def sync_env_variables_to_airflow(self) -> None:
        """
        Reads all OS environment variables and syncs them to Airflow variables.
        """
        env_vars = dict(os.environ)
        logger.info("Syncing %d environment variables to Airflow", len(env_vars))
        self.bulk_create_or_update_variables(env_vars)


# -----------------------------
# Example Usage
# -----------------------------
if __name__ == "__main__":
    airflow_client = AirflowConnectionClass(
        host="https://airflow.mycompany.com/api/v1",
        username="admin",
        password="admin",
        insecure=True,
        debug=True
    )

    client = airflow_client.get_client()
    manager = AirflowVariableManager(client)

    manager.sync_env_variables_to_airflow()
