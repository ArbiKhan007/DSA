from airflow.models import Variable

def delete_all_airflow_variables():
    """
    Deletes ALL Airflow Variables.
    ⚠️ WARNING: This will permanently remove all stored variables.
    """
    all_vars = Variable.get_all()
    print(f"Found {len(all_vars)} variables. Deleting...")

    for key in all_vars.keys():
        try:
            Variable.delete(key)
            print(f"✅ Deleted variable: {key}")
        except Exception as e:
            print(f"⚠️ Could not delete {key}: {e}")

    print("🎉 All variables deleted successfully.")


if __name__ == "__main__":
    delete_all_airflow_variables()
