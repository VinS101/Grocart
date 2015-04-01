
package shoppingcartapplication_main;


import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class ShoppingCartSystem 
{
     public static void main(String[] args)
     {
         //Make some Buyers
         Buyer Jack = new Buyer("jack", "123");
         Buyer Hendrix = new Buyer("hendrix", "123");
         
         //Make some Sellers
         Seller Joe = new Seller("joe", "234");
         Seller natasha = new Seller("natasha", "634");
         
         readFromFile(natasha, "natashaInventory.txt");
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
                    Double.parseDouble(tokens.get(4)), tokens.get(5), Integer.parseInt(tokens.get(i)));
            seller.getInventory().addToInventory(tempProduct);
            
        }
        
        
        
        //System.out.println(result[0]);
        }
        catch(Exception e){}
       
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
