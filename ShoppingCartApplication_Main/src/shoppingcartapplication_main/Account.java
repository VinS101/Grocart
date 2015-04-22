
package shoppingcartapplication_main;


public class Account 
{
    public Account(String aUsername, String aPassword)
    {
        this.username = aUsername;
        this.password = aPassword;
    }

    /**
     * Accessor for the username
     * @return 
     */
    public String getUsername()
    {
        return username;
    }
    /**
     * Is the password match or not
     * @param iPassword
     * @return this.password.equals(iPassword)
     */
    public boolean isPasswordMatch(String iPassword)
    {
        return (this.password.equals(iPassword));
    }
    
    private final String username;
    private final String password;
}
