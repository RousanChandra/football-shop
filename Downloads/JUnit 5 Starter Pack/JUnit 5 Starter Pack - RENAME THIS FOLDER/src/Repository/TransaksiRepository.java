package Repository;

import Model.*;

public class TransaksiRepository {
    private Transaksi[] transaksiList;

    // Constructor: inisialisasi array dengan kapasitas tertentu (misalnya 10)
    public TransaksiRepository() {
        this.transaksiList = new Transaksi[10];
    }


    public void addTransaksi(Transaksi transaksi) {
        for (int i = 0; i < transaksiList.length; i++) {
            if (transaksiList[i] == null) {
                transaksiList[i] = transaksi;
                return; // Setelah menambahkan, langsung keluar method
            }
        }
        // Jika tidak ada slot kosong, di sini bisa tambahkan pesan atau logika lain
        System.out.println("transaksiList penuh. Transaksi baru tidak dapat ditambahkan.");
    }


    public Transaksi[] getList() {
        return transaksiList;
    }
}
