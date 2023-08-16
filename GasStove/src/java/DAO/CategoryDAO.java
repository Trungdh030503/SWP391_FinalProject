/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.Category;
import Entity.Product;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author 5580
 */
public class CategoryDAO extends DBContext{
    public ArrayList<ArrayList<Category>> getCategory(){
        try {
            String sql = "select * from [Categories]";
            PreparedStatement stm = connection.prepareStatement(sql);
//            stm.setInt(1, categoryID);
            ResultSet rs = stm.executeQuery();
//            ArrayList<Category> cs = new ArrayList<>();
            ArrayList<ArrayList<Category>> list = new ArrayList<>(); 
            
            
            while (rs.next()) {
                Category c = new Category(rs.getInt("CategoryID"), rs.getString("CategoryName"), rs.getString("SubCategoryName"));
//                System.out.println(c.toString());
                boolean added = false;
                for (ArrayList<Category> cs: list){
                    if (cs.get(0).getCategoryName().equals(c.getCategoryName())){
                        cs.add(c);
                        added = true;
                        break;
                    }
                }
                if (!added){
                    list.add(new ArrayList<Category>());
                    list.get(list.size() - 1).add(c);
                }
//                cs.add(c);
//                return cs;
            }
            return list;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ArrayList<Category> getAllCategory(){
         try {
            String sql = "select * from [Categories]";
            PreparedStatement stm = connection.prepareStatement(sql);
//            stm.setInt(1, categoryID);
            ResultSet rs = stm.executeQuery();
            ArrayList<Category> cs = new ArrayList<>();;
            while (rs.next()) {
                Category c = new Category(rs.getInt("CategoryID"), rs.getString("CategoryName"), rs.getString("SubCategoryName"));
                
                cs.add(c);
//                return cs;
            }
            return cs;
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    
    public int getCategoryID(String categoryname){
        try{
            String sql = "select CategoryID from [Categories] where SubCategoryName=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, categoryname);
            ResultSet rs = stm.executeQuery();
            if (rs.next()){
                return rs.getInt("CategoryID");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }    
    
    public void addCategory(String name, String subname){
        try {
            String sql = "INSERT INTO Categories (CategoryName, SubCategoryName) VALUES ( ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, subname);
            ps.execute();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public Category getCategoryByID(String id){
        try{
            int cateid = Integer.parseInt(id);
            String sql = "select * from [Categories] where CategoryID=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, cateid);
            ResultSet rs = stm.executeQuery();
            if (rs.next()){
                Category c = new Category(cateid, rs.getString("CategoryName"), rs.getString("SubCategoryName"));
                return c;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    public String getCategory(int categoryID){
        try{
            String sql = "select CategoryName from [Categories] where CategoryID=?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, categoryID);
            ResultSet rs = stm.executeQuery();
            if (rs.next()){
                return rs.getString("CategoryName");
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }    
    
    public void updateCategory(Category c){
        try {
            String sql = "UPDATE [Categories]\n"
                    + "   SET [CategoryName] = ?\n"
                    + "      ,[SubCategoryName] = ?\n"
                    + " WHERE CategoryID= ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, c.getCategoryName());
            stm.setString(2, c.getSubCategoryName());

            stm.setInt(3, c.getCategoryID());
            stm.executeUpdate();
            System.out.println(stm);
            System.out.println("update successfully");
        } catch (SQLException ex) {
            System.out.println("update failed");
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String[] args) {

        CategoryDAO cd = new CategoryDAO();
        ArrayList<ArrayList<Category>> list = cd.getCategory();
//        Category
//        System.out.println(list.size());
    }
    
//    public List<Product> categoryFilter(List<Product> list, ArrayList<ArrayList<Category>> clist, String mod, String id){
//        List<Product> products = new ArrayList<>();        
//        if (mod.equals(0)){
//            
//        }
//    }
}
