package Repository;


import Model.*;

public class ProductRepository {
    private String namaToko;
    private Product[] productList;

    // Constructor: terima namaToko dan inisialisasi array productList
    public ProductRepository(String namaToko) {
        this.namaToko = namaToko;
        this.productList = new Product[0];
    }

    // Mencari Product di array productList berdasarkan String id
    public Product getProductById(String id) {
        for (int i = 0; i < productList.length; i++) {
            if (productList[i] != null && productList[i].getProductID().equals(id)) {
                return productList[i];
            }
        }
        return null; // tidak ditemukan
    }

    // Getter namaToko
    public String getNamaToko() {
        return namaToko;
    }

    // Getter productList
    public Product[] getProductList() {
        return productList;
    }

    // Metode isNamaTokoExist: mengecek apakah parameter namaToko sama dengan namaToko yang tersimpan
    public boolean isNamaTokoExist(String namaToko) {
        return this.namaToko.equals(namaToko);
    }
    
    // Mengecek apakah ada product dengan nama yang sama (case-insensitive)
    public boolean isProductExist(String name) {
        for (Product p : productList) {
            if (p != null && p.getName().equalsIgnoreCase(name)) {
                return true;
            }
        }
        return false;
    }

    // Menambahkan product baru di slot kosong pertama
    public boolean addProduct(String name, double price, int stock) {
        for (int i = 0; i < productList.length; i++) {
            if (productList[i] == null) {
                productList[i] = new Product(name, price, stock);
                return true; // Berhasil menambahkan
            }
        }
        return false; // Gagal (array penuh)
    }
    
    
}
