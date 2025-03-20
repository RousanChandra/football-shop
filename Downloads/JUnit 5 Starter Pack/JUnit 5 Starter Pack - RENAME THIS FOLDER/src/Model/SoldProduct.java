package Model;

public class SoldProduct {
    private String productName;
    private long amount;

    public String getProductName() {
        return productName;
    }

    public long getAmount() {
        return amount;
    }

    public void setName(String name) {
        this.productName = name;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }
}
