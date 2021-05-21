import javax.swing.*;

public class Sales extends JFrame {
    private JPanel salesForm;

    public static void main(String[] args) {
        JFrame salesScreenFrame = new Sales("Sales");
        salesScreenFrame.setVisible(true);
    }

    public Sales(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(salesForm);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); //Makes programs start in fullscreen
        this.setResizable(false);
    }
}