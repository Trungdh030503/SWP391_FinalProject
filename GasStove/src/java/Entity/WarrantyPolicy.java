/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

/**
 *
 * @author 5580
 */
public class WarrantyPolicy {
    int Warrantyid;
    String WarrantyPeriod;
    String WarrantyCategory;

    public WarrantyPolicy() {
    }

    public WarrantyPolicy(int Warrantyid, String WarrantyPeriod, String WarrantyCategory) {
        this.Warrantyid = Warrantyid;
        this.WarrantyPeriod = WarrantyPeriod;
        this.WarrantyCategory = WarrantyCategory;
    }

    public int getWarrantyid() {
        return Warrantyid;
    }

    public void setWarrantyid(int Warrantyid) {
        this.Warrantyid = Warrantyid;
    }

    public String getWarrantyPeriod() {
        return WarrantyPeriod;
    }

    public void setWarrantyPeriod(String WarrantyPeriod) {
        this.WarrantyPeriod = WarrantyPeriod;
    }

    public String getWarrantyCategory() {
        return WarrantyCategory;
    }

    public void setWarrantyCategory(String WarrantyCategory) {
        this.WarrantyCategory = WarrantyCategory;
    }
    
    

    @Override
    public String toString() {
        return "WarrantyPolicy{" + "Warrantyid=" + Warrantyid + ", WarrantyPeriod=" + WarrantyPeriod + ", WarrantyCategory=" + WarrantyCategory + '}';
    }
    
    
}
