
package shoppingcartapplication_main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
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
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;


public class BuyerPage 
{
    /**
     * For debugging purposes
     * @param args 
     */
    public static void main(String[] args)
    {
       BuyerPage page  = new BuyerPage();
        page.display();
        
    }
    
    public void display()
    {
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
        southPanel.setLayout(new FlowLayout());
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
        JLabel logo = new JLabel("Buyer Page");
        logo.setFont(logo.getFont().deriveFont(40.0f));
        logoPanel.add(logo);
        
        //Make buttons
        JButton logout = new JButton("Logout");
        JButton financialSummary = new JButton("Financial Summary");
        logout.setPreferredSize(new Dimension(150,75));
        financialSummary.setPreferredSize(new Dimension(150,75));
        
        //Populate buttons
        buttonPanel.add(financialSummary);
        buttonPanel.add(logout);
        
        //Populate northPanel
        northPanel.add(logoPanel);
        northPanel.add(Box.createRigidArea(new Dimension(600,5)));  //LOGO GOES HERE
        northPanel.add(buttonPanel);
        
        //Add scrollbar
        scrollBarPanel.add(verticalBar);
        
        //Create default table model
        DefaultTableModel dm = new DefaultTableModel();
        dm.setDataVector(new Object[][]  {  }, new Object[] { "Button", "Product", "Price", "Description", "Quntity", "Sold by"});
        
        
        
        //Create the Table
        JTable table = new JTable(dm);
        table.getColumn("Button").setCellRenderer(new shoppingcartapplication_main.ButtonRenderer());
        table.getColumn("Button").setCellEditor(new shoppingcartapplication_main.ButtonEditor(new JCheckBox()));
        
        //Create the scrollpane
        JScrollPane scroll = new JScrollPane(table);
  
        
        //Populate MainPanel
        mainPanel.add(Box.createRigidArea(new Dimension(400,400)));
        mainPanel.add(scrollBarPanel, BorderLayout.EAST);
        mainPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        
        //Populate SouthPanel
        southPanel.add(Box.createRigidArea(new Dimension(100,100)));
        
        //Make JFrame
        JFrame frame = new JFrame("Buyer Page");    //Create the main frame    
        frame.getContentPane().setBackground(Color.green);  //set background color
        frame.setLayout(new BorderLayout());
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);  //fullscreen
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //close
        frame.add(scroll, BorderLayout.CENTER );
        frame.add(northPanel, BorderLayout.NORTH);
        //frame.add(mainPanel, BorderLayout.CENTER);   //Add main panel
        frame.add(southPanel, BorderLayout.SOUTH);
        frame.setSize(1000,700);
        frame.pack();       //pack
        frame.setLocationRelativeTo(null);  //set position
        frame.setVisible(true); //set visible
    }
    
    public Object[] generateRow(Iterator it)
    {
        Product tempProduct = (Product) it.next();
        Object[] row = new Object[] {"Remove", tempProduct.getName()};
        
    }
    
    class ButtonRenderer extends JButton implements TableCellRenderer {

  public ButtonRenderer() {
    setOpaque(true);
  }

  public Component getTableCellRendererComponent(JTable table, Object value,
      boolean isSelected, boolean hasFocus, int row, int column) {
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

class ButtonEditor extends DefaultCellEditor {
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
    button.setText(label);
    isPushed = true;
    return button;
  }

  public Object getCellEditorValue() {
    if (isPushed) {
      // 
      // 
      JOptionPane.showMessageDialog(button, label + ": Ouch!");
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
