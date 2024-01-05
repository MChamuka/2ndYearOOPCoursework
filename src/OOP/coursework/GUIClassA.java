package OOP.coursework;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

public class GUIClassA extends JFrame {

    public GUIClassA(WestminsterShoppingManager productDetails) {
        setTitle("Westminster Shopping Centre");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);

        JPanel p1 = new JPanel(new BorderLayout());
        JPanel p2 = new JPanel(new BorderLayout());

        JLabel jlblSelect1 = new JLabel("Select Product Category");
        p1.add(jlblSelect1, BorderLayout.WEST);

        JComboBox<String> jcboProductTypes = new JComboBox<>(new String[]{"All", "Electronics", "Clothing"});
        p1.add(jcboProductTypes, BorderLayout.CENTER);

        JButton jbCartWindow = new JButton("Shopping Cart");
        p1.add(jbCartWindow, BorderLayout.EAST);
        p2.add(p1, BorderLayout.NORTH);

        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Product ID");
        tableModel.addColumn("Name");
        tableModel.addColumn("Price(\u20AC)");
        tableModel.addColumn("Info");


        JTable jtableProduct = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(jtableProduct);
        jtableProduct.setGridColor(Color.BLACK);

        p2.add(scrollPane, BorderLayout.CENTER);

        for (Product product : productDetails.getProductList()) {
            Object[] rowData = {product.getProductID(), product.getProductName(), product.getPrice(), product.getAvailableItemCount()};
            tableModel.addRow(rowData);
        }
        JLabel rowLabel = new JLabel("Output will be displayed here.");

        p2.add(rowLabel,BorderLayout.SOUTH);

        jtableProduct.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = jtableProduct.getSelectedRow();
                    if (selectedRow != -1) {
                        // Get data from the selected row
                        Object firstName = jtableProduct.getValueAt(selectedRow, 0);
                        Object lastName = jtableProduct.getValueAt(selectedRow, 1);
                        Object age = jtableProduct.getValueAt(selectedRow, 2);

                        // Display output on the JLabel
                        String output = "Selected Row: " + selectedRow + ", Data: " + firstName + " " + lastName + ", Age: " + age;
                        rowLabel.setText(output);
                    }
                }
            }
        });

        add(p2);


        setVisible(true);
    }
}