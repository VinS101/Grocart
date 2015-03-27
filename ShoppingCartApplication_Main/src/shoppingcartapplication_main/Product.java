
package shoppingcartapplication_main;


public class Product 
{
    /**
     * Constructor for Product, sets the products name, price, description, quantity, totalNumberSold, cost, sold by. 
     * @param name
     * @param price
     * @param description
     * @param quantity
     * @param totalNumberSold
     * @param cost
     * @param soldBy
     */
    public Product(String name, double price, String description, int quantity, int totalNumberSold, double cost, String soldBy)
    {
        this.name = name;
        this.price = price;
        this.description = description;
        this.inventoryQuantity = quantity;
        this.totalNumberSold = totalNumberSold;
        this.cost = cost;
        this.soldBy = soldBy;
        this.shoppingCartQuantity = 0;
    }
    /**
     * Accessor for name
     * @return name
     */
    public String getName()
    {
        return this.name;
    }
    /**
     * Accessor for description
     * @return description
     */
    public String getDescription()
    {
        return this.description;
    }
    /**
     * Accessor for price
     * @return price
     */
    public double getPrice()
    {
        return this.price;
    }
    /**
     * Accessor for quantity
     * @return quantity
     */
    public int getQuantity()
    {
        return this.quantity;
    }
    /**
     * Accessor for totalNumberSold
     * @return totalNumberSold
     */
    public int getTotalNumberSold()
    {
        return this.totalNumberSold;
    }
    /**
     * Accessor for Cost
     * @return cost
     */
    public double getCost()
    {
        return this.cost;
    }
    /**
     * Accessor for soldBy, returns the Seller object that sells this product
     * @return soldBy
     */
    public String getSoldBy()
    {
        return this.soldBy;
    }
    /**
     * Mutator for changing the product name
     * @param name 
     */
    public void setName(String name)
    {
        this.name = name;
    }
    /**
     * Mutator for changing product description
     * @param description 
     */
    public void setDescription(String description)
    {
        this.description = description;
    }
    /**
     * Mutator for changing product price
     * @param price 
     */
    public void setPrice(double price)
    {
        this.price = price;
    }
    /**
     * Mutator for changing seller's inventory quantity
     * @param quantity 
     */
    public void setInventoryQuantity (int quantity)
    {
        this.inventoryQuantity = quantity;
    }
    /**
     * Mutator for changing shopping cart's product quantity
     * @param quantity 
     */
    public void setCartQuantity (int quantity)
    {
        this.shoppingCartQuantity = quantity;
    }
    /**
     * Mutator for changing product cost
     * @param cost 
     */
    public void setCost (double cost)
    {
        this.cost = cost;
    }
    
   
    
    private String name;
    private String description;
    private double price;
    private int inventoryQuantity;
    private int shoppingCartQuantity;
    private int totalNumberSold;
    private double cost;
    private String soldBy;
}
