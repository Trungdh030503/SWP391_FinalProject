/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;
import DAO.CustomerDAO;
import java.util.Date;
/**
 *
 * @author 5580
 */
public class Feedback {
    int FeedbackID;
    int CustomerID;
    Date FeedbackDate;
    String FeedbackDetail;
    int ProductID;
    int Rating;
    Customer customer;

    public Customer getCustomer() {
        CustomerDAO cd = new CustomerDAO();
        Customer c = cd.getCustomerById(CustomerID);
        return c;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    
    public Feedback(int CustomerID, String FeedbackDetail, int ProductID, int Rating) {
        this.CustomerID = CustomerID;
        this.FeedbackDetail = FeedbackDetail;
        this.ProductID = ProductID;
        this.Rating = Rating;
    }

    
    public Feedback(int FeedbackID, int CustomerID, Date FeedbackDate, String FeedbackDetail, int ProductID, int Rating) {
        this.FeedbackID = FeedbackID;
        this.CustomerID = CustomerID;
        this.FeedbackDate = FeedbackDate;
        this.FeedbackDetail = FeedbackDetail;
        this.ProductID = ProductID;
        this.Rating = Rating;
    }

    public Feedback() {
    }

    public int getFeedbackID() {
        return FeedbackID;
    }

    public void setFeedbackID(int FeedbackID) {
        this.FeedbackID = FeedbackID;
    }

    public int getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(int CustomerID) {
        this.CustomerID = CustomerID;
    }

    public Date getFeedbackDate() {
        return FeedbackDate;
    }

    public void setFeedbackDate(Date FeedbackDate) {
        this.FeedbackDate = FeedbackDate;
    }

    public String getFeedbackDetail() {
        return FeedbackDetail;
    }

    public void setFeedbackDetail(String FeedbackDetail) {
        this.FeedbackDetail = FeedbackDetail;
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int ProductID) {
        this.ProductID = ProductID;
    }

    public int getRating() {
        return Rating;
    }

    public void setRating(int Rating) {
        this.Rating = Rating;
    }
    
}
