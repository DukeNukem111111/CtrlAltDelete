import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class Reports extends JFrame {
    private JPanel reportsForm;
    private JTable table1;
    private JTable reportsTable;
    private JTable table4;
    private JButton ordersSearchButton;
    private JTextField ordersSearchTextField;
    private JButton inventoryControlSearch;
    private JTextField inventoryControlTextField;
    private JButton transactionSearchButton;
    private JTextField transactionTextField;
    private JButton inventoryControlClearButton;
    private JButton ordersClearButton;
    private JButton transactionClearButton;

    public static void main(String[] args) {
        JFrame reportsScreenFrame = new Reports("Reports");
        reportsScreenFrame.setVisible(true);
    }
    public void tb_load(){ //Displays our javapos database menuControls table in the jtable
        try{

            DefaultTableModel dt = (DefaultTableModel) reportsTable.getModel();
            dt.setRowCount(0);
            dt.setColumnCount(4); //Line is necessary to add columns to table, caused major headaches and was found by chance. No table shown otherwise

            //Add names to columns
            reportsTable.getColumnModel().getColumn(0).setHeaderValue("Item ID");
            reportsTable.getColumnModel().getColumn(1).setHeaderValue("Item Name");
            reportsTable.getColumnModel().getColumn(2).setHeaderValue("Item Price");
            reportsTable.getColumnModel().getColumn(3).setHeaderValue("Item Quantity");
            reportsTable.getTableHeader().resizeAndRepaint();

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



    public Reports(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(reportsForm);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); //Makes programs start in fullscreen
        this.setResizable(false);

        // Searches for data using the item name as the search ID
        /*ordersSearchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchResult = ordersSearchTextField.getText();
                try {
                    Statement s = db.mycon().createStatement();
                    ResultSet rs = s.executeQuery(" SELECT * FROM menucontrol WHERE itemID = '"+searchResult+"'");
                    if (rs.next()){
                        itemIDTextField.setText(rs.getString("itemID"));
                        itemNameTextField.setText(rs.getString("itemName"));
                        itemPriceTextField.setText(rs.getString("itemPrice"));
                    }

                } catch (SQLException f){
                    System.out.println(f);
                }
                tb_load();
            }
        });*/


        //Searches for data using the item name as the search ID
        inventoryControlSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchResult = ordersSearchTextField.getText();
                try {
                    Statement s = db.mycon().createStatement();
                    ResultSet rs = s.executeQuery(" SELECT * FROM inventoryControl WHERE itemName = '"+searchResult+"'");
                    if (rs.next()){
                        inventoryControlTextField.setText(rs.getString("itemName"));

                    }

                } catch (SQLException f){
                    System.out.println(f);
                }
                tb_load();
            }
        });
        inventoryControlTextField.addActionListener(new ActionListener() { //Allows us to search by pressing enter
            @Override
            public void actionPerformed(ActionEvent e) {
                inventoryControlSearch.doClick();
            }
        });


            }

    }