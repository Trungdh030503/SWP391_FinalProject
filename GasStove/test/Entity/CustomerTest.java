/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Entity;

import java.util.Date;

import static org.junit.Assert.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 *
 * @author DUC ANH
 */
public class CustomerTest {
    
    public CustomerTest() {
    }
    
    @Test
    public void testGetImage() {
        // Create a Customer object
        String image = "profile.jpg";
        Customer customer = new Customer();
        customer.setImage(image);

        // Verify the retrieved image using getImage() method
        String retrievedImage = customer.getImage();
//        Assertions.assertEquals(image, retrievedImage);
        assertEquals(image, retrievedImage);
    }

//    @Test
//    public void testSetImage() {
//        // Create a new Customer object
//        Customer customer = new Customer();
//
//        // Set the image
//        String image = "image.jpg";
//        customer.setImage(image);
//
//        // Verify that the image was set correctly
//        assertEquals(image, customer.getImage());
//    }
//
//    @Test
//    public void testGetCustomerID() {
//        // Create a new Customer object
//        Customer customer = new Customer();
//
//        // Set the customer ID
//        int customerID = 1;
//        customer.setCustomerID(customerID);
//
//        // Verify that the customer ID is retrieved correctly
//        assertEquals(customerID, customer.getCustomerID());
//    }
//
//    @Test
//    public void testSetCustomerID() {
//        // Create a new Customer object
//        Customer customer = new Customer();
//
//        // Set the customer ID
//        int customerID = 1;
//        customer.setCustomerID(customerID);
//
//        // Verify that the customer ID is set correctly
//        assertEquals(customerID, customer.getCustomerID());
//    }
//
//     @Test
//    public void testGetFirstName() {
//        // Create a new Customer object
//        Customer customer = new Customer();
//
//        // Test when first name is not set
//        assertNull(customer.getFirstName());
//
//        // Set the first name
//        String firstName = "John";
//        customer.setFirstName(firstName);
//
//        // Verify that the correct first name is returned
//        assertEquals(firstName, customer.getFirstName());
//
//        // Test when first name is updated
//        String newFirstName = "Jane";
//        customer.setFirstName(newFirstName);
//
//        // Verify that the first name is updated correctly
//        assertEquals(newFirstName, customer.getFirstName());
//
//        // Test when first name is set to an empty string
//        customer.setFirstName("");
//        assertEquals("", customer.getFirstName());
//
//        // Test when first name is set to null
//        customer.setFirstName(null);
//        assertNull(customer.getFirstName());
//    }
//
//    @Test
//    public void testSetFirstName() {
//        // Create a new Customer object
//        Customer customer = new Customer();
//
//        // Set the first name
//        String firstName = "John";
//        customer.setFirstName(firstName);
//
//        // Verify that the first name is set correctly
//        assertEquals(firstName, customer.getFirstName());
//
//        // Update the first name
//        String newFirstName = "Jane";
//        customer.setFirstName(newFirstName);
//
//        // Verify that the first name is updated correctly
//        assertEquals(newFirstName, customer.getFirstName());
//
//        // Set the first name to an empty string
//        customer.setFirstName("");
//        assertEquals("", customer.getFirstName());
//
//        // Set the first name to null
//        customer.setFirstName(null);
//        assertNull(customer.getFirstName());
//    }
//
//     @Test
//    public void testGetLastName() {
//        // Create a new Customer object
//        Customer customer = new Customer();
//
//        // Test when last name is not set
//        assertNull(customer.getLastName());
//
//        // Set the last name
//        String lastName = "Doe";
//        customer.setLastName(lastName);
//
//        // Verify that the correct last name is returned
//        assertEquals(lastName, customer.getLastName());
//
//        // Test when last name is updated
//        String newLastName = "Smith";
//        customer.setLastName(newLastName);
//
//        // Verify that the last name is updated correctly
//        assertEquals(newLastName, customer.getLastName());
//
//        // Test when last name is set to an empty string
//        customer.setLastName("");
//        assertEquals("", customer.getLastName());
//
//        // Test when last name is set to null
//        customer.setLastName(null);
//        assertNull(customer.getLastName());
//    }
//
//    @Test
//    public void testSetLastName() {
//        // Create a new Customer object
//        Customer customer = new Customer();
//
//        // Set the last name
//        String lastName = "Doe";
//        customer.setLastName(lastName);
//
//        // Verify that the last name is set correctly
//        assertEquals(lastName, customer.getLastName());
//
//        // Update the last name
//        String newLastName = "Smith";
//        customer.setLastName(newLastName);
//
//        // Verify that the last name is updated correctly
//        assertEquals(newLastName, customer.getLastName());
//
//        // Set the last name to an empty string
//        customer.setLastName("");
//        assertEquals("", customer.getLastName());
//
//        // Set the last name to null
//        customer.setLastName(null);
//        assertNull(customer.getLastName());
//    }
//
//    @Test
//    public void testGetEmail() {
//        // Create a new Customer object
//        Customer customer = new Customer();
//
//        // Test when email is not set
//        assertNull(customer.getEmail());
//
//        // Set the email
//        String email = "john.doe@example.com";
//        customer.setEmail(email);
//
//        // Verify that the correct email is returned
//        assertEquals(email, customer.getEmail());
//
//        // Test when email is updated
//        String newEmail = "jane.smith@example.com";
//        customer.setEmail(newEmail);
//
//        // Verify that the email is updated correctly
//        assertEquals(newEmail, customer.getEmail());
//
//        // Test when email is set to an empty string
//        customer.setEmail("");
//        assertEquals("", customer.getEmail());
//
//        // Test when email is set to null
//        customer.setEmail(null);
//        assertNull(customer.getEmail());
//    }
//
//    @Test
//    public void testSetEmail() {
//        // Create a new Customer object
//        Customer customer = new Customer();
//
//        // Set the email
//        String email = "john.doe@example.com";
//        customer.setEmail(email);
//
//        // Verify that the email is set correctly
//        assertEquals(email, customer.getEmail());
//
//        // Update the email
//        String newEmail = "jane.smith@example.com";
//        customer.setEmail(newEmail);
//
//        // Verify that the email is updated correctly
//        assertEquals(newEmail, customer.getEmail());
//
//        // Set the email to an empty string
//        customer.setEmail("");
//        assertEquals("", customer.getEmail());
//
//        // Set the email to null
//        customer.setEmail(null);
//        assertNull(customer.getEmail());
//    }
//
//    @Test
//    public void testGetPhoneNumber() {
//        // Create a new Customer object
//        Customer customer = new Customer();
//
//        // Test when phone number is not set
//        assertNull(customer.getPhoneNumber());
//
//        // Set the phone number
//        String phoneNumber = "1234567890";
//        customer.setPhoneNumber(phoneNumber);
//
//        // Verify that the correct phone number is returned
//        assertEquals(phoneNumber, customer.getPhoneNumber());
//
//        // Test when phone number is updated
//        String newPhoneNumber = "9876543210";
//        customer.setPhoneNumber(newPhoneNumber);
//
//        // Verify that the phone number is updated correctly
//        assertEquals(newPhoneNumber, customer.getPhoneNumber());
//
//        // Test when phone number is set to an empty string
//        customer.setPhoneNumber("");
//        assertEquals("", customer.getPhoneNumber());
//
//        // Test when phone number is set to null
//        customer.setPhoneNumber(null);
//        assertNull(customer.getPhoneNumber());
//    }
//
//    @Test
//    public void testSetPhoneNumber() {
//        // Create a new Customer object
//        Customer customer = new Customer();
//
//        // Set the phone number
//        String phoneNumber = "1234567890";
//        customer.setPhoneNumber(phoneNumber);
//
//        // Verify that the phone number is set correctly
//        assertEquals(phoneNumber, customer.getPhoneNumber());
//
//        // Update the phone number
//        String newPhoneNumber = "9876543210";
//        customer.setPhoneNumber(newPhoneNumber);
//
//        // Verify that the phone number is updated correctly
//        assertEquals(newPhoneNumber, customer.getPhoneNumber());
//
//        // Set the phone number to an empty string
//        customer.setPhoneNumber("");
//        assertEquals("", customer.getPhoneNumber());
//
//        // Set the phone number to null
//        customer.setPhoneNumber(null);
//        assertNull(customer.getPhoneNumber());
//    }
//
//     @Test
//    public void testGetCity() {
//        // Create a new Customer object
//        Customer customer = new Customer();
//
//        // Test when city is not set
//        assertNull(customer.getCity());
//
//        // Set the city
//        String city = "New York";
//        customer.setCity(city);
//
//        // Verify that the correct city is returned
//        assertEquals(city, customer.getCity());
//
//        // Test when city is updated
//        String newCity = "Los Angeles";
//        customer.setCity(newCity);
//
//        // Verify that the city is updated correctly
//        assertEquals(newCity, customer.getCity());
//
//        // Test when city is set to an empty string
//        customer.setCity("");
//        assertEquals("", customer.getCity());
//
//        // Test when city is set to null
//        customer.setCity(null);
//        assertNull(customer.getCity());
//
//        // Test with different city names
//        String unicodeCity = "Çanakkale";
//        customer.setCity(unicodeCity);
//        assertEquals(unicodeCity, customer.getCity());
//
//        String spaceCity = " ";
//        customer.setCity(spaceCity);
//        assertEquals(spaceCity, customer.getCity());
//
//        // Test with long city names
//        String longCity = "ThisIsAVeryLongCityNameWithMoreThanTwentyCharacters";
//        customer.setCity(longCity);
//        assertEquals(longCity, customer.getCity());
//    }
//
//    @Test
//    public void testSetCity() {
//        // Create a new Customer object
//        Customer customer = new Customer();
//
//        // Set the city
//        String city = "New York";
//        customer.setCity(city);
//
//        // Verify that the city is set correctly
//        assertEquals(city, customer.getCity());
//
//        // Update the city
//        String newCity = "Los Angeles";
//        customer.setCity(newCity);
//
//        // Verify that the city is updated correctly
//        assertEquals(newCity, customer.getCity());
//
//        // Set the city to an empty string
//        customer.setCity("");
//        assertEquals("", customer.getCity());
//
//        // Set the city to null
//        customer.setCity(null);
//        assertNull(customer.getCity());
//
//        // Set a different city name
//        String unicodeCity = "Çanakkale";
//        customer.setCity(unicodeCity);
//        assertEquals(unicodeCity, customer.getCity());
//
//        // Set a city name with leading and trailing spaces
//        String spaceCity = " ";
//        customer.setCity(spaceCity);
//        assertEquals(spaceCity, customer.getCity());
//
//        // Set a long city name
//        String longCity = "ThisIsAVeryLongCityNameWithMoreThanTwentyCharacters";
//        customer.setCity(longCity);
//        assertEquals(longCity, customer.getCity());
//    }
//
//    @Test
//    public void testGetDistrict() {
//        // Create a new Customer object
//        Customer customer = new Customer();
//
//        // Test when district is not set
//        assertNull(customer.getDistrict());
//
//        // Set the district
//        String district = "Central";
//        customer.setDistrict(district);
//
//        // Verify that the correct district is returned
//        assertEquals(district, customer.getDistrict());
//
//        // Test when district is updated
//        String newDistrict = "North";
//        customer.setDistrict(newDistrict);
//
//        // Verify that the district is updated correctly
//        assertEquals(newDistrict, customer.getDistrict());
//
//        // Test when district is set to an empty string
//        customer.setDistrict("");
//        assertEquals("", customer.getDistrict());
//
//        // Test when district is set to null
//        customer.setDistrict(null);
//        assertNull(customer.getDistrict());
//
//        // Test with different district names
//        String unicodeDistrict = "Çankaya";
//        customer.setDistrict(unicodeDistrict);
//        assertEquals(unicodeDistrict, customer.getDistrict());
//
//        String spaceDistrict = " ";
//        customer.setDistrict(spaceDistrict);
//        assertEquals(spaceDistrict, customer.getDistrict());
//
//        // Test with long district names
//        String longDistrict = "ThisIsAVeryLongDistrictNameWithMoreThanTwentyCharacters";
//        customer.setDistrict(longDistrict);
//        assertEquals(longDistrict, customer.getDistrict());
//    }
//
//    @Test
//    public void testSetDistrict() {
//        // Create a new Customer object
//        Customer customer = new Customer();
//
//        // Set the district
//        String district = "Central";
//        customer.setDistrict(district);
//
//        // Verify that the district is set correctly
//        assertEquals(district, customer.getDistrict());
//
//        // Update the district
//        String newDistrict = "North";
//        customer.setDistrict(newDistrict);
//
//        // Verify that the district is updated correctly
//        assertEquals(newDistrict, customer.getDistrict());
//
//        // Set the district to an empty string
//        customer.setDistrict("");
//        assertEquals("", customer.getDistrict());
//
//        // Set the district to null
//        customer.setDistrict(null);
//        assertNull(customer.getDistrict());
//
//        // Set a different district name
//        String unicodeDistrict = "Çankaya";
//        customer.setDistrict(unicodeDistrict);
//        assertEquals(unicodeDistrict, customer.getDistrict());
//
//        // Set a district name with leading and trailing spaces
//        String spaceDistrict = " ";
//        customer.setDistrict(spaceDistrict);
//        assertEquals(spaceDistrict, customer.getDistrict());
//
//        // Set a long district name
//        String longDistrict = "ThisIsAVeryLongDistrictNameWithMoreThanTwentyCharacters";
//        customer.setDistrict(longDistrict);
//        assertEquals(longDistrict, customer.getDistrict());
//    }
//
//    @Test
//    public void testGetAddressDetail() {
//        // Create a new Customer object
//        Customer customer = new Customer();
//
//        // Test when address detail is not set
//        assertNull(customer.getAddressDetail());
//
//        // Set the address detail
//        String addressDetail = "123 Main Street";
//        customer.setAddressDetail(addressDetail);
//
//        // Verify that the correct address detail is returned
//        assertEquals(addressDetail, customer.getAddressDetail());
//
//        // Test when address detail is updated
//        String newAddressDetail = "456 Elm Street";
//        customer.setAddressDetail(newAddressDetail);
//
//        // Verify that the address detail is updated correctly
//        assertEquals(newAddressDetail, customer.getAddressDetail());
//
//        // Test when address detail is set to an empty string
//        customer.setAddressDetail("");
//        assertEquals("", customer.getAddressDetail());
//
//        // Test when address detail is set to null
//        customer.setAddressDetail(null);
//        assertNull(customer.getAddressDetail());
//
//        // Test with different address details
//        String unicodeAddressDetail = "İstiklal Caddesi";
//        customer.setAddressDetail(unicodeAddressDetail);
//        assertEquals(unicodeAddressDetail, customer.getAddressDetail());
//
//        String spaceAddressDetail = " ";
//        customer.setAddressDetail(spaceAddressDetail);
//        assertEquals(spaceAddressDetail, customer.getAddressDetail());
//
//        // Test with long address details
//        String longAddressDetail = "ThisIsAVeryLongAddressDetailWithMoreThanTwentyCharacters";
//        customer.setAddressDetail(longAddressDetail);
//        assertEquals(longAddressDetail, customer.getAddressDetail());
//    }
//
//    @Test
//    public void testSetAddressDetail() {
//        // Create a new Customer object
//        Customer customer = new Customer();
//
//        // Set the address detail
//        String addressDetail = "123 Main Street";
//        customer.setAddressDetail(addressDetail);
//
//        // Verify that the address detail is set correctly
//        assertEquals(addressDetail, customer.getAddressDetail());
//
//        // Update the address detail
//        String newAddressDetail = "456 Elm Street";
//        customer.setAddressDetail(newAddressDetail);
//
//        // Verify that the address detail is updated correctly
//        assertEquals(newAddressDetail, customer.getAddressDetail());
//
//        // Set the address detail to an empty string
//        customer.setAddressDetail("");
//        assertEquals("", customer.getAddressDetail());
//
//        // Set the address detail to null
//        customer.setAddressDetail(null);
//        assertNull(customer.getAddressDetail());
//
//        // Set a different address detail
//        String unicodeAddressDetail = "İstiklal Caddesi";
//        customer.setAddressDetail(unicodeAddressDetail);
//        assertEquals(unicodeAddressDetail, customer.getAddressDetail());
//
//        // Set an address detail with leading and trailing spaces
//        String spaceAddressDetail = " ";
//        customer.setAddressDetail(spaceAddressDetail);
//        assertEquals(spaceAddressDetail, customer.getAddressDetail());
//
//        // Set a long address detail
//        String longAddressDetail = "ThisIsAVeryLongAddressDetailWithMoreThanTwentyCharacters";
//        customer.setAddressDetail(longAddressDetail);
//        assertEquals(longAddressDetail, customer.getAddressDetail());
//    }
//
//    @Test
//    public void testGetUsername() {
//        // Create a new Customer object
//        Customer customer = new Customer();
//
//        // Test when username is not set
//        assertNull(customer.getUsername());
//
//        // Set the username
//        String username = "john123";
//        customer.setUsername(username);
//
//        // Verify that the correct username is returned
//        assertEquals(username, customer.getUsername());
//
//        // Test when username is updated
//        String newUsername = "johndoe";
//        customer.setUsername(newUsername);
//
//        // Verify that the username is updated correctly
//        assertEquals(newUsername, customer.getUsername());
//
//        // Test when username is set to an empty string
//        customer.setUsername("");
//        assertEquals("", customer.getUsername());
//
//        // Test when username is set to null
//        customer.setUsername(null);
//        assertNull(customer.getUsername());
//
//        // Test with different usernames
//        String unicodeUsername = "janeDoe";
//        customer.setUsername(unicodeUsername);
//        assertEquals(unicodeUsername, customer.getUsername());
//
//        String spaceUsername = " ";
//        customer.setUsername(spaceUsername);
//        assertEquals(spaceUsername, customer.getUsername());
//
//        // Test with long usernames
//        String longUsername = "ThisIsAVeryLongUsernameWithMoreThanTwentyCharacters";
//        customer.setUsername(longUsername);
//        assertEquals(longUsername, customer.getUsername());
//    }
//
//    @Test
//    public void testSetUsername() {
//        // Create a new Customer object
//        Customer customer = new Customer();
//
//        // Set the username
//        String username = "john123";
//        customer.setUsername(username);
//
//        // Verify that the username is set correctly
//        assertEquals(username, customer.getUsername());
//
//        // Update the username
//        String newUsername = "johndoe";
//        customer.setUsername(newUsername);
//
//        // Verify that the username is updated correctly
//        assertEquals(newUsername, customer.getUsername());
//
//        // Set the username to an empty string
//        customer.setUsername("");
//        assertEquals("", customer.getUsername());
//
//        // Set the username to null
//        customer.setUsername(null);
//        assertNull(customer.getUsername());
//
//        // Set a different username
//        String unicodeUsername = "janeDoe";
//        customer.setUsername(unicodeUsername);
//        assertEquals(unicodeUsername, customer.getUsername());
//
//        // Set a username with leading and trailing spaces
//        String spaceUsername = " ";
//        customer.setUsername(spaceUsername);
//        assertEquals(spaceUsername, customer.getUsername());
//
//        // Set a long username
//        String longUsername = "ThisIsAVeryLongUsernameWithMoreThanTwentyCharacters";
//        customer.setUsername(longUsername);
//        assertEquals(longUsername, customer.getUsername());
//    }
//
//    @Test
//    public void testGetPassword() {
//        // Create a new Customer object
//        Customer customer = new Customer();
//
//        // Test when password is not set
//        assertNull(customer.getPassword());
//
//        // Set the password
//        String password = "secret123";
//        customer.setPassword(password);
//
//        // Verify that the correct password is returned
//        assertEquals(password, customer.getPassword());
//
//        // Test when password is updated
//        String newPassword = "newpassword";
//        customer.setPassword(newPassword);
//
//        // Verify that the password is updated correctly
//        assertEquals(newPassword, customer.getPassword());
//
//        // Test when password is set to an empty string
//        customer.setPassword("");
//        assertEquals("", customer.getPassword());
//
//        // Test when password is set to null
//        customer.setPassword(null);
//        assertNull(customer.getPassword());
//
//        // Test with different passwords
//        String unicodePassword = "pässwörd";
//        customer.setPassword(unicodePassword);
//        assertEquals(unicodePassword, customer.getPassword());
//
//        String spacePassword = " ";
//        customer.setPassword(spacePassword);
//        assertEquals(spacePassword, customer.getPassword());
//
//        // Test with long passwords
//        String longPassword = "ThisIsAVeryLongPasswordWithMoreThanTwentyCharacters";
//        customer.setPassword(longPassword);
//        assertEquals(longPassword, customer.getPassword());
//    }
//
//    @Test
//    public void testSetPassword() {
//        // Create a new Customer object
//        Customer customer = new Customer();
//
//        // Set the password
//        String password = "secret123";
//        customer.setPassword(password);
//
//        // Verify that the password is set correctly
//        assertEquals(password, customer.getPassword());
//
//        // Update the password
//        String newPassword = "newpassword";
//        customer.setPassword(newPassword);
//
//        // Verify that the password is updated correctly
//        assertEquals(newPassword, customer.getPassword());
//
//        // Set the password to an empty string
//        customer.setPassword("");
//        assertEquals("", customer.getPassword());
//
//        // Set the password to null
//        customer.setPassword(null);
//        assertNull(customer.getPassword());
//
//        // Set a different password
//        String unicodePassword = "pässwörd";
//        customer.setPassword(unicodePassword);
//        assertEquals(unicodePassword, customer.getPassword());
//
//        // Set a password with leading and trailing spaces
//        String spacePassword = " ";
//        customer.setPassword(spacePassword);
//        assertEquals(spacePassword, customer.getPassword());
//
//        // Set a long password
//        String longPassword = "ThisIsAVeryLongPasswordWithMoreThanTwentyCharacters";
//        customer.setPassword(longPassword);
//        assertEquals(longPassword, customer.getPassword());
//    }
//
//    @Test
//    public void testGetBoughtCount() {
//        // Create a new Customer object
//        Customer customer = new Customer();
//
//        // Test when bought count is not set
//        assertEquals(0, customer.getBoughtCount());
//
//        // Set the bought count
//        int boughtCount = 10;
//        customer.setBoughtCount(boughtCount);
//
//        // Verify that the correct bought count is returned
//        assertEquals(boughtCount, customer.getBoughtCount());
//
//        // Test when bought count is updated
//        int newBoughtCount = 20;
//        customer.setBoughtCount(newBoughtCount);
//
//        // Verify that the bought count is updated correctly
//        assertEquals(newBoughtCount, customer.getBoughtCount());
//    }
//
//    @Test
//    public void testSetBoughtCount() {
//        // Create a new Customer object
//        Customer customer = new Customer();
//
//        // Set the bought count
//        int boughtCount = 10;
//        customer.setBoughtCount(boughtCount);
//
//        // Verify that the bought count is set correctly
//        assertEquals(boughtCount, customer.getBoughtCount());
//
//        // Update the bought count
//        int newBoughtCount = 20;
//        customer.setBoughtCount(newBoughtCount);
//
//        // Verify that the bought count is updated correctly
//        assertEquals(newBoughtCount, customer.getBoughtCount());
//
//        // Set the bought count to zero
//        int zeroBoughtCount = 0;
//        customer.setBoughtCount(zeroBoughtCount);
//        assertEquals(zeroBoughtCount, customer.getBoughtCount());
//
//        // Set a negative bought count
//        int negativeBoughtCount = -5;
//        customer.setBoughtCount(negativeBoughtCount);
//        assertEquals(negativeBoughtCount, customer.getBoughtCount());
//    }
//
//    @Test
//    public void testGetCreatedDate() {
//        // Create a new Customer object
//        Customer customer = new Customer();
//
//        // Test when created date is not set
//        assertNull(customer.getCreatedDate());
//
//        // Set the created date
//        Date createdDate = new Date();
//        customer.setCreatedDate(createdDate);
//
//        // Verify that the correct created date is returned
//        assertEquals(createdDate, customer.getCreatedDate());
//
//        // Test when created date is updated
//        Date newCreatedDate = new Date();
//        customer.setCreatedDate(newCreatedDate);
//
//        // Verify that the created date is updated correctly
//        assertEquals(newCreatedDate, customer.getCreatedDate());
//    }
//
//    @Test
//    public void testSetCreatedDate() {
//        // Create a new Customer object
//        Customer customer = new Customer();
//
//        // Set the created date
//        Date createdDate = new Date();
//        customer.setCreatedDate(createdDate);
//
//        // Verify that the created date is set correctly
//        assertEquals(createdDate, customer.getCreatedDate());
//
//        // Update the created date
//        Date newCreatedDate = new Date();
//        customer.setCreatedDate(newCreatedDate);
//
//        // Verify that the created date is updated correctly
//        assertEquals(newCreatedDate, customer.getCreatedDate());
//
//        // Set the created date to null
//        customer.setCreatedDate(null);
//        assertNull(customer.getCreatedDate());
//    }
//
//    @Test
//    public void testGetModifiedDate() {
//        // Create a new Customer object
//        Customer customer = new Customer();
//
//        // Test when modified date is not set
//        assertNull(customer.getModifiedDate());
//
//        // Set the modified date
//        Date modifiedDate = new Date();
//        customer.setModifiedDate(modifiedDate);
//
//        // Verify that the correct modified date is returned
//        assertEquals(modifiedDate, customer.getModifiedDate());
//
//        // Test when modified date is updated
//        Date newModifiedDate = new Date();
//        customer.setModifiedDate(newModifiedDate);
//
//        // Verify that the modified date is updated correctly
//        assertEquals(newModifiedDate, customer.getModifiedDate());
//    }
//
//    @Test
//    public void testSetModifiedDate() {
//        // Create a new Customer object
//        Customer customer = new Customer();
//
//        // Set the modified date
//        Date modifiedDate = new Date();
//        customer.setModifiedDate(modifiedDate);
//
//        // Verify that the modified date is set correctly
//        assertEquals(modifiedDate, customer.getModifiedDate());
//
//        // Update the modified date
//        Date newModifiedDate = new Date();
//        customer.setModifiedDate(newModifiedDate);
//
//        // Verify that the modified date is updated correctly
//        assertEquals(newModifiedDate, customer.getModifiedDate());
//
//        // Set the modified date to null
//        customer.setModifiedDate(null);
//        assertNull(customer.getModifiedDate());
//    }
//
//    @Test
//    public void testToString() {
//        // Create a new Customer object with sample data
//        Customer customer = new Customer(1, "John", "Doe", "john.doe@example.com", "123456789", "City", "District", "Address", "johndoe", "password", 10, new Date(), new Date());
//
//        // Define the expected string representation
//        String expectedString = "Customer{customerID=1, firstName=John, lastName=Doe, email=john.doe@example.com, phoneNumber=123456789, city=City, district=District, addressDetail=Address, username=johndoe, password=password, boughtCount=10, createdDate=" + customer.getCreatedDate() + ", modifiedDate=" + customer.getModifiedDate() + ", image=null}";
//
//        // Verify that the toString method returns the expected string representation
//        assertEquals(expectedString, customer.toString());
//    }
    
}

