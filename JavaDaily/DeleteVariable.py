from airflow.models import Variable

def delete_all_ui_variables():
    """
    Deletes all Airflow Variables visible in the UI.
    (This only affects variables stored in the metadata DB,
    not system environment variables.)
    """
    all_vars = Variable.get_all()
    print(f"Found {len(all_vars)} UI variables.")

    for key in list(all_vars.keys()):
        try:
            Variable.delete(key)
            print(f"🗑️ Removed from UI: {key}")
        except Exception as e:
            print(f"⚠️ Could not delete {key}: {e}")

    print("🎉 All variables removed from Airflow UI.")


if __name__ == "__main__":
    delete_all_ui_variables()
