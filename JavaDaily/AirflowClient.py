import os
import logging
from typing import Optional, Dict, List
from airflow_client.client.configuration import Configuration
from airflow_client.client.api_client import ApiClient
from airflow_client.client.api.variable_api import VariableApi
from airflow_client.client.model.variable import Variable



logging.basicConfig(
    level=logging.INFO,
    format="%(asctime)s [%(levelname)s] %(name)s - %(message)s",
)
logger = logging.getLogger("AirflowClient")


class AirflowClient:
    def __init__(
        self,
        host: Optional[str] = None,
        username: Optional[str] = None,
        password: Optional[str] = None,
        insecure: bool = False,
        timeout_seconds: int = 60,
        debug: bool = False
    ):
        """
        Initialize reusable Airflow client.
        """
        base_url = host or os.getenv("AIRFLOW_BASE_URL", "http://localhost:8080/api/v1")
        username = username or os.getenv("AIRFLOW_USER", "admin")
        password = password or os.getenv("AIRFLOW_PASSWORD", "admin")

        cfg = Configuration(
            host=base_url,
            username=username,
            password=password
        )

        cfg.verify_ssl = not insecure
        cfg.client_side_validation = True
        cfg.debug = debug

        self.api_client = ApiClient(configuration=cfg)
        self.username = username
        self.password = password
        self.variable_api = VariableApi(self.api_client)

        logger.info("Initialized AirflowClient with host=%s", base_url)

    # -----------------------------
    # Variables API
    # -----------------------------
    def create_or_update_variable(self, key: str, value: str) -> None:
        """
        Create or update a single Airflow variable.
        """
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

    def bulk_create_or_update_variables(self, variables: Dict[str, str]) -> None:
        """
        Create or update multiple variables.
        """
        for key, value in variables.items():
            self.create_or_update_variable(key, str(value))

    def list_variables(self, limit: int = 100) -> List[str]:
        """
        List variable keys.
        """
        try:
            result = self.variable_api.get_variables(limit=limit)
            keys = [v.key for v in result.variables]
            logger.info("Variables found: %s", keys)
            return keys
        except Exception as e:
            logger.error("Error listing variables: %s", e)
            return []

