/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package DAO;

import Entity.Product;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.Assert.*;

/**
 *
 * @author 5580
 */
public class ProductDAOTest {

    public ProductDAOTest() {
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
     * Test of fromResultSet method, of class ProductDAO.
     */
//    @Test
//    public void testFromResultSet() throws Exception {
//
//    }
    /**
     * Test of getProductById method, of class ProductDAO.
     */
    @Test
    public void testGetProductByExistId() {
        System.out.println("getProductByExistId");
        int productId = 1;
        ProductDAO instance = new ProductDAO();
        String expResult = "bep-tu-đon-eurosun-eu-t197";

        String result = instance.getProductById(1).getProductcode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    @Test
    public void testGetProductByNonExistId() {
        System.out.println("getProductByNonExistId");
        int productId = 0;
        ProductDAO instance = new ProductDAO();
        Product expResult = null;

        Product result = instance.getProductById(0);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of getProductByName method, of class ProductDAO.
     */
    @Test
    public void testGetProductByName() {
        System.out.println("getProductByName");
        String productName = "Bếp từ đơn Eurosun EU T199";
        ProductDAO instance = new ProductDAO();
        int expResult = 2;
        Product result = instance.getProductByName(productName);
        assertEquals(expResult, result.getProductID());
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getProductByCode method, of class ProductDAO.
     */
    @Test
    public void testGetProductByCode() {
        System.out.println("getProductByCode");
        String productCode = "bep-tu-đon-eurosun-eu-t197";
        ProductDAO instance = new ProductDAO();
        int expResult = 1;
        Product result = instance.getProductByCode(productCode);
        assertEquals(expResult, result.getProductID());
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of getBrandList method, of class ProductDAO.
     */
    @Test
    public void testGetBrandList() {
        System.out.println("getBrandList");
        ProductDAO instance = new ProductDAO();
        int expResult = 60;

        List<String> result = instance.getBrandList();
        assertEquals(expResult, result.size());
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of getProductsByCategoryID method, of class ProductDAO.
     */
    @Test
    public void testGetProductsByCategoryID() {
        System.out.println("getProductsByCategoryID");
        int categoryID = 7;
        ProductDAO instance = new ProductDAO();
        int expResult = 15;
        int result = instance.getProductsByCategoryID(categoryID).size();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of getProductsByBrand method, of class ProductDAO.
     */
    @Test
    public void testGetProductsByBrand() {
        System.out.println("getProductsByBrand");
        String brand = "Fagor";
        ProductDAO instance = new ProductDAO();
        int expResult = 18;
        List<Product> result = instance.getProductsByBrand(brand);
        assertEquals(expResult, result.size());
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of getProductsByPrice method, of class ProductDAO.
     */
    @Test
    public void testGetProductsByWrongPrice() {
        System.out.println("getProductsByPrice");
        double maxPrice = -1;
        ProductDAO instance = new ProductDAO();
        List<Product> expResult = new ArrayList<>();
        List<Product> result = instance.getProductsByPrice(maxPrice);
        assertEquals(expResult.size(), result.size());
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of getProductsByPrice method, of class ProductDAO.(all smaller
     * price)
     */
    @Test
    public void testGetProductsByExistPrice() {
        System.out.println("getProductsByPrice");
        double maxPrice = 1350000;
        ProductDAO instance = new ProductDAO();
        int expResult = 10;
        int result = instance.getProductsByPrice(maxPrice).get(0).getProductID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of getAllProducts method, of class ProductDAO.
     */
    @Test
    public void testGetAllProducts() {
        System.out.println("getAllProducts");
        ProductDAO instance = new ProductDAO();
        int expResult = 1702;
        int result = instance.getAllProducts().size();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

    /**
     * Test of updateProduct method, of class ProductDAO.
     */
    @Test
    public void testMissingUpdateProduct() {
        System.out.println("updateProduct");
        Product p = new Product();
        p.setProductID(1606);
        p.setProductName("new");
        ProductDAO instance = new ProductDAO();
        instance.updateProduct(p);
        Product result = instance.getProductById(1606);


        assertEquals("new", result.getProductName());
 

    }
    @Test
    public void testUpdateProduct() {
        System.out.println("updateProduct");
        Product p = new Product(1606, "name", 1, 0, "0", "Rinnai", "url", null, null, "", "", "Rinnai", "1 year", 0, 0);
        ProductDAO instance = new ProductDAO();

        instance.updateProduct(p);
        
        Product result = instance.getProductById(1606);
        assertEquals("new".toString(), result.getProductName());


    }

    /**
     * Test of getProductSuggestions method, of class ProductDAO.
     */
    @Test
    public void testGetProductSuggestions() {
        System.out.println("getProductSuggestions");
        String keyword = "";
        ProductDAO instance = new ProductDAO();
        List<String> expResult = null;
        List<String> result = instance.getProductSuggestions(keyword);
        
        assertEquals("null", "null");
        // TODO review the generated test code and remove the default call to fail.

    }

    @Test
    public void testGetProductById() {
    }

    @Test
    public void testGetProductsByCategoryName() {
    }

    @Test
    public void testGetProductsByPrice() {
    }

    @Test
    public void testGetSearch() {
    }

    @Test
    public void testGetProductsByCategory() {
    }

    @Test
    public void testDeleteProduct() {
    }

    @Test
    public void testInsertProduct() {
    }
    /**
     * Test of getSearch method, of class ProductDAO.
     */
//    @Test
//    public void testGetSearch() {
//        System.out.println("getSearch");
//        String keyword = "";
//        ProductDAO instance = new ProductDAO();
//        List<Product> expResult = null;
//        List<Product> result = instance.getSearch(keyword);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    /**
     * Test of getProductsByCategory method, of class ProductDAO.
     */
//    @Test
//    public void testGetProductsByCategory() {
//        System.out.println("getProductsByCategory");
//        String categoryName = "";
//        ProductDAO instance = new ProductDAO();
//        List<Product> expResult = null;
//        List<Product> result = instance.getProductsByCategory(categoryName);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    /**
     * Test of deleteProduct method, of class ProductDAO.
     */
//    @Test
//    public void testDeleteProduct() {
//        System.out.println("deleteProduct");
//        int id = 0;
//        ProductDAO instance = new ProductDAO();
//        instance.deleteProduct(id);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    /**
     * Test of insertProduct method, of class ProductDAO.
     */
//    @Test
//    public void testInsertProduct() {
//        System.out.println("insertProduct");
//        Product product = null;
//        ProductDAO instance = new ProductDAO();
//        instance.insertProduct(product);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
}
