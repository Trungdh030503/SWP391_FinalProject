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
public class MaintenanceRequest {
    private int RequestID;
    private int CustomerID;
    private int ProductID;
    private Date RequestDate;
    private String Description;
    private boolean isResolved;

    public MaintenanceRequest(int RequestID, int CustomerID, int ProductID, Date RequestDate, String Description, boolean isResolved) {
        this.RequestID = RequestID;
        this.CustomerID = CustomerID;
        this.ProductID = ProductID;
        this.RequestDate = RequestDate;
        this.Description = Description;
        this.isResolved = isResolved;
    }

    public MaintenanceRequest() {
    }

    public int getRequestID() {
        return RequestID;
    }

    public void setRequestID(int RequestID) {
        this.RequestID = RequestID;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int CustomerID) {
        this.CustomerID = CustomerID;
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int ProductID) {
        this.ProductID = ProductID;
    }

    public Date getRequestDate() {
        return RequestDate;
    }

    public void setRequestDate(Date RequestDate) {
        this.RequestDate = RequestDate;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public boolean isIsResolved() {
        return isResolved;
    }

    public void setIsResolved(boolean isResolved) {
        this.isResolved = isResolved;
    }

    @Override
    public String toString() {
        return "MaintenanceRequest{" + "RequestID=" + RequestID + ", CustomerID=" + CustomerID + ", ProductID=" + ProductID + ", RequestDate=" + RequestDate + ", Description=" + Description + ", isResolved=" + isResolved + '}';
    }
    
    
}
