import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class MenuControl extends JFrame {
    private JPanel menuControlForm;
    private JTable inventoryControlTable;
    private JTextField itemNameTextField;
    private JTextField itemIDTextField;
    private JLabel itemNameLabel;
    private JButton addButton;
    private JButton removeButton;
    private JButton updateButton;
    private JLabel tableNumberLabel;
    private JTextField itemPriceTextField;
    private JTextField reservationTimeTextField;
    private JTextField seatsTextField;
    private JTextField searchTextField;
    private JButton searchButton;
    private JPanel reservationsTableFrame;
    private JButton clearButton;
    private JLabel searchItemIDLabel;
    private JScrollPane menuControlJScrollPane;
    private JLabel inWindowLabel;
    private JLabel deliveredLabel;


    //Creates the new window that holds all menu item related items
    public static void main(String[] args) {
        JFrame menuControlFrame = new MenuControl("Menu Control");
        menuControlFrame.setVisible(true);
    }

    //Displays our javapos database menuControls table in the jtable
    public void tb_load(){
        try{

            DefaultTableModel dt = (DefaultTableModel) inventoryControlTable.getModel();
            dt.setRowCount(0);
            dt.setColumnCount(3); //Line is necessary to add columns to table, caused major headaches and was found by chance. No table shown otherwise

            //Add names to columns
            inventoryControlTable.getColumnModel().getColumn(0).setHeaderValue("Item ID");
            inventoryControlTable.getColumnModel().getColumn(1).setHeaderValue("Item Name");
            inventoryControlTable.getColumnModel().getColumn(2).setHeaderValue("Item Price");
            inventoryControlTable.getTableHeader().resizeAndRepaint();

            //Write data from mySQL database to jtable
            Statement s = db.mycon().createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM menucontrol");

            while (rs.next()){
                Vector v = new Vector();
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));

                dt.addRow(v);
            }

        }catch (SQLException f){
            System.out.println(f);
        }
    }

    //All settings for menuControl window that pops up when the button is clicked on the home screen
    public MenuControl(String title) {
        super(title);
        tb_load();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(menuControlForm);
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
                String itemPrice = itemPriceTextField.getText();


                try { //Add button code, adds details to mysql database
                    Statement s = db.mycon().createStatement();
                    s.executeUpdate("INSERT INTO menucontrol (itemName, itemPrice)(SELECT '"+itemName+"','"+itemPrice+"')");
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
                    ResultSet rs = s.executeQuery(" SELECT * FROM menucontrol WHERE itemID = '"+searchResult+"'");
                    if (rs.next()){
                        itemNameTextField.setText(rs.getString("itemName"));
                        itemPriceTextField.setText(rs.getString("itemPrice"));
                    }

                } catch (SQLException f){
                    System.out.println(f);
                }
                tb_load();
            }
        });

        //Allows us to search in the text field by pressing enter
        searchTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchButton.doClick();
            }
        });

        //Allows changes to be made to database records, update button
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String itemName = itemNameTextField.getText();
                String itemPrice = itemPriceTextField.getText();
                String id = searchTextField.getText();

                try{
                    Statement s = db.mycon().createStatement();
                    s.executeUpdate("UPDATE menucontrol SET  itemName = '"+itemName+"', itemPrice = '"+itemPrice+"' WHERE itemID = '"+id+"'");
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
                    s.executeUpdate("DELETE FROM menuControl WHERE itemID = '"+id+"'");
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
                itemPriceTextField.setText(null);
            }
        });
    }
}