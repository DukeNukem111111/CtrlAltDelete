import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class InventoryControl extends JFrame {
    private JPanel inventoryControlForm;
    private JTable menuControlTable;
    private JTextField itemNameTextField;
    private JTextField itemIDTextField;
    private JLabel itemNameLabel;
    private JButton addButton;
    private JButton removeButton;
    private JButton updateButton;
    private JLabel tableNumberLabel;
    private JTextField itemQuantityTextField;
    private JTextField reservationTimeTextField;
    private JTextField seatsTextField;
    private JTextField searchTextField;
    private JButton searchButton;
    private JPanel inventoryControlTableFrame;
    private JButton clearButton;
    private JLabel searchItemIDLabel;
    private JScrollPane inventoryControlJScrollPane;
    private JLabel inWindowLabel;
    private JLabel deliveredLabel;
    private JTable inventoryControlTable;
    private JTextField deliveredTextField;


    public static void main(String[] args) {
        JFrame inventoryControlControlFrame = new InventoryControl("Inventory Control"); //Creates the new window that holds all inventory control related items
        inventoryControlControlFrame.setVisible(true);
    }

    public void tb_load(){ //Displays our javapos database inventoryControl table in the jtable
        try{

            DefaultTableModel dt = (DefaultTableModel) inventoryControlTable.getModel();
            dt.setRowCount(0);
            dt.setColumnCount(4); //Line is necessary to add columns to table, caused major headaches and was found by chance. No table shown otherwise

            //Add names to columns
            inventoryControlTable.getColumnModel().getColumn(0).setHeaderValue("Item ID");
            inventoryControlTable.getColumnModel().getColumn(1).setHeaderValue("Item Name");
            inventoryControlTable.getColumnModel().getColumn(2).setHeaderValue("Item Quantity");
            inventoryControlTable.getColumnModel().getColumn(3).setHeaderValue("Delivery Date");
            inventoryControlTable.getTableHeader().resizeAndRepaint();

            Statement s = db.mycon().createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM inventorycontrol");

            //Write data from mySQL database to jtable
            while (rs.next()){
                Vector v = new Vector();
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));


                dt.addRow(v);

            }

        }catch (SQLException f){
            System.out.println(f);
        }
    }

    //All settings for inventoryControl window that pops up when the button is clicked on the home screen
    public InventoryControl(String title) {
        super(title);
        tb_load();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(inventoryControlForm);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); //Makes programs start in fullscreen
        this.setResizable(false);



        //Adds data to database
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String itemName = itemNameTextField.getText();
                String itemQuantity = itemQuantityTextField.getText();
                String delivered = deliveredTextField.getText();


                try { //Add button code, adds details to mysql database
                    Statement s = db.mycon().createStatement();
                    s.executeUpdate("INSERT INTO inventorycontrol (itemName, itemQuantity, delivered)(SELECT '"+itemName+"','"+itemQuantity+"','"+delivered+"')");
                }catch (Exception f){
                    System.out.println(f);
                }
                tb_load();
                clearButton.doClick();
            }
        });

        //Searches for data using the itemID as the search ID
        searchButton.addActionListener(new ActionListener() { //search button code, implements search functionality for database
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchResult = searchTextField.getText();
                try {
                    Statement s = db.mycon().createStatement();
                    ResultSet rs = s.executeQuery(" SELECT * FROM inventorycontrol WHERE itemID = '"+searchResult+"'");
                    if (rs.next()){
                        itemIDTextField.setText(rs.getString("itemID"));
                        itemNameTextField.setText(rs.getString("itemName"));
                        itemQuantityTextField.setText(rs.getString("itemQuantity"));
                        deliveredTextField.setText(rs.getString("delivered"));
                    }

                } catch (SQLException f){
                    System.out.println(f);
                }
                tb_load();
            }
        });

        searchTextField.addActionListener(new ActionListener() { //Allows us to search by pressing enter
            @Override
            public void actionPerformed(ActionEvent e) {
                searchButton.doClick();
            }
        });

        //Allows changes to be made to database records, update button
        updateButton.addActionListener(new ActionListener() { //Adds update functionality
            @Override
            public void actionPerformed(ActionEvent e) {
                String itemID = itemIDTextField.getText();
                String itemName = itemNameTextField.getText();
                String itemQuantity = itemQuantityTextField.getText();
                String delivered = deliveredTextField.getText();
                String id = searchTextField.getText();

                try{
                    Statement s = db.mycon().createStatement();
                    s.executeUpdate("UPDATE inventorycontrol SET itemID = '"+itemID+"', itemName = '"+itemName+"', itemQuantity = '"+itemQuantity+"', delivered = '"+delivered+"' WHERE itemID = '"+id+"'");
                }catch (Exception f) {
                    System.out.println(f);
                }
                tb_load();
                clearButton.doClick();
            }
        });

        //Removal of records
        removeButton.addActionListener(new ActionListener() { //Remove certain records from database
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = searchTextField.getText();
                try {
                    Statement s = db.mycon().createStatement();
                    s.executeUpdate("DELETE FROM inventorycontrol WHERE itemID = '"+id+"'");
                }catch (Exception f){
                    System.out.println(f);
                }
                tb_load();
                clearButton.doClick();
            }
        });

        //Clears all text fields
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                itemNameTextField.setText(null);
                itemQuantityTextField.setText(null);
                deliveredTextField.setText(null);
            }
        });
    }
}