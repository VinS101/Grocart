
package shoppingcartapplication_main;


import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Class designed to run the entire shopping cart system.
 * @author ASUS
 */

public class ShoppingCartSystem 
{
    
    /**
     * Beginning of program.
     * @param args 
     */
    
     public static void main(String[] args)
     {
         buyerList = new ArrayList();
         sellerList = new ArrayList();
         
         ProductList p = new ProductList();
          
         //make view pages
         initializeViewPages();
         
         initializeBuyers();
         
         initializeSellers();
         
         updateProductList(sellerList);
         
         Iterator<Product> iter = ProductList.getAllProducts();
         while(iter.hasNext())
         {
             Product tempProduct = (Product) iter.next();
             System.out.println(tempProduct.getName());
         }
         
         loginPage.display();
         
     }
     
     /**
      * Reads inventory files and creates inventories.
      * @param seller Seller pertaining to inventory file.
      * @param fileName file name of inventory file.
      * @precondition file name must exist.
      */
     
     public static void readFromFile(Seller seller, String fileName)
    {
        try
        {
        
        List<String> lines = Files.readAllLines(Paths.get(fileName)); //Reads all lines from a file and puts them in a list
        
        ArrayList<String> tokens = new ArrayList();
        for (int i = 0; i < lines.size(); i++)  //For every line
        {
            StringTokenizer st = new StringTokenizer(lines.get(i), "\t"); //tokenize 1 line
            while(st.hasMoreTokens())
            {
                tokens.add(st.nextToken());  
            }   

            Product tempProduct = new Product(tokens.get(0), Double.parseDouble(tokens.get(1)), tokens.get(2), Integer.parseInt(tokens.get(3)),
                    Double.parseDouble(tokens.get(4)), tokens.get(5), Integer.parseInt(tokens.get(6)));
            seller.getInventory().addToInventory(tempProduct);
            tokens.clear();
        }
        
        }
        catch(Exception e){}
       
    }
     
     /**
      * Updates product list with all inventory objects.
      * @param sellerList list containing all seller objects/inventories.
      */
     
     public static void updateProductList(ArrayList<Seller> sellerList)
     {
         for (int i = 0; i < sellerList.size(); i++)
         {
             Iterator<Product> iter = sellerList.get(i).getInventory().getAllProducts();
             while(iter.hasNext())
             {
                 Product tempProduct = iter.next();
                 ProductList.addToProductList(tempProduct);
             }
         }
     }
     
     /**
      * Authenticates user logins.
      * @param username user's entered username.
      * @param password user's entered password.
      * @param isBuyer boolean to distinguish whether the user is a buyer or seller.
      * @return True or False depending on whether there is a match.
      */
     
     public static boolean authenticate(String username, String password, boolean isBuyer)
     {
         if (isBuyer)
         {
             Buyer tempBuyer = findBuyer(username);
             if(tempBuyer == null)
             {
                 return false;
             }
             boolean isUser = tempBuyer.isPasswordMatch(password);
             if(isUser)
             {
                 activeBuyer = tempBuyer;
                 return isUser;
             }
             else
             {
                 
                 return isUser; //false
             }
             
         }
         else
         {
             Seller tempSeller = findSeller(username);
             if(tempSeller == null)
             {
                 return false;
             }
             boolean isUser = tempSeller.isPasswordMatch(password);
             if(isUser)
             {
                 activeSeller = tempSeller;
                 return isUser;
             }
             else
             {
                 return isUser; //false
             }
             
         }
     }
     
     /**
      * Returns seller based on username.
      * @param username username to search for.
      * @return seller object.
      */
     
     public static Seller findSeller(String username)
     {
        for(int i = 0; i < sellerList.size(); i++)
        {
            if (sellerList.get(i).getUsername().equals(username))
            {
                return sellerList.get(i);
            }
            else
            {
                //Throw error
            }
        }
         return null;
     }
     
     /**
      * Returns buyer based on username.
      * @param username username to search for.
      * @return buyer object.
      */
     
