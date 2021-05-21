import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RestaurantPOS extends JFrame {
    private JButton salesButton;
    private JButton menuControlButton;
    private JButton inventoryControlButton;
    private JButton reportsButton;
    private JLabel homeScreenLogoButton;
    private JPanel homeScreen;

    public static void main(String[] args) {
        JFrame homeScreenFrame = new RestaurantPOS("Home Screen");
        homeScreenFrame.setVisible(true);
    }

    public RestaurantPOS(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(homeScreen);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); //Makes programs start in fullscreen
        this.setResizable(false);

        homeScreenLogoButton.setIcon(new ImageIcon("C:\\Users\\Duke\\IdeaProjects\\JavaPOS\\icon.png"));
        validate();
        salesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
    }
}
