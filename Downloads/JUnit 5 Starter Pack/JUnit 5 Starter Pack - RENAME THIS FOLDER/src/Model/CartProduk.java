package Model;

import java.util.UUID;

public class CartProduk {
    private UUID productId;
    private int amount;

    // Constructor 
    public CartProduk(UUID productId, int amount) {
        this.productId = productId;
        this.amount = amount;
    }

    // getProductId(void): UUID
    public UUID getProductId() {
        return productId;
    }

    // getProductAmount(void): int
    public int getProductAmount() {
        return amount;
    }


    public void setQuantity(int amount) {
        this.amount = amount;
    }
}