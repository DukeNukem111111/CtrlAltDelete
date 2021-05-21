import javax.swing.*;

public class Reservations extends JFrame {
    private JPanel reservationsForm;

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