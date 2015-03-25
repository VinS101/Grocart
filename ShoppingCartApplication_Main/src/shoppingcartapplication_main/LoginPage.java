
package shoppingcartapplication_main;

import javax.swing.*;
import java.awt.*;


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
    username.setPreferredSize( new Dimension( 100,20) );
    userNamePanel.add(username);
    
    JPanel passwordPanel = new JPanel();
    passwordPanel.setLayout(new FlowLayout());
    
    passwordPanel.add(new JLabel("Password: "));
    JTextField password = new JTextField();
    password.setPreferredSize( new Dimension( 100,20) );
    passwordPanel.add(password);
    
    JPanel inputPanel = new JPanel();
    
    String[] menuOptions = {"Buyer", "Seller"};
    JComboBox dropMenu = new JComboBox(menuOptions);
    
    
    JButton login = new JButton("Login");
    
    inputPanel.add(dropMenu);
    inputPanel.add(login);
   
  
    loginPanel.add(userNamePanel);
    loginPanel.add(Box.createRigidArea(new Dimension(0,5)));
    loginPanel.add(passwordPanel);
    
    loginPanel.add(Box.createRigidArea(new Dimension(0,25)));
    loginPanel.add(userNamePanel);
    loginPanel.add(passwordPanel);
    loginPanel.add(inputPanel);
    
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   frame.add(logoPanel, BorderLayout.NORTH);
   frame.add(loginPanel, BorderLayout.CENTER);
   
   frame.setSize(500,300);
   frame.setVisible(true);
   
    }
   
    
}
