import java.util.ArrayList;

class Product{
    private String name;
    private float price;

    public Product(String name, float price){
        this.name = name;
        this.price = price;
    }

    public float getPrice(){
        return price;
    }

    public void setPrice(float price){
        this.price = price;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    @Override
    public String toString(){
        return "Product Name: " + name + " Price: " + price;
    }
}

class ShoppingCart{
    ArrayList<Product> products;

    public ShoppingCart(){
        products = new ArrayList<>();
    }

    public void addProduct(String name){
        for(Product p : products){
            if(p.getName().equals(name)){
                products.remove(p);
                System.out.println("Added product to shopping cart: " + p.getName());
                break;
            }
        }
    }

    public void removeProduct(String name){
        for(Product p : products){
            if(p.getName().equals(name)){
                products.remove(p);
                System.out.println("Removed product from shopping cart: " + p.getName());
                break;
            }
        }
    }

    public void viewCart(){
        System.out.println("\nTotal Products: " + products.size());
        for(Product product : products){
            System.out.println(product);
        }
    }
}

public class Shop {

}
