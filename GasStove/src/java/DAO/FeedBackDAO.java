/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.Feedback;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 5580
 */
public class FeedBackDAO extends DBContext {

    public void insertFeedBack(int CustomerID, String FeedbackDetail, int ProductID, int Rating) {
        boolean result = false;
        String query = "INSERT INTO Feedback (CustomerID, FeedbackDate, FeedbackDetail, ProductID, Rating) "
                + "VALUES (?, getdate(), ?, ?, ?)";

        try ( PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setInt(1, CustomerID);
            stmt.setString(2, FeedbackDetail);
            stmt.setInt(3, ProductID);
            stmt.setInt(4, Rating);

            int rowsAffected = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Feedback> getFeedbackbyProductID(int ProductID) {
        String query = "Select * from FeedBack "
                + "where ProductID = ?";
        List<Feedback> list = new ArrayList();
        try ( PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, ProductID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Feedback f = new Feedback(rs.getInt("FeedbackID"), rs.getInt("CustomerID"),  rs.getDate("FeedbackDate"), rs.getString("FeedbackDetail"), ProductID, rs.getInt("Rating"));
                list.add(f);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("feedback " + list.size());
        return list;
    }

}
