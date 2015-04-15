
package shoppingcartapplication_main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import static shoppingcartapplication_main.CartPage.cart;


public class CheckOutPage 
{
    static JFrame frame;
    static ShoppingCart cart;
    DefaultTableModel dm; 
    JTable table;
    JTable addTable;
    DefaultTableCellRenderer centerRenderer;
    DefaultTableCellRenderer descriptionRenderer = new DefaultTableCellRenderer();
    
     CheckOutPage()
    { 
       frame = new JFrame();    //Create the main frame  
      
    }
//    public static void main(String[] args)
//    {
//       CheckOutPage page  = new CheckOutPage();
//        page.display(cart);
//        
//    }
     public void display(ShoppingCart aCart)
    {
        cart = aCart;
        
        System.out.println(cart.getSize());
        //Make panels
        JPanel mainPanel = new JPanel();    //panel for table
        JPanel northPanel = new JPanel();   //Big panel for north, containing the logo panel and buttonPanel
        JPanel southPanel = new JPanel();   //panel for below the main panel
        JPanel buttonPanel = new JPanel();   //panel for displaying log in and financial summary buttons
        JPanel scrollBarPanel = new JPanel();   //panel for creating scroll bar
        JPanel removeButtonPanel = new JPanel();    //panel for displaying remove buttons
        JPanel logoPanel = new JPanel();
        
        //Make scrollbar
        JScrollBar verticalBar = new JScrollBar(JScrollBar.VERTICAL, 30, 40, 0, 300);

        //Set layouts for panels
        mainPanel.setLayout(new BorderLayout());
        northPanel.setLayout(new FlowLayout());
        southPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        scrollBarPanel.setLayout(new BorderLayout());
        removeButtonPanel.setLayout(new BorderLayout());
        logoPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        
        //Configure colors
        mainPanel.setBackground(new Color(70, 179, 43)); //set color
        northPanel.setBackground(new Color(70, 179, 43)); //set color
        southPanel.setBackground(new Color(70, 179, 43)); //set color
        buttonPanel.setBackground(new Color(70, 179, 43)); //set color
        northPanel.setBackground(new Color(70, 179, 43)); //set color
        logoPanel.setBackground(new Color(70, 179, 43)); //set color
        
        //Make and add logo
        String name = ShoppingCartSystem.getActiveBuyer().getUsername().substring(0, 1).toUpperCase() + ShoppingCartSystem.getActiveBuyer().getUsername().substring(1);
        JLabel logo = new JLabel("Your Checkout Page");
        logo.setFont(logo.getFont().deriveFont(33.0f));
        logoPanel.add(logo);
        
        //Make buttons
        JButton logout = new JButton("Logout");
        JButton back = new JButton("Back to Cart");
        JButton checkout = new JButton("Confirm Purchase");
        logout.setPreferredSize(new Dimension(150,75));
        back.setPreferredSize(new Dimension(150,75));
        checkout.setPreferredSize(new Dimension(150,75));
        
        //Make credit cart texfiled
        JTextField field = new JTextField("Enter your credit cart number");
        field.setSize(50,200);
        
        //Get total
        double total = ShoppingCartSystem.getActiveBuyer().getCart().getTotalPrice();
        JTextArea totalText = new JTextArea("Total: " + Double.toString(total));
        
        
        //Populate buttons
        buttonPanel.add(back);
        buttonPanel.add(logout);
        
        //Populate northPanel
        northPanel.add(logoPanel);
        northPanel.add(Box.createRigidArea(new Dimension(600,5)));  //LOGO GOES HERE
        northPanel.add(buttonPanel);
        
        //Add scrollbar
        scrollBarPanel.add(verticalBar);
        
        //Create default table model
        DefaultTableModel dm = generateTable();
      
        //Create the Table
       table = new JTable();
       table.getTableHeader().setReorderingAllowed(false);
       table.setOpaque(false);

       table.setModel(dm);
       
        //table.setDefaultRenderer(String.class, centerRenderer);
       table.getColumnModel().getColumn(0).setCellRenderer( centerRenderer );
       table.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
       table.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
       table.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
       
      
        
        //Create the scrollpane
        JScrollPane scroll = new JScrollPane(table);
        scroll.getViewport().setBackground(new Color(70, 179, 43));
        scroll.getViewport().setOpaque(true);
        scroll.setBorder(BorderFactory.createEmptyBorder());
        centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        
        
        
      
        
        
        //Populate MainPanel
        mainPanel.add(Box.createRigidArea(new Dimension(400,400)));
        mainPanel.add(scroll, BorderLayout.CENTER);
        
        
        //Populate SouthPanel
        southPanel.add(field);
        southPanel.add(totalText);
        southPanel.add(checkout);

        
        //mainPanel.add(southPanel,BorderLayout.SOUTH );
        //Make JFrame
        
        
        frame.getContentPane().setBackground(Color.green);  //set background color
        frame.setLayout(new BorderLayout());
        //frame.setExtendedState(JFrame.MAXIMIZED_BOTH);  //fullscreen
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //close
        //frame.add(scroll, BorderLayout.CENTER );
        frame.add(northPanel, BorderLayout.NORTH);
        frame.add(mainPanel);   //Add main panel
        frame.add(southPanel, BorderLayout.SOUTH);
        frame.setSize(1000,700);
        frame.pack();       //pack
        frame.setLocationRelativeTo(null);  //set position
        frame.setVisible(true); //set visible
        
        // Logout Button Controller (Annonymous)
        logout.addActionListener(new ActionListener()
    {
        @Override
        public void actionPerformed(ActionEvent ae)
        {
          frame.setVisible(false);
          ShoppingCartSystem.getActiveBuyer().getCart().clearCart();
          ShoppingCartSystem.clearActiveBuyer();
          ShoppingCartSystem.loginPage.display();
        }
    } );
        
        back.addActionListener(new ActionListener()
       {
        @Override
        public void actionPerformed(ActionEvent ae)
        {
          frame.setVisible(false);
          

          ShoppingCartSystem.cartpage.display(cart);
           
        }
    } ); 
        
    }
     
     public DefaultTableModel generateTable()
    {
        dm = new DefaultTableModel()
        {
            @Override
            public boolean isCellEditable(int row, int column)
            {
                return false;
            }
        };   
        
        dm.setDataVector(new Object[][]  {  }, new Object[] {"Product", "Price", "Quantity", "Sold By"});
        Iterator iter = cart.getAllProducts();
        
       
        while(iter.hasNext())
        {
            
            Product tempProduct = (Product) iter.next();

            Object[] row = new Object[] {tempProduct.getName(), tempProduct.getPrice(),tempProduct.getCartQuantity(), tempProduct.getSoldBy()};
            dm.addRow(row);
           
        }
        
        return dm;
    }
}

