package OOP.coursework;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class WestminsterShoppingManager implements ShoppingManager{
    public static final int MAX_PRODUCTS = 50;
    private int freeSlots=MAX_PRODUCTS;
    public ArrayList<Product> productList =new ArrayList<>();
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
    public void saveInFile(String storedFile) throws IOException {

        FileOutputStream fileOutputStream = new FileOutputStream(storedFile);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        for (Product product : productList) {

            objectOutputStream.writeObject(product);

        }
        fileOutputStream.flush();
        fileOutputStream.close();
        objectOutputStream.close();

        System.out.println("Product data are stored successfully");
    }
    @Override
    public void readFile(String filename) throws IOException,ClassNotFoundException {

        FileInputStream fileInputStream = new FileInputStream(filename);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        while (true) {
            try {
                Product product = (Product) objectInputStream.readObject();
                productList.add(product);

            } catch (EOFException e) {
                break;
            }
            System.out.println("Successfully updated");
        }
        try {
            fileInputStream.close();
            objectInputStream.close();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
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
}