package OOP.coursework;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class GUIClassB extends JFrame{
    String selectedProductID;
    public DefaultTableModel tableModelB;
    public GUIClassB(ShoppingCart shoppingCart){

        System.out.println(selectedProductID);
        setTitle("Shopping Cart");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);

        JPanel p1 = new JPanel(new BorderLayout());
        JPanel p2 = new JPanel(new BorderLayout());



        tableModelB = new DefaultTableModel();
        tableModelB.addColumn("Product");
        tableModelB.addColumn("Quantity");
        tableModelB.addColumn("Price(\u20AC)");

        JTable jtableProduct = new JTable(tableModelB);

        JScrollPane scrollPane = new JScrollPane(jtableProduct);
        jtableProduct.setGridColor(Color.BLACK);

        p1.add(scrollPane, BorderLayout.NORTH);
        displayTableRows(tableModelB,shoppingCart);

        add(p1);
        setVisible(true);
    }
    public void displayTableRows(DefaultTableModel tableModel,ShoppingCart shoppingCart) {

        for (Product product:shoppingCart.products) {
            System.out.println(product.getProductID());

            if (product instanceof  Clothing clothing) {
                Object[] rowData = {clothing.getProductID()+", "+clothing.getProductName()+", "+clothing.getSize()+", "+clothing.getColor(),"quantity" ,clothing.getPrice()+" \u20AC" };
                tableModel.addRow(rowData);
            } else if(product instanceof Electronics electronics){
                Object[] rowData = {electronics.getProductID()+", "+electronics.getProductName()+", "+electronics.getWarrantyPeriod(), "quantity", electronics.getPrice()};
                tableModel.addRow(rowData);
            }
        }
    }
}
