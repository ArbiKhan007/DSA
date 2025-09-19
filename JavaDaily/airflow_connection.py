import os
import logging
from typing import Optional
from airflow_client.client.configuration import Configuration
from airflow_client.client.api_client import ApiClient


# -----------------------------
# Configure Logging
# -----------------------------
logging.basicConfig(
    level=logging.INFO,
    format="%(asctime)s [%(levelname)s] %(name)s - %(message)s",
)
logger = logging.getLogger("AirflowClient")


class AirflowConnectionClass:
    """
    Responsible only for creating and returning an Airflow ApiClient.
    """

    def __init__(
        self,
        host: Optional[str] = None,
        username: Optional[str] = None,
        password: Optional[str] = None,
        insecure: bool = False,
        timeout_seconds: int = 60,
        debug: bool = False
    ):
        self.host = host or os.getenv("AIRFLOW_BASE_URL", "http://localhost:8080/api/v1")
        self.username = username or os.getenv("AIRFLOW_USER", "admin")
        self.password = password or os.getenv("AIRFLOW_PASSWORD", "admin")
        self.insecure = insecure
        self.timeout_seconds = timeout_seconds
        self.debug = debug

    def get_client(self) -> ApiClient:
        """
        Returns an authenticated Airflow API client.
        """
        cfg = Configuration(
            host=self.host,
            username=self.username,
            password=self.password
        )
        cfg.verify_ssl = not self.insecure
        cfg.client_side_validation = True
        cfg.debug = self.debug

        logger.info("Creating Airflow client for host=%s", self.host)
        return ApiClient(configuration=cfg)
