/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.Order;
import Entity.OrderDetail;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 5580
 */
public class DeliveryDAO extends DBContext {

    public Order getOrderByID(int id) {
        String sqlQuery = "SELECT [CustomerID], [EmployeeID], [OrderDate], [TotalPrice], [CustomerType], [RequiredDate], "
                + "[ShippedDate], [ShipVia], [ShipName], [ShipAddress], [ShipCity], [Status] "
                + "FROM [dbo].[Orders] "
                + "WHERE [OrderID] = ?";
        try {

            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            statement.setInt(1, id);
            // Execute the query
            ResultSet resultSet = statement.executeQuery();
            // Process the results
            if (resultSet.next()) {
                int customerId = resultSet.getInt("CustomerID");
                int employeeId = resultSet.getInt("EmployeeID");
                Date orderDate = resultSet.getDate("OrderDate");
                int totalPrice = resultSet.getInt("TotalPrice");
                String customerType = resultSet.getString("CustomerType");
                Date requiredDate = resultSet.getDate("RequiredDate");
                Date shippedDate = resultSet.getDate("ShippedDate");
                int shipVia = resultSet.getInt("ShipVia");
                String shipName = resultSet.getString("ShipName");
                String shipAddress = resultSet.getString("ShipAddress");
                String shipCity = resultSet.getString("ShipCity");
                String status = resultSet.getString("Status");
                Order o = new Order(id, customerId, employeeId, orderDate, totalPrice, customerType, requiredDate, shippedDate, shipVia, shipName, shipAddress, shipCity, status);
                return o;
            } else {
                System.out.println("Product not found.");
            }

            // Close the resources
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    

    public void updateRequireDate(int id, String date) {
            String sql = "UPDATE [SaleGasStovesOnline].[dbo].[Orders] SET RequiredDate = ?, Status = ? WHERE OrderID = ?";
            java.sql.Date datestr = java.sql.Date.valueOf(date);
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setDate(1, datestr);
            
            statement.setString(2, "Shipping");
            statement.setInt(3, id);
            int rowsAffected = statement.executeUpdate();
            
            if (rowsAffected > 0) {
                // Update successful
                // Do any additional processing or return a success message
            } else {
                // No rows affected, possibly invalid ID
                // Handle the case where the provided ID doesn't exist
            }
        } catch (SQLException e) {
            // Handle any errors that occurred during the update
            e.printStackTrace();
        }
    }

    public void updateShippedDate(int id) {
            String sql = "UPDATE [SaleGasStovesOnline].[dbo].[Orders] SET ShippedDate = GETDATE() , Status = ? WHERE OrderID = ?";
//            java.sql.Date datestr = java.sql.Date.valueOf(date);
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
//            statement.setDate(1, GETDATE());
            
            statement.setString(1, "Shipped");
            statement.setInt(2, id);
            int rowsAffected = statement.executeUpdate();
            
            if (rowsAffected > 0) {
                // Update successful
                // Do any additional processing or return a success message
            } else {
                // No rows affected, possibly invalid ID
                // Handle the case where the provided ID doesn't exist
            }
        } catch (SQLException e) {
            // Handle any errors that occurred during the update
            e.printStackTrace();
        }
    }
    
