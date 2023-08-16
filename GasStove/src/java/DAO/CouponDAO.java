/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.Coupon;
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
public class CouponDAO extends DBContext {

    public ArrayList<Coupon> getAllCoupon() {
        ArrayList<Coupon> coupons = new ArrayList<>();
        try {

            String sql = "SELECT * FROM Promotion";
            PreparedStatement stm = connection.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Coupon a = new Coupon(rs.getInt("PromotionID"), rs.getInt("ProductID"), rs.getString("PromotionName"), rs.getDouble("Discount"),
                        rs.getDate("StartDate"), rs.getDate("EndDate"), rs.getInt("MinimumTotalPrice"), rs.getInt("MinimumPurchaseQuantity"),
                        rs.getInt("MinimumBoughtCount"));
                coupons.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return coupons;
    }

    public void createCoupon(Coupon p) {
        try {

            String sql = "INSERT INTO Promotion (ProductID, PromotionName, Discount, StartDate, EndDate, MinimumTotalPrice, "
                    + "MinimumPurchaseQuantity, MinimumBoughtCount) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, p.getProductID());
            statement.setString(2, p.getCouponName());
            statement.setDouble(3, p.getDiscount());
            statement.setDate(4, p.getStartdate());
            statement.setDate(5, p.getEnddate());
            statement.setInt(6, p.getMinimunTotalPrice());
            statement.setInt(7, p.getPurchaseQuantity());
            statement.setInt(8, p.getMinimumBoughtCount());

            int rowsAffected = statement.executeUpdate();
            System.out.println(rowsAffected + " row(s) inserted successfully.");
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Coupon> getCouponforCart(int CustomerID) {
        ArrayList<Coupon> coupons = new ArrayList<>();
        try {

            String sql = "SELECT P.[PromotionID]\n"
                    + "     , P.[ProductID]\n"
                    + "     , P.[PromotionName]\n"
                    + "     , P.[Discount]\n"
                    + "     , P.[StartDate]\n"
                    + "     , P.[EndDate]\n"
                    + "     , P.[MinimumTotalPrice]\n"
                    + "     , P.[MinimumPurchaseQuantity]\n"
                    + "     , P.[MinimumBoughtCount]\n"
                    + "FROM [SaleGasStovesOnline].[dbo].[Promotion] P\n"
                    + "LEFT JOIN [SaleGasStovesOnline].[dbo].[Cart] C\n"
                    + "     ON P.[ProductID] = C.[ProductID]\n"
                    + "LEFT JOIN [SaleGasStovesOnline].[dbo].[PromotionUsage] U\n"
                    + "     ON P.[PromotionID] = U.[PromotionID] AND U.[CustomerID] = ?\n"
                    + "WHERE C.[CustomerID] = ?\n"
                    + "      AND C.[ProductID] IS NOT NULL\n"
                    + "      AND U.[PromotionID] IS NULL";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, CustomerID);
            stm.setInt(2, CustomerID);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Coupon a = new Coupon(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getDouble(4),
                        rs.getDate(5), rs.getDate(6), rs.getInt(7), rs.getInt(8),
                        rs.getInt(9));
                coupons.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return coupons;

    }
}
