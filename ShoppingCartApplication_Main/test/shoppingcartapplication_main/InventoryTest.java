/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppingcartapplication_main;

import java.util.Iterator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Vin
 */
public class InventoryTest
{
    
    public InventoryTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
    }
    
    @AfterClass
    public static void tearDownClass()
    {
    }
    
    @Before
    public void setUp()
    {
    }
    
    @After
    public void tearDown()
    {
    }

    /**
     * Test of getAllProducts method, of class Inventory.
     */
    @Test
    public void testGetAllProducts()
    {
        System.out.println("getAllProducts");
        Inventory instance = new Inventory();
        Product p = new Product("name", 2.99, "Good", 12, 12 , "Jack", 20);
        instance.addToInventory(p);
        String expResult = "name";
        Iterator<Product> result = instance.getAllProducts();
        Product r = result.next();
        assertEquals(expResult, r.getName());
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getProduct method, of class Inventory.
     */
    @Test
    public void testGetProduct()
    {
        System.out.println("getProduct");
        String aName = "";
        Product p = new Product("name", 2.99, "Good", 12, 12 , "Jack", 20);
        Inventory instance = new Inventory();
        instance.addToInventory(p);
        String expResult = "name";
        Product result = instance.getProduct(aName);
        assertEquals(expResult, result.getName());
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of addToInventory method, of class Inventory.
     */
    @Test
    public void testAddToInventory()
    {
        System.out.println("addToInventory");
        Product aProduct = null;
        Inventory instance = new Inventory();
        instance.addToInventory(aProduct);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of removeProduct method, of class Inventory.
     */
    @Test
    public void testRemoveProduct()
    {
        System.out.println("removeProduct");
        Product aProduct = null;
        Inventory instance = new Inventory();
        instance.removeProduct(aProduct);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of overWriteInventoryFile method, of class Inventory.
     */
    @Test
    public void testOverWriteInventoryFile()
    {
        System.out.println("overWriteInventoryFile");
        Seller s = null;
        Inventory instance = new Inventory();
        instance.overWriteInventoryFile(s);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of checkStock method, of class Inventory.
     */
    @Test
    public void testCheckStock()
    {
        System.out.println("checkStock");
         Product p = new Product("name", 2.99, "Good", 12, 12 , "Jack", 20);
        Inventory instance = new Inventory();
        instance.addToInventory(p);
        boolean expResult = true;
        boolean result = instance.checkStock(p);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getFinancialSummary method, of class Inventory.
     */
    @Test
    public void testGetFinancialSummary()
    {
        System.out.println("getFinancialSummary");
        Product p = new Product("name", 2.99, "Good", 12, 12 , "Jack", 20);
        Inventory instance = new Inventory();
        //instance.addToInventory(null);
        String expResult = "Total Products Sold: 0\n" +
"Total Profit: $0\n" +
"Revenue: $0";
        String result = instance.getFinancialSummary();
        

        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getSize method, of class Inventory.
     */
    @Test
    public void testGetSize()
    {
        System.out.println("getSize");
        Inventory instance = new Inventory();
        int expResult = 0;
        int result = instance.getSize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of clearInventory method, of class Inventory.
     */
    @Test
    public void testClearInventory()
    {
        System.out.println("clearInventory");
        Inventory instance = new Inventory();
        instance.clearInventory();
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
