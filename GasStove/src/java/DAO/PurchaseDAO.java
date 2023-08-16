/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.Order;
import Entity.OrderDetail;
import java.math.BigDecimal;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
/**
 *
 * @author 5580
 */
public class PurchaseDAO extends DBContext {

    public List<OrderDetail> getOrdersyCustomerID(int ID) throws SQLException {
        String sql = "SELECT o.OrderID, o.CustomerID, o.Status, od.ProductID, od.Quantity, od.UnitPrice " +
                       "FROM Orders o INNER JOIN OrderDetails od ON o.OrderID = od.OrderID " +
                       "WHERE o.CustomerID = ?";
        List<OrderDetail> orderlist = new ArrayList<>();
        try ( PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, ID);

            ResultSet rs = statement.executeQuery();
            
            // Loop through the result set and print order details and statuses
            while (rs.next()) {
                int orderId = rs.getInt("OrderID");
                String customerId = rs.getString("CustomerID");
                String status = rs.getString("Status");
                int productId = rs.getInt("ProductID");
                int quantity = rs.getInt("Quantity");
                double unitPrice = rs.getDouble("UnitPrice");
                OrderDetail od = new OrderDetail(orderId, productId, quantity, BigDecimal.valueOf(unitPrice));
                od.setStatus(status);
//                System.out.println("Order ID: " + orderId);
//                System.out.println("Customer ID: " + customerId);
//                System.out.println("Status: " + status);
//                System.out.println("Product ID: " + productId);
//                System.out.println("Quantity: " + quantity);
//                System.out.println("Unit Price: " + unitPrice);
//                System.out.println("--------------------------");
                orderlist.add(od);
            }
            return orderlist;
        }
    }
    
    public List<OrderDetail> getOrdersByOrderID(int ID) throws SQLException{
        String sql = "SELECT o.OrderID, o.CustomerID, o.Status, od.ProductID, od.Quantity, od.UnitPrice " +
                       "FROM Orders o INNER JOIN OrderDetails od ON o.OrderID = od.OrderID " +
                       "WHERE o.OrderID = ?";
        List<OrderDetail> orderlist = new ArrayList<>();
        try ( PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, ID);

            ResultSet rs = statement.executeQuery();
            
            // Loop through the result set and print order details and statuses
            while (rs.next()) {
                int orderId = rs.getInt("OrderID");
                String customerId = rs.getString("CustomerID");
                String status = rs.getString("Status");
                int productId = rs.getInt("ProductID");
                int quantity = rs.getInt("Quantity");
                double unitPrice = rs.getDouble("UnitPrice");
                OrderDetail od = new OrderDetail(orderId, productId, quantity, BigDecimal.valueOf(unitPrice));
                od.setStatus(status);
//                System.out.println("Order ID: " + orderId);
//                System.out.println("Customer ID: " + customerId);
//                System.out.println("Status: " + status);
//                System.out.println("Product ID: " + productId);
//                System.out.println("Quantity: " + quantity);
//                System.out.println("Unit Price: " + unitPrice);
//                System.out.println("--------------------------");
                orderlist.add(od);
            }
            return orderlist;
        }
    }
}
