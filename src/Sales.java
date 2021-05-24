import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

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
    private JTable ordersTableTop;
    private JTable ordersTableBottom;
    private JButton placeOrderButton;
    private JButton clearAllButton;
    private JButton cashConfirmPaymentButton;
    private JTextField cashOrderIDTextField;
    private JTextField cashSubtotalTextField;
    private JTextField cashGratuityTextField;
    private JTextField cashDiscountTextField;
    private JTextField cashTotalTextField;
    private JTextField cardOrderIDTextField;
    private JTextField cardSubtotalTextField;
    private JTextField cardGratuityTextField;
    private JTextField cardDiscountTextField;
    private JTextField cardTotalTextField;
    private JButton cardConfirmPaymentButton;
    private JTabbedPane tabbedPane;
    private JButton englishBreakfastButton;
    private JButton vegetarianNachosButton;
    private JButton gordonsButton;
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
    private JButton greekSalad;
    private JButton chickenCaesarButton;
    private JButton miditerraneanButton;
    private JButton skyyButton;
    private JButton absoluteButton;
    private JButton greyGooseButton;
    private JButton olmecaSilverButton;
    private JButton olmecaGoldButton;
    private JButton ponchosButton;
    private JButton johnnieWalkerButton;
    private JButton glenlivetButton;
    private JButton jamesonButton;
    private JButton havanaClubButton;
    private JButton redHeartButton;
    private JButton captainMorganSpicedButton;
    private JButton tanquerayButton;
    private JButton bombaySapphireButton;
    private JButton remyMartinVSOPButton;
    private JButton hennessyVSOPButton;
    private JButton martellCaractereButton;
    private JButton sauvignonBlancButton;
    private JButton chardonnayButton;
    private JButton merlotShirazButton;
    private JButton ribSteakButton;
    private JButton steakWingButton;
    private JButton ribCalamariButton;
    private JButton domPerignonButton;
    private JButton veuveClicquotButton;
    private JButton andreBrutButton;
    private JButton tapWaterButton;
    private JButton stillButton;
    private JButton sparklingButton;
    private JButton fantaGrapeButton;
    private JButton lemonIcedTeaButton;
    private JButton redBullButton;
    private JButton windhoekDraughtButton;
    private JButton castleLightButton;
    private JButton savannaDryButton;
    private JButton porkTacosButton;
    private JButton beefLasagneButton;
    private JButton beefBurgerButton;
    private JButton steakBurgerButton;
    private JButton salmonBurgerButton;
    private JButton chickenSchnitzelButton;
    private JButton chickenEspetadaButton;
    private JButton chickenFilletButton;
    private JButton mexicanButton;
    private JButton BBQButton;
    private JButton hawaiianButton;
    private JButton cheesePrawnsButton;
    private JButton blackMushroomsButton;
    private JButton lambKidneysButton;
    private JButton rumpSteakButton;
    private JButton filletSteakButton;
    private JButton sirloinSteakButton;
    private JButton eggsBenedictButton;
    private JButton wafflesSyrupButton;
    private JButton gordonBleuButton;
    private JButton panSearedSalmonButton;
    private JButton beefBrisketButton;
    private JButton cashSearchButton;
    private JButton cardSearchButton;
    private JTextField topCustomerNameTextField;
    private JTextField cardNumberTextField;
    private JTextField cardPinTextField;
    private JButton cashClearButton;
    private JButton cardClearAllButton;
    private JButton checkCardButton;
    private JTextField cardPinInput;
    private JTextField cardNumberInput;
    private JTextField cardBalanceInput;
    private JTextField cardValidShower;
    public int allowAccess;

    public static void main(String[] args) {
        JFrame salesScreenFrame = new Sales("Sales");
        salesScreenFrame.setVisible(true);
    }

    public void tb_load(){ //Displays our javapos database menucontrol table in the jtable
        try{

            DefaultTableModel dt = (DefaultTableModel) ordersTableTop.getModel();
            dt.setRowCount(0);
            dt.setColumnCount(3); //Line is necessary to add columns to table, caused major headaches and was found by chance. No table shown otherwise

            //Add names to columns
            ordersTableTop.getColumnModel().getColumn(0).setHeaderValue("Item ID");
            ordersTableTop.getColumnModel().getColumn(1).setHeaderValue("Item Name");
            ordersTableTop.getColumnModel().getColumn(2).setHeaderValue("Item Price");
            ordersTableTop.getTableHeader().resizeAndRepaint();

            Statement s = db.mycon().createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM orderstabletop");

            //Write data from mySQL database to jtable
            while (rs.next()){
                Vector v = new Vector();
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));

                dt.addRow(v);

            }

        }catch (SQLException f){
            System.out.println(f);
        }
    }

    public void tb2_load(){ //Displays the order history in the second table after "place order is clicked"
        try{

            DefaultTableModel dt = (DefaultTableModel) ordersTableBottom.getModel();
            dt.setRowCount(0);
            dt.setColumnCount(4); //Line is necessary to add columns to table, caused major headaches and was found by chance. No table shown otherwise

            //Add names to columns
            ordersTableBottom.getColumnModel().getColumn(0).setHeaderValue("Order ID");
            ordersTableBottom.getColumnModel().getColumn(1).setHeaderValue("Customer Name");
            ordersTableBottom.getColumnModel().getColumn(2).setHeaderValue("Order Details");
            ordersTableBottom.getColumnModel().getColumn(3).setHeaderValue("Order Total");
            ordersTableBottom.getTableHeader().resizeAndRepaint();

            Statement s = db.mycon().createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM orderstablebottom");

            //Write data from mySQL database to jtable
            while (rs.next()){
                Vector v = new Vector();
                v.add(rs.getString(1));
                v.add(rs.getString(2));
                v.add(rs.getString(3));
                v.add(rs.getString(4));

                dt.addRow(v);

            }

        }catch (SQLException f){
            System.out.println(f);
        }
    }

    //calculates the total for the cash payment section
    public void calculatetotal(){
        Double cashTotal = Double.parseDouble(cashSubtotalTextField.getText())+Double.parseDouble(cashGratuityTextField.getText())-Double.parseDouble(cashDiscountTextField.getText());
        cashTotalTextField.setText(String.valueOf(cashTotal));
    }

    //Calculates total for the card payment section
    public void cardcalculatetotal(){
        Double cardTotal = Double.parseDouble(cardSubtotalTextField.getText())+Double.parseDouble(cardGratuityTextField.getText())-Double.parseDouble(cardDiscountTextField.getText());
        cardTotalTextField.setText(String.valueOf(cardTotal));
    }


    public Sales(String title) {
        super(title);
        tb_load();
        tb2_load();
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
        lunchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tabbedPane.setSelectedComponent(lunchTab);
            }
        });
        dinnerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tabbedPane.setSelectedComponent(dinnerTab);
            }
        });
        startersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tabbedPane.setSelectedComponent(startersTab);
            }
        });
        saladsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tabbedPane.setSelectedComponent(saladsTab);
            }
        });
        steakButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tabbedPane.setSelectedComponent(steakTab);
            }
        });
        burgersButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tabbedPane.setSelectedComponent(burgersTab);
            }
        });
        pizzaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tabbedPane.setSelectedComponent(pizzaTab);
            }
        });
        chickenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tabbedPane.setSelectedComponent(chickenTab);
            }
        });
        combosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tabbedPane.setSelectedComponent(combosTab);
            }
        });
        waterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tabbedPane.setSelectedComponent(waterTab);
            }
        });
        beerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tabbedPane.setSelectedComponent(beerTab);
            }
        });
        cansButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tabbedPane.setSelectedComponent(cansTab);
            }
        });
        wineButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tabbedPane.setSelectedComponent(wineTab);
            }
        });
        champagneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tabbedPane.setSelectedComponent(champagneTab);
            }
        });
        tequilaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tabbedPane.setSelectedComponent(tequilaTab);
            }
        });
        rumButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tabbedPane.setSelectedComponent(rumTab);
            }
        });
        whiskeyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tabbedPane.setSelectedComponent(whiskeyTab);
            }
        });
        vodkaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tabbedPane.setSelectedComponent(vodkaTab);
            }
        });
        brandyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tabbedPane.setSelectedComponent(brandyTab);
            }
        });
        breakfastButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tabbedPane.setSelectedComponent(breakfastTab);
            }
        });

        englishBreakfastButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String itemName = englishBreakfastButton.getText();
                try {
                    Statement s = db.mycon().createStatement();
                    s.executeUpdate("INSERT INTO orderstabletop (SELECT * FROM menucontrol WHERE itemName = '"+itemName+"')");
                    tb_load();
                }catch (Exception f){
                    System.out.println(f);
                }

            }
        });
        clearAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Statement s = db.mycon().createStatement();
                    s.executeUpdate("TRUNCATE TABLE orderstabletop");
                    tb_load();
                }catch (Exception f){
                    System.out.println(f);
                }
            }
        });

        eggsBenedictButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String itemName = eggsBenedictButton.getText();
                try {
                    Statement s = db.mycon().createStatement();
                    s.executeUpdate("INSERT INTO orderstabletop (SELECT * FROM menucontrol WHERE itemName = '"+itemName+"')");
                    tb_load();
                }catch (Exception f){
                    System.out.println(f);
                }
            }
        });
        wafflesSyrupButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String itemName = wafflesSyrupButton.getText();
                try {
                    Statement s = db.mycon().createStatement();
                    s.executeUpdate("INSERT INTO orderstabletop (SELECT * FROM menucontrol WHERE itemName = '"+itemName+"')");
                    tb_load();
                }catch (Exception f){
                    System.out.println(f);
                }
            }
        });
        vegetarianNachosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String itemName = vegetarianNachosButton.getText();
                try {
                    Statement s = db.mycon().createStatement();
                    s.executeUpdate("INSERT INTO orderstabletop (SELECT * FROM menucontrol WHERE itemName = '"+itemName+"')");
                    tb_load();
                }catch (Exception f){
                    System.out.println(f);
                }
            }
        });
        porkTacosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String itemName = porkTacosButton.getText();
                try {
                    Statement s = db.mycon().createStatement();
                    s.executeUpdate("INSERT INTO orderstabletop (SELECT * FROM menucontrol WHERE itemName = '"+itemName+"')");
                    tb_load();
                }catch (Exception f){
                    System.out.println(f);
                }
            }
        });
        beefLasagneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String itemName = beefLasagneButton.getText();
                try {
                    Statement s = db.mycon().createStatement();
                    s.executeUpdate("INSERT INTO orderstabletop (SELECT * FROM menucontrol WHERE itemName = '"+itemName+"')");
                    tb_load();
                }catch (Exception f){
                    System.out.println(f);
                }
            }
        });
        gordonBleuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String itemName = gordonBleuButton.getText();
                try {
                    Statement s = db.mycon().createStatement();
                    s.executeUpdate("INSERT INTO orderstabletop (SELECT * FROM menucontrol WHERE itemName = '"+itemName+"')");
                    tb_load();
                }catch (Exception f){
                    System.out.println(f);
                }
            }
        });
        panSearedSalmonButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String itemName = panSearedSalmonButton.getText();
                try {
                    Statement s = db.mycon().createStatement();
                    s.executeUpdate("INSERT INTO orderstabletop (SELECT * FROM menucontrol WHERE itemName = '"+itemName+"')");
                    tb_load();
                }catch (Exception f){
                    System.out.println(f);
                }
            }
        });
        beefBrisketButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String itemName = beefBrisketButton.getText();
                try {
                    Statement s = db.mycon().createStatement();
                    s.executeUpdate("INSERT INTO orderstabletop (SELECT * FROM menucontrol WHERE itemName = '"+itemName+"')");
                    tb_load();
                }catch (Exception f){
                    System.out.println(f);
                }
            }
        });

        /*When the place order button is clicked, the info in the top table should be summarized and displayed in the bottom one, this
        does just that */
        placeOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String customerName = topCustomerNameTextField.getText();
                try {
                    Statement s = db.mycon().createStatement();
                    s.executeUpdate("INSERT INTO orderstablebottom (CustomerName, OrderDetails, OrderTotal)(SELECT '"+customerName+"', GROUP_CONCAT(itemName), SUM(itemPrice) FROM orderstabletop)");
                    tb2_load();
                }catch (Exception f){
                    System.out.println(f);
                }
                clearAllButton.doClick();
            }
        });
        cashSearchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchResult = cashOrderIDTextField.getText();
                try {
                    Statement s = db.mycon().createStatement();
                    ResultSet rs = s.executeQuery(" SELECT * FROM orderstablebottom WHERE OrderID = '"+searchResult+"'");
                    if (rs.next()){
                        cashOrderIDTextField.setText(rs.getString("OrderID"));
                        cashSubtotalTextField.setText(rs.getString("OrderTotal"));
                    }

                } catch (SQLException f){
                    System.out.println(f);
                }
                tb2_load();
            }
        });
        cashOrderIDTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cashSearchButton.doClick();
            }
        });

        cashDiscountTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculatetotal();
            }
        });
        cashClearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cashOrderIDTextField.setText(null);
                cashSubtotalTextField.setText(null);
                cashGratuityTextField.setText(null);
                cashDiscountTextField.setText(null);
                cashTotalTextField.setText(null);
            }
        });
        cashConfirmPaymentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String transactionType = "Cash";
                int orderID = Integer.parseInt(cashOrderIDTextField.getText());
                calculatetotal();
                Double cashTotal = Double.valueOf(cashTotalTextField.getText());
                try {
                    Statement s = db.mycon().createStatement();
                    s.executeUpdate("INSERT INTO transactions (TransactionAmount, CustomerName, TransactionType, OrderID)(SELECT '"+cashTotal+"', CustomerName,'"+transactionType+"', OrderID FROM orderstablebottom WHERE OrderID = '"+orderID+"')");
                }catch (Exception f){
                    System.out.println(f);
                }
                cashOrderIDTextField.setText(null);
                cashSubtotalTextField.setText(null);
                cashGratuityTextField.setText(null);
                cashDiscountTextField.setText(null);
                cashTotalTextField.setText(null);
            }
        });
        cashGratuityTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculatetotal();
            }
        });
        cardOrderIDTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardSearchButton.doClick();
            }
        });
        cardSearchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchResult = cardOrderIDTextField.getText();
                try {
                    Statement s = db.mycon().createStatement();
                    ResultSet rs = s.executeQuery(" SELECT * FROM orderstablebottom WHERE OrderID = '"+searchResult+"'");
                    if (rs.next()){
                        cardOrderIDTextField.setText(rs.getString("OrderID"));
                        cardSubtotalTextField.setText(rs.getString("OrderTotal"));
                    }

                } catch (SQLException f){
                    System.out.println(f);
                }
                tb2_load();
            }
        });
        cardClearAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardOrderIDTextField.setText(null);
                cardSubtotalTextField.setText(null);
                cardGratuityTextField.setText(null);
                cardDiscountTextField.setText(null);
                cardTotalTextField.setText(null);
            }
        });
        cardGratuityTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardcalculatetotal();
            }
        });
        cardDiscountTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardcalculatetotal();
            }
        });



        cardConfirmPaymentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (allowAccess == 1) { /* Checks to see whether the card has been verified and the balance is enough, if so
                    then the transaction can continue*/

                    String transactionType = "Card";
                    int orderID = Integer.parseInt(cardOrderIDTextField.getText());
                    cardcalculatetotal();
                    Double cardTotal = Double.valueOf(cardTotalTextField.getText());
                    try {
                        Statement s = db.mycon().createStatement();
                        s.executeUpdate("INSERT INTO transactions (TransactionAmount, CustomerName,TransactionType, OrderID)(SELECT '" + cardTotal + "', CustomerName,'" + transactionType + "', OrderID FROM orderstablebottom WHERE OrderID = '" + orderID + "')");
                    } catch (Exception f) {
                        System.out.println(f);
                    }
                    cardOrderIDTextField.setText(null);
                    cardSubtotalTextField.setText(null);
                    cardGratuityTextField.setText(null);
                    cardDiscountTextField.setText(null);
                    cardTotalTextField.setText(null);

                    cardValidShower.setBackground(new Color(187,186,0));
                    cardNumberTextField.setText(null);
                    cardPinTextField.setText(null);
                }
            }
        });


        /*The previously declared public int allowAccess will act as a true/false boolean using the numbers 1 and 0 to
        either allow or deny access to the rest of the payment functions. The check card button checks wether a card is
        valid and has enough money*/

        checkCardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchResult = cardPinTextField.getText();
                try {
                    Statement s = db.mycon().createStatement();
                    ResultSet rs = s.executeQuery(" SELECT * FROM bankingdetails WHERE cardPin = '"+searchResult+"'");
                    if (rs.next()){
                        cardPinInput.setText(rs.getString("cardPin"));
                        cardNumberInput.setText(rs.getString("cardNumber"));
                        cardBalanceInput.setText(rs.getString("availableBalance"));
                    }

                } catch (SQLException f){
                    System.out.println(f);
                }

                String CardNum1 = cardNumberInput.getText();
                String CardNum2 = cardNumberTextField.getText();
                String pinNum1 = cardPinInput.getText();
                String pinNum2 = cardPinTextField.getText();
                String Balance1 = cardTotalTextField.getText();
                String Balance2= cardBalanceInput.getText();
                if (Integer.parseInt(pinNum1)==Integer.parseInt(pinNum2) && Integer.parseInt(CardNum1)==Integer.parseInt(CardNum2)
                        && Double.parseDouble(Balance2)>Double.parseDouble(Balance1)){
                    allowAccess=1;
                    cardValidShower.setBackground(new Color(131,187,87));
                }
                else{
                    allowAccess=0;
                }
            }
        });
    }

}