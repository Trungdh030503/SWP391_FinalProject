/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package DAO;

import DAO.WarrantyDAO;
import Entity.Warranty;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Lenovo
 */
public class WarrantyDAOTest {

//    private WarrantyDAO warrantyDAO;
    private WarrantyDAO warrantyDAO;

    public WarrantyDAOTest() {
        warrantyDAO = new WarrantyDAO();
    }

//    @Test
    public void testGetAllWarranty() {
        // Arrange
        int sizeTest = 6;

        // Act
        ArrayList<Warranty> warranty = warrantyDAO.getAllWarranty();
        System.out.println(warranty.size());

        // Assert
        assertNotNull(warranty);
        assertEquals(sizeTest, warranty.size());
    }

    @Test
    public void testCreateWarranty() {
        // Arrange
        WarrantyDAO warrantyDAO = new WarrantyDAO();
        Warranty warranty = new Warranty();
        // Set properties of the warranty object

        // Act
        boolean result = warrantyDAO.createWarranty(warranty);

        // Assert
        assertTrue(result);
        assertNotNull(warranty.getWarrantyID());
    }

}
