
package shoppingcartapplication_main;

import java.util.ArrayList;
import java.util.Iterator;



public class ShoppingCart
{
    public ShoppingCart(){
        cart = new ArrayList<>();
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
               return current < cart.size();
            }

            @Override
            public Product next()
            {
               return cart.get(current++);
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
    
    public void addToCart(Product aProduct){
        cart.add(aProduct);
    }
    
    
    
    ArrayList<Product> cart;

  
    
}
