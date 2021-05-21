import javax.swing.*;
import java.awt.*;

public class Sales extends JFrame {
    public JPanel salesForm;
    private JLabel salesHeading;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton button10;
    private JButton button11;
    private JButton button12;
    private JButton button13;
    private JButton button14;
    private JButton button15;
    private JButton button16;
    private JButton button17;
    private JButton button18;
    private JButton button19;
    private JButton button20;
    private JButton button21;
    private JButton button22;
    private JButton button23;
    private JButton button24;
    private JButton button25;
    private JButton button26;
    private JButton button27;
    private JButton button28;
    private JButton button29;
    private JButton button30;
    private JButton button31;
    private JButton button32;
    private JButton button33;
    private JButton button34;
    private JTextArea totalTextArea;
    private JTextArea subTotalTextArea;
    private JButton button35;
    private JButton button36;

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