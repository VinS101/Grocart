/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shoppingcartapplication_main;

import java.util.ArrayList;
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
public class ShoppingCartSystemTest
{
    
    public ShoppingCartSystemTest()
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
     * Test of main method, of class ShoppingCartSystem.
     */
    @Test
    public void testMain()
    {
        System.out.println("main");
        String[] args = null;
        ShoppingCartSystem.main(args);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of readFromFile method, of class ShoppingCartSystem.
     */
    @Test
    public void testReadFromFile()
    {
        System.out.println("readFromFile");
        Seller seller = null;
        String fileName = "";
        ShoppingCartSystem.readFromFile(seller, fileName);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of updateProductList method, of class ShoppingCartSystem.
     */
    @Test
    public void testUpdateProductList()
    {
        System.out.println("updateProductList");
        ArrayList<Seller> sellerList = new ArrayList();
        ProductList p = new ProductList();
        ShoppingCartSystem.updateProductList(sellerList);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of authenticate method, of class ShoppingCartSystem.
     */
    @Test
    public void testAuthenticate()
    {
        System.out.println("authenticate");
        String username = "";
        String password = "";
        boolean isBuyer = false;
        boolean expResult = false;
        boolean result = ShoppingCartSystem.authenticate(username, password, isBuyer);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of findSeller method, of class ShoppingCartSystem.
     */
    @Test
    public void testFindSeller()
    {
        System.out.println("findSeller");
        String username = "test";
        Seller s = new Seller("test", "123");
        ArrayList<Seller> sList1 = new ArrayList();
        ShoppingCartSystem.getSellerList().add(s);
        ArrayList sList = ShoppingCartSystem.getSellerList();
     
        String expResult = "test";
        Seller result = ShoppingCartSystem.findSeller(username);
        assertEquals(expResult, result.getUsername());
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of findBuyer method, of class ShoppingCartSystem.
     */
    @Test
    public void testFindBuyer()
    {
        System.out.println("findBuyer");
        String username = "test";
        Buyer s = new Buyer("test", "123");
        ArrayList sList = ShoppingCartSystem.getBuyerList();
        sList.add(s);
        String expResult = "test";
        Buyer result = ShoppingCartSystem.findBuyer(username);
        assertEquals(expResult, result.getUsername());
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getActiveBuyer method, of class ShoppingCartSystem.
     */
    @Test
    public void testGetActiveBuyer()
    {
        System.out.println("getActiveBuyer");
        Buyer expResult = null;
        Buyer result = ShoppingCartSystem.getActiveBuyer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of clearActiveBuyer method, of class ShoppingCartSystem.
     */
    @Test
    public void testClearActiveBuyer()
    {
        System.out.println("clearActiveBuyer");
        ShoppingCartSystem.clearActiveBuyer();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getActiveSeller method, of class ShoppingCartSystem.
     */
    @Test
    public void testGetActiveSeller()
    {
        System.out.println("getActiveSeller");
        Seller expResult = null;
        Seller result = ShoppingCartSystem.getActiveSeller();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of clearActiveSeller method, of class ShoppingCartSystem.
     */
    @Test
    public void testClearActiveSeller()
    {
        System.out.println("clearActiveSeller");
        ShoppingCartSystem.clearActiveSeller();
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of makePurchases method, of class ShoppingCartSystem.
     */
    @Test
    public void testMakePurchases()
    {
        System.out.println("makePurchases");
        ShoppingCart acart = new ShoppingCart();
        ShoppingCartSystem.makePurchases(acart);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of updateInventory method, of class ShoppingCartSystem.
     */
    @Test
    public void testUpdateInventory()
    {
        System.out.println("updateInventory");
        Seller s = new Seller("","");
        Inventory i = new Inventory();
        ShoppingCartSystem.updateInventory(s);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getSellerList method, of class ShoppingCartSystem.
     */
    @Test
    public void testGetSellerList()
    {
        System.out.println("getSellerList");
        ArrayList<Seller> expResult = null;
        ArrayList<Seller> result = ShoppingCartSystem.getSellerList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
