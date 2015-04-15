
package shoppingcartapplication_main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;
import static shoppingcartapplication_main.SellerPage.frame;

public class CartPage 
{
    static JFrame frame;
    static ShoppingCart cart;
    DefaultTableModel dm; 
    JTable table;
    JTable addTable;
     DefaultTableCellRenderer centerRenderer;
     boolean viewedCartPage;
    
     CartPage()
    { 
     frame = new JFrame();    //Create the main frame  
     centerRenderer = new DefaultTableCellRenderer();
     viewedCartPage = false;
    }
     
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
        JLabel logo = new JLabel(name +"'s Shopping Cart");
        logo.setFont(logo.getFont().deriveFont(33.0f));
        logoPanel.add(logo);
        
        //Make buttons
        JButton logout = new JButton("Logout");
        JButton continueShopping = new JButton("Continue Shopping");
        JButton checkout = new JButton("Checkout");
        logout.setPreferredSize(new Dimension(150,75));
        continueShopping.setPreferredSize(new Dimension(150,75));
        checkout.setPreferredSize(new Dimension(150,75));
        
        
        //Populate buttons
        buttonPanel.add(continueShopping);
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
       table.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
       table.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
       table.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
       table.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
       table.getColumnModel().getColumn(5).setCellRenderer( centerRenderer );
       
       table.getColumn("Button").setCellRenderer(new ButtonRenderer());
       table.getColumn("Button").setCellEditor(new ButtonEditor(new JCheckBox()));
       table.getColumn("Description").setCellRenderer(new ButtonRenderer());
       table.getColumn("Description").setCellEditor(new ButtonEditor(new JCheckBox()));
        
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
        
        southPanel.add(checkout);

        
        mainPanel.add(southPanel,BorderLayout.SOUTH );
        //Make JFrame
        
        
        frame.getContentPane().setBackground(Color.green);  //set background color
        frame.setLayout(new BorderLayout());
        //frame.setExtendedState(JFrame.MAXIMIZED_BOTH);  //fullscreen
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //close
        //frame.add(scroll, BorderLayout.CENTER );
        frame.add(northPanel, BorderLayout.NORTH);
        frame.add(mainPanel);   //Add main panel
        //frame.add(southPanel, BorderLayout.SOUTH);
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
        
        continueShopping.addActionListener(new ActionListener()
       {
        @Override
        public void actionPerformed(ActionEvent ae)
        {
          frame.setVisible(false);
          

          ShoppingCartSystem.buyerPage.display();
           
        }
    } );
        
        checkout.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent ae)
            {
                
                if (ShoppingCartSystem.getActiveBuyer().getCart().getSize() != 0)
                {
                    if(viewedCartPage == false)
                    {
                        viewedCartPage = true;
                        frame.setVisible(false);
                        ShoppingCartSystem.checkOutPage.display(ShoppingCartSystem.getActiveBuyer().getCart());
                    }
                    else
                    {
                        
                        frame.setVisible(false);
                        ShoppingCartSystem.checkOutPage.repaintTable(ShoppingCartSystem.getActiveBuyer().getCart());
                    }
                    
                }
                else
                {
                    JOptionPane.showMessageDialog(frame, "You have no items in your shopping cart.");
                }
            }
            
        });
        
    }
     
    public void repaintTable(ShoppingCart newCart)
    {
        frame.setVisible(true);
        cart = newCart;
        dm = generateTable();
        table.setModel(dm);
        
        table.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
        table.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
        table.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
        table.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
        table.getColumnModel().getColumn(5).setCellRenderer( centerRenderer );
        table.getColumn("Button").setCellRenderer(new ButtonRenderer());
        table.getColumn("Button").setCellEditor(new ButtonEditor(new JCheckBox()));
        table.getColumn("Description").setCellRenderer(new ButtonRenderer());
        table.getColumn("Description").setCellEditor(new ButtonEditor(new JCheckBox()));
        
        table.repaint();
    }
    
    public DefaultTableModel generateTable()
    {
        dm = new DefaultTableModel()
        {
            @Override
            public boolean isCellEditable(int row, int column)
            {
                if(column !=4 && column !=3 && column != 0 ) return false;
                else return true;
                 
            }
        };   
        
        dm.setDataVector(new Object[][]  {  }, new Object[] { "Button", "Product", "Price", "Description", "Quantity", "Sold By"});
        Iterator iter = cart.getAllProducts();
        
       
        while(iter.hasNext())
        {
            
            Product tempProduct = (Product) iter.next();

            Object[] row = new Object[] {"Update", tempProduct.getName(), tempProduct.getPrice(), "Click for Description", tempProduct.getCartQuantity(), tempProduct.getSoldBy()};
            dm.addRow(row);
           
        }
        
        return dm;
    }
    
    class ButtonRenderer extends JButton implements TableCellRenderer 
    {

        public ButtonRenderer() 
        {
          setOpaque(true);
        }

        public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column)
        {
          if (isSelected) {
            setForeground(table.getSelectionForeground());
            setBackground(table.getSelectionBackground());
          } else {
            setForeground(table.getForeground());
            setBackground(UIManager.getColor("Button.background"));
          }
          setText((value == null) ? "" : value.toString());
          return this;
        }
}

/**
 * @version 1.0 11/09/98
 */

class ButtonEditor extends DefaultCellEditor 
{
    protected JButton button;

    private String label;

    private boolean isPushed;

