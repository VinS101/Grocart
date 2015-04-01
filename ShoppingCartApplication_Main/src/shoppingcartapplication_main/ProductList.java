
package shoppingcartapplication_main;

import java.util.ArrayList;
import java.util.Iterator;


public class ProductList 
{
    public ProductList(){
        productList = new ArrayList<>();
    }
    
    /**
     * Returns an iterator used to cycle through all the products in the list.
     * @return An anonymous iterator class for the product list.
     */
    static public Iterator<Product> getAllProducts()
   {
      return new
         Iterator<Product>()
         {
            @Override
            public boolean hasNext()
            {
               return current < productList.size();
            }

            @Override
            public Product next()
            {
               return productList.get(current++);
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
     * Finds a product by the given name and seller strings in the product list and returns it.
     * @param name Name of the product.
     * @param soldBy Seller of the product's name.
     * @return The product being searched for.
     */
    
    public Product getOneProduct(String name, String soldBy){
        Iterator iter = this.getAllProducts();
         Product product = (Product) iter.next();
         
        while(iter.hasNext()){
         
         if(product.getName().equals(name) && product.getSoldBy().equals(soldBy)){
            break;
        }
         
         product = (Product) iter.next();
         
        }
         return product;
    }
    
    static ArrayList<Product> productList;
}
