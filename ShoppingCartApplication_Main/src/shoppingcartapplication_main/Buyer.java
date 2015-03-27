
package shoppingcartapplication_main;


public class Buyer extends Account
{
    /**
     * Constructor for a Buyer object.
     * @param aUsername The buyer's username.
     * @param aPassword The buyer's password.
     */

    public Buyer(String aUsername, String aPassword) {
        super(aUsername, aPassword);
        cart = new ShoppingCart();
    }
    
    private ShoppingCart cart;
    
}
