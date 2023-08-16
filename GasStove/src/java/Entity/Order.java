 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import DAO.PurchaseDAO;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 *
 * @author DUC ANH
 */
public class Order {
    private int orderID;
    private int customerID;
    private int employeeID;
    private Date orderDate;
    private int totalPrice;
    private String customerType;
    private Date requiredDate;
    private Date shippedDate;
    private int shipVia;
    private String shipName;
    private String shipAddress;
    private String shipCity;
    private String Status;
    
    public List<OrderDetail> getOrderDetails() throws SQLException{
        PurchaseDAO pd = new PurchaseDAO();
        return pd.getOrdersByOrderID(orderID);
    }

    public Order(int orderID, int customerID, int employeeID, Date orderDate, int totalPrice, String customerType, Date requiredDate, Date shippedDate, int shipVia, String shipName, String shipAddress, String shipCity, String status) {
        this.orderID = orderID;
        this.customerID = customerID;
        this.employeeID = employeeID;
        this.orderDate = orderDate;
        this.totalPrice = totalPrice;
        this.customerType = customerType;
        this.requiredDate = requiredDate;
        this.shippedDate = shippedDate;
        this.shipVia = shipVia;
        this.shipName = shipName;
        this.shipAddress = shipAddress;
        this.shipCity = shipCity;
        this.Status = status;
    }

    public String getStatus() {
       if (Status==null || Status.isEmpty()){
            Status="Waiting";
        }
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }
    public Order() {
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public Date getRequiredDate() {
        return requiredDate;
    }

    public void setRequiredDate(Date requiredDate) {
        this.requiredDate = requiredDate;
    }

    public Date getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(Date shippedDate) {
        this.shippedDate = shippedDate;
    }

    public int getShipVia() {
        return shipVia;
    }

    public void setShipVia(int shipVia) {
        this.shipVia = shipVia;
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public String getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }

    public String getShipCity() {
        return shipCity;
    }

    public void setShipCity(String shipCity) {
        this.shipCity = shipCity;
    }

    @Override
    public String toString() {
        return "Order{" + "orderID=" + orderID + ", customerID=" + customerID + ", employeeID=" + employeeID + ", orderDate=" + orderDate + ", totalPrice=" + totalPrice + ", customerType=" + customerType + ", requiredDate=" + requiredDate + ", shippedDate=" + shippedDate + ", shipVia=" + shipVia + ", shipName=" + shipName + ", shipAddress=" + shipAddress + ", shipCity=" + shipCity + ", Status=" + Status + '}';
    }
    
}
