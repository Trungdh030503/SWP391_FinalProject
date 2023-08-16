/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


import Entity.Customer;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
//import Entity.Customers;

/**
 *
 * @author Admin
 */
public class CustomerDAO extends DBContext {


    
    public Customer findCustomer(String email) {
        try {
            String sql = "select * from [Customers] where [Email] = ? ";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, email);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Customer s = new Customer();
                s.setCustomerID(rs.getInt("CustomerID"));
                s.setFirstName(rs.getString("FirstName"));
                s.setLastName(rs.getString("LastName"));
                s.setEmail(rs.getString("Email"));
                s.setPhoneNumber(rs.getString("PhoneNumber"));
                s.setCity(rs.getString("City"));
                s.setDistrict(rs.getString("District"));
//                s.setCustomerType(rs.getString("CustomerType"));
                s.setUsername(rs.getString("username"));
                s.setPassword(rs.getString("password"));
                s.setBoughtCount(rs.getInt("BoughtCount"));
                s.setCreatedDate(rs.getDate("CreatedDate"));

                return s;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Customer findCustomer(String email, String password) {
        try {
            String sql = "select * from [Customers] where [Email] = ? and [password] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, email);
            stm.setString(2, password);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Customer s = new Customer();
                s.setCustomerID(rs.getInt("CustomerID"));
                s.setFirstName(rs.getString("FirstName"));
                s.setLastName(rs.getString("LastName"));
                s.setEmail(rs.getString("Email"));
                s.setPhoneNumber(rs.getString("PhoneNumber"));
                s.setCity(rs.getString("City"));
                s.setDistrict(rs.getString("District"));
//                s.setCustomerType(rs.getString("CustomerType"));
                s.setUsername(rs.getString("username"));
                s.setPassword(rs.getString("password"));
                s.setBoughtCount(rs.getInt("BoughtCount"));
                s.setCreatedDate(rs.getDate("CreatedDate"));

                return s;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public Customer findCustomer(int CustomerID) {
        try {
            String sql = "select * from [Customers] where [CustomerID] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, CustomerID);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                Customer s = new Customer();
                s.setCustomerID(rs.getInt("CustomerID"));
                s.setFirstName(rs.getString("FirstName"));
                s.setLastName(rs.getString("LastName"));
                s.setEmail(rs.getString("Email"));
                s.setPhoneNumber(rs.getString("PhoneNumber"));
                s.setCity(rs.getString("City"));
                s.setDistrict(rs.getString("District"));
//                s.setCustomerType(rs.getString("CustomerType"));
                s.setUsername(rs.getString("username"));
                s.setPassword(rs.getString("password"));
                s.setBoughtCount(rs.getInt("BoughtCount"));
                s.setCreatedDate(rs.getDate("CreatedDate"));

                return s;
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    
    public void insertCustomer(Customer customer) {
        try {
            String sql = "INSERT INTO Customers (FirstName, LastName, Email, PhoneNumber, City, District, username, password, Address) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, customer.getFirstName());
            ps.setString(2, customer.getLastName());
            ps.setString(3, customer.getEmail());
            ps.setString(4, customer.getPhoneNumber());
            ps.setString(5, customer.getCity());
            ps.setString(6, customer.getDistrict());
            ps.setString(7, customer.getUsername());
            ps.setString(8, customer.getPassword());
            ps.setString(9, customer.getAddressDetail());
            ps.execute();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void insertAccountWithGmail(String firstname, String lastname, String email) {
        PreparedStatement preparedStatement = null;
        try {
            // Step 1: Register the JDBC driver
            // Step 3: Set auto-commit to false
            connection.setAutoCommit(false);

            // Step 4: Create and execute the transaction
            String insertQuery = "INSERT INTO Customers (FirstName, LastName, Email) VALUES (?, ?, ?)";
            preparedStatement = connection.prepareStatement(insertQuery);
            preparedStatement.setString(1, firstname);
            preparedStatement.setString(2, lastname);
            preparedStatement.setString(3, email);
            preparedStatement.executeUpdate();

            // Step 5: Commit the transaction
            connection.commit();
            System.out.println("Transaction committed successfully!");

        } catch (SQLException e) {
            e.printStackTrace();

            // Step 6: Rollback the transaction if any exception occurs
            if (connection != null) {
                try {
                    connection.rollback();
                    System.out.println("Transaction rolled back!");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        } finally {
            // Step 7: Close the connection and statement
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<Customer> getAllAccount() {
        ArrayList<Customer> customers = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Customers";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Customer a = new Customer();
                a.setCustomerID(rs.getInt(1));
                a.setFirstName(rs.getString(2));
                a.setLastName(rs.getString(3));
                a.setEmail(rs.getString(4));
                a.setPhoneNumber(rs.getString(5));
                a.setCity(rs.getString(6));
                a.setDistrict(rs.getString(7));
                a.setAddressDetail(rs.getString(8));
                a.setUsername(rs.getString(8));
                a.setPassword(rs.getString(9));
                a.setBoughtCount(rs.getInt(10));
                a.setCreatedDate(rs.getDate(11));


                customers.add(a);
            }
        } catch (Exception ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return customers;
    }

    public void updateCustomer(Customer p) {
        try {
            String sql = "UPDATE [Customers]\n"
                    + "   SET [FirstName] = ?\n"
                    + "      ,[LastName] = ?\n"
                    + "      ,[Email] = ?\n"
                    + "      ,[PhoneNumber] = ?\n"
                    + "      ,[City] = ?\n"
                    + "      ,[District] = ?\n"
                    + "      ,[Address] = ?\n"
                    + "      ,[username] = ?\n"
                    + "      ,[password] = ?\n"
                    + "      ,[AvatarURL] = ?\n"
                    + " WHERE CustomerID= ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, p.getFirstName());
            stm.setString(2, p.getLastName());
            stm.setString(3, p.getEmail());
            stm.setString(4, p.getPhoneNumber());
            stm.setString(5, p.getCity());
            stm.setString(6, p.getDistrict());
            stm.setString(7, p.getAddressDetail());
            stm.setString(8, p.getUsername());
            stm.setString(9, p.getPassword());
            stm.setString(10, p.getImage());
            stm.setInt(11, p.getCustomerID());
            stm.executeUpdate();
            System.out.println(stm);
            System.out.println("update successfully");
        } catch (SQLException ex) {
            System.out.println("update failed");
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteProduct(int id) {
        try {
            String sql = "DELETE FROM [Customers]\n"
                    + "WHERE CustomerID = ? ";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Customer getCustomerById(int ID) {
        try {
            String sql = "select *  from Customers where CustomerID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, ID);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Customer c = new Customer();
                c.setCustomerID(rs.getInt(1));
                c.setFirstName(rs.getString(2));
                c.setLastName(rs.getString(3));
                c.setEmail(rs.getString(4));
                c.setPhoneNumber(rs.getString(5));
                c.setCity(rs.getString(6));
                c.setDistrict(rs.getString(7));
                c.setAddressDetail(rs.getString(8));
                c.setUsername(rs.getString(9));
                c.setPassword(rs.getString(10));
                c.setBoughtCount(rs.getInt(11));
                c.setCreatedDate(rs.getDate(12));
                c.setModifiedDate(rs.getDate(13));
                return c;
            }
        } catch (Exception ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ArrayList<Customer> getAllCustomer() {
        ArrayList<Customer> customers = new ArrayList<>();
        try {

            String sql = "SELECT * FROM Customers";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Customer a = new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9),
                        rs.getString(10), rs.getInt(11), rs.getDate(12), rs.getDate(13));
                customers.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return customers;
    }
      public int updateCustomer(String password, int CustomerID) {
        
        try {
            String sql = "UPDATE [dbo].[Customers]\n"
                    + "   SET [password] = ?\n"
                    + "WHERE [Customers].CustomerID =?";
            PreparedStatement stm = connection.prepareCall(sql);
            stm.setString(1, password);
            stm.setInt(2, CustomerID);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
        return 1;
    }
      public int updateCustomer(String password, String Email) {
        
        try {
            String sql = "UPDATE [dbo].[Customers]\n"
                    + "   SET [password] = ?\n"
                    + "WHERE [Customers].Email =?";
            PreparedStatement stm = connection.prepareCall(sql);
            stm.setString(1, password);
            stm.setString(2, Email);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
        return 1;
    }
  

      public List<String> getUsernameList() {
        List<String> usernameList = new ArrayList<>();
        // SQL query to retrieve the email addresses
        try {
            String sql = "SELECT [username] FROM Customers";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            // Iterate through the result set and add email addresses to the list
            while (rs.next()) {
                String username = rs.getString("username");
                if (username != null){
                    usernameList.add(username.trim());
                }
                
            }
            rs.close();
            return usernameList;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<String> getUserEmailList() {
        List<String> emailList = new ArrayList<>();
        // SQL query to retrieve the email addresses
        try {
            String sql = "SELECT Email FROM Customers";
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            // Iterate through the result set and add email addresses to the list
            while (rs.next()) {
                String email = rs.getString("Email");
                emailList.add(email.trim());
            }
            rs.close();
            return emailList;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList getAccountByName(String search) {
        ArrayList<Customer> customers = new ArrayList<>();
        try {
            
            String sql = "select* from Customers where (FirstName like ? ) or (LastName like ?) or (PhoneNumber like ?) or ( FirstName+LastName like ?)" ;
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, "%"+search+"%");
            stm.setString(2, "%"+search+"%");
            stm.setString(3, "%"+search+"%");
            stm.setString(4, "%"+search+"%");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {                
               customers.add(new Customer(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getInt(11), rs.getDate(12), rs.getDate(13), rs.getString(14)));
               
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return customers;
    }
    
    
//    public static void main(String[] args) {
//        CustomerDAO a = new CustomerDAO();
//        List<Customer> list = a.getAllCustomer();
//        for (Customer customer : list) {
//            System.out.println(customer.toString());
//        }
// 
//    }

}