    public void updateFinish(int id) {
            String sql = "UPDATE [SaleGasStovesOnline].[dbo].[Orders] SET  Status = ? WHERE OrderID = ?";
//            java.sql.Date datestr = java.sql.Date.valueOf(date);
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
//            statement.setDate(1, GETDATE());
            
            statement.setString(1, "Completed");
            statement.setInt(2, id);
            int rowsAffected = statement.executeUpdate();
            
            if (rowsAffected > 0) {
                // Update successful
                // Do any additional processing or return a success message
            } else {
                // No rows affected, possibly invalid ID
                // Handle the case where the provided ID doesn't exist
            }
        } catch (SQLException e) {
            // Handle any errors that occurred during the update
            e.printStackTrace();
        }
    }
    
    
    public List<Order> getAllOrders() {
        String sqlQuery = "SELECT [OrderID], [CustomerID], [EmployeeID], [OrderDate], [TotalPrice], [CustomerType], [RequiredDate], "
                + "[ShippedDate], [ShipVia], [ShipName], [ShipAddress], [ShipCity], [Status] "
                + "FROM [dbo].[Orders] ";
        try {
            List<Order> list = new ArrayList<>();
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            // Execute the query
            ResultSet resultSet = statement.executeQuery();
            // Process the results
            while (resultSet.next()) {
                int orderID = resultSet.getInt("OrderID");
                int customerId = resultSet.getInt("CustomerID");
                int employeeId = resultSet.getInt("EmployeeID");
                Date orderDate = resultSet.getDate("OrderDate");
                int totalPrice = resultSet.getInt("TotalPrice");
                String customerType = resultSet.getString("CustomerType");
                Date requiredDate = resultSet.getDate("RequiredDate");
                Date shippedDate = resultSet.getDate("ShippedDate");
                int shipVia = resultSet.getInt("ShipVia");
                String shipName = resultSet.getString("ShipName");
                String shipAddress = resultSet.getString("ShipAddress");
                String shipCity = resultSet.getString("ShipCity");
                String status = resultSet.getString("Status");
                Order o = new Order(orderID, customerId, employeeId, orderDate, totalPrice, customerType, requiredDate, shippedDate, shipVia, shipName, shipAddress, shipCity, status);
                list.add(o);
            }

            // Close the resources
            resultSet.close();
            statement.close();
            connection.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public List<Order> getOrderByCustomerID(int id) {
        String sqlQuery = "SELECT [OrderID], [CustomerID], [EmployeeID], [OrderDate], [TotalPrice], [CustomerType], [RequiredDate], "
                + "[ShippedDate], [ShipVia], [ShipName], [ShipAddress], [ShipCity], [Status] "
                + "FROM [dbo].[Orders] where CustomerID = ? ";
        try {
            List<Order> list = new ArrayList<>();
            PreparedStatement statement = connection.prepareStatement(sqlQuery);
            // Execute the query
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            // Process the results
            while (resultSet.next()) {
                int orderID = resultSet.getInt("OrderID");
                int customerId = resultSet.getInt("CustomerID");
                int employeeId = resultSet.getInt("EmployeeID");
                Date orderDate = resultSet.getDate("OrderDate");
                int totalPrice = resultSet.getInt("TotalPrice");
                String customerType = resultSet.getString("CustomerType");
                Date requiredDate = resultSet.getDate("RequiredDate");
                Date shippedDate = resultSet.getDate("ShippedDate");
                int shipVia = resultSet.getInt("ShipVia");
                String shipName = resultSet.getString("ShipName");
                String shipAddress = resultSet.getString("ShipAddress");
                String shipCity = resultSet.getString("ShipCity");
                String status = resultSet.getString("Status");
                Order o = new Order(orderID, customerId, employeeId, orderDate, totalPrice, customerType, requiredDate, shippedDate, shipVia, shipName, shipAddress, shipCity, status);
                list.add(o);
            }

            // Close the resources
//            resultSet.close();
//            statement.close();
//            connection.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<OrderDetail> getOrderbyCustomerID(int ID) throws SQLException {
        String sql = "SELECT o.OrderID, o.Status, od.ProductID, od.Quantity, od.UnitPrice "
                + "FROM Orders o INNER JOIN OrderDetails od ON o.OrderID = od.OrderID "
                + "WHERE o.CustomerID = ?";
        List<OrderDetail> orderlist = new ArrayList<>();
        try ( PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, ID);

            ResultSet rs = statement.executeQuery();

            // Loop through the result set and print order details and statuses
            while (rs.next()) {
                int orderId = rs.getInt("OrderID");
                String status = rs.getString("Status");
                int productId = rs.getInt("ProductID");
                int quantity = rs.getInt("Quantity");
                double unitPrice = rs.getDouble("UnitPrice");
                OrderDetail od = new OrderDetail(orderId, productId, quantity, BigDecimal.valueOf(unitPrice));
                od.setStatus(status);
                orderlist.add(od);
            }
            return orderlist;
        }
    }
    
    public List<OrderDetail> getFinishedOrderbyCustomerID(int ID) throws SQLException {
        String sql = "SELECT o.OrderID, o.Status, od.ProductID, od.Quantity, od.UnitPrice "
                + "FROM Orders o INNER JOIN OrderDetails od ON o.OrderID = od.OrderID "
                + "WHERE o.CustomerID = ? and o.Status = ?";
        List<OrderDetail> orderlist = new ArrayList<>();
        try ( PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, ID);
            statement.setString(2, "Completed");
            ResultSet rs = statement.executeQuery();

            // Loop through the result set and print order details and statuses
            while (rs.next()) {
                int orderId = rs.getInt("OrderID");
                String status = rs.getString("Status");
                int productId = rs.getInt("ProductID");
                int quantity = rs.getInt("Quantity");
                double unitPrice = rs.getDouble("UnitPrice");
                OrderDetail od = new OrderDetail(orderId, productId, quantity, BigDecimal.valueOf(unitPrice));
                od.setStatus(status);
                orderlist.add(od);
            }
            return orderlist;
        }
    }

    public List<OrderDetail> getOrdersbyOrderID(int ID) throws SQLException {
        String sql = "SELECT o.OrderID, o.CustomerID, o.Status, od.ProductID, od.Quantity, od.UnitPrice "
                + "FROM Orders o INNER JOIN OrderDetails od ON o.OrderID = od.OrderID "
                + "WHERE o.OrderID = ?";
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
                orderlist.add(od);
            }
            return orderlist;
        }
    }
}
