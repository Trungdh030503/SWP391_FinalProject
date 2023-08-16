/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.Order;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class OrdersDAO extends DBContext{
    
    // Các trường dữ liệu và phương thức khác

    public ArrayList<Order> getOrderByCustomerID(int customerID) {
        ArrayList<Order> orders = new ArrayList<>();

        try {
            String query = "SELECT * FROM Orders WHERE CustomerID = ?";
            PreparedStatement stm = connection.prepareStatement(query);
            stm.setInt(1, customerID);
            ResultSet rs = stm.executeQuery();

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

                orders.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orders;
    }

    // Các trường dữ liệu và phương thức khác
}

    

