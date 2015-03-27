
package shoppingcartapplication_main;

import javax.swing.*;
import java.awt.*;

public class DescriptionPage 
{
    public DescriptionPage(Product aProduct){
        product = aProduct;
    }
    
    public static void main(String[] args){
        Product milk = new Product("Milk", 2.99, "It's Fucking Milk... It's Fucking Delicious.", 10, 0, 1.50, "Shervin");
        DescriptionPage description = new DescriptionPage(milk);
        description.display();
    }
    
    
    public void display(){
        
        JFrame frame = new JFrame("Product Description:");
        frame.setSize(1000,700); 
        
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());
        
        JLabel productTitle = new JLabel("Product:   " +product.getName());
        productTitle.setFont(productTitle.getFont().deriveFont(40.0f));
        
        JButton logout = new JButton("Logout");
        logout.setPreferredSize(new Dimension(100,30));
        logout.setFont(logout.getFont().deriveFont(12.0f));
        JButton back = new JButton("Back to Homepage");
        back.setPreferredSize(new Dimension(150,30));
        back.setFont(back.getFont().deriveFont(12.0f));
        
        topPanel.add(productTitle);
        topPanel.add(Box.createRigidArea(new Dimension(350,0)));
        topPanel.add(back);
        topPanel.add(logout);
        
        JPanel mainPanel = new JPanel();

       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.add(topPanel, BorderLayout.NORTH);
    //   frame.add(loginPanel, BorderLayout.CENTER);

       
       frame.setVisible(true);
   
   } 
    
    private Product product;
}
