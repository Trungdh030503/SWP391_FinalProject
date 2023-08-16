/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;
import java.sql.Date;
/**
 *
 * @author 5580
 */
public class Maintenance {
    private int MaintenanceID;
    private int ProductID;
    private Date MaintenanceDate;
    private String MaintenanceDetail;
    private String Status;
    private int CustomerID;
    public Maintenance(int MaintenanceID, int ProductID, Date MaintenanceDate, String MaintenanceDetail) {
        this.MaintenanceID = MaintenanceID;
        this.ProductID = ProductID;
        this.MaintenanceDate = MaintenanceDate;
        this.MaintenanceDetail = MaintenanceDetail;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int CustomerID) {
        this.CustomerID = CustomerID;
    }

    public Maintenance() {
    }

    public int getMaintenanceID() {
        return MaintenanceID;
    }

    public void setMaintenanceID(int MaintenanceID) {
        this.MaintenanceID = MaintenanceID;
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int ProductID) {
        this.ProductID = ProductID;
    }

    public Date getMaintenanceDate() {
        return MaintenanceDate;
    }

    public void setMaintenanceDate(Date MaintenanceDate) {
        this.MaintenanceDate = MaintenanceDate;
    }

    public String getMaintenanceDetail() {
        return MaintenanceDetail;
    }

    public void setMaintenanceDetail(String MaintenanceDetail) {
        this.MaintenanceDetail = MaintenanceDetail;
    }
    
    
}
