package OOP.coursework;
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
    public JPanel lblPanel;
    private ShoppingCart shoppingCart=new ShoppingCart();
    public GUIClassA(WestminsterShoppingManager productDetails) {
        setTitle("Westminster Shopping Centre");
        setSize(800, 800);

        JPanel p1 = new JPanel(new BorderLayout());
        JPanel p2 = new JPanel(new BorderLayout());
        JPanel p3 = new JPanel(new BorderLayout());

        lblPanel = new JPanel(new GridLayout(13, 2, 10, 10));

        JLabel jlblSelect1 = new JLabel("Select Product Category");
        p1.add(jlblSelect1, BorderLayout.WEST);

        JComboBox<String> jcboProductTypes = new JComboBox<>(new String[]{"All", "Electronics", "Clothing"});
        p1.add(jcboProductTypes, BorderLayout.CENTER);

        JButton jbCartWindow = new JButton("Shopping Cart");
        p1.add(jbCartWindow, BorderLayout.EAST);
        p2.add(p1, BorderLayout.NORTH);
        p2.add(p3,BorderLayout.SOUTH);

        jbCartWindow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                GUIClassB anotherGUI = new GUIClassB(shoppingCart);

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

        scrollPane.setBorder(BorderFactory.createEmptyBorder(80,20,20,20));

        p1.add(scrollPane, BorderLayout.SOUTH);

        JButton addToCart = new JButton("Add to Shopping Cart");
        p3.add(addToCart,BorderLayout.SOUTH);

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                displayTableRows(tableModel, productDetails.productList,comboBoxOption);
            }
        });



        p3.add(lblPanel, BorderLayout.NORTH);

        selectedRowData(jtableProduct,lblPanel,productDetails.productList,addToCart);

        addToCart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shoppingCart.addProduct(productDetails.productList,selectedProductID);
            }
        });
        jcboProductTypes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedCategory = jcboProductTypes.getSelectedItem().toString();

                switch (selectedCategory) {
                    case "All":
                        comboBoxOption = 1;
                        break;
                    case "Electronics":
                        comboBoxOption = 2;
                        break;
                    case "Clothing":
                        comboBoxOption = 3;
                        break;
                }

                displayTableRows(tableModel, productDetails.productList, comboBoxOption);
            }
        });

        add(p2);
        setVisible(true);
    }
    private void displayTableRows(DefaultTableModel tableModel, ArrayList<Product> productList,int comboBoxOption) {
        tableModel.setRowCount(0);
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
    private void selectedRowData(JTable jtableProduct, JPanel rowLabel, ArrayList<Product> productList, JButton addToCart){
        jtableProduct.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {

                if (!e.getValueIsAdjusting()) {
                    int selectedRow = jtableProduct.getSelectedRow();
                    if (selectedRow != -1) {
                        // Get data from the selected row
                        Object selectedRowProductID = jtableProduct.getValueAt(selectedRow, 0);

                        String output = "label output";
                        for (Product product : productList) {
                            if (selectedRowProductID == product.getProductID()) {
                                selectedProductID = selectedRowProductID.toString();


                                if (product instanceof Clothing clothing) {
                                    lblPanel.removeAll();

                                    JLabel label01=new JLabel("Selected product - ");
                                    JLabel label02=new JLabel("Details");
                                    JLabel label1 = new JLabel("Product id");
                                    JLabel label2 = new JLabel(String.valueOf(clothing.getProductID()));
                                    JLabel label3 = new JLabel("Category");
                                    JLabel label4 = new JLabel(String.valueOf("Clothing"));
                                    JLabel label5 = new JLabel("Name");
                                    JLabel label6 = new JLabel(String.valueOf(clothing.getProductName()));
                                    JLabel label7 = new JLabel("Size");
                                    JLabel label8 = new JLabel(String.valueOf(clothing.getSize()));
                                    JLabel label9 = new JLabel("Colour");
                                    JLabel label10 = new JLabel(String.valueOf(clothing.getColor()));
                                    JLabel label11 = new JLabel("Items available");
                                    JLabel label12 = new JLabel(String.valueOf(clothing.getAvailableItemCount()));

                                    lblPanel.add(label01);
                                    lblPanel.add(label02);
                                    lblPanel.add(label1);
                                    lblPanel.add(label2);
                                    lblPanel.add(label3);
                                    lblPanel.add(label4);
                                    lblPanel.add(label5);
                                    lblPanel.add(label6);
                                    lblPanel.add(label7);
                                    lblPanel.add(label8);
                                    lblPanel.add(label9);
                                    lblPanel.add(label10);
                                    lblPanel.add(label11);
                                    lblPanel.add(label12);

                                    lblPanel.revalidate();
                                    lblPanel.repaint();


                                    break;

                                } else if (product instanceof Electronics electronics) {
                                    lblPanel.removeAll();

                                    JLabel label01=new JLabel("Selected product - ");
                                    JLabel label02=new JLabel("Details");
                                    JLabel label1 = new JLabel("Product id");
                                    JLabel label2 = new JLabel(String.valueOf(electronics.getProductID()));
                                    JLabel label3 = new JLabel("Category");
                                    JLabel label4 = new JLabel(String.valueOf("Electronics"));
                                    JLabel label5 = new JLabel("Name");
                                    JLabel label6 = new JLabel(String.valueOf(electronics.getProductName()));
                                    JLabel label7 = new JLabel("Brand");
                                    JLabel label8 = new JLabel(String.valueOf(electronics.getBrand()));
                                    JLabel label9 = new JLabel("Warranty");
                                    JLabel label10 = new JLabel(String.valueOf(electronics.getAvailableItemCount()));
                                    JLabel label11 = new JLabel("Items available");
                                    JLabel label12 = new JLabel(String.valueOf(electronics.getAvailableItemCount()));

                                    lblPanel.add(label01);
                                    lblPanel.add(label02);
                                    lblPanel.add(label1);
                                    lblPanel.add(label2);
                                    lblPanel.add(label3);
                                    lblPanel.add(label4);
                                    lblPanel.add(label5);
                                    lblPanel.add(label6);
                                    lblPanel.add(label7);
                                    lblPanel.add(label8);
                                    lblPanel.add(label9);
                                    lblPanel.add(label10);
                                    lblPanel.add(label11);
                                    lblPanel.add(label12);

                                    lblPanel.revalidate();
                                    lblPanel.repaint();
                                    break;
                                }
                            }
                        }
                    }
                }

            }
        });
    }
}

