import csv

# Open the CSV file
with open('data1.csv', 'r', encoding='utf-8') as file:
    # Create a CSV reader object
    reader = csv.reader(file)

    # Skip the header row if it exists
    next(reader)

    # Create an empty set to store unique suppliers
    unique_suppliers = set()

    # Iterate over each row and add the supplier to the set
    for row in reader:
        supplier = row[2]  # Assuming the supplier column is at index 2 (adjust accordingly)
        unique_suppliers.add(supplier)

    # Print the unique supplier values
    for supplier in unique_suppliers:
        print(supplier)