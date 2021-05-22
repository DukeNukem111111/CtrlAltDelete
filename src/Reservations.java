import com.mysql.cj.protocol.Resultset;

import javax.swing.*;
import javax.xml.transform.Result;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.sql.*;

public class Reservations extends JFrame {
    private JPanel reservationsForm;
    private JTable table1;
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

    public static void main(String[] args) {
        JFrame reservationsFrame = new Reservations("Reservations");
        reservationsFrame.setVisible(true);
    }

    public Reservations(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(reservationsForm);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); //Makes programs start in fullscreen
        this.setResizable(false);

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
            }
        });

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
            }
        });

        searchTextField.addActionListener(new ActionListener() { //Allows us to search by pressing enter
            @Override
            public void actionPerformed(ActionEvent e) {
                searchButton.doClick();
            }
        });

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
            }
        });

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
            }
        });
    }
}