
package shoppingcartapplication_main;


public class Product 
{
    /**
     * Constructor for Product, sets the products name, price, description, quantity, totalNumberSold, cost, sold by. 
     * @param name  Name of product.
     * @param price Price of product.
     * @param description Description of product.
     * @param quantity Quantity of items in the inventories stock. 
     * @param cost Cost of item to the seller.
     * @param soldBy Sellers name.
     * @param totalNumberSold total number sold 
     */
    public Product(String name, double price, String description, int quantity, double cost, String soldBy, int totalNumberSold)
    {
        this.name = name;
        this.price = price;
        this.description = description;
        this.inventoryQuantity = quantity;
        this.cost = cost;
        this.soldBy = soldBy;
        this.cartQuantity = 0;
        this.totalNumberSold = totalNumberSold;
    }
    /**
     * Accessor for name.
     * @return name Name of Product.
     */
    public String getName()
    {
        return this.name;
    }
    /**
     * Accessor for description.
     * @return description Description of the product.
     */
    public String getDescription()
    {
        return this.description;
    }
    /**
     * Accessor for price.
     * @return price Price of the item.
     */
    public double getPrice()
    {
        return this.price;
    }
    /**
     * Accessor for inventory Quantity.
     * @return inventoryQuantity Quantity of product in sellers inventory.
     */
    public int getinventoryQuantity()
    {
        return this.inventoryQuantity;
    }
    /**
     * Accessor for inventory Quantity.
     * @return cartQuantity Quantity of product in buyers shopping cart.
     */
    public int getCartQuantity()
    {
        return this.cartQuantity;
    }
    /**
     * Accessor for totalNumberSold
     * @return totalNumberSold Number of products of this type sold.
     */
    public int getTotalNumberSold()
    {
        return this.totalNumberSold;
    }
    /**
     * Accessor for Cost
     * @return cost Cost of item for the seller.
     */
    public double getCost()
    {
        return this.cost;
    }
    /**
     * Accessor for soldBy, returns the Seller object that sells this product
     * @return soldBy Name of the seller.
     */
    public String getSoldBy()
    {
        return this.soldBy;
    }
    /**
     * Mutator for changing the product name
     * @param aName The name that the attribute will be changed to.
     */
    public void setName(String aName)
    {
        this.name = aName;
    }
    /**
     * Mutator for changing product description
     * @param aDescription The description that the attribute will be changed to.
     */
    public void setDescription(String aDescription)
    {
        this.description = aDescription;
    }
    /**
     * Mutator for changing product price
     * @param aPrice The price that the attribute will be changed to.
     */
    public void setPrice(double aPrice)
    {
        this.price = aPrice;
    }
    /**
     * Mutator for changing seller's inventory quantity
     * @param aQuantity The quantity that the attribute will be changed to.
     */
    public void setInventoryQuantity (int aQuantity)
    {
        this.inventoryQuantity = aQuantity;
        if(this.inventoryQuantity < 0)
        {
            this.inventoryQuantity = 0 - this.inventoryQuantity;
        }
    }
    /**
     * Mutator for changing shopping cart's product quantity
     * @param aQuantity The quantity that the attribute will be changed to.
     */
    public void setCartQuantity (int aQuantity)
    {
        this.cartQuantity = aQuantity;
    }
    /**
     * Mutator for changing product cost
     * @param aCost The cost that the attribute will be changed to.
     */
    public void setCost (double aCost)
    {
        this.cost = aCost;
    }
    
    public void setTotalNumberSold(int s)
    {
        this.totalNumberSold = s;
    }
    
   
    
    private String name;
    private String description;
    private double price;
    private int inventoryQuantity;
    private int cartQuantity;
    private int totalNumberSold;
    private double cost;
    private String soldBy;
}
