/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Entity;

import DAO.CustomerDAO;
import DAO.ProductDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lenovo
 */
public class WarrantyTest {

    public WarrantyTest() {
    }

    @Test
    public void testGetCustomer() {
        // Arrange
        Warranty warranty = new Warranty();
        int customerId = 1;
        warranty.setCustomerid(customerId);
        CustomerDAO customerDAO = new CustomerDAO();

        // Act
        Customer customer = customerDAO.getCustomerById(customerId);

        // Assert
        assertNotNull(customer);
        assertEquals(customerId, customer.getCustomerID());
    }

    @Test
    public void testSetCustomer() {
        // Arrange
        Warranty warranty = new Warranty();
        Customer customer = new Customer();
        int customerId = 1;
        customer.setCustomerID(customerId);
        warranty.setCustomerid(customerId);

        // Act
        warranty.setCustomer(customer);

        // Assert
        assertEquals(customerId, warranty.getCustomerid());
    }

    @Test
    public void testGetProduct() {
        // Arrange
        Warranty warranty = new Warranty();
        int productId = 1;
        warranty.setProductID(productId);
        ProductDAO productDAO = new ProductDAO();

        // Act
        Product product = warranty.getProduct();

        // Assert
        assertNotNull(product);
        assertEquals(productId, product.getProductID());
    }

    @Test
    public void testSetProduct() {
        // Arrange
        Warranty warranty = new Warranty();
        Product product = new Product();
        int productId = 1;
        product.setProductID(productId);
        warranty.setProductID(productId);

        // Act
        warranty.setProduct(product);

        // Assert
        assertEquals(productId, warranty.getProduct().getProductID());
    }

    @Test
    public void testGetWarrantyID() {
        // Arrange
        int expectedWarrantyID = 1;
        Warranty warranty = new Warranty();
        warranty.setWarrantyID(expectedWarrantyID);

        // Act
        int actualWarrantyID = warranty.getWarrantyID();

        // Assert
        assertEquals(expectedWarrantyID, actualWarrantyID);
    }
//

    @Test
    public void testSetWarrantyID() {
        // Arrange
        int expectedWarrantyID = 1;
        Warranty warranty = new Warranty();

        // Act
        warranty.setWarrantyID(expectedWarrantyID);

        // Assert
        assertEquals(expectedWarrantyID, warranty.getWarrantyID());
    }

    @Test
    public void testGetProductID() {
        // Arrange
        Warranty warranty = new Warranty();
        int expectedProductID = 1;
        warranty.setProductID(expectedProductID);

        // Act
        int actualProductID = warranty.getProductID();

        // Assert
        assertEquals(expectedProductID, actualProductID);
    }

    @Test
    public void testSetProductID() {
        // Arrange
        Warranty warranty = new Warranty();
        int expectedProductID = 1;

        // Act
        warranty.setProductID(expectedProductID);

        // Assert
        assertEquals(expectedProductID, warranty.getProductID());
    }

    @Test
    public void testGetOrderID() {
        // Arrange
        Warranty warranty = new Warranty();
        int expectedOrderID = 1;
        warranty.setOrderID(expectedOrderID);

        // Act
        int actualOrderID = warranty.getOrderID();

        // Assert
        assertEquals(expectedOrderID, actualOrderID);
    }

    @Test
    public void testSetOrderID() {
        // Arrange
        Warranty warranty = new Warranty();
        int expectedOrderID = 1;

        // Act
        warranty.setOrderID(expectedOrderID);

        // Assert
        assertEquals(expectedOrderID, warranty.getOrderID());
    }

    @Test
    public void testGetCustomerid() {
        // Arrange
        Warranty warranty = new Warranty();
        int expectedCustomerid = 1;
        warranty.setCustomerid(expectedCustomerid);

        // Act
        int actualCustomerid = warranty.getCustomerid();

        // Assert
        assertEquals(expectedCustomerid, actualCustomerid);
    }

