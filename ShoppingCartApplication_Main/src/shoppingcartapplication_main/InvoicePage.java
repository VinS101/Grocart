
package shoppingcartapplication_main;

import javax.swing.*;
import java.awt.*;

public class InvoicePage 
{
         public static void main(String[] args){
        InvoicePage invoice = new InvoicePage();
        invoice.display();
    }
        public void display(){
        
        JFrame frame = new JFrame("Invoice");
        frame.setSize(1000,700);
        
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());
        
        JLabel productTitle = new JLabel("\t\t Thank you for shopping!");
        productTitle.setFont(productTitle.getFont().deriveFont(40.0f));
        
        JButton logout = new JButton("Logout");
        logout.setPreferredSize(new Dimension(100,30));
        logout.setFont(logout.getFont().deriveFont(12.0f));
        JButton back = new JButton("Back to Homepage");
        back.setPreferredSize(new Dimension(150,30));
        back.setFont(back.getFont().deriveFont(12.0f));
        
        topPanel.add(productTitle);
        topPanel.add(Box.createRigidArea(new Dimension(200,0)));
        topPanel.add(back);
        topPanel.add(logout);
        
        JPanel mainPanel = new JPanel();

       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.add(topPanel, BorderLayout.NORTH);
    //   frame.add(loginPanel, BorderLayout.CENTER);

       
       frame.setVisible(true);
   
   } 
}
