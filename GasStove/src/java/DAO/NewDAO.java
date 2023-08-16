/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.Customer;
import Entity.New;
import Entity.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author krikn
 */
public class NewDAO extends DBContext {

    public ArrayList<New> getInfoNew(String type) {
        ArrayList<New> News = new ArrayList<>();
        
        try {

            String sql = "SELECT TOP 3 * FROM News WHERE Type = ? ORDER BY NewsID DESC";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, type);

            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                New a = new New(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getString(7), rs.getDate(8), rs.getInt(9));
               
                News.add(a);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(NewDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return News;
    }

    public ArrayList<New> getDiscountNew(String type) {
        ArrayList<New> News = new ArrayList<>();
        try {

            String sql = "SELECT TOP 2 * FROM News WHERE Type = ? ORDER BY NewsID DESC";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, type);

            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                New a = new New(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getString(7), rs.getDate(8), rs.getInt(9));
                try{
                Product p = new ProductDAO().getProductById(rs.getInt(6));
                System.out.println("product: "+ p.toString());
                a.setProduct(p);
                   
               }catch (Exception e){
                   System.out.println("set product fail");
               }
                News.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NewDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return News;
    }

    public ArrayList<New> getAllNew() {
        ArrayList<New> News = new ArrayList<>();
        try {

            String sql = "SELECT * FROM News";
            PreparedStatement stm = connection.prepareStatement(sql);

            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                New a = new New(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getString(7), rs.getDate(8), rs.getInt(9));
                News.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NewDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return News;
    }

    public static void main5(String[] args) {
        NewDAO a = new NewDAO();
        ArrayList<New> b = a.getAllNew();
        for (New new1 : b) {
            System.out.println(new1.toString());
        }
    }

    public void addNew(New n) {
        try {
            String sql = "INSERT INTO News (Type, Title, Description, SalePercent, ProductID, ImageURL, categoryID)\n"
                    + "VALUES (?,?,?,?,?,?,?);";

            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, n.getType());
            stm.setString(2, n.getTitle());
            stm.setString(3, n.getDescription());
            stm.setInt(4, n.getSalePercent());
            stm.setInt(5, n.getProductID());
            stm.setString(6, n.getImageURL());
            stm.setInt(7, n.getCategoryID());

            stm.executeUpdate();

        } catch (Exception ex) {
            Logger.getLogger(NewDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main3(String[] args) {
        NewDAO a = new NewDAO();
        a.addNew(new New("info", "gêgegge", "gugeegte", 0, 0, "https://tse2.mm.bing.net/th?id=OIP.V96TIooR5FahShDxPlq-hQHaE7&pid=Api&P=0&h=180", 5));
        ArrayList<New> b = a.getAllNew();
        for (New new1 : b) {
            System.out.println(new1.toString());
        }
    }

    public New getNewById(int ID) {
        try {
            String sql = "select *  from News where NewsID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, ID);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                New c = new New();
                c.setType(rs.getString(2));
                c.setTitle(rs.getString(3));
                c.setDescription(rs.getString(4));
                c.setSalePercent(rs.getInt(5));
                c.setImageURL(rs.getString(7));
                c.setProductID(rs.getInt(6));
                c.setCategoryID(rs.getInt(9));
                return c;
            }
        } catch (Exception ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static void main(String[] args) {
        NewDAO a = new NewDAO();
        New b = a.getNewById(1);
        System.out.println(b.toString());
    }

    public void updateNew(New p) {
        try {
            String sql = "UPDATE News\n"
                    + "SET Type = ?, Title = ?, Description = ? ,SalePercent = ? ,ProductID = ? ,ImageURL = ? ,categoryID = ?\n"
                    + "WHERE NewsID= ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, p.getType());
            stm.setString(2, p.getTitle());
            stm.setString(3, p.getDescription());
            stm.setInt(4, p.getSalePercent());
            stm.setInt(5, p.getProductID());
            stm.setString(6, p.getImageURL());
            stm.setInt(7, p.getCategoryID());
            stm.setInt(8, p.getNewID());
            stm.executeUpdate();
            System.out.println(stm);
            System.out.println("update successfully");
        } catch (SQLException ex) {
            System.out.println("update failed");
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteNew(int idd) {
        try {
            String sql = "DELETE FROM [News]\n"
                    + "WHERE NewsID = ? ";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, idd);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList getNewByTitle(String search) {
        ArrayList<New> news = new ArrayList<>();
        try {
            
            String sql = "select* from News where (Title like ? ) or (Type like ?) or (Title like ?)" ;
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, "%"+search+"%");
            stm.setString(2, "%"+search+"%");
            stm.setString(3, "%"+search+"%");
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {                
               news.add(new New(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getString(7), rs.getDate(8), rs.getInt(9)));
               
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return news;
    }
}
