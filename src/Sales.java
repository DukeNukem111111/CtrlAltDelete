import javax.swing.*;

public class Sales extends JFrame {
    public JPanel salesForm;
    private JLabel salesHeading;
    private JButton startersButton;
    private JButton vodkaButton;
    private JButton rumButton;
    private JButton sparklingWineButton;
    private JButton waterButton;
    private JButton poultryButton;
    private JButton burgersButton;
    private JButton saladsButton;
    private JButton smallPizzaButton;
    private JButton combosButton;
    private JButton beerButton;
    private JButton wineButton;
    private JButton ginButton;
    private JButton brandyButton;
    private JButton steaksButton;
    private JButton largePizzaButton;
    private JButton fishButton;
    private JButton cansButton;
    private JButton champagneButton;
    private JButton whiskeyButton;
    private JButton tequilaButton;
    private JTextArea totalTextArea;
    private JTextArea subTotalTextArea;

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

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}