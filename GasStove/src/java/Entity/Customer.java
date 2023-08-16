/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.util.Date;

/**
 *
 * @author DUC ANH
 */
public class Customer {
    private int customerID;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String city;
    private String district;
    private String addressDetail;
    private String username;
    private String password;
//    private String customerType;
    private int boughtCount;
    private Date createdDate;
    private Date modifiedDate;
    private String image;

    public Customer(int customerID, String firstName, String lastName, String email, String phoneNumber, String city, String district, String addressDetail, String username, String password, String image) {
        this.customerID = customerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.district = district;
        this.addressDetail = addressDetail;
        this.username = username;
        this.password = password;
        this.image = image;
    }

    
    
    public Customer(int customerID, String firstName, String lastName, String email, String phoneNumber, String city, String district, String addressDetail, String username, String password, int boughtCount, Date createdDate, Date modifiedDate, String image) {
        this.customerID = customerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.district = district;
        this.addressDetail = addressDetail;
        this.username = username;
        this.password = password;
        this.boughtCount = boughtCount;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
        this.image = image;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    
    public Customer() {
    }

    public Customer(int customerID, String firstName, String lastName, String email, String phoneNumber, String city, String district, String addressDetail, String username, String password, int boughtCount, Date createdDate, Date modifiedDate) {
        this.customerID = customerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.district = district;
        this.addressDetail = addressDetail;
        this.username = username;
        this.password = password;
//        this.customerType = customerType;
        this.boughtCount = boughtCount;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public String getCustomerType() {
//        return customerType;
//    }
//
//    public void setCustomerType(String customerType) {
//        this.customerType = customerType;
//    }

    public int getBoughtCount() {
        return boughtCount;
    }

    public void setBoughtCount(int boughtCount) {
        this.boughtCount = boughtCount;
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

    @Override
    public String toString() {
        return "Customer{" + "customerID=" + customerID + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", phoneNumber=" + phoneNumber + ", city=" + city + ", district=" + district + ", addressDetail=" + addressDetail + ", username=" + username + ", password=" + password + ", boughtCount=" + boughtCount + ", createdDate=" + createdDate + ", modifiedDate=" + modifiedDate + ", image=" + image + '}';
    }

    
    
}
