
package shoppingcartapplication_main;


import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;


public class ShoppingCartSystem 
{
     public static void main(String[] args)
     {
         buyerList = new ArrayList();
         sellerList = new ArrayList();
         
         ProductList p = new ProductList();
          
         //make view pages
         initializeViewPages();
         
         initializeBuyers();
         
         initializeSellers();
         
         
      
         //Populate the ProductList class
         //Readfiles tester block
//         Iterator iter = natasha.getInventory().getAllProducts();
//         while(iter.hasNext())
//         {
//             Product tempProduct = (Product) iter.next();
//             System.out.println(tempProduct.getName());
//         }
         
         updateProductList(sellerList);
         //test productLIst
         Iterator<Product> iter = ProductList.getAllProducts();
         while(iter.hasNext())
         {
             Product tempProduct = (Product) iter.next();
             System.out.println(tempProduct.getName());
         }
         
         loginPage.display();
         
     }
     
     public static void readFromFile(Seller seller, String fileName)
    {
        try
        {
        
        List<String> lines = Files.readAllLines(Paths.get(fileName)); //Reads all lines from a file and puts them in a list
        
        ArrayList<String> tokens = new ArrayList();
        for (int i = 0; i < lines.size(); i++)  //For every line
        {
            //String[] st = lines.get(i).split("\\t");
            StringTokenizer st = new StringTokenizer(lines.get(i), "\t"); //tokenize 1 line
            while(st.hasMoreTokens())
            {
                tokens.add(st.nextToken());  
            }   
            //1 line
            Product tempProduct = new Product(tokens.get(0), Double.parseDouble(tokens.get(1)), tokens.get(2), Integer.parseInt(tokens.get(3)),
                    Double.parseDouble(tokens.get(4)), tokens.get(5), Integer.parseInt(tokens.get(6)));
            seller.getInventory().addToInventory(tempProduct);
            tokens.clear();
        }
        
        
        
        //System.out.println(result[0]);
        }
        catch(Exception e){}
       
    }
     
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
     
     public static Buyer getActiveBuyer()
     {
         return activeBuyer;
     }
     
     public static void clearActiveBuyer(){
         activeBuyer = null;
     }
     
     public static Seller getActiveSeller()
     {
         return activeSeller;
     }
     
      public static void clearActiveSeller(){
         activeSeller = null;
     }
     
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
     
     public static void updateInventory(Seller s)
     {
         s.getInventory().clearInventory();
         readFromFile(s, s.getUsername() +"Inventory.txt");
         
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
