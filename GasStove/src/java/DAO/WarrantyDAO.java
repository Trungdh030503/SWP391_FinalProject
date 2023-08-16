/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.Order;
import Entity.OrderDetail;
import Entity.Product;
import Entity.Warranty;
import Entity.WarrantyPolicy;
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
 * @author Lenovo
 */
public class WarrantyDAO extends DBContext {
//    ProductDAO pd = new ProductDAO();
//    CheckoutDAO cd = new CheckoutDAO();

//    Product
//            EmployeeDAO ed= new EmployeeDAO();
//            ArrayList<Employee> employee= ed.getAllEmployee();
    public Warranty getAllWarrantyByID(int WarrantyID) {

        List<Warranty> warranties = new ArrayList<>();

        try {
            String query = "SELECT * FROM Warranty WHERE WarrantyID = ?";
            PreparedStatement stm = connection.prepareStatement(query);
            stm.setInt(1, WarrantyID);
            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                Warranty warranty = new Warranty();
                warranty.setWarrantyID(rs.getInt("WarrantyID"));
                warranty.setProductID(rs.getInt("ProductID"));
                warranty.setOrderID(rs.getInt("OrderID"));
                warranty.setCustomerid(rs.getInt("Customerid"));
                warranty.setStartDate(rs.getDate("StartDate"));
                warranty.setEndDate(rs.getDate("EndDate"));
                warranty.setStatus(rs.getInt("Status"));
                warranty.setComment(rs.getString("Comment"));

                warranty.setEmployeeID(rs.getInt("EmployeeID"));
                warranty.setTicketNumber(rs.getString("TicketNumber"));
                warranty.setSerialNumber(rs.getString("SerialNumber"));

                return warranty;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Warranty getWarrantyBy3ID(int WarrantyID, int productID, int orderID) {

        Warranty warranty = new Warranty();

        try {
            String query = "SELECT * FROM Warranty WHERE warrantyID = ? AND productID = ? AND orderID = ?";
            PreparedStatement stm = connection.prepareStatement(query);
            stm.setInt(1, WarrantyID);
            stm.setInt(2, productID);
            stm.setInt(3, orderID);
            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
//                Warranty warranty = new Warranty();
                warranty.setWarrantyID(rs.getInt("WarrantyID"));
                warranty.setProductID(rs.getInt("ProductID"));
                warranty.setOrderID(rs.getInt("OrderID"));
                warranty.setCustomerid(rs.getInt("Customerid"));
                warranty.setStartDate(rs.getDate("StartDate"));
                warranty.setEndDate(rs.getDate("EndDate"));
                warranty.setStatus(rs.getInt("Status"));
                warranty.setComment(rs.getString("Comment"));
                warranty.setEmployeeID(rs.getInt("EmployeeID"));
                warranty.setSerialNumber(rs.getString("SerialNumber"));
                warranty.setTicketNumber(rs.getString("TicketNumber"));
                warranty.setDescription(rs.getString("description"));

                return warranty;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return warranty;
    }
    public Warranty getWarrantyBySerialNumber(String SerialNumber) {

        Warranty warranty = new Warranty();

        try {
            String query = "SELECT * FROM Warranty WHERE SerialNumber = ? ";
            PreparedStatement stm = connection.prepareStatement(query);
            stm.setString(1, SerialNumber);
            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
//                Warranty warranty = new Warranty();
                warranty.setWarrantyID(rs.getInt("WarrantyID"));
                warranty.setProductID(rs.getInt("ProductID"));
                warranty.setOrderID(rs.getInt("OrderID"));
                warranty.setCustomerid(rs.getInt("Customerid"));
                warranty.setStartDate(rs.getDate("StartDate"));
                warranty.setEndDate(rs.getDate("EndDate"));
                warranty.setStatus(rs.getInt("Status"));
                warranty.setComment(rs.getString("Comment"));
                warranty.setEmployeeID(rs.getInt("EmployeeID"));
                warranty.setSerialNumber(rs.getString("SerialNumber"));
                warranty.setTicketNumber(rs.getString("TicketNumber"));
                warranty.setDescription(rs.getString("description"));

                return warranty;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return warranty;
    }

    public Warranty getWarrantyBy5ID(int WarrantyID, int productID, int orderID, Date StartDate, Date EndDate) {

        Warranty warranty = new Warranty();

        try {
            String query = "SELECT * FROM Warranty WHERE warrantyID = ? AND productID = ? AND orderID = ? AND StartDate = ? AND EndDate = ?";
            PreparedStatement stm = connection.prepareStatement(query);
            stm.setInt(1, WarrantyID);
            stm.setInt(2, productID);
            stm.setInt(3, orderID);
            stm.setDate(4, StartDate);
            stm.setDate(5, EndDate);
            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
//                Warranty warranty = new Warranty();
                warranty.setWarrantyID(rs.getInt("WarrantyID"));
                warranty.setProductID(rs.getInt("ProductID"));
                warranty.setOrderID(rs.getInt("OrderID"));
                warranty.setCustomerid(rs.getInt("Customerid"));
                warranty.setStartDate(rs.getDate("StartDate"));
                warranty.setEndDate(rs.getDate("EndDate"));
                warranty.setStatus(rs.getInt("Status"));
                warranty.setComment(rs.getString("Comment"));
                warranty.setEmployeeID(rs.getInt("EmployeeID"));

                return warranty;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return warranty;
    }

    public ArrayList<WarrantyPolicy> getAllWarrantyPolicy() {
        ArrayList<WarrantyPolicy> policies = new ArrayList<>();
        try {
            String sql = "Select * from WarrantyPolicy";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                WarrantyPolicy policy = new WarrantyPolicy();
                policy.setWarrantyid(rs.getInt("Warrantyid"));
                policy.setWarrantyPeriod(rs.getString("WarrantyPeriod"));
                policy.setWarrantyCategory(rs.getString("WarrantyCategory"));

                policies.add(policy);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return policies;
    }

    public ArrayList<Warranty> getAllWarrantyByCustomerID() {
        ArrayList<Warranty> warranties = new ArrayList<>();

        try {
            String query = "SELECT * FROM Warranty WHERE customerID = 1 and status = 3";
            PreparedStatement stm = connection.prepareStatement(query);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Warranty warranty = new Warranty();
                warranty.setWarrantyID(rs.getInt("warrantyID"));
                warranty.setProductID(rs.getInt("productID"));
                warranty.setOrderID(rs.getInt("orderID"));
                warranty.setCustomerid(rs.getInt("customerID"));
                warranty.setStartDate(rs.getDate("startDate"));
                warranty.setEndDate(rs.getDate("endDate"));
                warranty.setStatus(rs.getInt("status"));
                warranty.setComment(rs.getString("comment"));
                warranty.setEmployeeID(rs.getInt("employeeID"));

                warranties.add(warranty);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return warranties;
    }

    public boolean createWarranty(Warranty warranty) {
        boolean result = false;
        String query = "INSERT INTO Warranty (productID, orderID, customerID, startDate, endDate, status, comment, employeeID, warrantyID) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        // Check if warranty already exists for the given orderID and productID
        String checkQuery = "SELECT COUNT(*) FROM Warranty WHERE orderID = ? AND productID = ?";
        try ( PreparedStatement checkStmt = connection.prepareStatement(checkQuery)) {
            checkStmt.setInt(1, warranty.getOrderID());
            checkStmt.setInt(2, warranty.getProductID());
            ResultSet resultSet = checkStmt.executeQuery();
            resultSet.next();
            int existingCount = resultSet.getInt(1);

            if (existingCount > 0) {
                // Warranty already exists, perform appropriate action (e.g., display error)
                System.out.println("exist orderID and productID.");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        try ( PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(9, warranty.getWarrantyID());
            stmt.setInt(1, warranty.getProductID());
            stmt.setInt(2, warranty.getOrderID());
            stmt.setInt(3, warranty.getCustomerid());
            stmt.setDate(4, warranty.getStartDate());
            stmt.setDate(5, warranty.getEndDate());
            stmt.setInt(6, warranty.getStatus());
            stmt.setString(7, warranty.getComment());
            stmt.setInt(8, warranty.getEmployeeID());

            int rowsAffected = stmt.executeUpdate();

//            if (rowsAffected > 0) {
//                ResultSet generatedKeys = stmt.getGeneratedKeys();
//                if (generatedKeys.next()) {
//                    int generatedID = generatedKeys.getInt(1);
//                    warranty.setWarrantyID(generatedID);
//                    result = true;
//                }
//            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return result;
    }

    public ArrayList<Warranty> getAllWarranty() {
        ArrayList<Warranty> warranty = new ArrayList<>();
        try {

            String sql = "SELECT * FROM Warranty";

            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
//                  Warranty w = new Warranty
                Warranty w = new Warranty(rs.getInt(9), rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(8), rs.getDate(4), rs.getDate(5), rs.getInt(6), rs.getString(7), rs.getString(10), rs.getString(11), rs.getString(12));
                warranty.add(w);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return warranty;

    }

    public ArrayList<String> getSerialNumbersByCustomerID(int customerID) {
        ArrayList<String> serialNumbers = new ArrayList<>();
        try {
            String sql = "SELECT SerialNumber FROM Warranty WHERE customerID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, customerID);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                String serialNumber = rs.getString("SerialNumber");
                serialNumbers.add(serialNumber);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("serial number size" + serialNumbers.size());
        return serialNumbers;
    }

    public int updateWarranty(int WarrantyID, Date StartDate, Date EndDate, int Status) {
        try {
            String sql = "UPDATE [dbo].[Warranty]\n"
                    + "   SET    [StartDate] = ?,\n"
                    + "       [EndDate] = ?,\n"
                    + "       [Status] = ?\n"
                    + " WHERE [Warranty].WarrantyID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setDate(1, StartDate);
            stm.setDate(2, EndDate);
            stm.setInt(3, Status);
            stm.setInt(4, WarrantyID);
            int rowsAffected = stm.executeUpdate();
            stm.close();
            return rowsAffected;
        } catch (SQLException ex) {
            Logger.getLogger(WarrantyDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    public int updateWarranty(int WarrantyID, Date StartDate, Date EndDate, int Status, int OrderID, int ProductID) {
        try {
            String sql = "UPDATE [dbo].[Warranty]\n"
                    + "   SET    [StartDate] = ?,\n"
                    + "       [EndDate] = ?,\n"
                    + "       [Status] = ?\n"
                    + " WHERE [Warranty].WarrantyID = ? AND [Warranty].OrderID = ? and [Warranty].ProductID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setDate(1, StartDate);
            stm.setDate(2, EndDate);
            stm.setInt(3, Status);
            stm.setInt(5, OrderID);
            stm.setInt(6, ProductID);
            stm.setInt(4, WarrantyID);
            int rowsAffected = stm.executeUpdate();
            stm.close();
            return rowsAffected;
        } catch (SQLException ex) {
            Logger.getLogger(WarrantyDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

     public int updateWarrantyyy(int WarrantyID, Date StartDate, Date EndDate, int Status, int EmployeeID, int OrderID, int ProductID) {
    try {
        String sql = "UPDATE [dbo].[Warranty]\n"
                + "   SET    [StartDate] = ?,\n"
                + "       [EndDate] = ?,\n"
                + "       [Status] = ?,\n"
                + "       [employeeID] = ?,\n"
                + "       [warrantyID] = ?\n"
                + " WHERE [Warranty].OrderID = ? and [Warranty].ProductID = ?";
        PreparedStatement stm = connection.prepareStatement(sql);
        stm.setDate(1, StartDate);
        stm.setDate(2, EndDate);
        stm.setInt(3, Status);
        stm.setInt(4, EmployeeID);
        stm.setInt(5, WarrantyID);
        stm.setInt(6, OrderID);
        stm.setInt(7, ProductID);
        int rowsAffected = stm.executeUpdate();
        stm.close();
        return rowsAffected;
    } catch (SQLException ex) {
        Logger.getLogger(WarrantyDAO.class.getName()).log(Level.SEVERE, null, ex);
        return 0;
    }
}




    public int updateWarranty(String serialNumber, String ticketNumber, int status) {
        try {
            String sql = "UPDATE [dbo].[Warranty]\n"
                    + "   SET    [Status] = ?\n"
                    + " WHERE [SerialNumber] = ? AND [TicketNumber] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, status);
            stm.setString(2, serialNumber);
            stm.setString(3, ticketNumber);
            int rowsAffected = stm.executeUpdate();
            stm.close();
            return rowsAffected;
        } catch (SQLException ex) {
            Logger.getLogger(WarrantyDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
    public int updateWarranty(String serialNumber, int status) {
        try {
            String sql = "UPDATE [dbo].[Warranty]\n"
                    + "   SET    [Status] = ?\n"
                    + " WHERE [SerialNumber] = ? ";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, status);
            stm.setString(2, serialNumber);
            int rowsAffected = stm.executeUpdate();
            stm.close();
            return rowsAffected;
        } catch (SQLException ex) {
            Logger.getLogger(WarrantyDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
    public int updateWarrantyy(String serialNumber, String ticketNumber, String description, int status, int customerID) {
        try {
            String selectSql = "SELECT [description], [TicketNumber] FROM [dbo].[Warranty] WHERE [SerialNumber] = ?";
            PreparedStatement selectStm = connection.prepareStatement(selectSql);
            selectStm.setString(1, serialNumber);
            ResultSet resultSet = selectStm.executeQuery();

            // Kiểm tra kết quả truy vấn SELECT
            if (resultSet.next()) {
                String existingDescription = resultSet.getString("description");
                String existingTicketNumber = resultSet.getString("TicketNumber");

                // Kiểm tra nếu description và ticketNumber đã tồn tại, không cần cập nhật
                if (existingDescription != null && existingTicketNumber != null) {
                    return 0;
                }
            }

            // Nếu description hoặc ticketNumber chưa tồn tại, thực hiện truy vấn UPDATE
            String updateSql = "UPDATE [dbo].[Warranty]\n"
                    + " SET [Status] = ?,\n"
                    + "[customerID] = ?,\n"
                    + "[TicketNumber] = ?,\n"
                    + "[description] = ?\n"
                    + "WHERE [SerialNumber] = ?";
            PreparedStatement updateStm = connection.prepareStatement(updateSql);
            updateStm.setInt(1, status);
            updateStm.setInt(2, customerID);
            updateStm.setString(3, ticketNumber);
            updateStm.setString(4, description);
            updateStm.setString(5, serialNumber);
            int rowsAffected = updateStm.executeUpdate();
            updateStm.close();
            return rowsAffected;
        } catch (SQLException ex) {
            Logger.getLogger(WarrantyDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    public int updateWarrantyFeedback(int WarrantyID, int ProductID, int OrderID, String comment) {
        try {
            String sql = "UPDATE Warranty SET comment = ? WHERE WarrantyID = ? AND ProductID = ? AND OrderID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, comment);
            stm.setInt(2, WarrantyID);
            stm.setInt(3, ProductID);
            stm.setInt(4, OrderID);
            int rowsAffected = stm.executeUpdate();
            stm.close();
            return rowsAffected;
        } catch (SQLException ex) {
            Logger.getLogger(WarrantyDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    public ArrayList<Warranty> getAllWarrantyByCustomerID(int customerID) {
        ArrayList<Warranty> warranties = new ArrayList<>();

        try {
            String query = "SELECT * FROM Warranty WHERE customerID = ?";
            PreparedStatement stm = connection.prepareStatement(query);
            stm.setInt(1, customerID);
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                Warranty warranty = new Warranty();
                warranty.setWarrantyID(rs.getInt("warrantyID"));
                warranty.setProductID(rs.getInt("productID"));
                warranty.setOrderID(rs.getInt("orderID"));
                warranty.setCustomerid(rs.getInt("customerID"));
                warranty.setStartDate(rs.getDate("startDate"));
                warranty.setEndDate(rs.getDate("endDate"));
                warranty.setStatus(rs.getInt("status"));
                warranty.setComment(rs.getString("comment"));
                warranty.setEmployeeID(rs.getInt("employeeID"));
                warranty.setSerialNumber(rs.getString("SerialNumber"));
                warranty.setTicketNumber(rs.getString("TicketNumber"));
                warranty.setDescription(rs.getString("description"));

                warranties.add(warranty);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return warranties;
    }

    public WarrantyPolicy getPolicyByID(int id) {
        try {
            String sql = "Select WarrantyPeriod, WarrantyCategory from WarrantyPolicy where Warrantyid = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();

            if (rs.next()) {
                WarrantyPolicy ret = new WarrantyPolicy();
                ret.setWarrantyid(id);
                ret.setWarrantyCategory(rs.getString("WarrantyCategory"));
                ret.setWarrantyPeriod(rs.getString("WarrantyPeriod"));
                return ret;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }

    public void createWarrantyWithOrderID(int OrderID, int EmployeeID) {
        String sql = "SELECT od.[ProductID], o.[CustomerID], od.[Quantity]\n"
                + "FROM [OrderDetails] od\n"
                + "JOIN [Orders] o ON od.[OrderID] = o.[OrderID] WHERE OD.OrderID = ?";
        try {
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, OrderID);
            ResultSet rs = stm.executeQuery();
            String insert = "INSERT INTO Warranty (productID, orderID, customerID, status, employeeID, SerialNumber) VALUES (?, ?, ? , 0, ?, ?)";
            while (rs.next()) {
                int quantity = rs.getInt(3);
                int productID = rs.getInt(1);
                int customerID = rs.getInt(2);

                for (int i = 0; i < quantity; i++) {

                    String query = "SELECT TOP 1 PI.SerialNumber\n"
                            + "FROM [ProductInstances] PI\n"
                            + "WHERE\n"
                            + "PI.ProductID = ?\n"
                            + "  AND\n"
                            + "  (PI.SerialNumber NOT IN (\n"
                            + "    SELECT DISTINCT W.SerialNumber\n"
                            + "    FROM [Warranty] W\n"
                            + "WHERE W.SerialNumber IS NOT NULL\n"
                            + "  ) OR PI.SerialNumber IS NULL)";

                    PreparedStatement serialStmt = connection.prepareStatement(query);
                    serialStmt.setInt(1, productID);
                    ResultSet serialRs = serialStmt.executeQuery();

                    if (serialRs.next()) {
                        String serialNumber = serialRs.getString(1);

                        PreparedStatement insertStmt = connection.prepareStatement(insert);
                        insertStmt.setInt(1, productID);
                        insertStmt.setInt(2, OrderID);
                        insertStmt.setInt(3, customerID);
                        insertStmt.setInt(4, EmployeeID);
                        insertStmt.setString(5, serialNumber);
                        int rowsAffected = insertStmt.executeUpdate();
                        if (rowsAffected > 0) {
                            System.out.println("Product Instance inserted successfully.");
                        } else {
                            System.out.println("Failed to insert the product instance.");
                        }
                        insertStmt.close();
                    } else {
                        System.out.println("there is no serialnumber");
                    }
                }
            }
            rs.close();
            stm.close();
        } catch (Exception e) {
            System.out.println("Del insert duoc warranty");
        }

    }

}
