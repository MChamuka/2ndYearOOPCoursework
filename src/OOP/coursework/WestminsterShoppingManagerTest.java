package OOP.coursework;

import org.junit.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class WestminsterShoppingManagerTest {
    @Test
    public void testAddNewProduct() {
        WestminsterShoppingManager westminsterShoppingManager = new WestminsterShoppingManager();
        Product product = new Electronics("e12223", "yamaha", 34, 2000, "suzu", 12);
        westminsterShoppingManager.addProduct(product);

        assertTrue(westminsterShoppingManager.productList.get(0).equals(product), "Product successfully added");
    }

    @Test
    public void testDeleteProduct() {
        WestminsterShoppingManager westminsterShoppingManager = new WestminsterShoppingManager();
        Product product = new Electronics("e12223", "yamaha", 34, 2000, "suzu", 12);
        westminsterShoppingManager.addProduct(product);

        String productID = product.getProductID();
        westminsterShoppingManager.deleteProduct(productID);
        assertFalse(westminsterShoppingManager.productList.contains(product));
    }

    @Test
    public void testListOfProducts() {
        WestminsterShoppingManager westminsterShoppingManager = new WestminsterShoppingManager();
        Product product = new Electronics("e12223", "yamaha", 34, 2000, "suzu", 12);
        westminsterShoppingManager.addProduct(product);

        westminsterShoppingManager.listOfProducts();
    }

    @Test
    public void testSaveInFile() throws IOException {
        WestminsterShoppingManager westminsterShoppingManager = new WestminsterShoppingManager();
        westminsterShoppingManager.saveInFile("test.txt");
    }

    @Test
    public void testReadFile() throws IOException, ClassNotFoundException {
        WestminsterShoppingManager westminsterShoppingManager = new WestminsterShoppingManager();
        westminsterShoppingManager.readFile("test.txt");
    }
}