
package shoppingcartapplication_main;


public class Seller extends Account
{
    /**
     * Constructor for the Seller class. it initiates the inventory
     * @param aUsername
     * @param aPassword 
     */
    public Seller(String aUsername, String aPassword)
    {
        super(aUsername, aPassword);
        inventory = new Inventory();
    }
    
    Inventory inventory;
}
