package OOP.coursework;

import java.io.IOException;

public interface ShoppingManager {
 void addProduct(Product product);
 void deleteProduct(String productID);
 void listOfProducts();
 void calculateTotalCost();
 void saveInFile(String storedFile) throws IOException;
 void readFile(String filename) throws IOException,ClassNotFoundException;

 void changeItemCount();

}
