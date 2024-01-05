package OOP.coursework;
import java.awt.*;
import java.util.Scanner;


public class ConsoleApplication {
    private static final ShoppingManager manager=new WestminsterShoppingManager();
    public static void main(String[] args) {
        while (true) {
            while (true) {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Are you a User or a manager? \n 1.User \n 2.manager \n Enter the number: ");
                int operatorType = scanner.nextInt();
                scanner.nextLine();

                if (operatorType == 1) {
                    new GUIClassA((WestminsterShoppingManager) manager);
                    continue;

                } else if (operatorType == 2) {
                    System.out.print("enter the password: ");
                    String password = scanner.nextLine();
                    if (password.equals("manager123")) {
                        break;
                    } else
                        System.out.println("Incorrect password");
                    continue;
                }
                break;
            }

            int option = 4;
            while (option != 9) {
                try {
                    Scanner scanner = new Scanner(System.in);
                    displayMenu();
                    option = scanner.nextInt();

                    switch (option) {
                        case 1:
                            addProduct();
                            break;
                        case 2:
                            deleteProduct();
                            break;
                        case 3:
                            manager.listOfProducts();
                            break;
                        case 4:
                            manager.calculateTotalCost();
                            break;
                        case 5:
                            manager.saveInFile();
                            break;
                        case 6:
                            manager.readFile();
                            break;
                        case 7:
                            manager.changeItemCount();
                            break;
                        default:
                            System.out.println("Invalid option No.");
                    }
                } catch (Exception e) {
                    System.out.println("Invalid option No. , Try again");
                }
            }
        }
    }
    public static void displayMenu(){
        System.out.println(" ");
        System.out.println("Welcome to the Westminster shopping");
        System.out.println("1:Add a new product");
        System.out.println("2:Delete a product");
        System.out.println("3:List of products");
        System.out.println("4:Calculate total cost");
        System.out.println("5:Save in file");
        System.out.println("9:Exit the menu");
        System.out.print("enter the option number you want to proceed with :");
    }
    private static void addProduct() {
        Product product;
        int productType=1;
        while(true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println(" product types: \n 1:Electronics \n 2:Clothing \n 9:Go back");
                System.out.print("Enter the product type no. : ");
                productType = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Invalid product type, try again");
            }
        }
        String productID="productID";
        while(true) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the product ID: ");
            productID = scanner.nextLine();

            if (productType == 1 && !productID.toLowerCase().startsWith("e")) {
                System.out.println("electronics product ID starts with 'e', Try again!");
                continue;
            }
            if (productType == 2 && !productID.toLowerCase().startsWith("c")) {
                System.out.println("Clothing product ID starts with 'c', Try again!");
                continue;
            }
            break;
        }
        while(true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.print("Enter the product Name: ");
                String productName = scanner.nextLine();

                System.out.print("Enter the available item count: ");
                int availableItemCount = scanner.nextInt();

                System.out.print("Enter the price of the product: ");
                double price = scanner.nextDouble();
                scanner.nextLine();

                switch (productType) {
                    case 1:
                        System.out.print("Enter the brand of " + productName + ": ");
                        String brand = scanner.nextLine();

                        System.out.print("Enter the warranty period of " + productName + ": ");
                        double warrantyPeriod = scanner.nextDouble();
                        scanner.nextLine();

                        product = new Electronics(productID, productName, availableItemCount, price, brand, warrantyPeriod);
                        manager.addProduct(product);
                        break;
                    case 2:
                        System.out.print("Enter the size of " + productName + ": ");
                        int size = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Enter the colour of " + productName + ": ");
                        String color = scanner.nextLine();

                        product = new Clothing(productID, productName, availableItemCount, price, size, color);
                        manager.addProduct(product);
                        break;
                    case 9:
                        System.out.println("");
                    default:
                        System.out.println("Invalid option no.");
                }
                break;
            }catch(Exception e){
                System.out.println("Invalid input, try again");
            }
        }
    }
    private static void deleteProduct() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the product ID : ");
            String productID = scanner.nextLine();

            manager.deleteProduct(productID);
    }
}
