import com.mysql.cj.protocol.Resultset;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.xml.transform.Result;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.sql.*;
import java.util.Vector;

public class Reservations extends JFrame {
    private JPanel reservationsForm;
    private JTable reservationsTable;
    private JTextField contactNumberTextField;
    private JTextField customerNameTextField;
    private JLabel customerNameLabel;
    private JLabel contactNumberLabel;
    private JButton addButton;
    private JButton removeButton;
    private JButton updateButton;
    private JLabel reservationTimeLabel;
    private JLabel tableNumberLabel;
    private JTextField tableNumberTextField;
    private JTextField reservationTimeTextField;
    private JLabel seatsLabel;
    private JTextField seatsTextField;
    private JTextField searchTextField;
    private JButton searchButton;
    private JPanel reservationsTableFrame;
    private JButton clearButton;


    public static void main(String[] args) {
        JFrame reservationsFrame = new Reservations("Reservations"); //Creates the new window that holds all reservations related items
        reservationsFrame.setVisible(true);
    }

    public void tb_load(){ //Displays our javapos database reservations table in the jtable
        try{

            DefaultTableModel dt = (DefaultTableModel) reservationsTable.getModel();
            dt.setRowCount(0);
            dt.setColumnCount(5); //Line is necessary to add columns to table, caused major headaches and was found by chance. No table shown otherwise

            //Add names to columns
            reservationsTable.getColumnModel().getColumn(0).setHeaderValue("Customer Name");
            reservationsTable.getColumnModel().getColumn(1).setHeaderValue("Contact Number");
            reservationsTable.getColumnModel().getColumn(2).setHeaderValue("Table Number");
            reservationsTable.getColumnModel().getColumn(3).setHeaderValue("Reservation Time");
            reservationsTable.getColumnModel().getColumn(4).setHeaderValue("Seats");
            reservationsTable.getTableHeader().resizeAndRepaint();

            Statement s = db.mycon().createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM reservations");

            //Write data from mySQL database to jtable
            while (rs.next()){
                Vector v = new Vector();
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));
                v.add(rs.getString(5));

                dt.addRow(v);

            }

        }catch (SQLException f){
            System.out.println(f);
        }
    }

    //All settings for reservations window that pops up when the button is clicked on the home screen
    public Reservations(String title) {
        super(title);
        tb_load();
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(reservationsForm);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); //Makes programs start in fullscreen
        this.setResizable(false);



        //Adds data to database
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String customerName = customerNameTextField.getText();
                String contactNumber = contactNumberTextField.getText();
                String tableNumber = tableNumberTextField.getText();
                String reservationTime = reservationTimeTextField.getText();
                String seats = seatsTextField.getText();

                try { //Add button code, adds details to mysql database
                    Statement s = db.mycon().createStatement();
                    s.executeUpdate("INSERT INTO reservations VALUES ('"+customerName+"','"+contactNumber+"','"+tableNumber+"','"+reservationTime+"','"+seats+"')");
                }catch (Exception f){
                    System.out.println(f);
                }
                tb_load();
                clearButton.doClick();
            }
        });

        //Searches for data using the customer name as the search ID
        searchButton.addActionListener(new ActionListener() { //search button code, implements search functionality for database
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchResult = searchTextField.getText();
                try {
                    Statement s = db.mycon().createStatement();
                    ResultSet rs = s.executeQuery(" SELECT * FROM reservations WHERE CustomerName = '"+searchResult+"'");
                    if (rs.next()){
                        customerNameTextField.setText(rs.getString("CustomerName"));
                        contactNumberTextField.setText(rs.getString("ContactNumber"));
                        tableNumberTextField.setText(rs.getString("TableNumber"));
                        reservationTimeTextField.setText(rs.getString("ReservationTime"));
                        seatsTextField.setText(rs.getString("Seats"));
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

        //Allows changes to be made to database records
        updateButton.addActionListener(new ActionListener() { //Adds update functionality
            @Override
            public void actionPerformed(ActionEvent e) {
                String customerName = customerNameTextField.getText();
                String contactNumber = contactNumberTextField.getText();
                String tableNumber = tableNumberTextField.getText();
                String reservationTime = reservationTimeTextField.getText();
                String seats = seatsTextField.getText();
                String id = searchTextField.getText();

                try{
                    Statement s = db.mycon().createStatement();
                    s.executeUpdate("UPDATE reservations SET CustomerName = '"+customerName+"', ContactNumber = '"+contactNumber+"', TableNumber = '"+tableNumber+"', ReservationTime = '"+reservationTime+"', Seats = '"+seats+"' WHERE CustomerName = '"+id+"'");
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
                    s.executeUpdate("DELETE FROM reservations WHERE CustomerName = '"+id+"'");
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
                customerNameTextField.setText(null);
                contactNumberTextField.setText(null);
                tableNumberTextField.setText(null);
                reservationTimeTextField.setText(null);
                seatsTextField.setText(null);
                searchTextField.setText(null);
            }
        });
    }
}