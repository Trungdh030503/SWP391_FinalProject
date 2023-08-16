import pyodbc
import csv
server = 'DESKTOP-6NERDOS'
database = 'SaleGasStovesOnline'
username = 'sa'
password = '123'

driver = '{ODBC Driver 17 for SQL Server}'

conn_str = f"DRIVER={driver};SERVER={server};DATABASE={database};UID={username};PWD={password}"
connection = pyodbc.connect(conn_str)

cursor = connection.cursor()

csv_file = 'bepdientu.csv'

with open(csv_file, 'r', encoding='utf-8') as file:
    reader = csv.reader(file)
    next(reader)  # Skip the header row
    query = "SELECT CategoryID FROM Categories WHERE SubCategoryName = ?"
    
    # Iterate over the rows and insert data into the table
    for row in reader:
        # ...
        title = row[1]
        image_url = f'img/{row[8]}'
        
        # Prepare the SQL INSERT statement
        # insert_query = '''
        #     INSERT INTO [dbo].[Products] ([ProductName], [Brand], [UnitPrice], [CategoryID], [WarrantyPeriod], [ModelNumber], [Description], [ImageURL], [CreatedDate], [CreatedBy], [Stock], [SaleOff])
        #     VALUES (?, ?, ?, ?, ?, ?, ?, ?, GETDATE(), 'Admin', ?, ?)
        # '''
        # Execute the INSERT statement

        # Update the image_url for the inserted record
        update_query = '''
            UPDATE [dbo].[Products]
            SET [ImageURL] = ?
            WHERE [ProductName] = ?
        '''
        # Execute the UPDATE statement
        cursor.execute(update_query, (image_url, title))
        connection.commit()

# Close the cursor and connection
cursor.close()
connection.close()