package Model;
import java.util.UUID;

public class Product {
    private UUID productID;
    private String name;
    private double price;
    private int stock;

    public Product(String name, double price, int stock) {
        this.productID = UUID.randomUUID();
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public UUID getProductID() {
        return productID;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int Stokbaru) {
        this.stock = Stokbaru;
    }
    public void setPrice(double Hargabaru) {
        this.price = Hargabaru;
    }
}
