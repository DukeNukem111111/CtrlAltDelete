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
    private JTable orderReportTable;
    private JTable inventoryControlReportsTable;
    private JTable transactionReportTable;
    private JTextField ordersReportTextField;
    private JTextField inventoryReportTextField;
    private JTextField transactionsReportTextField;

    public static void main(String[] args) {
        JFrame reportsScreenFrame = new Reports("Reports");
        reportsScreenFrame.setVisible(true);
    }


    public void tb_load(){ //Displays our javapos database inventoryControl table in the jtable
        try{

            DefaultTableModel dt = (DefaultTableModel) inventoryControlReportsTable.getModel();
            dt.setRowCount(0);
            dt.setColumnCount(4); //Line is necessary to add columns to table, caused major headaches and was found by chance. No table shown otherwise

            //Add names to columns
            inventoryControlReportsTable.getColumnModel().getColumn(0).setHeaderValue("Item ID");
            inventoryControlReportsTable.getColumnModel().getColumn(1).setHeaderValue("Item Name");
            inventoryControlReportsTable.getColumnModel().getColumn(2).setHeaderValue("Item Quantity");
            inventoryControlReportsTable.getColumnModel().getColumn(3).setHeaderValue("delivered");
            inventoryControlReportsTable.getTableHeader().resizeAndRepaint();

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

    public void tb2_load(){ //Displays the order history in orderReportTable
        try{

            DefaultTableModel dt = (DefaultTableModel) orderReportTable.getModel();
            dt.setRowCount(0);
            dt.setColumnCount(4); //Line is necessary to add columns to table, caused major headaches and was found by chance. No table shown otherwise

            //Add names to columns
            orderReportTable.getColumnModel().getColumn(0).setHeaderValue("Order ID");
            orderReportTable.getColumnModel().getColumn(1).setHeaderValue("Customer Name");
            orderReportTable.getColumnModel().getColumn(2).setHeaderValue("Order Details");
            orderReportTable.getColumnModel().getColumn(3).setHeaderValue("Order Total");
            orderReportTable.getTableHeader().resizeAndRepaint();

            Statement s = db.mycon().createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM orderstablebottom");

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

    public void tb3_load(){ //Displays the transaction history in transactionReportsTable
        try{

            DefaultTableModel dt = (DefaultTableModel) transactionReportTable.getModel();
            dt.setRowCount(0);
            dt.setColumnCount(6); //Line is necessary to add columns to table, caused major headaches and was found by chance. No table shown otherwise

            //Add names to columns
            transactionReportTable.getColumnModel().getColumn(0).setHeaderValue("Transaction ID");
            transactionReportTable.getColumnModel().getColumn(1).setHeaderValue("Order ID");
            transactionReportTable.getColumnModel().getColumn(2).setHeaderValue("Customer Name");
            transactionReportTable.getColumnModel().getColumn(3).setHeaderValue("Transaction Date");
            transactionReportTable.getColumnModel().getColumn(4).setHeaderValue("Transaction Amount");
            transactionReportTable.getColumnModel().getColumn(5).setHeaderValue("Transaction Type");
            transactionReportTable.getTableHeader().resizeAndRepaint();

            Statement s = db.mycon().createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM transactions");

            //Write data from mySQL database to jtable
            while (rs.next()){
                Vector v = new Vector();
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getString(5));
                v.add(rs.getString(6));

                dt.addRow(v);

            }

        }catch (SQLException f){
            System.out.println(f);
        }
    }



    public Reports(String title) {
        super(title);
        tb_load();
        tb2_load();
        tb3_load();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(reportsForm);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); //Makes programs start in fullscreen
        this.setResizable(false);

            }

    }