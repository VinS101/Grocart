
package shoppingcartapplication_main;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;



public class ShoppingCart
{
    public ShoppingCart()
    {
        cart = new ArrayList<>();
    }
    
   
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
    
    public int getSize(){
        return cart.size();
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
        if(cart.contains(aProduct)){
            aProduct.setCartQuantity(aProduct.getCartQuantity() + quantity);
            System.out.println(quantity + " more" + aProduct.getName() + "products were added");
            return;
        }
        
        aProduct.setCartQuantity(quantity);
        cart.add(aProduct);
        System.out.println(aProduct.getName() + " was added");   //debugging
    }
    
    public void removeProduct(Product aProduct){
        cart.remove(aProduct);
    }
    
    public void clearCart(){
        Iterator iter = getAllProducts();
        
        while (iter.hasNext()){
            removeProduct((Product) iter.next());
        }
        System.out.println(cart.size());
    }
    
    public double getTotalPrice()
    {
        totalPrice = 0;
        
        for (int i = 0; i < cart.size(); i++)
        {
            totalPrice = totalPrice + (cart.get(i).getPrice() * cart.get(i).getCartQuantity());
        }
        
        return totalPrice;
    }
    
    public String generateSummary(){

       Iterator iter = getAllProducts();
        String invoice = "";
       
        while(iter.hasNext())
        {
            
            Product tempProduct = (Product) iter.next();
            String tempPriceText = new DecimalFormat("#.##").format(tempProduct.getPrice()*tempProduct.getCartQuantity());
            
            

            invoice = invoice + tempProduct.getName() + "\tQuantity: " + tempProduct.getCartQuantity()+ "\tPrice: $ " + tempPriceText + "\n";
     
        }
        
        return invoice;
    }
    
    private ArrayList<Product> cart;
    private double totalPrice;

  
    
}
