/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import DAO.CheckoutDAO;
import DAO.CustomerDAO;
import DAO.EmployeeDAO;
import DAO.OrdersDAO;
import DAO.ProductDAO;
import DAO.PurchaseDAO;
import DAO.WarrantyDAO;
import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.http.client.utils.DateUtils;

/**
 *
 * @author Lenovo
 */
public class Warranty {

    int WarrantyID;
    int ProductID;
    int OrderID;
    int Customerid;
    int EmployeeID;
    Date StartDate;
    Date EndDate;
    int Status;
    String comment;
    Product product;
    Customer customer;
    WarrantyPolicy policy;
    String SerialNumber;
    String TicketNumber;
    String description;
    Employee employee;
    Order order;

    public String getWarrantyStartDate() {
        CheckoutDAO cd = new CheckoutDAO();
        Order o = cd.getOrderByOrderID(OrderID);

        return o.getRequiredDate().toString();
    }

    public String getWarrantyEndDate() {
        CheckoutDAO cd = new CheckoutDAO();
        Order o = cd.getOrderByOrderID(OrderID);

        Date startDate = (Date) o.getRequiredDate();

        ProductDAO pd = new ProductDAO();
        Product p = pd.getProductById(ProductID);
        String endDate = "";
        String pattern = "\\d+";
        Pattern regex = Pattern.compile(pattern);

        String warrantyPeriod = p.getWarrantyPeriod();
        System.out.println("Period: " + warrantyPeriod);
        if (warrantyPeriod.contains("năm")) {
            Matcher matcher = regex.matcher(warrantyPeriod);
            if (matcher.find()) {
                String match = matcher.group();
                int years = Integer.parseInt(match);
                LocalDate enddate = startDate.toLocalDate().plusYears(years);
                System.out.println("Year: " + years);
                //calculatedEndDate ==> string
                endDate = enddate.toString();

            }
            // startdate => string

        } else if (warrantyPeriod.contains("tháng")) {
            Matcher matcher = regex.matcher(warrantyPeriod);
            if (matcher.find()) {
                String match = matcher.group();
                int months = Integer.parseInt(match);
                LocalDate enddate = startDate.toLocalDate().plusMonths(months);
                System.out.println("Months: " + months);
                //calculatedEndDate ==> string
                endDate = enddate.toString();

            }

        }
        return endDate;
    }

    public int getWarrantyRatio() {
        CheckoutDAO cd = new CheckoutDAO();
        Order o = cd.getOrderByOrderID(OrderID);
        Date orderDate = (Date) o.getRequiredDate();
        
        ProductDAO pd = new ProductDAO();
        Product p = pd.getProductById(ProductID);

        String pattern = "\\d+";
        Pattern regex = Pattern.compile(pattern);

        String warrantyPeriod = p.getWarrantyPeriod();
        if (warrantyPeriod.contains("năm")) {
            Matcher matcher = regex.matcher(warrantyPeriod);
            if (matcher.find()) {
                String match = matcher.group();
                int years = Integer.parseInt(match);
                LocalDate startDate = orderDate.toLocalDate();
                LocalDate currentDate = LocalDate.now();
                LocalDate enddate = startDate.plusYears(years);
                // Calculate the duration in days
                long duration = ChronoUnit.DAYS.between(startDate, currentDate);
                long divider = ChronoUnit.DAYS.between(startDate, enddate);
                // Calculate the ratio
                double ratio = 100 * (double) duration / divider; // Assuming 365 days in a year
                return (int) ratio;
            }

        } else if (warrantyPeriod.contains("tháng")) {
            Matcher matcher = regex.matcher(warrantyPeriod);
            if (matcher.find()) {
                String match = matcher.group();
                int months = Integer.parseInt(match);
                LocalDate startDate = orderDate.toLocalDate();
                LocalDate currentDate = LocalDate.now();
                LocalDate enddate = startDate.plusMonths(months);
                // Calculate the duration in days
                long duration = ChronoUnit.DAYS.between(startDate, currentDate);
                long divider = ChronoUnit.DAYS.between(startDate, enddate);
                // Calculate the ratio
                double ratio = 100 * (double) duration / divider; // Assuming 30 days in a month
                return (int) ratio;
            }
        }

        // Return a default ratio value if warranty period format is not recognized
        return -1;
    }

    public Warranty() {
    }

    public WarrantyPolicy getPolicy() {
        return policy;
    }

    public void setPolicy(WarrantyPolicy policy) {
        this.policy = policy;
    }

    public Warranty(int WarrantyID, int ProductID, int OrderID, int Customerid, int EmployeeID, Date StartDate, Date EndDate, int Status, String comment, String SerialNumber, String TicketNumber, String description) {
        this.WarrantyID = WarrantyID;
        this.ProductID = ProductID;
        this.OrderID = OrderID;
        this.EmployeeID = EmployeeID;
        this.Customerid = Customerid;
        this.StartDate = StartDate;
        this.EndDate = EndDate;
        this.Status = Status;
        this.comment = comment;
        this.SerialNumber = SerialNumber;
        this.TicketNumber = TicketNumber;
        this.description = description;

    }

    public Employee getEmployee() {
        EmployeeDAO ed = new EmployeeDAO();
        return ed.findEmployeeByID(EmployeeID);
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Customer getCustomer() {
        CustomerDAO cd = new CustomerDAO();
        return cd.getCustomerById(Customerid);
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        ProductDAO pd = new ProductDAO();

        return pd.getProductById(ProductID);
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getWarrantyID() {
        return WarrantyID;
    }

    public void setWarrantyID(int WarrantyID) {
        this.policy = (new WarrantyDAO().getPolicyByID(WarrantyID));
        this.WarrantyID = WarrantyID;
    }

    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int ProductID) {
        this.ProductID = ProductID;
    }

    public int getOrderID() {
        return OrderID;
    }

    public void setOrderID(int OrderID) {
        this.OrderID = OrderID;
    }

    public int getCustomerid() {
        return Customerid;
    }

    public void setCustomerid(int Customerid) {
        this.Customerid = Customerid;
    }

    public Date getStartDate() {
        return StartDate;
    }

    public void setStartDate(Date StartDate) {
        this.StartDate = StartDate;
    }

    public Date getEndDate() {
        return EndDate;
    }

    public void setEndDate(Date EndDate) {
        this.EndDate = EndDate;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

    public String getSerialNumber() {
        return SerialNumber;
    }

    public void setSerialNumber(String SerialNumber) {
        this.SerialNumber = SerialNumber;
    }

    public String getTicketNumber() {
        return TicketNumber;
    }

    public void setTicketNumber(String TicketNumber) {
        this.TicketNumber = TicketNumber;
    }

    public String getComment() {
        return comment;
    }

    public int getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(int EmployeeID) {
        this.EmployeeID = EmployeeID;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString() {
        return "Warranty{" + "WarrantyID=" + WarrantyID + ", ProductID=" + ProductID + ", OrderID=" + OrderID + ", Customerid=" + Customerid + ", EmployeeID=" + EmployeeID + ", StartDate=" + StartDate + ", EndDate=" + EndDate + ", Status=" + Status + ", comment=" + comment + ", product=" + product + ", customer=" + customer + ", policy=" + policy + ", SerialNumber=" + SerialNumber + ", TicketNumber=" + TicketNumber + '}';
    }

}
