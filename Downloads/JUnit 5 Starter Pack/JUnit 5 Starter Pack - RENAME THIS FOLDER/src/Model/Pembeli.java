package Model;
import java.util.UUID;

import Repository.*;


public class Pembeli {
    private UUID id;
    private String username;
    private String password;
    private Cart keranjang;                    // Relasi ke Cart
    private long balance;
    private TransaksiRepository riwayatTransaksi;

    public Pembeli(String username, String password) {
        this.id = UUID.randomUUID();
        this.username = username;
        this.password = password;
        this.keranjang = new Cart();
        this.balance = 0;
        this.riwayatTransaksi = new TransaksiRepository();
    }

    public UUID getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Cart getCart() {
        return keranjang;
    }

    public long getBalance() {
        return balance;
    }

    public void addBalance(long amount) {
        this.balance += amount;
    }

    public TransaksiRepository getRiwayatTransaksi() {
        return riwayatTransaksi;
    }
}
