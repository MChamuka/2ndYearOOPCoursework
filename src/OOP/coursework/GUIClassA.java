package OOP.coursework;
import UI.OOP.coursework.ComboBoxExample;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
public class GUIClassA extends JFrame {
    private static final ShoppingManager manager=new WestminsterShoppingManager();
    public String selectedProductID;
    int comboBoxOption=1;
    private ShoppingCart shoppingCart=new ShoppingCart();
    public GUIClassA(WestminsterShoppingManager productDetails) {
        setTitle("Westminster Shopping Centre");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 250);

        JPanel p1 = new JPanel(new BorderLayout());
        JPanel p2 = new JPanel(new BorderLayout());
        JPanel p3 = new JPanel(new BorderLayout());

        JLabel jlblSelect1 = new JLabel("Select Product Category");
        p1.add(jlblSelect1, BorderLayout.WEST);

        JComboBox<String> jcboProductTypes = new JComboBox<>(new String[]{"All", "Electronics", "Clothing"});
        p1.add(jcboProductTypes, BorderLayout.CENTER);

        JButton jbCartWindow = new JButton("Shopping Cart");
        p1.add(jbCartWindow, BorderLayout.EAST);
        p2.add(p1, BorderLayout.NORTH);
        p2.add(p3,BorderLayout.SOUTH);

        //opening shopping cart using jbCartWindow button
        jbCartWindow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // When the button is clicked, open the AnotherGUI
                GUIClassB anotherGUI = new GUIClassB(shoppingCart);
                anotherGUI.displayTableRows(anotherGUI.tableModelB,shoppingCart);

                UserGUIClass userGUIClass = new UserGUIClass(shoppingCart);
            }
        });

        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Product ID");
        tableModel.addColumn("Name");
        tableModel.addColumn("Price(\u20AC)");
        tableModel.addColumn("Info");

        JTable jtableProduct = new JTable(tableModel);

        JScrollPane scrollPane = new JScrollPane(jtableProduct);
        jtableProduct.setGridColor(Color.BLACK);

        p1.add(scrollPane, BorderLayout.SOUTH);

        JButton addToCart = new JButton("Add to Shopping Cart");
        p3.add(addToCart,BorderLayout.SOUTH);

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                int comboBoxOption=comboBoxListner(jcboProductTypes);
                displayTableRows(tableModel, productDetails.productList,comboBoxOption);
            }
        });
        JLabel rowLabel = new JLabel("Select a product row ");

        p3.add(rowLabel, BorderLayout.NORTH);

        selectedRowData(jtableProduct,rowLabel,productDetails.productList,addToCart);

        addToCart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // When the button is clicked, open the AnotherGUI

               shoppingCart.addProduct(productDetails.productList,selectedProductID);
            }
        });

        add(p2);
        setVisible(true);
    }
    private void displayTableRows(DefaultTableModel tableModel, ArrayList<Product> productList,int comboBoxOption) {
        for (Product product: productList) {
            if ((product instanceof  Clothing clothing) && (comboBoxOption==1 || comboBoxOption==3) ) {
                Object[] rowData = {clothing.getProductID(), "Clothing" , clothing.getPrice(), clothing.getProductName() + ", " + clothing.getColor()+" weeks warranty"};
                tableModel.addRow(rowData);
            } else if((product instanceof Electronics electronics) && (comboBoxOption==1 || comboBoxOption==2)){
                Object[] rowData = {electronics.getProductID(), "Electronics", electronics.getPrice(), electronics.getProductName() + ", " +electronics.getWarrantyPeriod()+ " color"};
                tableModel.addRow(rowData);
            }
        }
    }
    private void selectedRowData(JTable jtableProduct,JLabel rowLabel,ArrayList<Product> productList,JButton addToCart){
        jtableProduct.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                if (!e.getValueIsAdjusting()) {
                    int selectedRow = jtableProduct.getSelectedRow();
                    if (selectedRow != -1) {
                        // Get data from the selected row
                        Object selectedRowProductID = jtableProduct.getValueAt(selectedRow, 0);

                        String output="label output";
                        for(Product product:productList){
                            if (selectedRowProductID==product.getProductID()){
                                selectedProductID = selectedRowProductID.toString();


                                System.out.println(selectedProductID);

                                if(product instanceof  Clothing clothing){
                                    output = "Selected Product - Details \n"
                                            + "Product id : " + clothing.getProductID() + "\n"
                                            + "Category : Clothing \n"
                                            + "Name : " + clothing.getProductName() + "\n"
                                            + "Size : " + clothing.getSize() + "\n"
                                            + "Colour : " + clothing.getColor() + "\n"
                                            + "Items available : " + clothing.getAvailableItemCount();
                                    break;
                                }
                                else if(product instanceof Electronics electronics){
                                    output = "Selected Product - Details \n"
                                            + "Product id : " + electronics.getProductID() + "\n"
                                            + "Category : Clothing \n"
                                            + "Name : " + electronics.getProductName() + "\n"
                                            + "Size : " + electronics.getBrand() + "\n"
                                            + "Colour : " + electronics.getWarrantyPeriod() + "\n"
                                            + "Items available : " + electronics.getAvailableItemCount();
                                    break;
                                }
                            }
                        }
                        // Display output on the JLabel
                        rowLabel.setText(output);
                    }
                }

            }
        });
    }
    public int comboBoxListner(JComboBox<String> jcboProductTypes){
        jcboProductTypes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the selected item
                String selectedValue = jcboProductTypes.getSelectedItem().toString();

                // Display a message with the selected item
                JOptionPane.showMessageDialog(GUIClassA.this, "Selected: " + selectedValue);

                if (selectedValue.equals("All")) {
                    comboBoxOption = 1;
                } else if (selectedValue.equals("Electronics")) {
                    comboBoxOption = 2;
                } else if (selectedValue.equals("Clothing")) {
                    comboBoxOption = 3;
                }
            }
        });
        return comboBoxOption;
    }
}