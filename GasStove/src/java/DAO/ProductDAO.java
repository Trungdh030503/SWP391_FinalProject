/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.Product;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 5580
 */
public class ProductDAO extends DBContext {

    public static Product fromResultSet(ResultSet rs) throws SQLException {
        int productID = rs.getInt("ProductID");
        String productName = rs.getString("ProductName");
        int categoryID = rs.getInt("CategoryID");
        double unitPrice = rs.getDouble("UnitPrice");
        String description = rs.getString("Description");
        String brand = rs.getString("Brand");
        String modelNumber = rs.getString("ModelNumber");
        String warrantyPeriod = rs.getString("WarrantyPeriod");
        String imageURL = rs.getString("ImageURL");
        Date createdDate = rs.getDate("CreatedDate");
        Date modifiedDate = rs.getDate("ModifiedDate");
        String createdBy = rs.getString("CreatedBy");
        String modifiedBy = rs.getString("ModifiedBy");
        int stock = rs.getInt("Stock");
        int saleoff = rs.getInt("SaleOff");

        return new Product(productID, productName, categoryID, unitPrice, description,
                modelNumber, imageURL, createdDate, modifiedDate, createdBy, modifiedBy, brand, warrantyPeriod, stock, saleoff);
    }

    public Product getProductById(int productId) {
        String query = "SELECT * FROM Products WHERE ProductID = ?";
        Product product = null;

        try (
                 PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, productId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                product = this.fromResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    public Product getProductByName(String productName) {
        String query = "SELECT * FROM Products WHERE ProductName = ?";
        Product product = null;

        try (
                 PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, productName);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                product = this.fromResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    public Product getProductByCode(String productCode) {
        String query = "SELECT * FROM products WHERE LOWER(REPLACE(ProductName, ' ', '-')) COLLATE Latin1_General_CI_AI  LIKE ?";
        Product product = null;

        try (
                 PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, "%" + productCode.toLowerCase() + "%");
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                product = this.fromResultSet(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    public List<String> getBrandList() {
        String query = "SELECT DISTINCT Brand FROM Products;";
        List<String> brands = new ArrayList<>();

        try (
                 PreparedStatement stmt = connection.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String brand = rs.getString("brand");
                brands.add(brand);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return brands;
    }

    public List<Product> getProductsByCategoryID(int categoryID) {
        String query = "SELECT * FROM Products WHERE CategoryID = ?";
        List<Product> products = new ArrayList<>();

        try (
                 PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, categoryID);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Product product = this.fromResultSet(rs);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }

    public List<Product> getProductsByCategoryName(int categoryID) {
        String query = "SELECT p.ProductID, p.ProductName, p.CategoryID, p.UnitPrice, p.Description, p.ModelNumber, "
                + "p.ImageURL, p.CreatedDate, p.ModifiedDate, p.CreatedBy, p.ModifiedBy, p.Brand, p.WarrantyPeriod, "
                + "p.Stock, p.SaleOff "
                + "FROM Products p\n"
                + "JOIN Categories c ON p.CategoryID = c.CategoryID\n"
                + "WHERE c.CategoryName = (SELECT CategoryName FROM Categories WHERE CategoryID = ?)";
        List<Product> products = new ArrayList<>();

        try (
                 PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, categoryID);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Product product = this.fromResultSet(rs);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }

    public List<Product> getProductsByBrand(String brand) {
        String query = "SELECT * FROM Products WHERE Brand = ?";
        List<Product> products = new ArrayList<>();

        try (
                 PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, brand);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Product product = this.fromResultSet(rs);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }

    public List<Product> getProductsByPrice(double maxPrice) {
        String query = "SELECT * FROM Products WHERE UnitPrice < ?";
        List<Product> products = new ArrayList<>();

        try (
                 PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setDouble(1, maxPrice);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Product product = this.fromResultSet(rs);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }

    public List<Product> getAllProducts() {
        String query = "SELECT * FROM Products";
        List<Product> products = new ArrayList<>();

        try (
                 PreparedStatement stmt = connection.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Product product = this.fromResultSet(rs);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }

//    public static void main(String[] args) {
//        DBContext db = new DBContext();
//        System.out.println(db.connection);
//        ProductDAO pd = new ProductDAO();
////        List<Product> list =
//        Product p = pd.getProductByCode("bep-ga-am-rinnai-rvb6sdq(b)");
////        for (Product p : list) {
////            System.out.println(p.getProductName());
////        }
//        System.out.println(p.getCategoryID());
//    }
    public void updateProduct(Product p) {
        try {
            String sql = "UPDATE [Products]\n"
                    + "   SET [ProductName] = ?\n"
                    + "      ,[ModelNumber] = ?\n"
                    + "      ,[CategoryID] = ?\n"
                    + "      ,[UnitPrice] = ?\n"
                    + "      ,[Description] = ?\n"
                    + "      ,[ImageURL] = ?\n"
                    + "      ,[ModifiedDate] = GETDATE() \n"
                    + "      ,[ModifiedBy] = ?\n"
                    + "      ,[Brand] = ?\n"
                    + "      ,[WarrantyPeriod] = ?\n"
                    + "      ,[Stock] = ?\n"
                    + "      ,[SaleOff] = ?\n"
                    + " WHERE ProductID= ?";

//            System.out.println(p.toString());
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, p.getProductName());
            stm.setString(2, p.getModelNumber());
            stm.setInt(3, p.getCategoryID());
            stm.setDouble(4, p.getPrice());
            stm.setString(5, p.getDescription());
//            stm.setString(6, p.getModelNumber());
            stm.setString(6, p.getImageURL());
//            stm.setDate(7, "GETDATE()");
//            stm.setDate(7, "GETDATE()");
            stm.setString(7, "admin");
            stm.setString(8, p.getBrand());
            stm.setString(9, p.getWarrantyPeriod());
            stm.setInt(10, p.getStock());
            stm.setInt(11, p.getSaleoffPercent());
            stm.setInt(12, p.getProductID());
            stm.executeUpdate();
//            System.out.println(stm);
            System.out.println("update successfully");
        } catch (SQLException ex) {
            System.out.println("update failed");
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<String> getProductSuggestions(String keyword) {
        List<String> suggestions = new ArrayList<>();

        try {
            String sql = "SELECT ProductName FROM Products WHERE ProductName LIKE ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + keyword + "%");
            ResultSet resultSet = statement.executeQuery();
            int count = 0;
            while (resultSet.next() && count < 10) {
                String suggestion = resultSet.getString("ProductName");
                suggestions.add(suggestion);
                count++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return suggestions;
    }

    public List<Product> getSearch(String keyword) {
        List<Product> products = new ArrayList<>();

        try {
            String sql = "SELECT * FROM Products WHERE ProductName LIKE ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, "%" + keyword + "%");
            ResultSet resultSet = statement.executeQuery();
            int count = 0;
            while (resultSet.next()) {
                Product product = fromResultSet(resultSet);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }

    public List<Product> getProductsByCategory(String categoryName) {
        List<Product> products = new ArrayList<>();

        try {
            String sql = "SELECT p.ProductID, p.ProductName, p.CategoryID, p.UnitPrice, p.Description, p.ModelNumber, "
                    + "p.ImageURL, p.CreatedDate, p.ModifiedDate, p.CreatedBy, p.ModifiedBy, p.Brand, p.WarrantyPeriod, "
                    + "p.Stock, p.SaleOff "
                    + "FROM Products p "
                    + "JOIN Categories c ON p.CategoryID = c.CategoryID "
                    + "WHERE c.CategoryName = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, categoryName);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Product product = fromResultSet(resultSet);
                products.add(product);
            }

        } catch (SQLException ex) {
            // Handle any potential errors here 
            ex.printStackTrace();
        }

        return products;
    }

    public void deleteProduct(int id) {
        try {
            String sql = "DELETE FROM Products WHERE ProductID = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Product with ID " + id + " has been deleted successfully.");
            } else {
                System.out.println("Product with ID " + id + " does not exist or could not be deleted.");
            }
        } catch (SQLException ex) {
            // Handle any potential errors here
            ex.printStackTrace();
        }
    }

    public void insertProduct(Product product) {
        try {
            String sql = "INSERT INTO products (ProductName, CategoryID, UnitPrice, Description, ModelNumber, ImageURL, CreatedBy, Brand, WarrantyPeriod, Stock, SaleOff) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, product.getProductName());
            stmt.setInt(2, product.getCategoryID());
            stmt.setDouble(3, product.getPrice());
            stmt.setString(4, product.getDescription());
            stmt.setString(5, product.getModelNumber());
            stmt.setString(6, product.getImageURL());
            stmt.setString(7, "admin");
            stmt.setString(8, product.getBrand());
            stmt.setString(9, product.getWarrantyPeriod());
            stmt.setInt(10, product.getStock());
            stmt.setInt(11, product.getSaleoffPercent());

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Product inserted successfully.");
            } else {
                System.out.println("Failed to insert the product.");
            }
        } catch (SQLException ex) {
            // Handle any potential errors here
            ex.printStackTrace();
        }
    }

    public int insertnewProduct(Product product) {
        int index = -1;
        try {
            String sql = "INSERT INTO products (ProductName, CategoryID, UnitPrice, Description, ModelNumber, ImageURL, CreatedBy, Brand, WarrantyPeriod, Stock, SaleOff) "
                    + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, product.getProductName());
            stmt.setInt(2, product.getCategoryID());
            stmt.setDouble(3, product.getPrice());
            stmt.setString(4, product.getDescription());
            stmt.setString(5, product.getModelNumber());
            stmt.setString(6, product.getImageURL());
            stmt.setString(7, "admin");
            stmt.setString(8, product.getBrand());
            stmt.setString(9, product.getWarrantyPeriod());
            stmt.setInt(10, product.getStock());
            stmt.setInt(11, product.getSaleoffPercent());

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                ResultSet generatedKeys = stmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int insertedIndex = generatedKeys.getInt(1);
                    index = insertedIndex;
                    System.out.println("Product inserted successfully. Inserted index: " + insertedIndex);
                }
            } else {
                System.out.println("Failed to insert the product.");
            }
        } catch (SQLException ex) {
            // Handle any potential errors here
            ex.printStackTrace();
        }
        return index;
    }

    public void generateSerialNumber(Product p, int amount) {
        String sql = "Select count(*) from ProductInstances where productID = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, p.getProductID());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                String insert = "INSERT INTO ProductInstances (ProductID, SerialNumber) VALUES (?, ?)";
                for (int i = count; i <= (amount + count); i++) {
                    PreparedStatement insertStmt = connection.prepareStatement(insert); // Create a new statement inside the loop
                    insertStmt.setInt(1, p.getProductID());
                    insertStmt.setString(2, p.getModelNumber().concat("-").concat(String.valueOf(i))); // Convert integer to string
                    int rowsAffected = insertStmt.executeUpdate();
                    if (rowsAffected > 0) {
                        System.out.println("Product Instance inserted successfully.");
                    } else {
                        System.out.println("Failed to insert the product instance.");
                    }
                    insertStmt.close(); // Close the statement after use
                }
            }
            rs.close();
            stmt.close();
        } catch (Exception e) {
            System.out.println("Del insert duoc");
        }
    }
}
