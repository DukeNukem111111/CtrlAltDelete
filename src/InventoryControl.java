import javax.swing.*;

public class InventoryControl extends JFrame {
    private JPanel inventoryControlForm;

    public static void main(String[] args) {
        JFrame inventoryControlFrame = new InventoryControl("Inventory Control");
        inventoryControlFrame.setVisible(true);
    }

    public InventoryControl(String title) {
        super(title);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setContentPane(inventoryControlForm);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); //Makes programs start in fullscreen
        this.setResizable(false);
    }
}