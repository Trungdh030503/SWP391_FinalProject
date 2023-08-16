/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package Entity;

import java.sql.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 5580
 */
public class ProductTest {
    
    public ProductTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    
    /**
     * Test of convertToCode method, of class Product.
     */
    @Test
    public void testConvertToCode() {
        System.out.println("convertToCode");
        String productName = "ngo u ngu";
        Product instance = new Product();
        String expResult = "ngo-u-ngu";
        String result = instance.convertToCode(productName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }
    
    
    

    /**
     * Test of getProductcode method, of class Product.
     */
    @Test
    public void testGetProductcode() {
        System.out.println("getProductcode");
        Product instance = new Product();
        String expResult = "";
        String result = instance.getProductcode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of setProductcode method, of class Product.
     */
    @Test
    public void testSetProductcode() {
        System.out.println("setProductcode");
        String productcode = "rinnai";
        Product instance = new Product();
        instance.setProductcode(productcode);
        assert
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getSalePrice method, of class Product.
     */
    @Test
    public void testGetSalePrice() {
        System.out.println("getSalePrice");
        String expResult = "";
        String result = p.getSalePrice();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of getSaleoffPercent method, of class Product.
     */
    @Test
    public void testGetSaleoffPercent() {
        System.out.println("getSaleoffPercent");
        Product instance = new Product();
        int expResult = 0;
        int result = instance.getSaleoffPercent();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    public Product p = new Product(0, "name", 0, 0, "des", "mod", "url", null, null, "admin", "admin", "brand", "wpe", 0, 0);
    /**
     * Test of setSaleoff method, of class Product.
     */
    @Test
    public void testSetSaleoff() {
        System.out.println("setSaleoff");
        int saleoff = 0;
        Product instance = new Product();
        instance.setSaleoff(saleoff);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of getStock method, of class Product.
     */
    @Test
    public void testGetStock() {
        System.out.println("getStock");
//        Product instance = new Product();
        int expResult = 0;
        int result = p.getStock();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of setStock method, of class Product.
     */
    @Test
    public void testSetStock() {
        System.out.println("setStock");
        int stock = 0;
        Product instance = new Product();
        instance.setStock(stock);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of getProductID method, of class Product.
     */
    @Test
    public void testGetProductID() {
        System.out.println("getProductID");
        Product instance = new Product();
        int expResult = 0;
        int result = instance.getProductID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of setProductID method, of class Product.
     */
    @Test
    public void testSetProductID() {
        System.out.println("setProductID");
        int productID = 0;
        Product instance = new Product();
        instance.setProductID(productID);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of getProductName method, of class Product.
     */
    @Test
    public void testGetProductName() {
        System.out.println("getProductName");
        Product instance = new Product();
        String expResult = "";
        String result = instance.getProductName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of setProductName method, of class Product.
     */
    @Test
    public void testSetProductName() {
        System.out.println("setProductName");
        String productName = "";
        Product instance = new Product();
        instance.setProductName(productName);
        // TODO review the generated test code and remove the default call to fail.
  
    }

    /**
     * Test of getCategoryID method, of class Product.
     */
    @Test
    public void testGetCategoryID() {
        System.out.println("getCategoryID");
        Product instance = new Product();
        int expResult = 0;
        int result = instance.getCategoryID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of setCategoryID method, of class Product.
     */
    @Test
    public void testSetCategoryID() {
        System.out.println("setCategoryID");
        int categoryID = 0;
        Product instance = new Product();
        instance.setCategoryID(categoryID);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of getUnitPriceFixed method, of class Product.
     */
    @Test
    public void testGetUnitPriceFixed() {
        System.out.println("getUnitPriceFixed");
        Product instance = new Product();
        String expResult = "";
        String result = instance.getUnitPriceFixed();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of getUnitPrice method, of class Product.
     */
    @Test
    public void testGetUnitPrice() {
        System.out.println("getUnitPrice");
        Product instance = new Product();
        String expResult = "";
        String result = instance.getUnitPrice();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of getPrice method, of class Product.
     */
    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        Product instance = new Product();
        double expResult = 0.0;
        double result = instance.getPrice();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of setUnitPrice method, of class Product.
     */
    @Test
    public void testSetUnitPrice() {
        System.out.println("setUnitPrice");
        double unitPrice = 0.0;
        Product instance = new Product();
        instance.setUnitPrice(unitPrice);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of getDescription method, of class Product.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        Product instance = new Product();
        String expResult = "";
        String result = instance.getDescription();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of setDescription method, of class Product.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "";
        Product instance = new Product();
        instance.setDescription(description);
        // TODO review the generated test code and remove the default call to fail.
  
    }

    /**
     * Test of getModelNumber method, of class Product.
     */
    @Test
    public void testGetModelNumber() {
        System.out.println("getModelNumber");
        Product instance = new Product();
        String expResult = "";
        String result = instance.getModelNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of setModelNumber method, of class Product.
     */
    @Test
    public void testSetModelNumber() {
        System.out.println("setModelNumber");
        String modelNumber = "";
        Product instance = new Product();
        instance.setModelNumber(modelNumber);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of getImageURL method, of class Product.
     */
    @Test
    public void testGetImageURL() {
        System.out.println("getImageURL");
        Product instance = new Product();
        String expResult = "";
        String result = instance.getImageURL();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of getImageURLs method, of class Product.
     */
    @Test
    public void testGetImageURLs() {
        System.out.println("getImageURLs");
        Product instance = new Product();
        List<String> expResult = null;
        List<String> result = instance.getImageURLs();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of setImageURL method, of class Product.
     */
    @Test
    public void testSetImageURL() {
        System.out.println("setImageURL");
        String imageURL = "";
        Product instance = new Product();
        instance.setImageURL(imageURL);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of getCreatedDate method, of class Product.
     */
    @Test
    public void testGetCreatedDate() {
        System.out.println("getCreatedDate");
        Product instance = new Product();
        Date expResult = null;
        Date result = instance.getCreatedDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of setCreatedDate method, of class Product.
     */
    @Test
    public void testSetCreatedDate() {
        System.out.println("setCreatedDate");
        Date createdDate = null;
        Product instance = new Product();
        instance.setCreatedDate(createdDate);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of getModifiedDate method, of class Product.
     */
    @Test
    public void testGetModifiedDate() {
        System.out.println("getModifiedDate");
        Product instance = new Product();
        Date expResult = null;
        Date result = instance.getModifiedDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of setModifiedDate method, of class Product.
     */
    @Test
    public void testSetModifiedDate() {
        System.out.println("setModifiedDate");
        Date modifiedDate = null;
        Product instance = new Product();
        instance.setModifiedDate(modifiedDate);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of getCreatedBy method, of class Product.
     */
    @Test
    public void testGetCreatedBy() {
        System.out.println("getCreatedBy");
        Product instance = new Product();
        String expResult = "";
        String result = instance.getCreatedBy();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of setCreatedBy method, of class Product.
     */
    @Test
    public void testSetCreatedBy() {
        System.out.println("setCreatedBy");
        String createdBy = "";
        Product instance = new Product();
        instance.setCreatedBy(createdBy);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of getModifiedBy method, of class Product.
     */
    @Test
    public void testGetModifiedBy() {
        System.out.println("getModifiedBy");
        Product instance = new Product();
        String expResult = "";
        String result = instance.getModifiedBy();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of setModifiedBy method, of class Product.
     */
    @Test
    public void testSetModifiedBy() {
        System.out.println("setModifiedBy");
        String modifiedBy = "";
        Product instance = new Product();
        instance.setModifiedBy(modifiedBy);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of getBrand method, of class Product.
     */
    @Test
    public void testGetBrand() {
        System.out.println("getBrand");
        Product instance = new Product();
        String expResult = "";
        String result = instance.getBrand();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of setBrand method, of class Product.
     */
    @Test
    public void testSetBrand() {
        System.out.println("setBrand");
        String brand = "";
        Product instance = new Product();
        instance.setBrand(brand);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of getWarrantyPeriod method, of class Product.
     */
    @Test
    public void testGetWarrantyPeriod() {
        System.out.println("getWarrantyPeriod");
        Product instance = new Product();
        String expResult = "";
        String result = instance.getWarrantyPeriod();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of setWarrantyPeriod method, of class Product.
     */
    @Test
    public void testSetWarrantyPeriod() {
        System.out.println("setWarrantyPeriod");
        String warrantyPeriod = "";
        Product instance = new Product();
        instance.setWarrantyPeriod(warrantyPeriod);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of toString method, of class Product.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Product instance = new Product();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }
    
}
