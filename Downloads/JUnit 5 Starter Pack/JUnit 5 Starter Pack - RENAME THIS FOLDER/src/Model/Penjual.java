package Model;

import java.util.UUID;
import Repository.*;

public class Penjual {
    private UUID userID;
    private String username;
    private String password;
    private ProductRepository productRepo;        // Daftar produk yang dijual
    private SoldProductRepository laporanTerjual; // Daftar produk yang sudah terjual

    public Penjual(String username, String password, String namaToko) {
        this.userID = UUID.randomUUID();
        this.username = username;
        this.password = password;
        this.productRepo = new ProductRepository(namaToko);
        this.laporanTerjual = new SoldProductRepository();
    }
    
    public UUID getId() {
        return userID;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public ProductRepository getRepo() {
        return productRepo;
    }

   
    public SoldProductRepository getLaporan() {
        return laporanTerjual;
    }
}
