import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tree productTree = new Tree();

        // First hardcoded product (does not exist yet)
        String productID1 = "4c69b61db1fc16e7013b43fc926e502d";  // Sample Product ID
        String name1 = "Safdie & Co. 35566.3T.01 Sheets, White 3 Sets";  // Product Name
        String category1 = "Home & Kitchen | Bedding | Kids' Bedding | Sheets & Pillowcases | Sheet & Pillowcase Sets";  // Category
        double price1 = 49.38;  // Price of the product

        // Check if the first product already exists in the tree before inserting it
        if (productTree.get(productID1) == null) {
            // Create a new Product object
            Product newProduct1 = new Product(productID1, name1, category1, price1);

            // Insert the product into the Tree
            productTree.put(productID1, newProduct1);

            // Print confirmation message
            System.out.println("Product inserted: " + newProduct1);
        } else {
            System.out.println("Product with ID " + productID1 + " already exists.");
        }

        // Second hardcoded product (already exists, same product ID as the first one)
        String productID2 = "4c69b61db1fc16e7013b43fc926e502d";  // Same Product ID as the first one
        String name2 = "Safdie & Co. 35566.3T.01 Sheets, White 3 Sets";  // Same Name
        String category2 = "Home & Kitchen | Bedding | Kids' Bedding | Sheets & Pillowcases | Sheet & Pillowcase Sets";  // Same Category
        double price2 = 59.99;  // Different price

        // Check if the second product already exists in the tree before inserting it
        if (productTree.get(productID2) == null) {
            // Create a new Product object
            Product newProduct2 = new Product(productID2, name2, category2, price2);

            // Insert the product into the Tree
            productTree.put(productID2, newProduct2);

            // Print confirmation message
            System.out.println("Hardcoded Product inserted: " + newProduct2);
        } 

        String csvFile = "src/amazon-product-data.csv";

        try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
            String line;
            // Skip the header if it exists
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                // Use regex to handle commas and quoted strings
                String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
                // Check if the line has the correct number of fields
                if (values.length >= 4) {
                    String productIDFromCSV = values[0].trim();  // Remove any leading/trailing spaces
                    String name = values[1].trim().replaceAll("^\"|\"$", "");
                    String category = values[2].trim().replaceAll("^\"|\"$", "");
                    String priceString = values[3].trim().replace("$", "");

                    double price = 0.0;
                    if (priceString.contains("-")) {
                        String[] priceRange = priceString.split("-");
                        double minPrice = Double.parseDouble(priceRange[0].trim());
                        double maxPrice = Double.parseDouble(priceRange[1].trim());
                        price = (minPrice + maxPrice) / 2;
                    } else {
                        price = Double.parseDouble(priceString);
                    }

                    // Create a Product object from the CSV data
                    Product product = new Product(productIDFromCSV, name, category, price);

                    // Insert the product into the Tree (if it does not already exist)
                    if (productTree.get(productIDFromCSV) == null) {
                        productTree.put(productIDFromCSV, product);
                    } else {
                        System.out.println("Product with ID " + productIDFromCSV + " already exists from CSV data.");
                    }
                } else {
                    System.out.println("Skipping invalid line: " + line);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 3; i++) {
            System.out.println("Enter the Product ID you are looking for: ");
            String searchID = scanner.nextLine();

            Product foundProduct = productTree.get(searchID);
            if (foundProduct != null) {
                System.out.println("Product found: " + foundProduct);
            } else {
                System.out.println("Product not found!");
            }
        }
    }
}
