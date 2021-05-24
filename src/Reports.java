import javax.swing.*;

public class Reports extends JFrame {
    private JPanel reportsForm;
    private JTable table1;
    private JTable table2;
    private JTable table4;
    private JButton button1;
    private JTextField textField1;
    private JButton button3;
    private JTextField textField2;
    private JButton button5;
    private JTextField textField3;

    public static void main(String[] args) {
        JFrame reportsScreenFrame = new Reports("Reports");
        reportsScreenFrame.setVisible(true);
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
    }
}