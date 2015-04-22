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
public class AccountTest
{
    
    public AccountTest()
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
     * Test of getUsername method, of class Account.
     */
    @Test
    public void testGetUsername()
    {
        System.out.println("getUsername");
        Account Jack = new Buyer("jack", "123");
        String expResult = "jack";
        String result = Jack.getUsername();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of isPasswordMatch method, of class Account.
     */
    @Test
    public void testIsPasswordMatch()
    {
        System.out.println("isPasswordMatch");
        String iPassword = "";
        Account Jack = new Buyer("jack", "123");
        
        boolean expResult = true;
        boolean result = Jack.isPasswordMatch("123");
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
