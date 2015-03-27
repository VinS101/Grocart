
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
    
    public void addToCart(Product aProduct, int quantity){
        aProduct.setCartQuantity(quantity);
        cart.add(aProduct);
    }
    
    public void removeProduct(Product aProduct){
        cart.remove(aProduct);
    }
    
    public double getTotalPrice(){
        double price = 0.0;
        
        for (int i = 0; i < cart.size()-1; i++){
            price = price + cart.get(i).getPrice();
        }
        
        return price;
    }
    
    
    
    private ArrayList<Product> cart;

  
    
}
