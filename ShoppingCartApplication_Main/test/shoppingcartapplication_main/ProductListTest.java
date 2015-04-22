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
public class ProductListTest
{
    
    public ProductListTest()
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
     * Test of getAllProducts method, of class ProductList.
     */
    @Test
    public void testGetAllProducts()
    {
        System.out.println("getAllProducts");
        Product instance = new Product("name", 2.99, "Good", 12, 12 , "Jack", 20);
        Product instance2 = new Product("namse", 2.99, "Good", 12, 12 , "Jack", 20);
        ProductList p = new ProductList();
        ProductList.addToProductList(instance);
        ProductList.addToProductList(instance2);
        String expResult = "name";
        Iterator<Product> result = ProductList.getAllProducts();
        Product r = result.next();
        assertEquals(expResult, r.getName());
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getOneProduct method, of class ProductList.
     */
    @Test
    public void testGetOneProduct()
    {
        System.out.println("getOneProduct");
        Product instance = new Product("name", 2.99, "Good", 12, 12 , "Jack", 20);
        String name = "name";
        String soldBy = "Jack";
        String expResult = "name";
        Product result = ProductList.getOneProduct(name, soldBy);
        assertEquals(expResult, result.getName());
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of addToProductList method, of class ProductList.
     */
    @Test
    public void testAddToProductList()
    {
        System.out.println("addToProductList");
        Product product = null;
        ProductList.addToProductList(product);
        // TODO review the generated test code and remove the default call to fail.
       
    }
    
}
