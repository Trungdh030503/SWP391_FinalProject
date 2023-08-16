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

csv_file = 'beptu.csv'

with open(csv_file, 'r', encoding='utf-8') as file:
    reader = csv.reader(file)
    next(reader)  # Skip the header row
    query = "SELECT CategoryID FROM Categories WHERE SubCategoryName = ?"
    
    # Iterate over the rows and insert data into the table
    for row in reader:
        cursor.execute(query, row[4])
        category = cursor.fetchone()[0]
        title = row[1]
        brand = row[2]
        unit_price = row[3].replace('₫', '').replace('.', '')
        # category_id = row.CategoryID
        warranty = row[5]
        modelnumber = row[6]
        description = row[7]
        # img = row[8]
        image_url = f'img/img_{row[8]}'
        stock = 99
        saleoff = 0
        # print(data)
        # Prepare the SQL INSERT statement
        insert_query = '''
            INSERT INTO [dbo].[Products] ([ProductName], [Brand], [UnitPrice], [CategoryID], [WarrantyPeriod], [ModelNumber], [Description], [ImageURL], [CreatedDate], [CreatedBy], [Stock], [SaleOff])
            VALUES (?, ?, ?, ?, ?, ?, ?, ?, GETDATE(), 'Admin', ?, ?)
        '''
        # # Execute the INSERT statement
        cursor.execute(insert_query, (title, brand, unit_price, category, warranty, modelnumber, description, image_url, stock, saleoff))
        connection.commit()

# Close the cursor and connection
cursor.close()
connection.close()