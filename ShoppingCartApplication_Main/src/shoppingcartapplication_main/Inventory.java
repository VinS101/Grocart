
package shoppingcartapplication_main;

import java.util.ArrayList;
import java.util.Iterator;


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
     * testing
     * @param args 
     */
//    public static void main(String[] args)
//    {
//        
//        
//    }
    //Example from the book
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
     * @param aName
     * @return 
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
     * @param aProduct 
     */
    public void addToInventory(Product aProduct)
    {
        inventory.add(aProduct);
    }
    
    public void removeProduct(Product aProduct)
    {
        inventory.remove(aProduct);
    }
    /**
     * not implemented yet
     */
    public void overWriteInventoryFile()
    {
    }
    
    public boolean checkStock(Product product)
    {
       Product tempInventoryProduct = getProduct(product.getName());
        return tempInventoryProduct.getinventoryQuantity() > product.getCartQuantity();
    }
    /**
     * Not impelemented yet
     */
    public void updateInventory()
    {
    
    }
    
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
        result = "Total Products Sold: " + totalProductsSold + "\nTotal Profit: " + totalProfit + "\nRevenue: " + totalRevenue; 
        return result;
    }
    
    private ArrayList<Product> inventory;
}
    
