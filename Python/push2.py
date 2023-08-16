import pandas as pd
import pyodbc

# Read the CSV file into a pandas DataFrame
csv_file_path = 'beptu.csv'
df = pd.read_csv(csv_file_path)

# Extract the unique categories
unique_categories = df['Category'].unique()

print(unique_categories)

server = 'DESKTOP-6NERDOS'
database = 'SaleGasStovesOnline'
username = 'sa'
password = '123'

driver = '{ODBC Driver 17 for SQL Server}'

conn_str = f"DRIVER={driver};SERVER={server};DATABASE={database};UID={username};PWD={password}"
conn = pyodbc.connect(conn_str)

cursor = conn.cursor()


# # Insert rows with unique categories into the new table
insert_query = "INSERT INTO Categories (CategoryName, SubCategoryName) VALUES (?, ?)"
# select_query = "SELECT * FROM Category WHERE category = ?"

for category in unique_categories:
    # Check if the category already exists in the new table
    # cursor.execute(select_query, category)
    # if cursor.fetchone() is None:
        # Insert the rows with the unique category into the new table
    # category_rows = df[df['Category'] == category]
    # for _, row in category_rows.iterrows():
    cursor.execute(insert_query, 'Bếp từ', category)
    
    # Optionally, you can commit the changes after each category if desired
    conn.commit()

# # Close the cursor and connection
cursor.close()
conn.close()