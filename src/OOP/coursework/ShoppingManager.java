package OOP.coursework;

public interface ShoppingManager {
 public abstract void addProduct(Product product);
 public abstract void deleteProduct(String productID);
 public abstract void listOfProducts();
 public abstract void calculateTotalCost();
 public abstract void saveInFile();
 public abstract void readFile();
 public abstract void changeItemCount();
}
