package Repository;


import Model.*;

public class PembeliRepository {
    private Pembeli[] pembeliList;

    public PembeliRepository() {
        this.pembeliList = new Pembeli[0];
    }

    public Pembeli getPembeliById(String id) {
        for (int i = 0; i < pembeliList.length; i++) {
            if (pembeliList[i].getUsername().equalsIgnoreCase(id)) {
                return pembeliList[i];
            }
        }
        return null; // tidak ditemukan
    }
    
    // Mengembalikan array pembeli yang terdaftar
    public Pembeli[] getList() {
        return pembeliList;
    }

    public boolean login(String username, String password) {
        for (int i = 0; i < pembeliList.length; i++) {
            Pembeli p = pembeliList[i];
            if (p.getUsername().equalsIgnoreCase(username) && p.getPassword().equals(password)) {
                return true; // login berhasil
            }
        }
        return false; // tidak ada yang cocok
    }

    public void register(String username, String password) {
        Pembeli newPembeli = new Pembeli(username, password);
        // Buat array baru dengan ukuran satu lebih banyak
        Pembeli[] newArray = new Pembeli[pembeliList.length + 1];
        // Salin data lama ke array baru
        for (int i = 0; i < pembeliList.length; i++) {
            newArray[i] = pembeliList[i];
        }
        // Tambahkan pembeli baru di posisi terakhir
        newArray[newArray.length - 1] = newPembeli;
        pembeliList = newArray;
        System.out.println("Registrasi akun pembeli berhasil!");
    }
    public boolean isUsernameExist(String username) {
        for (int i = 0; i < pembeliList.length; i++) {
            if (pembeliList[i] != null && pembeliList[i].getUsername().equalsIgnoreCase(username)) {
                return true;
            }
        }
        return false;
    }
    public Pembeli getPembeli(String username) {
        for (Pembeli pembeli : pembeliList) {
            if (pembeli != null && pembeli.getUsername().equalsIgnoreCase(username)) {
                return pembeli;
            }
        }
        return null;
    }

}