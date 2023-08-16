/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.sql.Date;
import java.text.DecimalFormat;
import java.text.Normalizer;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author 5580
 */
public class Product {
    private int productID;
    private String productName;
    private int categoryID;
    private double unitPrice;
    private String description;
    private String modelNumber;
    private String imageURL;
    private Date createdDate;
    private Date modifiedDate;
    private String createdBy;
    private String modifiedBy;
    private String brand;
    private String warrantyPeriod;
    private int stock;
    private int saleoff;
    private String productcode; 

    public String convertToCode(String productName) {
    // Remove diacritical marks from Vietnamese characters
    String normalized = Normalizer.normalize(productName, Normalizer.Form.NFD);
    String withoutDiacritics = normalized.replaceAll("\\p{M}", "");

    // Replace non-alphanumeric characters (except parentheses and đ) with hyphens
    String code = withoutDiacritics
        .replaceAll("[^\\p{Alnum}\\s()\\-đ]", "")
        .replaceAll("\\s", "-").replaceAll("đ", "d");;

    // Convert to lowercase
    code = code.toLowerCase();

    return code;
}
    
    public String getProductcode() {
        
        return convertToCode(productName);
    }

    public void setProductcode(String productcode) {
        this.productcode = productcode;
    }

    public String getSalePrice() {
        double price = unitPrice - unitPrice*saleoff/100;
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
        String formatedPrice = currencyVN.format(price);
        return formatedPrice;
    }
    
    public int getSaleoffPercent(){
        return this.saleoff;
    }
    
    public void setSaleoff(int saleoff) {
        this.saleoff = saleoff;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    public Product() {
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getUnitPriceFixed() {
        Locale localeVN = new Locale("vi", "VN");
        NumberFormat currencyVN = NumberFormat.getCurrencyInstance(localeVN);
        String str1 = currencyVN.format(unitPrice);
        
//        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
//        String formattedUnitPrice = decimalFormat.format(unitPrice);
        return str1;
    }

    public String getUnitPrice() {
        DecimalFormat df = new DecimalFormat("#,###.##");
        
        return df.format(unitPrice);
    }

    public double getPrice(){
        return this.unitPrice;
    }
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getModelNumber() {
        return modelNumber;
    }

    public void setModelNumber(String modelNumber) {
        this.modelNumber = modelNumber;
    }

    public String getImageURL() {
        String imageUrl = null;
    
        if (imageURL != null && !imageURL.isEmpty()) {
            String[] urlArray = imageURL.split(", ");
            imageUrl = urlArray[0].trim();
        }

        return imageUrl;
    }

    public List<String> getImageURLs() {
        List<String> urls = new ArrayList<>();
        
        if (imageURL != null && !imageURL.isEmpty()) {
            String[] urlArray = imageURL.split(", ");
            for (String url : urlArray) {
                urls.add(url.trim());
            }
        }
        
        return urls;
    }
    
    public String getImageURLsString(){
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

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(String warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    public Product(int productID, String productName, int categoryID, double unitPrice, String description, String modelNumber, String imageURL, Date createdDate, Date modifiedDate, String createdBy, String modifiedBy, String brand, String warrantyPeriod, int stock, int saleoff) {
        this.productID = productID;
        this.productName = productName;
        this.categoryID = categoryID;
        this.unitPrice = unitPrice;
        this.description = description;
        this.modelNumber = modelNumber;
        this.imageURL = imageURL;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.createdBy = createdBy;
        this.modifiedBy = modifiedBy;
        this.brand = brand;
        this.warrantyPeriod = warrantyPeriod;
        this.stock = stock;
        this.saleoff = saleoff;
    }

    @Override
    public String toString() {
        return "Product{" + "productID=" + productID + ", productName=" + productName + ", categoryID=" + categoryID + ", unitPrice=" + unitPrice + ", description=" + description + ", modelNumber=" + modelNumber + ", imageURL=" + imageURL + ", createdDate=" + createdDate + ", modifiedDate=" + modifiedDate + ", createdBy=" + createdBy + ", modifiedBy=" + modifiedBy + ", brand=" + brand + ", warrantyPeriod=" + warrantyPeriod + ", stock=" + stock + ", saleoff=" + saleoff + '}';
    }
}
