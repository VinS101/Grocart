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
public class ShoppingCartTest
{
    
    public ShoppingCartTest()
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
     * Test of getAllProducts method, of class ShoppingCart.
     */
    @Test
    public void testGetAllProducts()
    {
        System.out.println("getAllProducts");
        ShoppingCart instance = new ShoppingCart();
        Product p = new Product("name", 2.99, "Good", 12, 12 , "Jack", 20);
        instance.addToCart(p, 1);
        String expResult = "name";
        Iterator<Product> result = instance.getAllProducts();
        Product r = result.next();
        assertEquals(expResult, r.getName());
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getSize method, of class ShoppingCart.
     */
    @Test
    public void testGetSize()
    {
        System.out.println("getSize");
        ShoppingCart instance = new ShoppingCart();
        Product p = new Product("name", 2.99, "Good", 12, 12 , "Jack", 20);
        instance.addToCart(p, 1);
        int expResult = 1;
        int result = instance.getSize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getOneProduct method, of class ShoppingCart.
     */
    @Test
    public void testGetOneProduct()
    {
        System.out.println("getOneProduct");
        String name = "";
        ShoppingCart instance = new ShoppingCart();
        Product p = new Product("name", 2.99, "Good", 12, 12 , "Jack", 20);
        instance.addToCart(p, 1);
        String expResult = "name";
        Product result = instance.getOneProduct("name");
        assertEquals(expResult, result.getName());
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of addToCart method, of class ShoppingCart.
     */
    @Test
    public void testAddToCart()
    {
        System.out.println("addToCart");
        Product p = new Product("name", 2.99, "Good", 12, 12 , "Jack", 20);
        int quantity = 0;
        ShoppingCart instance = new ShoppingCart();
        instance.addToCart(p, 1);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of removeProduct method, of class ShoppingCart.
     */
    @Test
    public void testRemoveProduct()
    {
        System.out.println("removeProduct");
        Product aProduct = null;
        ShoppingCart instance = new ShoppingCart();
        instance.removeProduct(aProduct);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of clearCart method, of class ShoppingCart.
     */
    @Test
    public void testClearCart()
    {
        System.out.println("clearCart");
        ShoppingCart instance = new ShoppingCart();
        instance.clearCart();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getTotalPrice method, of class ShoppingCart.
     */
    @Test
    public void testGetTotalPrice()
    {
        System.out.println("getTotalPrice");
        ShoppingCart instance = new ShoppingCart();
        double expResult = 0.0;
        double result = instance.getTotalPrice();
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of generateSummary method, of class ShoppingCart.
     */
    @Test
    public void testGenerateSummary()
    {
        System.out.println("generateSummary");
        ShoppingCart instance = new ShoppingCart();
        String expResult = "";
        String result = instance.generateSummary();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
      
    }
    
}
