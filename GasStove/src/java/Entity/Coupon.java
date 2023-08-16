/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import DAO.ProductDAO;
import java.sql.Date;

/**
 *
 * @author 5580
 */
public class Coupon {
    private int couponID;

    public Coupon(int couponID, int ProductID, String CouponName, double discount, Date startdate, Date enddate, int MinimunTotalPrice, int PurchaseQuantity, int MinimumBoughtCount) {
        this.couponID = couponID;
        this.ProductID = ProductID;
        this.CouponName = CouponName;
        this.discount = discount;
        this.startdate = startdate;
        this.enddate = enddate;
        this.MinimunTotalPrice = MinimunTotalPrice;
        this.PurchaseQuantity = PurchaseQuantity;
        this.MinimumBoughtCount = MinimumBoughtCount;
    }

    public int getCouponID() {
        return couponID;
    }

    public void setCouponID(int couponID) {
        this.couponID = couponID;
    }
    private int ProductID;
    private String CouponName;
    private double discount;
    private Date startdate;
    private Date enddate;
    private int MinimunTotalPrice;
    private int PurchaseQuantity;
    private int MinimumBoughtCount;

    
    public Product getProduct(){
        ProductDAO pd = new ProductDAO();
        return pd.getProductById(ProductID);
    }
    
    public int getProductID() {
        return ProductID;
    }

    public void setProductID(int ProductID) {
        this.ProductID = ProductID;
    }

    public String getCouponName() {
        return CouponName;
    }

    public void setCouponName(String CouponName) {
        this.CouponName = CouponName;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public Date getStartdate() {
        return startdate;
    }

    public void setStartdate(Date startdate) {
        this.startdate = startdate;
    }

    public Date getEnddate() {
        return enddate;
    }

    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    public int getMinimunTotalPrice() {
        return MinimunTotalPrice;
    }

    public void setMinimunTotalPrice(int MinimunTotalPrice) {
        this.MinimunTotalPrice = MinimunTotalPrice;
    }

    public int getPurchaseQuantity() {
        return PurchaseQuantity;
    }

    public void setPurchaseQuantity(int PurchaseQuantity) {
        this.PurchaseQuantity = PurchaseQuantity;
    }

    public int getMinimumBoughtCount() {
        return MinimumBoughtCount;
    }

    public void setMinimumBoughtCount(int MinimumBoughtCount) {
        this.MinimumBoughtCount = MinimumBoughtCount;
    }

    public Coupon() {
    }

    public Coupon(int ProductID, String CouponName, double discount, Date startdate, Date enddate, int MinimunTotalPrice, int PurchaseQuantity, int MinimumBoughtCount) {
        this.ProductID = ProductID;
        this.CouponName = CouponName;
        this.discount = discount;
        this.startdate = startdate;
        this.enddate = enddate;
        this.MinimunTotalPrice = MinimunTotalPrice;
        this.PurchaseQuantity = PurchaseQuantity;
        this.MinimumBoughtCount = MinimumBoughtCount;
    }

    @Override
    public String toString() {
        return "Coupon{" + "couponID=" + couponID + ", ProductID=" + ProductID + ", CouponName=" + CouponName + ", discount=" + discount + ", startdate=" + startdate + ", enddate=" + enddate + ", MinimunTotalPrice=" + MinimunTotalPrice + ", PurchaseQuantity=" + PurchaseQuantity + ", MinimumBoughtCount=" + MinimumBoughtCount + '}';
    }
}
