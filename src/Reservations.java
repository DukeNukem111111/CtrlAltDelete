import javax.swing.*;

public class Reservations extends JFrame {
    private JPanel reservationsForm;
    private JTable table1;
    private JTextField textField1;
    private JTextField textField2;
    private JLabel customerNameLabel;
    private JLabel contactNumberLabel;
    private JButton addButton;
    private JButton removeButton;
    private JButton updateButton;
    private JLabel reservationTimeLabel;
    private JLabel tableNumberLabel;
    private JTextField textField3;
    private JTextField textField4;
    private JLabel seatsLabel;
    private JTextField textField5;
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
    }
}