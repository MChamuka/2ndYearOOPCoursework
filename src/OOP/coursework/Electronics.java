package OOP.coursework;

public class Electronics extends Product{
    private String brand;
    private double warrantyPeriod;

    public Electronics(String productID, String productName, int availableItemCount, double price, String brand, double warrantyPeriod) {
        super(productID, productName, availableItemCount, price);
        this.brand = brand;
        this.warrantyPeriod = warrantyPeriod;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(double warrantyPeriod) {
        this.warrantyPeriod = warrantyPeriod;
    }

    @Override
    public String toString() {
        return "Electronics{" +super.toString()+
                "brand='" + brand + '\'' +
                ", warrantyPeriod=" + warrantyPeriod +
                '}';
    }
}
