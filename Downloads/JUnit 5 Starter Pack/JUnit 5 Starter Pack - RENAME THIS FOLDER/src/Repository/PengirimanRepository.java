package Repository;

import java.util.UUID;


import Model.*;

public class PengirimanRepository {
    private Pengiriman[] pengiriman;

    // Constructor, misal menentukan kapasitas array
    public PengirimanRepository() {
        this.pengiriman = new Pengiriman[0];
    }

    // Contoh method untuk menambahkan data Pengiriman
    public void addPengiriman(Pengiriman newPengiriman) {
        for (int i = 0; i < pengiriman.length; i++) {
            if (pengiriman[i] == null) {
                pengiriman[i] = newPengiriman;
                System.out.println("Pengiriman baru ditambahkan pada index: " + i);
                return; 
            }
        }
    }

    // Contoh method untuk mengambil semua data Pengiriman
    public Pengiriman[] getAllPengiriman() {
        return pengiriman;
    }


}
