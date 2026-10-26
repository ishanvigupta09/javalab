
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Product {
    private int productId;
    private String name;
    private double price;

    // Constructor
    Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}

class CartItem {
    private Product product;
    private int quantity;

    CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException(
                    "Quantity must be positive!");
        }
        this.quantity = quantity;
    }

    public double getAmount() {
        return product.getPrice() * quantity;
    }
}

class ShoppingCart {
    private HashMap<Integer, CartItem> items = new HashMap<>();

    // Add product or increase its quantity
    public void addProduct(Product product, int quantity) {
        if (quantity <= 0) {
            System.out.println("Invalid quantity!");
            return;
        }

        int id = product.getProductId();

        if (items.containsKey(id)) {
            CartItem item = items.get(id);
            item.setQuantity(item.getQuantity() + quantity);
            System.out.println("Product quantity increased!");
        } else {
            items.put(id, new CartItem(product, quantity));
            System.out.println("Product added to cart!");
        }
    }

    // Update quantity
    public void updateQuantity(int id, int quantity) {
        if (quantity <= 0) {
            System.out.println("Invalid quantity!");
            return;
        }

        CartItem item = items.get(id);

        if (item != null) {
            item.setQuantity(quantity);
            System.out.println("Quantity updated!");
        } else {
            System.out.println("Product not found in cart!");
        }
    }

    // Remove product
    public void removeProduct(int id) {
        if (items.remove(id) != null) {
            System.out.println("Product removed from cart!");
        } else {
            System.out.println("Product not found in cart!");
        }
    }

    // Calculate subtotal
    public double calculateSubtotal() {
        double subtotal = 0;

        for (CartItem item : items.values()) {
            subtotal += item.getAmount();
        }

        return subtotal;
    }

    // Calculate discount percentage
    public double getDiscountPercentage() {
        double subtotal = calculateSubtotal();

        if (subtotal >= 5000) {
            return 10;
        } else if (subtotal >= 1000) {
            return 5;
        } else {
            return 0;
        }
    }

    // Calculate final bill
    public double calculateFinalAmount() {
        double subtotal = calculateSubtotal();
        double discount = subtotal * getDiscountPercentage() / 100;

        return subtotal - discount;
    }

    // Display cart
    public void displayCart() {
        System.out.printf("%-15s %-10s %s%n",
                "Product", "Quantity", "Amount");

        for (CartItem item : items.values()) {
            System.out.printf("%-15s %-10d %.2f%n",
                    item.getProduct().getName(),
                    item.getQuantity(),
                    item.getAmount());
        }

        double subtotal = calculateSubtotal();
        double discount = subtotal * getDiscountPercentage() / 100;

        System.out.println("----------------------------------");
        System.out.printf("Subtotal: %.2f%n", subtotal);
        System.out.printf("Discount (%.0f%%): %.2f%n",
                getDiscountPercentage(), discount);
        System.out.printf("Final Amount: %.2f%n",
                calculateFinalAmount());
    }
}
public class s2p10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ShoppingCart cart = new ShoppingCart();

        // Available products
        Product p1 = new Product(101, "Keyboard", 800);
        Product p2 = new Product(102, "Mouse", 700);
        Product p3 = new Product(103, "Monitor", 4500);

        int choice;

        do {
            System.out.println("\n===== SHOPPING CART =====");
            System.out.println("1. Add Product");
            System.out.println("2. Update Quantity");
            System.out.println("3. Remove Product");
            System.out.println("4. Display Cart and Bill");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Available Products:");
                    System.out.println("101. Keyboard - Rs. 800");
                    System.out.println("102. Mouse - Rs. 700");
                    System.out.println("103. Monitor - Rs. 4500");

                    System.out.print("Enter product ID: ");
                    int id = sc.nextInt();

                    System.out.print("Enter quantity: ");
                    int qty = sc.nextInt();

                    Product selected = null;

                    if (id == 101) {
                        selected = p1;
                    } else if (id == 102) {
                        selected = p2;
                    } else if (id == 103) {
                        selected = p3;
                    }

                    if (selected == null) {
                        System.out.println("Invalid product ID!");
                    } else {
                        cart.addProduct(selected, qty);
                    }
                    break;

                case 2:
                    System.out.print("Enter product ID: ");
                    int updateId = sc.nextInt();

                    System.out.print("Enter new quantity: ");
                    int newQty = sc.nextInt();

                    cart.updateQuantity(updateId, newQty);
                    break;

                case 3:
                    System.out.print("Enter product ID to remove: ");
                    int removeId = sc.nextInt();

                    cart.removeProduct(removeId);
                    break;

                case 4:
                    cart.displayCart();
                    break;

                case 5:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}
