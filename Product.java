public class Product {
    private String productID;
    private String name;
    private String category;
    private double price;

    public Product(String productID, String name, String category, double price) {
        this.productID = productID;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product ID: " + productID + ", Name: " + name + ", Category: " + category + ", Price: $" + price;
    }
}