
package shoppingcartapplication_main;


public class Buyer extends Account
{

    public Buyer(String aUsername, String aPassword, ShoppingCart aCart) {
        super(aUsername, aPassword);
        cart = aCart;
    }
    
    private ShoppingCart cart;
    
}
