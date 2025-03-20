package Model;

import java.util.UUID;

public class Cart {
    private CartProduk[] keranjang;

    // Constructor: misalnya kapasitas tetap 10
    public Cart() {
        this.keranjang = new CartProduk[0];
    }

    /**
     * addToCart(UUID productId)
     * - Jika productId sudah ada di keranjang, quantity ditambah 1.
     * - Jika belum ada, cari slot null, isi CartProduk baru dengan quantity = 1.
     * - Jika array penuh, (opsional) tampilkan pesan "Keranjang penuh!".
     */
    public void addToCart(UUID productId) {
        // 1. Cek apakah productId sudah ada di keranjang
        for (int i = 0; i < keranjang.length; i++) {
            if (keranjang[i] != null && keranjang[i].getProductId().equals(productId)) {
                int currentQty = keranjang[i].getProductAmount();
                keranjang[i].setQuantity(currentQty + 1);
                return;
            }
        }

        // 2. Jika belum ada, cari slot null
        for (int i = 0; i < keranjang.length; i++) {
            if (keranjang[i] == null) {
                keranjang[i] = new CartProduk(productId, 1);
                return;
            }
        }

        // 3. Jika array penuh (opsional)
        // System.out.println("Keranjang penuh!");
    }

    /**
     * deleteFromCart(UUID productId)
     * - Cari productId di array.
     * - Jika ketemu, hapus (return CartProduk yang dihapus) dan geser elemen berikutnya ke kiri.
     * - Jika tidak ketemu, return null.
     */
    public CartProduk deleteFromCart(UUID productId) {
        for (int i = 0; i < keranjang.length; i++) {
            if (keranjang[i] != null && keranjang[i].getProductId().equals(productId)) {
                CartProduk removed = keranjang[i];
                // Geser elemen setelahnya ke kiri
                for (int j = i; j < keranjang.length - 1; j++) {
                    keranjang[j] = keranjang[j + 1];
                }
                // Kosongkan slot terakhir
                keranjang[keranjang.length - 1] = null;
                return removed;
            }
        }
        return null; // tidak ditemukan
    }

    /**
     * getKeranjang()
     * - Mengembalikan array berisi item yang tidak null (tanpa slot kosong).
     */
    public CartProduk[] getKeranjang() {
        // Hitung jumlah item non-null
        int count = 0;
        for (CartProduk c : keranjang) {
            if (c != null) count++;
        }

        // Buat array baru berukuran count
        CartProduk[] result = new CartProduk[count];
        int idx = 0;
        for (CartProduk c : keranjang) {
            if (c != null) {
                result[idx] = c;
                idx++;
            }
        }
        return result;
    }
}
