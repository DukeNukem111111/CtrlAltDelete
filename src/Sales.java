import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Sales extends JFrame {
    public JPanel salesForm;
    private JLabel salesLabel;
    private JButton breakfastButton;
    private JButton dinnerButton;
    private JButton lunchButton;
    private JButton tequilaButton;
    private JButton brandyButton;
    private JButton vodkaButton;
    private JButton whiskeyButton;
    private JButton ginButton;
    private JButton rumButton;
    private JButton champagneButton;
    private JButton wineButton;
    private JButton cansButton;
    private JButton beerButton;
    private JButton waterButton;
    private JButton combosButton;
    private JButton chickenButton;
    private JButton pizzaButton;
    private JButton burgersButton;
    private JButton steakButton;
    private JButton saladsButton;
    private JButton startersButton;
    private JTable table1;
    private JTable table2;
    private JButton button28;
    private JButton button29;
    private JButton cashConfirmPaymentButton;
    private JTextField customerNameTextField;
    private JTextField subtotalTextField;
    private JTextField gratuityTextField;
    private JTextField discountTextField;
    private JTextField totalTextField;
    private JTextField textField6;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField9;
    private JTextField textField10;
    private JButton cardConfirmPaymentButton;
    private JCheckBox cashPaymentCheckBox;
    private JCheckBox cardPaymentCheckBox;
    private JTabbedPane tabbedPane;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button10;
    private JButton button11;
    private JButton button4;
    private JButton button5;
    private JPanel ginTab;
    private JPanel breakfastTab;
    private JPanel tequilaTab;
    private JPanel rumTab;
    private JPanel brandyTab;
    private JPanel vodkaTab;
    private JPanel whiskeyTab;
    private JPanel wineTab;
    private JPanel combosTab;
    private JPanel champagneTab;
    private JPanel waterTab;
    private JPanel cansTab;
    private JPanel beerTab;
    private JPanel lunchTab;
    private JPanel burgersTab;
    private JPanel chickenTab;
    private JPanel pizzaTab;
    private JPanel dinnerTab;
    private JPanel startersTab;
    private JPanel steakTab;
    private JPanel saladsTab;

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

        ginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tabbedPane.setSelectedComponent(ginTab);
            }
        });
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}