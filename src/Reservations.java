import javax.swing.*;
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
    private JTextField textField6;
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

                try{
                    Statement s = database.reservations().createStatement();
                    s.executeUpdate("INSERT INTO reservations VALUES ('"+customerName+"','"+contactNumber+"','"+tableNumber+"','"+reservationTime+"','"+seats+"')");
                } catch (SQLException f) {
                    System.out.println(f);
                }
            }
        });
    }
}