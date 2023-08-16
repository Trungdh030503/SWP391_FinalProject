/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entity;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.util.Base64;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import static javax.crypto.Cipher.SECRET_KEY;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Lenovo
 */
public class Employee {
    private  int EmployeeID;
    private String FirstName;
    private  String LastName;
    private String Email;
    private String PhoneNumber;
    private String Address;
    private Date HireDate;
    private Double Salary;
    private String JobTitle;
    private String username;
    private String password;
    private String AvatarURL;

    public Employee() {
    }

    public Employee(int EmployeeID, String FirstName, String LastName, String Email, String PhoneNumber, String Address, Date HireDate, Double Salary, String JobTitle, String username, String password, String AvatarURL) {
        this.EmployeeID = EmployeeID;
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.Email = Email;
        this.PhoneNumber = PhoneNumber;
        this.Address = Address;
        this.HireDate = HireDate;
        this.Salary = Salary;
        this.JobTitle = JobTitle;
        this.username = username;
        this.password = password;
        this.AvatarURL = AvatarURL;
    }

    public int getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(int EmployeeID) {
        this.EmployeeID = EmployeeID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(String PhoneNumber) {
        this.PhoneNumber = PhoneNumber;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public Date getHireDate() {
        return HireDate;
    }

    public void setHireDate(Date HireDate) {
        this.HireDate = HireDate;
    }

    public Double getSalary() {
        return Salary;
    }

    public void setSalary(Double Salary) {
        this.Salary = Salary;
    }

    public String getJobTitle() {
        return JobTitle;
    }

    public void setJobTitle(String JobTitle) {
        this.JobTitle = JobTitle;
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

    public String getAvatarURL() {
        return AvatarURL;
    }

    public void setAvatarURL(String AvatarURL) {
        this.AvatarURL = AvatarURL;
    }
    public String getDecryptedPassword() {
        return decryptPassword(password);
    }
    
     private static final String SECRET_KEY = "YourSecretKey123";
    private static final String ENCRYPTION_ALGORITHM = "AES";
    private static String decryptPassword(String encryptedPassword) {
    try {
        SecretKeySpec secretKeySpec = new SecretKeySpec(SECRET_KEY.getBytes(), ENCRYPTION_ALGORITHM);
        Cipher cipher = Cipher.getInstance(ENCRYPTION_ALGORITHM);
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
        byte[] encryptedBytes = Base64.getDecoder().decode(encryptedPassword);
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
        return new String(decryptedBytes);
    } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
        e.printStackTrace();
    }
    return null;
}

    
    
   
}



