
import java.util.HashMap;
import java.util.Map;

class Product {
    private int productId;
    private String name;
    private double price;
    private int quantity;

    // Constructor
    Product(int productId, String name, double price, int quantity) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public int getProductId() {
        return productId;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Display product details
    public void displayProduct() {
        System.out.println("Product ID: " + productId);
        System.out.println("Name: " + name);
        System.out.println("Price: Rs. " + price);
        System.out.println("Available Quantity: " + quantity);
        System.out.println("--------------------------");
    }
}

class Catalogue {
    private HashMap<Integer, Product> products = new HashMap<>();

    // Add product
    public void addProduct(Product p) {
        if (products.containsKey(p.getProductId())) {
            System.out.println("Product ID already exists!");
        } else {
            products.put(p.getProductId(), p);
            System.out.println("Product added successfully!");
        }
    }

    // Search product
    public void searchProduct(int id) {
        Product p = products.get(id);

        if (p != null) {
            System.out.println("Product found:");
            p.displayProduct();
        } else {
            System.out.println("Product not found!");
        }
    }

    // Update product price
    public void updatePrice(int id, double newPrice) {
        Product p = products.get(id);

        if (p != null) {
            p.setPrice(newPrice);
            System.out.println("Price updated successfully!");
        } else {
            System.out.println("Product not found!");
        }
    }

    // Remove product
    public void removeProduct(int id) {
        if (products.containsKey(id)) {
            products.remove(id);
            System.out.println("Product removed successfully!");
        } else {
            System.out.println("Product not found!");
        }
    }

    // Display all products
    public void displayAllProducts() {
        if (products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }

        for (Product p : products.values()) {
            p.displayProduct();
        }
    }
}

public class s2p5 {
    public static void main(String[] args) {
        Catalogue catalogue = new Catalogue();

        // Add products
        catalogue.addProduct(new Product(101, "Laptop", 55000, 10));
        catalogue.addProduct(new Product(102, "Mobile", 25000, 20));
        catalogue.addProduct(new Product(103, "Headphones", 1500, 30));

        // Try adding duplicate ID
        catalogue.addProduct(new Product(102, "Tablet", 18000, 5));

        // Display all products
        System.out.println("\nAll Products:");
        catalogue.displayAllProducts();

        // Search product
        System.out.println("\nSearching for Product ID 102:");
        catalogue.searchProduct(102);

        // Update price
        catalogue.updatePrice(102, 23000);

        // Remove product
        catalogue.removeProduct(101);

        // Display remaining products
        System.out.println("\nUpdated Product Catalogue:");
        catalogue.displayAllProducts();
    }
}
