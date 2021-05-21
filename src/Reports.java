import javax.swing.*;

public class Reports extends JFrame {
    private JPanel reportsForm;

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