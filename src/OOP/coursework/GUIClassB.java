package OOP.coursework;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import static OOP.coursework.UserGUIClass.nonRegisteredUser;
public class GUIClassB extends JFrame{
    private int discountTen;
    private int discountTwenty;
    private double firstTotal;
    private JTable jtableProduct;
    public DefaultTableModel tableModelB;
    private int eCountTwenty;
    private int cCountTwenty;
    public GUIClassB(ShoppingCart shoppingCart){

        setTitle("Shopping Cart");
        setSize(800, 800);

        tableModelB = new DefaultTableModel();
        tableModelB.addColumn("Product");
        tableModelB.addColumn("Quantity");
        tableModelB.addColumn("Price(\u20AC)");

        jtableProduct = new JTable(tableModelB);

        JScrollPane scrollPane = new JScrollPane(jtableProduct);
        jtableProduct.setGridColor(Color.BLACK);

        scrollPane.setBorder(BorderFactory.createEmptyBorder(60,60,60,60));

        displayTableRows(tableModelB,shoppingCart);

        discountCalculator(shoppingCart);


        double remainAfterTen=(firstTotal*discountTen/100);
        double remainAfterTwenty=(firstTotal*discountTwenty/100);
        double finalTotal=firstTotal-remainAfterTen-remainAfterTwenty;

        JPanel p1 = new JPanel(new BorderLayout());
        JPanel p2 = new JPanel(new BorderLayout());
        JLabel label1 = new JLabel("Total");
        JLabel label2 = new JLabel(String.valueOf(firstTotal));
        JLabel label3 = new JLabel("First Purchase Discount(10%)");
        JLabel label4 = new JLabel(String.valueOf(remainAfterTen));
        JLabel label5 = new JLabel("Three items in same category discount(20%)");
        JLabel label6 = new JLabel(String.valueOf(remainAfterTwenty));
        JLabel label7 = new JLabel("Final Total");
        JLabel label8 = new JLabel(String.valueOf(finalTotal));

        JPanel lblPanel=new JPanel(new GridLayout(4, 2, 10, 10));
        lblPanel.add(label1);
        lblPanel.add(label2);
        lblPanel.add(label3);
        lblPanel.add(label4);
        lblPanel.add(label5);
        lblPanel.add(label6);
        lblPanel.add(label7);
        lblPanel.add(label8);

        p1.add(scrollPane, BorderLayout.NORTH);
        p1.add(lblPanel,BorderLayout.SOUTH);
        lblPanel.setBorder(BorderFactory.createEmptyBorder(420,60,100,60));

        add(p1);
        setVisible(true);
    }

    public void displayTableRows(DefaultTableModel tableModel,ShoppingCart shoppingCart) {
        for (Product product:shoppingCart.products) {

            if ((product instanceof  Clothing clothing) ) {
                Object[] rowData = {clothing.getProductID()+", "+clothing.getProductName()+", "+clothing.getSize()+", "+clothing.getColor(),"1" ,clothing.getPrice()+" \u20AC" };
                tableModel.addRow(rowData);
                firstTotal+=clothing.getPrice();
            } else if((product instanceof Electronics electronics)){
                Object[] rowData = {electronics.getProductID()+", "+electronics.getProductName()+", "+electronics.getWarrantyPeriod(), "1", electronics.getPrice()};
                tableModel.addRow(rowData);
                firstTotal+=electronics.getPrice();
            }
        }
    }

    public void discountCalculator(ShoppingCart shoppingCart){
        if(nonRegisteredUser){
            discountTen=10;
        }
        else{
            discountTen=0;
        }
        for(Product product:shoppingCart.products){
            if(product.getProductID().startsWith("e")){
                eCountTwenty+=1;
            }
            else{
                cCountTwenty+=1;
            }
        }
        if (eCountTwenty>2 || cCountTwenty>2){
            discountTwenty=20;
        }
        else{
            discountTwenty=0;
        }
    }
}
