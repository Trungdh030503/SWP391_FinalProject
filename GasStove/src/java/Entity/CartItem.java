/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.math.BigDecimal;

/**
 *
 * @author DUC ANH
 */
public class CartItem {
    private String productName;
    private BigDecimal unitPrice;
    private int quantity;
    private BigDecimal totalPrice;
    private String productID;
    // Constructors, getters, setters, and other methods
    public CartItem(String productName, BigDecimal unitPrice, int quantity, BigDecimal totalPrice) {
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public CartItem(String productName, BigDecimal unitPrice, int quantity, BigDecimal totalPrice, String productID) {
        this.productName = productName;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.productID = productID;
    }

    public CartItem() {
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "CartItem{" + "productName=" + productName + ", unitPrice=" + unitPrice + ", quantity=" + quantity + ", totalPrice=" + totalPrice + '}';
    }

    // Calculate and set the total price based on unit price and quantity
    public void calculateTotalPrice() {
        totalPrice = unitPrice.multiply(BigDecimal.valueOf(quantity));
    }
    
    public void increaseQuantity() {
        quantity++;
    }
}
