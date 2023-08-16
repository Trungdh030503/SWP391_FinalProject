/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.CartItem;
import Entity.Customer;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DUC ANH
 */
public class CartDAO extends DBContext {
    
    public void updateCartItem(CartItem item, int customerID) {
    try {
        String sql = "UPDATE Cart SET quantity = ?, unitPrice = ?, totalPrice = ? WHERE CustomerID = ? AND productID = ?";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.setInt(1, item.getQuantity());
        ps.setBigDecimal(2, item.getUnitPrice());
        ps.setInt(3, item.getTotalPrice().intValue());
        ps.setInt(4, customerID);
        ps.setInt(5 , Integer.parseInt(item.getProductID().trim()));
        ps.executeUpdate();
        ps.close();
    } catch (SQLException ex) {
        Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
}

    public void addToCart(CartItem item, int customerID) {
        try {
            String sql = "INSERT INTO Cart (CustomerID, productID, quantity, unitPrice, totalPrice) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, customerID);
            ps.setInt(2, Integer.parseInt(item.getProductID().trim()));
            ps.setInt(3, item.getQuantity());
            ps.setBigDecimal(4, item.getUnitPrice());
            ps.setInt(5, item.getTotalPrice().intValue());
            ps.execute();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void removeFromCart(String productID, int customerID) throws SQLException {
        String query = "DELETE FROM Cart WHERE productID = ? AND CustomerID = ?";
        try ( PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, Integer.parseInt(productID.trim()));
            statement.setInt(2, customerID);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
 

    public List<CartItem> getCartItemsByCustomer(String customerID) throws SQLException {
        String query = " SELECT p.ProductName, c.quantity, c.unitPrice, c.totalPrice, p.ProductID FROM Cart c left outer join Products p ON p.ProductID = c.productID where c.CustomerID = ?";
        List<CartItem> cartItems = new ArrayList<>();
        try ( PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, Integer.parseInt(customerID.trim()));
            try ( ResultSet rs = statement.executeQuery()) {
                while (rs.next()) {
                    int productID = rs.getInt("ProductID");
                    String productName = rs.getString("ProductName");
                    int quantity = rs.getInt("quantity");
                    BigDecimal unitPrice = rs.getBigDecimal("unitPrice");
                    BigDecimal totalPrice = new BigDecimal(rs.getInt("totalPrice"));

                    // Tạo đối tượng CartItem và gán giá trị từ ResultSet
                    CartItem item = new CartItem();
                    item.setProductID(productID + "");
                    item.setQuantity(quantity);
                    item.setUnitPrice(unitPrice);
                    item.setTotalPrice(totalPrice);
                    item.setProductName(productName);
                    cartItems.add(item);
                }
                rs.close();
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            return cartItems;
        }
    }
}