    @Test
    public void testSetCustomerid() {
        // Arrange
        Warranty warranty = new Warranty();
        int expectedCustomerid = 1;

        // Act
        warranty.setCustomerid(expectedCustomerid);

        // Assert
        assertEquals(expectedCustomerid, warranty.getCustomerid());
    }

@Test
public void testGetStartDate() {
    // Arrange
    Warranty warranty = new Warranty();
    Date expectedStartDate = new Date();
    warranty.setStartDate((java.sql.Date) expectedStartDate);

    // Act
    Date actualStartDate = warranty.getStartDate();

    // Assert
    assertEquals(expectedStartDate, actualStartDate);
}

@Test
public void testSetStartDate() {
    // Arrange
    Warranty warranty = new Warranty();
    Date expectedStartDate = new Date();

    // Act
    warranty.setStartDate((java.sql.Date) expectedStartDate);

    // Assert
    assertEquals(expectedStartDate, warranty.getStartDate());
}
@Test
public void testGetEndDate() {
    // Arrange
    Warranty warranty = new Warranty();
    Date expectedEndDate = new Date();
    warranty.setEndDate((java.sql.Date) expectedEndDate);

    // Act
    Date actualEndDate = warranty.getEndDate();

    // Assert
    assertEquals(expectedEndDate, actualEndDate);
}

@Test
public void testSetEndDate() {
    // Arrange
    Warranty warranty = new Warranty();
    Date expectedEndDate = new Date();

    // Act
    warranty.setEndDate((java.sql.Date) expectedEndDate);

    // Assert
    assertEquals(expectedEndDate, warranty.getEndDate());
}

@Test
public void testGetStatus() {
    // Arrange
    Warranty warranty = new Warranty();
    int expectedStatus = 1;
    warranty.setStatus(expectedStatus);

    // Act
    int actualStatus = warranty.getStatus();

    // Assert
    assertEquals(expectedStatus, actualStatus);
}

@Test
public void testSetStatus() {
    // Arrange
    Warranty warranty = new Warranty();
    int expectedStatus = 1;

    // Act
    warranty.setStatus(expectedStatus);

    // Assert
    assertEquals(expectedStatus, warranty.getStatus());
}

@Test
public void testGetComment() {
    // Arrange
    Warranty warranty = new Warranty();
    String expectedComment = "Test comment";
    warranty.setComment(expectedComment);

    // Act
    String actualComment = warranty.getComment();

    // Assert
    assertEquals(expectedComment, actualComment);
}

@Test
public void testSetComment() {
    // Arrange
    Warranty warranty = new Warranty();
    String expectedComment = "Test comment";

    // Act
    warranty.setComment(expectedComment);

    // Assert
    assertEquals(expectedComment, warranty.getComment());
}


@Test
public void testToString() {
    // Arrange
    Warranty warranty = new Warranty();
    warranty.setWarrantyID(1);
    warranty.setProductID(1);
    warranty.setOrderID(1);
    warranty.setCustomerid(1);

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    try {
        Date startDate = dateFormat.parse("2022-01-01");
        Date endDate = dateFormat.parse("2023-01-01");
        warranty.setStartDate((java.sql.Date) startDate);
        warranty.setEndDate((java.sql.Date) endDate);
    } catch (ParseException e) {
        e.printStackTrace();
    }

    warranty.setStatus(1);
    warranty.setComment("Test comment");
    warranty.setEmployeeID(1);

    String expectedString = "Warranty{" +
            "warrantyID=1, " +
            "productID=1, " +
            "orderID=1, " +
            "customerid=1, " +
            "startDate=2022-01-01, " +
            "endDate=2023-01-01, " +
            "status=1, " +
            "comment='Test comment', " +
            "employeeID=1}";

    // Act
    String actualString = warranty.toString();

    // Assert
    assertEquals(expectedString, actualString);
}
}
