/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.CartItem;
import Entity.Order;
import Entity.OrderDetail;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DUC ANH
 */
public class CheckoutDAO extends DBContext{
    public void createOrder(Order order, String date, List<CartItem> cart) throws ParseException {
    int orderID = 0;
    try {
        String sql = "INSERT INTO Orders (CustomerID, EmployeeID, TotalPrice, CustomerType, RequiredDate, ShipVia, ShipName, ShipAddress, ShipCity) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        //String sql = "INSERT INTO Orders (CustomerID, EmployeeID, TotalPrice, CustomerType, ShipVia, ShipName, ShipAddress, ShipCity) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
        ps.setInt(1, order.getCustomerID());
        ps.setInt(2, 1);
        ps.setInt(3, order.getTotalPrice());
        ps.setString(4, "New");
        //convert date type
        String dateString = date;
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        java.util.Date utilDate = format.parse(dateString);
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        ps.setDate(5, sqlDate);
        ps.setInt(6, 2);
        ps.setString(7, order.getShipName());
        ps.setString(8, order.getShipAddress());
        ps.setString(9, order.getShipCity());
        ps.executeUpdate();
        ResultSet generatedKeys = ps.getGeneratedKeys();
        if (generatedKeys.next()) {
            orderID = generatedKeys.getInt(1);
            // Sử dụng orderID ở đây
        }
        List<CartItem> Cart = cart;
        for (CartItem item : Cart) {
            int productID = Integer.parseInt(item.getProductID());
            int quantity = item.getQuantity();
            // Thực hiện câu lệnh INSERT vào bảng OrderDetails
            String sql2 = "INSERT INTO OrderDetails (OrderID, ProductID, Quantity, UnitPrice) VALUES (?, ?, ?, ?)";
            PreparedStatement ps2 = connection.prepareStatement(sql2);
            ps2.setInt(1, orderID);
            ps2.setInt(2, productID);
            ps2.setInt(3, quantity);
            ps2.setInt(4, item.getUnitPrice().intValue());
            ps2.executeUpdate();
        }
        generatedKeys.close();
        ps.close();
        connection.close();
    } catch (SQLException ex) {
            Logger.getLogger(CheckoutDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    //return orderID;
    }
public ArrayList<Order> getAllOrder() {
    ArrayList<Order> orderList = new ArrayList<>();

    PreparedStatement stmt = null;
    ResultSet rs = null;

    try {
        
        String query = "SELECT * FROM Orders";
        stmt = connection.prepareStatement(query);
        rs = stmt.executeQuery();

        while (rs.next()) {
            Order order = new Order();
            order.setOrderID(rs.getInt("OrderID"));
            order.setCustomerID(rs.getInt("CustomerID"));
            order.setEmployeeID(rs.getInt("EmployeeID"));
            order.setOrderDate(rs.getDate("OrderDate"));
            order.setTotalPrice(rs.getInt("TotalPrice"));
            order.setCustomerType(rs.getString("CustomerType"));
            order.setRequiredDate(rs.getDate("RequiredDate"));
            order.setShippedDate(rs.getDate("ShippedDate"));
            order.setShipVia(rs.getInt("ShipVia"));
            order.setShipName(rs.getString("ShipName"));
            order.setShipAddress(rs.getString("ShipAddress"));
            order.setShipCity(rs.getString("ShipCity"));
            order.setStatus(rs.getString("Status"));
            orderList.add(order);
            
}
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    } finally {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    return orderList;
}
public Order getOrderByOrderID(int orderID) {
    PreparedStatement stmt = null;
    ResultSet rs = null;
    Order order = null;

    try {
        String query = "SELECT * FROM Orders WHERE OrderID = ?";
        stmt = connection.prepareStatement(query);
        stmt.setInt(1, orderID);
        rs = stmt.executeQuery();

        if (rs.next()) {
            order = new Order();
            order.setOrderID(rs.getInt("OrderID"));
            order.setCustomerID(rs.getInt("CustomerID"));
            order.setEmployeeID(rs.getInt("EmployeeID"));
            order.setOrderDate(rs.getDate("OrderDate"));
            order.setTotalPrice(rs.getInt("TotalPrice"));
            order.setCustomerType(rs.getString("CustomerType"));
            order.setRequiredDate(rs.getDate("RequiredDate"));
            order.setShippedDate(rs.getDate("ShippedDate"));
            order.setShipVia(rs.getInt("ShipVia"));
            order.setShipName(rs.getString("ShipName"));
            order.setShipAddress(rs.getString("ShipAddress"));
            order.setShipCity(rs.getString("ShipCity"));
            order.setStatus(rs.getString("Status"));
        }
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    } finally {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    return order;
}
public OrderDetail getOrderDetailByOrderID(int orderID) {
    PreparedStatement stmt = null;
    ResultSet rs = null;
    OrderDetail orderDetail = null;

    try {
        String query = "SELECT * FROM OrderDetails WHERE OrderID = ?";
        stmt = connection.prepareStatement(query);
        stmt.setInt(1, orderID);
        rs = stmt.executeQuery();

        if (rs.next()) {
            orderDetail = new OrderDetail();
            orderDetail.setOrderID(rs.getInt("OrderID"));
            orderDetail.setProductID(rs.getInt("ProductID"));
            orderDetail.setQuantity(rs.getInt("Quantity"));
            orderDetail.setUnitPrice(rs.getBigDecimal("UnitPrice"));
            orderDetail.setStatus(rs.getString("Status"));
        }
    } catch (SQLException ex) {
        System.out.println(ex.getMessage());
    } finally {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    return orderDetail;
}





}
