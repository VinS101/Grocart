/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppingcartapplication_main;

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
public class ProductTest
{
    
    public ProductTest()
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
     * Test of getName method, of class Product.
     */
    @Test
    public void testGetName()
    {
        System.out.println("getName");
        Product instance = new Product("name", 2.99, "Good", 12, 12 , "Jack", 20);
        String expResult = "name";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getDescription method, of class Product.
     */
    @Test
    public void testGetDescription()
    {
        System.out.println("getDescription");
        Product instance = new Product("name", 2.99, "Good", 12, 12 , "Jack", 20);
        String expResult = "Good";
        String result = instance.getDescription();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.  
    }

    /**
     * Test of getPrice method, of class Product.
     */
    @Test
    public void testGetPrice()
    {
        System.out.println("getPrice");
        Product instance = new Product("name", 2.99, "Good", 12, 12 , "Jack", 20);
        double expResult =2.99;
        double result = instance.getPrice();
        assertEquals(expResult, result,2.99);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getinventoryQuantity method, of class Product.
     */
    @Test
    public void testGetinventoryQuantity()
    {
        System.out.println("getinventoryQuantity");
        Product instance = new Product("name", 2.99, "Good", 12, 12 , "Jack", 20);
        int expResult = 12;
        int result = instance.getinventoryQuantity();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getCartQuantity method, of class Product.
     */
    @Test
    public void testGetCartQuantity()
    {
        System.out.println("getCartQuantity");
        Product instance = new Product("name", 2.99, "Good", 12, 12 , "Jack", 20);
        int expResult = 0;
        int result = instance.getCartQuantity();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getTotalNumberSold method, of class Product.
     */
    @Test
    public void testGetTotalNumberSold()
    {
        System.out.println("getTotalNumberSold");
        Product instance = new Product("name", 2.99, "Good", 12, 12 , "Jack", 20);
        int expResult = 20;
        int result = instance.getTotalNumberSold();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getCost method, of class Product.
     */
    @Test
    public void testGetCost()
    {
        System.out.println("getCost");
        Product instance = new Product("name", 2.99, "Good", 12, 12 , "Jack", 20);
        double expResult = 12;
        double result = instance.getCost();
        assertEquals(expResult, result, 12);
        // TODO review the generated test code and remove the default call to fail. 
    }

    /**
     * Test of getSoldBy method, of class Product.
     */
    @Test
    public void testGetSoldBy()
    {
        System.out.println("getSoldBy");
        Product instance = new Product("name", 2.99, "Good", 12, 12 , "Jack", 20);
        String expResult = "Jack";
        String result = instance.getSoldBy();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setName method, of class Product.
     */
    @Test
    public void testSetName()
    {
        System.out.println("setName");
        Product instance = new Product("name", 2.99, "Good", 12, 12 , "Jack", 20);
        String aName = "newName";
        instance.setName(aName);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setDescription method, of class Product.
     */
    @Test
    public void testSetDescription()
    {
        System.out.println("setDescription");
        String aDescription = "";
        Product instance = new Product("name", 2.99, "Good", 12, 12 , "Jack", 20);
        instance.setDescription(aDescription);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of setPrice method, of class Product.
     */
    @Test
    public void testSetPrice()
    {
        System.out.println("setPrice");
        double aPrice = 0.0;
        Product instance = new Product("name", 2.99, "Good", 12, 12 , "Jack", 20);
        instance.setPrice(aPrice);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setInventoryQuantity method, of class Product.
     */
    @Test
    public void testSetInventoryQuantity()
    {
        System.out.println("setInventoryQuantity");
        int aQuantity = 0;
        Product instance = new Product("name", 2.99, "Good", 12, 12 , "Jack", 20);
        instance.setInventoryQuantity(aQuantity);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of setCartQuantity method, of class Product.
     */
    @Test
    public void testSetCartQuantity()
    {
        System.out.println("setCartQuantity");
        int aQuantity = 0;
        Product instance = new Product("name", 2.99, "Good", 12, 12 , "Jack", 20);
        instance.setCartQuantity(aQuantity);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setCost method, of class Product.
     */
    @Test
    public void testSetCost()
    {
        System.out.println("setCost");
        double aCost = 0.0;
        Product instance = new Product("name", 2.99, "Good", 12, 12 , "Jack", 20);
        instance.setCost(aCost);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setTotalNumberSold method, of class Product.
     */
    @Test
    public void testSetTotalNumberSold()
    {
        System.out.println("setTotalNumberSold");
        int s = 0;
        Product instance = new Product("name", 2.99, "Good", 12, 12 , "Jack", 20);
        instance.setTotalNumberSold(s);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