    public ButtonEditor(JCheckBox checkBox) {
      super(checkBox);
      button = new JButton();
      button.setOpaque(true);
      button.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          fireEditingStopped();
        }
      });
    }

    public Component getTableCellEditorComponent(JTable table, Object value,
        boolean isSelected, int row, int column) {
      if (isSelected) {
        button.setForeground(table.getSelectionForeground());
        button.setBackground(table.getSelectionBackground());
      } else {
        button.setForeground(table.getForeground());
        button.setBackground(table.getBackground());
      }
      label = (value == null) ? "" : value.toString();
      System.out.println(table.getValueAt(row, column + 1).toString());
      
      if(column == 0)   // Update Button
      {
        if(table.getValueAt(row, column + 4).equals("0"))
        {
           String name = table.getValueAt(row, column + 1).toString();  
           Product temp = ShoppingCartSystem.getActiveBuyer().getCart().getOneProduct(name);
           ShoppingCartSystem.getActiveBuyer().getCart().removeProduct(temp);
        }
        else
        {
            String name = table.getValueAt(row, column + 1).toString();
            
            //Get new quantity
            String quantity = (String) (table.getValueAt(row, column + 4));
            int q = Integer.parseInt(quantity);

            Product temp = ShoppingCartSystem.getActiveBuyer().getCart().getOneProduct(name);  //changed
            temp.setCartQuantity(q);
        }
         
  
      if (ShoppingCartSystem.getActiveBuyer().getCart().getSize() > 0)
      {
            dm = generateTable();
            table.setModel(dm);

            table.getColumn("Button").setCellRenderer(new ButtonRenderer());
            table.getColumn("Button").setCellEditor(new ButtonEditor(new JCheckBox()));
            table.getColumn("Description").setCellRenderer(new ButtonRenderer());
            table.getColumn("Description").setCellEditor(new ButtonEditor(new JCheckBox()));
                    
   
            //table.setDefaultRenderer(String.class, centerRenderer);
            table.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
            table.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
            table.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
            table.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
            table.getColumnModel().getColumn(5).setCellRenderer( centerRenderer );
        
            table.repaint();
      }
      
      else
      {
         dm.setDataVector(new Object[][]  {  }, new Object[] { "Button", "Product", "Price", "Description", "Quantity", "Total Sold"});
         table.setModel(dm);
          //table.setDefaultRenderer(String.class, centerRenderer);
        table.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
        table.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
        table.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
        table.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
        table.getColumnModel().getColumn(5).setCellRenderer( centerRenderer );
        table.getColumn("Button").setCellRenderer(new ButtonRenderer());
        table.getColumn("Button").setCellEditor(new ButtonEditor(new JCheckBox()));
        table.getColumn("Description").setCellRenderer(new ButtonRenderer());
        table.getColumn("Description").setCellEditor(new ButtonEditor(new JCheckBox()));
        table.repaint();
      }
      
      button.setText(label);
      isPushed = true;
      
      }
      
      else if(column == 3)  //Description Button
      {
          System.out.println("Description");
          String name = table.getValueAt(row, column - 2).toString();
          Product temp = ShoppingCartSystem.getActiveBuyer().getCart().getOneProduct(name);
          frame.setVisible(false);
          try
          {
              ShoppingCartSystem.descriptionPage.display(temp);
          } 
          
          catch (IOException ex)
          {
              Logger.getLogger(SellerPage.class.getName()).log(Level.SEVERE, null, ex);
          }
      }
      
      else  //Anything else
      {
          
          if (ShoppingCartSystem.getActiveSeller().getInventory().getSize() > 0)
          {
            dm = generateTable();
            table.setModel(dm);

            table.getColumn("Button").setCellRenderer(new ButtonRenderer());
            table.getColumn("Button").setCellEditor(new ButtonEditor(new JCheckBox()));
            table.getColumn("Description").setCellRenderer(new ButtonRenderer());
            table.getColumn("Description").setCellEditor(new ButtonEditor(new JCheckBox()));
        
            //table.setDefaultRenderer(String.class, centerRenderer);
            table.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
            table.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
            table.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
            table.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
            table.getColumnModel().getColumn(5).setCellRenderer( centerRenderer );
        
            table.repaint();
      }
      
      else
          {
             dm.setDataVector(new Object[][]  {  }, new Object[] { "Button", "Product", "Price", "Description", "Quantity", "Total Sold"});
             table.setModel(dm);
            //table.setDefaultRenderer(String.class, centerRenderer);
            table.getColumnModel().getColumn(1).setCellRenderer( centerRenderer );
            table.getColumnModel().getColumn(2).setCellRenderer( centerRenderer );
            table.getColumnModel().getColumn(3).setCellRenderer( centerRenderer );
            table.getColumnModel().getColumn(4).setCellRenderer( centerRenderer );
            table.getColumnModel().getColumn(5).setCellRenderer( centerRenderer );
            table.getColumn("Button").setCellRenderer(new ButtonRenderer());
            table.getColumn("Button").setCellEditor(new ButtonEditor(new JCheckBox()));
            table.getColumn("Description").setCellRenderer(new ButtonRenderer());
            table.getColumn("Description").setCellEditor(new ButtonEditor(new JCheckBox()));
            
            table.repaint();
      }
      }
      return button;
    }
    
   

    public Object getCellEditorValue() 
    {
      if (isPushed) {
        // 
        // 
        JOptionPane.showMessageDialog(button, "Product Removed From Inventory");
        // System.out.println(label + ": Ouch!");
      }
      isPushed = false;
      return new String(label);
    }

    public boolean stopCellEditing() {
      isPushed = false;
      return super.stopCellEditing();
    }

    protected void fireEditingStopped() {
      super.fireEditingStopped();
    }
   }
}
