import pyodbc
import csv
server = 'DESKTOP-6NERDOS'
database = 'SaleGasStovesOnline'
username = 'sa'
password = '123'

driver = '{ODBC Driver 17 for SQL Server}'

conn_str = f"DRIVER={driver};SERVER={server};DATABASE={database};UID={username};PWD={password}"
conn = pyodbc.connect(conn_str)

# cursor = connection.cursor()

# csv_file = 'bepdientu.csv'

# Create a cursor object to execute SQL queries
cursor = conn.cursor()

# Execute the UPDATE statement to set all stock values to 0
update_query = "UPDATE Products SET Stock = 0"
cursor.execute(update_query)

# Commit the changes to the database
conn.commit()

# Close the cursor and connection
cursor.close()
conn.close()