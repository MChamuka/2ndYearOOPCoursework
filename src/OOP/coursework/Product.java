package OOP.coursework;

import java.io.Serializable;

public abstract class Product implements Serializable {
    private String productID;
    private String productName;
    private int  availableItemCount;
    private double price;

    public Product(String productID, String productName, int availableItemCount, double price) {
        this.productID = productID;
        this.productName = productName;
        this.availableItemCount = availableItemCount;
        this.price = price;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getAvailableItemCount() {
        return availableItemCount;
    }

    public void setAvailableItemCount(int availableItemCount) {
        this.availableItemCount = availableItemCount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productID='" + productID + '\'' +
                ", productName='" + productName + '\'' +
                ", availableItemCount=" + availableItemCount +
                ", price=" + price +
                '}';
    }
}
