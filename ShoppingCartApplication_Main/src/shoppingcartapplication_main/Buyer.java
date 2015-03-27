
package shoppingcartapplication_main;


public class Buyer extends Account
{

    public Buyer(String aUsername, String aPassword) {
        super(aUsername, aPassword);
        cart = new ShoppingCart();
    }
    
    private ShoppingCart cart;
    
}