     public static Buyer findBuyer (String username)
     {
         for(int i = 0; i < buyerList.size(); i++)
         {
              if (buyerList.get(i).getUsername().equals(username))
            {
                return buyerList.get(i);
            }
            else
            {
                //Throw error
            }
         }
         return null;
     }
     
     /**
      * Returns active buyer.
      * @return active buyer.
      */
     
     public static Buyer getActiveBuyer()
     {
         return activeBuyer;
     }
     
     /**
      * Clears active buyer.
      */
     
     public static void clearActiveBuyer(){
         activeBuyer = null;
     }
     
     /**
      * Returns active seller.
      * @return active seller.
      */
     
     public static Seller getActiveSeller()
     {
         return activeSeller;
     }
     
      /**
      * Clears active seller.
      */
     
      public static void clearActiveSeller(){
         activeSeller = null;
     }
      
     /**
      * Initializes all the GUI pages.
      */
     
     private static void initializeViewPages()
     {
         buyerPage = new BuyerPage();
         sellerPage = new SellerPage();
         loginPage = new LoginPage();
         invoicepage = new InvoicePage();
         cartpage = new CartPage();
         checkOutPage = new CheckOutPage();
         finanSummaryPage = new FinancialSummaryPage();
         descriptionPage = new DescriptionPage();
         
     }
     
     /**
      * Hard codes buyers into system.
      */
     
     
     private static void initializeBuyers()
     {
        //Make some Buyers
         Buyer Jack = new Buyer("jack", "123");
         Buyer Hendrix = new Buyer("hendrix", "123");
         Buyer harold = new Buyer("harold", "harold");
         buyerList.add(Jack);
         buyerList.add(Hendrix);
         buyerList.add(harold);
     }
     
     /**
      * Hard codes sellers into system.
      */
     
     private static void initializeSellers()
     {
         //Make some Sellers
         Seller Joe = new Seller("joe", "234");
         Seller natasha = new Seller("natasha", "634");
         
         //Add to sellerList and buyerList
         sellerList.add(Joe);
         sellerList.add(natasha);
         
         //Read from files
         readFromFile(Joe, "joeInventory.txt");
         readFromFile(natasha, "natashaInventory.txt");
     }
     
     /**
      * Makes purchases and mutates products when checkout is confirmed.
      * @param acart shopping cart that is making purchases.
      */
     
     public static void makePurchases(ShoppingCart acart)
     {
         ShoppingCart cart = acart;
         Iterator iter = cart.getAllProducts();
          Product tempProduct;
         while(iter.hasNext())
         {
            tempProduct = (Product) iter.next();
             Seller s = findSeller(tempProduct.getSoldBy());
             Iterator iter2 = s.getInventory().getAllProducts();
             
             while(iter2.hasNext())
             {
                
                Product temp = (Product) iter2.next();
                if(temp.getName().equals(tempProduct.getName()))
                {
                    temp.setInventoryQuantity(temp.getinventoryQuantity() - tempProduct.getCartQuantity());
                    temp.setTotalNumberSold(temp.getTotalNumberSold() + tempProduct.getCartQuantity());
                    s.getInventory().overWriteInventoryFile(s);
                    updateInventory(s);
                    updateProductList(sellerList);
                }
             }
         }
     }
     
     /**
      * Updates a sellers inventory from inventory file.
      * @param s seller who's inventory is to be updated.
      */
     
     public static void updateInventory(Seller s)
     {
         s.getInventory().clearInventory();
         readFromFile(s, s.getUsername() +"Inventory.txt");
         
     }
     
     public static ArrayList<Seller> getSellerList()
     {
         return sellerList;
     }
     
     private static ArrayList<Buyer> buyerList;
     private static ArrayList<Seller> sellerList;
     private static Buyer activeBuyer;
     private static Seller activeSeller;
     
     public static BuyerPage buyerPage;
     public static SellerPage sellerPage;
     public static LoginPage loginPage;
     public static InvoicePage invoicepage;
     public static CartPage cartpage;
     public static CheckOutPage checkOutPage;
     public static DescriptionPage descriptionPage;
     public static FinancialSummaryPage finanSummaryPage;
}
