import java.util.ArrayList;
import java.util.Scanner;

class Product {
    private String name;
    private float price;

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product Name: " + name + " Price: " + price;
    }
}

class ShoppingCart {
    ArrayList<Product> products;

    public ShoppingCart() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Product Added: " + product);
    }

    public void removeProduct(String name) {
        for (Product p : products) {
            if (p.getName().equals(name)) {
                products.remove(p);
                System.out.println("Removed product from shopping cart: " + p.getName());
                return;
            }
        }
        System.out.println("Product not found");
    }

    public void viewCart() {
        System.out.println("\nTotal Products: " + products.size());
        for (Product product : products) {
            System.out.println(product);
        }
    }

    public float totalPrice() {
        float total = 0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }
}

public class Shop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(new Product("Book", 112));
        cart.addProduct(new Product("Table", 100));
        cart.viewCart();
        cart.removeProduct("Book");

        cart.viewCart();
        cart.addProduct(new Product("Jayraj", 69));
        cart.addProduct(new Product("Samurai", 200));
        cart.viewCart();
        System.out.println("Total Price: " + cart.totalPrice());
    }
}
