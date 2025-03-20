package Repository;
import org.junit.jupiter.api.Test;


import Model.*;
import static org.junit.jupiter.api.Assertions.*;

public class AdminRepositoryTest {

    @Test
    public void testFindByUsername() {
        AdminRepository adminRepo = new AdminRepository();
        Admin admin = adminRepo.findByUsername("admin");
        assertNotNull(admin);
        assertEquals("admin", admin.getUsername());
    }

    @Test
    public void testLoginStatusSuccess() {
        AdminRepository adminRepo = new AdminRepository();
        int status = adminRepo.loginStatus("admin", "admin");
        assertEquals(0, status, "Login seharusnya berhasil dengan username & password benar.");
    }

    @Test
    public void testLoginStatusFailure() {
        AdminRepository adminRepo = new AdminRepository();
        int status = adminRepo.loginStatus("admin", "wrongPassword");
        assertEquals(2, status, "Login seharusnya gagal dengan password salah.");
    }

    @Test
    public void testRegister() {
        AdminRepository adminRepo = new AdminRepository();
        adminRepo.register("newAdmin", "newPass");
        Admin newAdmin = adminRepo.findByUsername("newAdmin");
        assertNotNull(newAdmin, "Admin baru harus terdaftar.");
        assertEquals("newPass", newAdmin.getPassword(), "Password admin baru harus sesuai.");
    }
}
