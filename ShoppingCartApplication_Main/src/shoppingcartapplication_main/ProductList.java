
package shoppingcartapplication_main;

import java.util.ArrayList;
import java.util.Iterator;


public class ProductList 
{
    public ProductList(){
        productList = new ArrayList<>();
    }
    
    public Iterator<Product> getAllProducts()
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
    public Product getOneProduct(String name){
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
    
    ArrayList<Product> productList;
}
