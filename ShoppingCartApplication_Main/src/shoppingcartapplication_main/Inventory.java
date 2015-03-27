
package shoppingcartapplication_main;

import java.util.ArrayList;
import java.util.Iterator;


public class Inventory
{
    public Inventory()
    {
        inventory = new ArrayList<>();
    }
    
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
    
    public Product getproduct(String name)
    {
        Iterator iter = this.getAllProducts();
         Product product = (Product) iter.next();
         
        while(iter.hasNext()){
         
         if(product.getName().equals(name)){
            break;
         }
         
         product = (Product) iter.next();
         
        }
         return product;
    }
    
    public Product removeProduct()
    {
        
    }
    
    
    private ArrayList<Product> inventory;;
    
}
    
