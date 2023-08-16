/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import DAO.ProductDAO;
import java.math.BigDecimal;

/**
 *
 * @author DUC ANH
 */
public class OrderDetail {
    private int orderID;
    private int productID;
    private int quantity;
    private BigDecimal unitPrice;
    private String status;
    private Product product;

    public Product getProduct() {
        Product p = new ProductDAO().getProductById(productID);
        return p;
    }
    
    
    public String getStatus() {
        if (status==null || status.isEmpty()){
            status="Waiting";
        }
        return status;
    }

    public OrderDetail(int orderID, int productID, int quantity, BigDecimal unitPrice) {
        this.orderID = orderID;
        this.productID = productID;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public OrderDetail() {
    }

    // Các phương thức getter/setter

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }
}
