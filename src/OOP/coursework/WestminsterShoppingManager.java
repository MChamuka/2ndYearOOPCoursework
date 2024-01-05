package OOP.coursework;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class WestminsterShoppingManager implements ShoppingManager {
    public static final int MAX_PRODUCTS = 50;
    private int freeSlots=MAX_PRODUCTS;
    private ArrayList<Product> productList =new ArrayList<>();

    @Override
    public void addProduct(Product product) {
        if(productList.contains(product)){
            System.out.println("Product is already in the system");
        }
        else if(productList.size()>=MAX_PRODUCTS){
            System.out.println("System is full");
        }
        else{
            productList.add(product);
            freeSlots-=1;
            System.out.printf("Product added successfully ,", freeSlots>0 ? ("Free slots remaining"+freeSlots):"No more free slots available");
        }
    }
    @Override
    public void deleteProduct(String productID) {
        for(Product product:productList){
            if(productID.equals(product.getProductID())){
                System.out.println(productID + " has been removed successfully");
                productList.remove(product);
                return;
            }
        }
        System.out.println("Invalid product ID. please check and try again");
    }
    @Override
    public void listOfProducts() { //bubble sort technique is used
        if(productList.isEmpty()){
            System.out.println("No products in the system to display");
            return;
        }
        System.out.println("List of all products");
        int bottom = productList.size()-2;
        boolean exchanged = true;

        while(exchanged) {
            exchanged = false;
            for (int i = 0; i < bottom ; i++) {
                int result=(productList.get(i).getProductID()).compareTo(productList.get(i+1).getProductID());
                if(result == +1){
                    productList.add(i,productList.get(i+1));
                    productList.remove(i+2);
                    exchanged= true;
                }
            }
            bottom--;
        }
        for(Product product: productList){
            System.out.println(product);
        }
    }

    @Override
    public void calculateTotalCost() {
        double total = 0;
        for(Product product:productList){
            total+=(product.getPrice()* product.getAvailableItemCount());
        }
        System.out.println("Total cost of all products are : " + total);
    }

    @Override
    public void saveInFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\HP\\Desktop\\productData.txt"))) {
            writer.write(String.valueOf(productList));

            System.out.println("Data has been successfully written to the file.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void readFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\HP\\Desktop\\productData.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void changeItemCount(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the product ID : ");
        String productID=scanner.nextLine();

        System.out.println("Enter the new number of items : ");
        int itemCount=scanner.nextInt();

        for (Product product: productList){
            if(productID.equals(product.getProductID())){
                product.setAvailableItemCount(itemCount);
                return;
            }
        }
        System.out.println("Invalid product ID");
    }
    public ArrayList<Product> getProductList() {
        return productList;
    }
}
