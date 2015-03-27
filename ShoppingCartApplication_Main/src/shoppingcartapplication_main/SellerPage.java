
package shoppingcartapplication_main;
import java.awt.*;
import javax.swing.*;

public class SellerPage 
{
    /**
     * For debugging purposes
     * @param args 
     */
    public static void main(String[] args)
    {
        SellerPage sellerPage = new SellerPage();
        sellerPage.display();
        
    }
    
    public void display()
    {
        JPanel mainPanel = new JPanel();    //panel for table and scroll bar
        JPanel northPanel = new JPanel();   //Big panel for north, containing the logo panel and buttonPanel
        JPanel southPanel = new JPanel();   //panel for below the main panel
        JPanel buttonPanel = new JPanel();   //panel for displaying log in and financial summary buttons
        JPanel scrollBarPanel = new JPanel();   //panel for creating scroll bar
        JPanel removeButtonPanel = new JPanel();    //panel for displaying remove buttons
        JPanel logoPanel = new JPanel();
        
        JScrollBar verticalBar = new JScrollBar(JScrollBar.VERTICAL, 30, 40, 0, 300);

        
        JLabel logo = new JLabel("Seller Page");
        logo.setFont(logo.getFont().deriveFont(24.0f));
        logoPanel.add(logo);
        mainPanel.setLayout(new BorderLayout());
        northPanel.setLayout(new FlowLayout());
        southPanel.setLayout(new FlowLayout());
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
        scrollBarPanel.setLayout(new BorderLayout());
        removeButtonPanel.setLayout(new BorderLayout());
        
        
        JButton button1 = new JButton("Logout");
        JButton button2 = new JButton("Financial Summary");
        JButton button3 = new JButton("Car");
        
        buttonPanel.add(button2);
        buttonPanel.add(button1);
        

        northPanel.add(logoPanel, BorderLayout.WEST);
        northPanel.add(Box.createRigidArea(new Dimension(600,5)));  //LOGO GOES HERE
        northPanel.add(buttonPanel, BorderLayout.EAST);
        
        scrollBarPanel.add(verticalBar);
        
        mainPanel.add(Box.createRigidArea(new Dimension(400,400)));
        mainPanel.add(scrollBarPanel, BorderLayout.EAST);
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        
        southPanel.add(Box.createRigidArea(new Dimension(100,100)));
        
        JFrame frame = new JFrame("Seller Page");    //Create the main frame
        frame.getContentPane().setBackground(Color.green);  //set background color
        frame.setLayout(new BorderLayout());
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);  //fullscreen
        
        frame.add(northPanel, BorderLayout.NORTH);
        frame.add(mainPanel, BorderLayout.CENTER);   //Add main panel
        frame.add(southPanel, BorderLayout.SOUTH);
//        frame.add(buttonPanel, BorderLayout.NORTH);
//        frame.add(scrollBarPanel, BorderLayout.EAST);
//        frame.add(removeButtonPanel, BorderLayout.WEST);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //close
        frame.pack();       //pack
        frame.setLocationRelativeTo(null);  //set position
        frame.setVisible(true); //set visible
        
    }
    
    public void input()
    {
    
    }
}
