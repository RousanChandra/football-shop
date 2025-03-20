package Model;


public class Admin {
    private String username;
    private String password;

    // Constructor
    public Admin(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Method login (mengembalikan true jika username & password cocok)
    public boolean login(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    // Getter & Setter (opsional, tergantung kebutuhan)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
