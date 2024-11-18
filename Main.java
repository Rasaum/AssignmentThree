import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tree productTree = new Tree();

        String productID1 = "4c69b61db1fc16e7013b43fc926e502d";  
        String name1 = "Safdie & Co. 35566.3T.01 Sheets, White 3 Sets";  
        String category1 = "Home & Kitchen | Bedding | Kids' Bedding | Sheets & Pillowcases | Sheet & Pillowcase Sets";  
        double price1 = 49.38;  // Price of the product

        if (productTree.get(productID1) == null) {
          
            Product newProduct1 = new Product(productID1, name1, category1, price1);

            productTree.put(productID1, newProduct1);
            
            System.out.println("Product inserted: " + newProduct1);
        } 
        
        else {
            System.out.println("Product with ID " + productID1 + " already exists.");
        }

        String productID2 = "4c69b61db1fc16e7013b43fc926e502d";  
        String name2 = "Safdie & Co. 35566.3T.01 Sheets, White 3 Sets"; 
        String category2 = "Home & Kitchen | Bedding | Kids' Bedding | Sheets & Pillowcases | Sheet & Pillowcase Sets";  
        double price2 = 59.99;  

        if (productTree.get(productID2) == null) {
            
            Product newProduct2 = new Product(productID2, name2, category2, price2);

            productTree.put(productID2, newProduct2);

            System.out.println("Hardcoded Product inserted: " + newProduct2);
        } 

        String csvFile = "src/amazon-product-data.csv";

        try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
            String line;
         
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                
                String[] values = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);
               
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

                 
                    Product product = new Product(productIDFromCSV, name, category, price);

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
