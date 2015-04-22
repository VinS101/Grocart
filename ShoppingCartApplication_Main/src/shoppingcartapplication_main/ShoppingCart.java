
package shoppingcartapplication_main;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * A class designated to creating a shoppingc cart for each buyer.
 */

public class ShoppingCart
{
    /**
     * Constructor for shopping cart.
     */
    
    public ShoppingCart()
    {
        cart = new ArrayList<>();
    }
    
    /**
     * Returns iterator pointing to products inside shopping cart list.
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
    
    /**
     * Returns cart size.
     * @return cart.size().
     */    
    
    public int getSize(){
        return cart.size();
    }
    
    /**
     * Finds and returns one product.
     * @param name name of the product.
     * @return product that is found.
     * @precondition a product with the name "name" must exist.
     */
    
    
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
    
    /**
     * Adds product to cart.
     * @param aProduct product to be added.
     * @param quantity how many of the product to be added.
     * @preconditon quantity > 0
     */
    
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
    
    
    /**
     * Removes product from cart.
     * @param aProduct product to be removed.
     */
    public void removeProduct(Product aProduct){
        cart.remove(aProduct);
    }
    
    /**
     * Clears cart of all items.
     */
    
    public void clearCart(){
        Iterator iter = getAllProducts();
        
        while (iter.hasNext()){
            removeProduct((Product) iter.next());
        }
        System.out.println(cart.size());
    }
    
    /**
     * Calculates total price of items in cart.
     * @return total price.
     */
    
    public double getTotalPrice()
    {
        totalPrice = 0;
        
        for (int i = 0; i < cart.size(); i++)
        {
            totalPrice = totalPrice + (cart.get(i).getPrice() * cart.get(i).getCartQuantity());
        }
        
        return totalPrice;
    }
    
    /**
     * Generates a summary for items purchased in cart.
     * @return string consisting of the summary.
     */
    
    public String generateSummary(){

       Iterator iter = getAllProducts();
        String invoice = "";
       int count = 1;
        while(iter.hasNext())
        {
            
            Product tempProduct = (Product) iter.next();
            String tempPriceText = new DecimalFormat("#.##").format(tempProduct.getPrice()*tempProduct.getCartQuantity());
            
            

            invoice = invoice + count + ". " + tempProduct.getName() + "\tQuantity: " + tempProduct.getCartQuantity()+ "\tPrice: $ " + tempPriceText + "\n";
            count++;
        }
        
        return invoice;
    }
    
    private ArrayList<Product> cart;
    private double totalPrice;

  
    
}
