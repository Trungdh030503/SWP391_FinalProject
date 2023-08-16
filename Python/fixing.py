import pandas as pd

# Đọc tệp CSV vào DataFrame

# Đọc tệp CSV vào DataFrame
df = pd.read_csv('beptu.csv')
columns_to_check = ['Title']  # Thay thế bằng các cột bạn muốn kiểm tra
df.drop_duplicates(subset=columns_to_check, inplace=True)

# Ghi DataFrame đã xóa dòng trùng vào tệp CSV

df.to_csv('du_lieu_moi.csv', index=False)