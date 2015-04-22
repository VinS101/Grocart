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
public class SellerTest
{
    
    public SellerTest()
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
     * Test of getInventory method, of class Seller.
     */
    @Test
    public void testGetInventory()
    {
        System.out.println("getInventory");
        Seller instance = new Seller("joe", "234");
        int expResult = 0;
        Inventory result = instance.getInventory();
        assertEquals(expResult, result.getSize());
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
