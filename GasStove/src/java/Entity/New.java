/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.sql.Date;

/**
 *
 * @author krikn
 */
public class New {
    int newID;
    String type;
    String title;
    String description;
    int salePercent;
    int productID;
    String imageURL;
    Date createdDate;
    int categoryID;
    Product product;
    
    public New() {
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public New(int newID, String type, String title, String description, int salePercent, int productID, String imageURL, Date createdDate, int categoryID) {
        this.newID = newID;
        this.type = type;
        this.title = title;
        this.description = description;
        this.salePercent = salePercent;
        this.productID = productID;
        this.imageURL = imageURL;
        this.createdDate = createdDate;
        this.categoryID = categoryID;
    }

    public New(String type, String title, String description, int salePercent, int productID, String imageURL, int categoryID) {
        this.type = type;
        this.title = title;
        this.description = description;
        this.salePercent = salePercent;
        this.productID = productID;
        this.imageURL = imageURL;
        this.categoryID = categoryID;
    }

    
    
    public int getNewID() {
        return newID;
    }

    public void setNewID(int newID) {
        this.newID = newID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getSalePercent() {
        return salePercent;
    }

    public void setSalePercent(int salePercent) {
        this.salePercent = salePercent;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    @Override
    public String toString() {
        return "New{" + "newID=" + newID + ", type=" + type + ", title=" + title + ", description=" + description + ", salePercent=" + salePercent + ", productID=" + productID + ", imageURL=" + imageURL + ", createdDate=" + createdDate + ", categoryID=" + categoryID + '}';
    }

    
}
