package Repository;


import Model.*;

public class AdminRepository {
    private Admin[] adminList;

    // Constructor: Hardcode 3 admin
    public AdminRepository() {
        adminList = new Admin[3];
        adminList[0] = new Admin("admin", "admin");
        adminList[1] = new Admin("root", "toor");
        adminList[2] = new Admin("dekdepe", "aku CinTaJava");
    }


    public boolean login(String username, String password) {
        // Loop semua admin di adminList
        for (int i = 0; i < adminList.length; i++) {
            if (adminList[i] != null) {
                // Bandingkan username & password
                if (adminList[i].getUsername().equals(username) &&
                    adminList[i].getPassword().equals(password)) {
                    return true; // login berhasil
                }
            }
        }
        return false; // tidak ditemukan admin yang cocok
    }
    public boolean isUsernameExist(String username) {
        for (int i = 0; i < adminList.length; i++) {
            if (adminList[i] != null && adminList[i].getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }
    
    public Admin getAdmin(String username) {
        for (Admin admin : adminList) {
            if (admin != null && admin.getUsername().equalsIgnoreCase(username)) {
                return admin;
            }
        }
        return null;
    }
}
