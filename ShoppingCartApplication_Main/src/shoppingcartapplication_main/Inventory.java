
package shoppingcartapplication_main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Class used to handle seller inventories.
 */

public class Inventory
{
    /**
     * Constructor for the inventory class. it initializes the inventory ArrayList
     */
    public Inventory()
    {
        inventory = new ArrayList<>();
    }
       
    /**
     * Returns iterator pointing to products inside inventory list.
     * @return product iterator.
     */
    public Iterator<Product> getAllProducts()
   {
      return new
         Iterator<Product>()
         {
            @Override
            public boolean hasNext()
            {
               return current < inventory.size();
            }

            @Override
            public Product next()
            {
               return inventory.get(current++);
            }

            @Override
            public void remove()
            {
               throw new UnsupportedOperationException();
            }

            private int current = 0;
         };
   }
    /**
     * Find the product from the list
     * @param aName name of the product.
     * @return product object with the same name attribute as aName.
     */
    public Product getProduct(String aName)
    {
        Iterator iter = this.getAllProducts();
        Product product = (Product) iter.next();
         
        while(iter.hasNext()){
         
         if(product.getName().equals(aName)){
            break;
         }
         product = (Product) iter.next();
        }
         return product;
    }
    /**
     * Add the product to array list inventory
     * @param aProduct product to be added.
     */
    public void addToInventory(Product aProduct)
    {
        inventory.add(aProduct);
    }
    
    /**
     * Removes product from inventory.
     * @param aProduct product to be removed.
     */
    
    public void removeProduct(Product aProduct)
    {
        inventory.remove(aProduct);
    }
    
    /**
     * Overwrites sellers inventory text file for persistency.
     * @param s Seller who's inventory has changed.
     */
    
    public void overWriteInventoryFile(Seller s)
    {
        String result = "";
        try
        {
        File fout = new File(s.getUsername() + "Inventory.txt");    //Create file
        FileOutputStream fos = new FileOutputStream(fout);  //create output steam
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));    //create writer
        
        //Loop goes here to save Data line by line
        for(int i=0; i < inventory.size(); i++)
        {
            result += inventory.get(i).getName() + "\t";
            result += inventory.get(i).getPrice() + "\t";
            result += inventory.get(i).getDescription() + "\t";
            result += inventory.get(i).getinventoryQuantity() + "\t";
            result += inventory.get(i).getCost() + "\t";
            result += inventory.get(i).getSoldBy() + "\t";
            result += inventory.get(i).getTotalNumberSold();
            writer.write(result);   //write one line
            writer.newLine();   //next line
            result = "";  //clear
        }
//        writer.write("1 line goes here");
//        writer.newLine();
//        writer.write("new line goes here");
        writer.close();
        }
        catch(Exception e){}
    }
    
    /**
     * Checks if there is enough stock to satisfy cart amount.
     * @param product product that is being purchased.
     * @return TRUE if stock >= cart quantity, FALSE otherwise.
     */
    
    public boolean checkStock(Product product)
    {
       Product tempInventoryProduct = getProduct(product.getName());
        return tempInventoryProduct.getinventoryQuantity() >= product.getCartQuantity();
    }
   
    /**
     * Generates sellers financial summary.
     * @return a string consisting of sellers financial summary.
     * @precondtion inventory.size() > 0.
     */
    public String getFinancialSummary()
    {
        String result;
        
        double totalProfit = 0;
        double totalCost = 0;
        double totalRevenue = 0;
        int totalProductsSold = 0;
        
        Iterator iter = this.getAllProducts();
        while(iter.hasNext())
        {
            Product p = (Product) iter.next();
            totalRevenue += (p.getPrice() * p.getTotalNumberSold());
            totalCost += p.getCost()*(p.getTotalNumberSold()+p.getinventoryQuantity());
            totalProductsSold += p.getTotalNumberSold();
        }
        
        totalProfit = totalRevenue - totalCost;
        if(totalProfit < 0){
            totalProfit = 0;
        }
        
        String totalProfitText = new DecimalFormat("#.##").format(totalProfit);
        String totalRevenueText = new DecimalFormat("#.##").format(totalRevenue);
        result = "Total Products Sold: " + totalProductsSold + "\nTotal Profit: $" + totalProfitText + "\nRevenue: $" + totalRevenueText; 
        return result;
    }
    
    /**
     * Accessor for inventory size.
     * @return inventory.size().
     */
    
    public int getSize()
    {
        return inventory.size();
    }
    
    /**
     * Clears inventory.
     */
    
    public void clearInventory()
    {
        inventory.clear();
    }
 
    private ArrayList<Product> inventory;
}
    
