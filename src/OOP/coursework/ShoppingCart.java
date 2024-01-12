package OOP.coursework;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
public class ShoppingCart {
    public List<Product> products;

    public ShoppingCart() {
        this.products = new ArrayList<>();
    }
    public void addProduct(ArrayList<Product> productList,String selectedProductID) {
        for(Product product: productList){
            if(selectedProductID.equals(product.getProductID())){
                products.add(product);
                System.out.println(products);
            }
            else{
                System.out.println("nothing added");
            }
            this.products.add(product);
        }
    }
    public void removeProduct(Product product) {
        this.products.remove(product);
    }

    public double calculateTotalPrice() {
        double price = 0;
        for (Product product: this.products) {
            price += product.getPrice();
        }
        return price;
    }

    public List<Product> getAllProducts() {
        return products;
    }

    @Override
    public String toString() {
        return  "Shopping Cart Details: {" +
                "\n\tList of Products: " + this.products +
                "\n}";
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShoppingCart that = (ShoppingCart) o;
        return Objects.equals(products, that.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(products);
    }
}