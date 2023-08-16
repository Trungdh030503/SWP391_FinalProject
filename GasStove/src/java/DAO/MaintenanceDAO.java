/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entity.Category;
import Entity.Maintenance;
import Entity.MaintenanceRequest;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 5580
 */
public class MaintenanceDAO extends DBContext {

    public void createRequest(MaintenanceRequest rq) {
        boolean result = false;
        String query = "INSERT INTO MaintenanceRequest (CustomerID, ProductID, RequestDate, Description, IsResolved) "
                + "VALUES (?, ?, getdate(), ?, ?)";

        try ( PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setInt(1, rq.getCustomerID());
            stmt.setInt(2, rq.getProductID());
            stmt.setString(3, rq.getDescription());
            stmt.setBoolean(4, rq.isIsResolved());

            int rowsAffected = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<MaintenanceRequest> getAllRequest() {
        String query = "Select * from MaintenanceRequest";
        List<MaintenanceRequest> list = new ArrayList<>();
        try ( PreparedStatement stmt = connection.prepareStatement(query)) {
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                MaintenanceRequest rq = new MaintenanceRequest(rs.getInt("RequestID"), rs.getInt("CustomerID"),
                        rs.getInt("ProductID"), rs.getDate("RequestDate"), rs.getString("Description"), rs.getBoolean("IsResolved"));
                list.add(rq);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public MaintenanceRequest getRequestByID(int id) {
        String query = "Select CustomerID, ProductID, RequestDate, Description, IsResolved from MaintenanceRequest "
                + "where RequestID = ?";
        MaintenanceRequest ret = new MaintenanceRequest();
        try ( PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()){
                ret.setRequestID(id);
                ret.setCustomerID(rs.getInt("CustomerID"));
                ret.setProductID(rs.getInt("ProductID"));
                ret.setDescription(rs.getString("Description"));
                ret.setRequestDate(rs.getDate("RequestDate"));
                ret.setIsResolved(rs.getBoolean("IsResolved"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ret;
    }
    
    public void ResolveRequest(int id){
        try{
            String sql = "UPDATE [MaintenanceRequest]\n"
                    + "   SET [IsResolved] = 1\n"
                    + " WHERE RequestID = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            stm.executeUpdate();
        } catch(SQLException ex){
            ex.printStackTrace();
        }
        
    }
    
    public void CreateMaintenance(Maintenance m){
        boolean result = false;
        String query = "INSERT INTO Maintenance (CustomerID, ProductID, MaintenanceDate, MaintenanceDetail, Status) "
                + "VALUES (?, ?, getdate(), ?, ?)";

        try ( PreparedStatement stmt = connection.prepareStatement(query)) {

            stmt.setInt(1, m.getCustomerID());
            stmt.setInt(2, m.getProductID());
            stmt.setString(3, m.getMaintenanceDetail());
            stmt.setString(4, "Unused");

            int rowsAffected = stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public List<Maintenance> getMaintenanceByCustomerID(int CustomerID){
        String query = "Select * from Maintenance "
                + "where CustomerID = ?";
        List<Maintenance> list = new ArrayList();
        try ( PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setInt(1, CustomerID);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                Maintenance m = new Maintenance(rs.getInt("MaintenanceID"), rs.getInt("ProductID"), rs.getDate("MaintenanceDate"), rs.getString("MaintenanceDetail"));
                m.setStatus(rs.getString("Status"));
                m.setCustomerID(CustomerID);
                list.add(m);
            }
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}
