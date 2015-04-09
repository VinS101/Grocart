
package shoppingcartapplication_main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LoginPage 
{
public static void main(String[] args){
    LoginPage login = new LoginPage();
    login.display();
}
    
    /**
     * This method displays the login page on the GUI.
     */
    public void display(){
        
    JFrame frame = new JFrame("Login Page:");
    
    
    JPanel logoPanel = new JPanel();
    JLabel logo = new JLabel("Login Page");
    logo.setFont(logo.getFont().deriveFont(24.0f));
    logoPanel.add(logo);
    
    JPanel loginPanel = new JPanel();
    loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS));
    
    JPanel userNamePanel = new JPanel();
    userNamePanel.setLayout(new FlowLayout());
    
    userNamePanel.add(new JLabel("Username: "));
    JTextField username = new JTextField();
    username.setPreferredSize( new Dimension( 50,20) );
    userNamePanel.add(username);
    
    JPanel passwordPanel = new JPanel();
    passwordPanel.setLayout(new FlowLayout());
    
    passwordPanel.add(new JLabel("Password: "));
    JTextField password = new JTextField();
    password.setPreferredSize( new Dimension( 100,20) );
    passwordPanel.add(password);
    
    JPanel textFieldsPanel = new JPanel();
    textFieldsPanel.setLayout(new BoxLayout(textFieldsPanel, BoxLayout.Y_AXIS));
    textFieldsPanel.add(userNamePanel);
    textFieldsPanel.add(passwordPanel);
    
   
    
    String[] menuOptions = {"Buyer", "Seller"};
    JComboBox dropMenu = new JComboBox(menuOptions);

    JButton login = new JButton("Login");
    
    
    JPanel inputPanel = new JPanel();
    
    inputPanel.add(dropMenu);
    inputPanel.add(login);
    
    
    loginPanel.add(Box.createRigidArea(new Dimension(0,25)));
    loginPanel.add(textFieldsPanel);
    loginPanel.add(inputPanel);
    
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   frame.add(logoPanel, BorderLayout.NORTH);
   frame.add(loginPanel, BorderLayout.CENTER);
   
   frame.setSize(500,300);
   frame.setVisible(true);
   
   login.addActionListener(new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent ae)
        {
           String user = username.getText();
           String pass = password.getText();
           boolean isBuyer;
           if(dropMenu.getSelectedItem().equals("Buyer"))
           {
              isBuyer = true;
           }
           else
           {
               isBuyer = false;
           }
           
           if(ShoppingCartSystem.authenticate(user, pass, isBuyer))
           {
               frame.setVisible(false);
               ShoppingCartSystem.buyerPage.display();
           }
        }
    } );
    }
    
}
