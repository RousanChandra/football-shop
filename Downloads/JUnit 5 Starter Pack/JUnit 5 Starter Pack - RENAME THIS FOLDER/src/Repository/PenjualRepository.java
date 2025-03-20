package Repository;


import Model.*;

public class PenjualRepository {
    private Penjual[] penjualList;

    // Konstruktor: inisialisasi array penjual sebagai array kosong
    public PenjualRepository() {
        this.penjualList = new Penjual[0];
    }

    // Mencari Penjual berdasarkan ID (dengan membandingkan toString() dari UUID)
    public Penjual getPenjualById(String id) {
        for (int i = 0; i < penjualList.length; i++) {
            if (penjualList[i] != null && penjualList[i].getId().toString().equalsIgnoreCase(id)) {
                return penjualList[i];
            }
        }
        return null; // tidak ditemukan
    }

    public Penjual[] getList() {
        return penjualList;
    }

    public boolean login(String username, String password) {
        for (int i = 0; i < penjualList.length; i++) {
            Penjual p = penjualList[i];
            if (p.getUsername().equalsIgnoreCase(username) && p.getPassword().equals(password)) {
                return true; // login berhasil
            }
        }
        return false; // tidak ada yang cocok
    }

    public Penjual getPenjual(String username) {
        for (Penjual penjual : penjualList) {
            if (penjual != null && penjual.getUsername().equalsIgnoreCase(username)) {
                return penjual;
            }
        }
        return null;
    }
    

    public void register(String username, String password, String namaToko) {
        Penjual newPenjual = new Penjual(username, password, namaToko);
        // Buat array baru dengan ukuran satu lebih banyak
        Penjual[] newArray = new Penjual[penjualList.length + 1];
        // Salin data lama ke array baru
        for (int i = 0; i < penjualList.length; i++) {
            newArray[i] = penjualList[i];
        }
        // Tambahkan penjual baru di posisi terakhir
        newArray[newArray.length - 1] = newPenjual;
        penjualList = newArray;
        System.out.println("Registrasi akun penjual berhasil!");
    }
    public boolean isUsernameExist(String username) {
        for (int i = 0; i < penjualList.length; i++) {
            if (penjualList[i] != null && penjualList[i].getUsername().equalsIgnoreCase(username)) {
                return true;
            }
        }
        return false;
    }
    
}
