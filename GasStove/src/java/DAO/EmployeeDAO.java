/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Entity.Customer;
import Entity.Employee;
import java.sql.Date;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class EmployeeDAO extends DBContext {

    public Employee findEmployee(String email, String password) {
        try {
            String sql = "select * from [Employee] where [Email] = ? and [password] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, email);
            stm.setString(2, password);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Employee e = new Employee();
                e.setEmployeeID(rs.getInt("EmployeeID"));
                e.setFirstName(rs.getString("FirstName"));
                e.setLastName(rs.getString("LastName"));
                e.setEmail(rs.getString("Email"));
                e.setPhoneNumber(rs.getString("PhoneNumber"));
                e.setAddress(rs.getString("Address"));
                e.setHireDate(rs.getDate("HireDate"));
                e.setSalary(rs.getDouble("Salary"));
                e.setJobTitle(rs.getString("JobTitle"));
                e.setUsername(rs.getString("username"));
                e.setPassword(rs.getString("password"));
                return e;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Employee findEmployee(String email) {
        try {
            String sql = "select * from [Employee] where [Email] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, email);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Employee e = new Employee();
                e.setEmployeeID(rs.getInt("EmployeeID"));
                e.setFirstName(rs.getString("FirstName"));
                e.setLastName(rs.getString("LastName"));
                e.setEmail(rs.getString("Email"));
                e.setPhoneNumber(rs.getString("PhoneNumber"));
                e.setAddress(rs.getString("Address"));
                e.setHireDate(rs.getDate("HireDate"));
                e.setSalary(rs.getDouble("Salary"));
                e.setJobTitle(rs.getString("JobTitle"));
                e.setUsername(rs.getString("username"));
                e.setPassword(rs.getString("password"));
                e.setAvatarURL(rs.getNString("AvatarURL"));
                return e;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
      public Employee findEmployeeByID(int EmployeeID) {
        try {
            String sql = "select * from [Employee] where [EmployeeID] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, EmployeeID);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Employee e = new Employee();
                e.setEmployeeID(rs.getInt("EmployeeID"));
                e.setFirstName(rs.getString("FirstName"));
                e.setLastName(rs.getString("LastName"));
                e.setEmail(rs.getString("Email"));
                e.setPhoneNumber(rs.getString("PhoneNumber"));
                e.setAddress(rs.getString("Address"));
                e.setHireDate(rs.getDate("HireDate"));
                e.setSalary(rs.getDouble("Salary"));
                e.setJobTitle(rs.getString("JobTitle"));
                e.setUsername(rs.getString("username"));
                e.setPassword(rs.getString("password"));
                e.setAvatarURL(rs.getNString("AvatarURL"));
                return e;
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Employee> getAllEmployee() {
        ArrayList<Employee> employee = new ArrayList<>();
        try {

            String sql = "SELECT * FROM Employee";

            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {

                Employee e = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getDate(7), rs.getDouble(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12));
                employee.add(e);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return employee;
    }
public ArrayList<Employee> getEmployeeUnassigned() {
    ArrayList<Employee> employee = new ArrayList<>();
    try {
        String sql = "SELECT TOP (1000) [EmployeeID], [FirstName], [LastName], [Email], [PhoneNumber], [Address], [HireDate], [Salary], [JobTitle], [username], [password], [AvatarURL] " +
                     "FROM [SaleGasStovesOnline].[dbo].[Employee] " +
                     "WHERE JobTitle = 'Employee' " +
                     "AND EmployeeID NOT IN (SELECT DISTINCT employeeID FROM [SaleGasStovesOnline].[dbo].[Warranty]) " +
                     "OR (EmployeeID IN (SELECT DISTINCT employeeID FROM [SaleGasStovesOnline].[dbo].[Warranty] WHERE Status = 2) " +
                     "AND EmployeeID NOT IN (SELECT DISTINCT employeeID FROM [SaleGasStovesOnline].[dbo].[Warranty] WHERE Status = 1)) " +
                     "AND EmployeeID NOT IN (SELECT DISTINCT employeeID FROM [SaleGasStovesOnline].[dbo].[Warranty] WHERE Status = 1 AND Status = 2)";

        PreparedStatement stm = connection.prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            Employee e = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getDate(7), rs.getDouble(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12));
            employee.add(e);
        }
    } catch (SQLException ex) {
        Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return employee;
}   





    public ArrayList<Employee> searchEmployee(String search) {
        ArrayList<Employee> employee = new ArrayList<>();
        try {
            String sql = "select * from [Employee] where (FirstName like ? ) or (LastName like ?) or (PhoneNumber like ?) or(JobTitle like ?) or ( FirstName+LastName like ?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, "%" + search + "%");
            stm.setString(2, "%" + search + "%");
            stm.setString(3, "%" + search + "%");
            stm.setString(4, "%" + search + "%");
            stm.setString(5, "%" + search + "%");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                employee.add(new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getDate(7), rs.getDouble(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return employee;
    }

    public int createEmployee(String FirstName, String LastName, String Email,
            String PhoneNumber, String Address, Date HireDate, Double Salary, String JobTitle, String username, String password, String AvatarURL) {
        
        
        try {
            String getIdQuery = "SELECT MAX(EmployeeID) FROM Employee";
            Statement getIdStatement = connection.createStatement();
            ResultSet rs = getIdStatement.executeQuery(getIdQuery);
            int newEmployeeID = 1; // Giá trị khởi tạo mặc định nếu không có bản ghi nào trong bảng

            if (rs.next()) {
                int maxEmployeeID = rs.getInt(1);
                newEmployeeID = maxEmployeeID + 1;
            }
            
            String sql = "INSERT INTO [dbo].[Employee]\n"
 
                    + "           ([EmployeeID]\n"
                    + "           ,[FirstName]\n"
                    + "           ,[LastName]\n"
                    + "           ,[Email]\n"
                    + "           ,[PhoneNumber]\n"
                    + "           ,[Address]\n"
                    + "           ,[HireDate]\n"
                    + "           ,[Salary]\n"
                    + "           ,[JobTitle]\n"
                    + "           ,[username]\n"
                    + "           ,[password]\n"
                    + "           ,[AvatarURL])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           )";
            PreparedStatement stm = connection.prepareCall(sql);
            stm.setInt(1, newEmployeeID);
            stm.setString(2, FirstName);
            stm.setString(3, LastName);
            stm.setString(4, Email);
            stm.setString(5, PhoneNumber);
            stm.setString(6, Address);
            stm.setDate(7, HireDate);
            stm.setDouble(8, Salary);
            stm.setString(9, JobTitle);
            stm.setString(10, username);
            stm.setString(11, password);
            stm.setString(12, AvatarURL);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
        return 1;
    }
    public int updateEmployee(String JobTitle, String Email, String username, String password, Double Salary,
                          String Address, String PhoneNumber, String AvatarURL, int EmployeeID) {
    try {
        String sql = "UPDATE [dbo].[Employee]\n"
                   + "   SET [JobTitle] = ?,\n"
                   + "       [Email] = ?,\n"
                   + "       [username] = ?,\n"
                   + "       [password] = ?,\n"
                   + "       [Salary] = ?,\n"
                   + "       [Address] = ?,\n"
                   + "       [PhoneNumber] = ?,\n"
                   + "       [AvatarURL] = ?\n"
                   + " WHERE [Employee].EmployeeID = ?";
        PreparedStatement stm = connection.prepareCall(sql);
        stm.setString(1, JobTitle);
        stm.setString(2, Email);
        stm.setString(3, username);
        stm.setString(4, password);
        stm.setDouble(5, Salary);
        stm.setString(6, Address);
        stm.setString(7, PhoneNumber);
        stm.setString(8, AvatarURL);
        stm.setInt(9, EmployeeID);
        stm.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        return 0;
    }
    return 1;
}
    public int updateEmployee(String PhoneNumber, String Address, int EmployeeID) {
    try {
        String sql = "UPDATE [dbo].[Employee]\n"
                   + "   SET [PhoneNumber] = ?,\n"
                   + "       [Address] = ?\n"
                   + " WHERE [Employee].EmployeeID = ?";
        PreparedStatement stm = connection.prepareCall(sql);
        stm.setString(1, PhoneNumber);
        stm.setString(2, Address);
        stm.setInt(3, EmployeeID);
        stm.executeUpdate();
    } catch (SQLException ex) {
        Logger.getLogger(EmployeeDAO.class.getName()).log(Level.SEVERE, null, ex);
        return 0;
    }
    return 1;
}

     public void deleteEmployee(int id) {
        try {
            String sql = "DELETE FROM [Employee]\n"
                    + "WHERE EmployeeID = ? ";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        public int updateEmpPass(String password, int EmployeeID) {
        
        try {
            String sql = "UPDATE [dbo].[Employee]\n"
                    + "   SET [password] = ?\n"
                    + "WHERE [Employee].EmployeeID =?";
            PreparedStatement stm = connection.prepareCall(sql);
            stm.setString(1, password);
            stm.setInt(2, EmployeeID);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
        return 1;
    }

}
