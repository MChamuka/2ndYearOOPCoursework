package OOP.coursework;

import java.awt.*;

public class Clothing extends Product{
    private int size;
    private String color;

    public Clothing(String productID, String productName, int availableItemCount, double price, int size, String color) {
        super(productID, productName, availableItemCount, price);
        this.size = size;
        this.color = color;
    }
    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Clothing{" +super.toString()+
                "size=" + size +
                ", color=" + color +
                '}';
    }
}