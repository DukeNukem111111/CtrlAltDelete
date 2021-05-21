import javax.swing.*;

public class MenuControl extends JFrame {
    private JPanel menuControlForm;

    public static void main(String[] args) {
        JFrame menuControlFrame = new MenuControl("Menu Control");
        menuControlFrame.setVisible(true);
    }

    public MenuControl(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(menuControlForm);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); //Makes programs start in fullscreen
        this.setResizable(false);
    }
}