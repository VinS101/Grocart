
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
         
         //Make some Buyers
         Buyer Jack = new Buyer("jack", "123");
         Buyer Hendrix = new Buyer("hendrix", "123");
         
         //Make some Sellers
         Seller Joe = new Seller("joe", "234");
         Seller natasha = new Seller("natasha", "634");
         
         //Add to sellerList and buyerList
         sellerList.add(Joe);
         sellerList.add(natasha);
         buyerList.add(Jack);
         buyerList.add(Hendrix);
         
         //Read from files
         readFromFile(natasha, "natashaInventory.txt");
         readFromFile(Joe, "joeInventory.txt");
         
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
     }
     
     public static void readFromFile(Seller seller, String fileName)
    {
        try
        {
        
        List<String> lines = Files.readAllLines(Paths.get(fileName)); //Reads all lines from a file and puts them in a list
        
        ArrayList<String> tokens = new ArrayList();
        for (int i = 0; i < lines.size(); i++)  //For every line
        {
            //String[] result = lines.get(i).split("\\s");
            StringTokenizer st = new StringTokenizer(lines.get(i)); //tokenize 1 line
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
             return tempBuyer.isPasswordMatch(password);
         }
         else
         {
             Seller tempSeller = findSeller(username);
             return tempSeller.isPasswordMatch(password);
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
     
     
     private static ArrayList<Buyer> buyerList;
     private static ArrayList<Seller> sellerList;
     
}
