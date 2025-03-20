package Repository;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import Model.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class PenjualRepositoryTest {

    @Test
    public void testFindByUsernameNotFound() {
        PenjualRepository repo = new PenjualRepository();
        // Ketika belum ada penjual, mencari username harus mengembalikan null.
        assertNull(repo.findByUsername("nonexistent"));
    }
    
    @Test
    public void testFindByUsernameCaseInsensitive() {
        PenjualRepository repo = new PenjualRepository();
        repo.register("SellerCase", "passCase", "MyToko");
        // Pencarian dengan huruf kecil seharusnya menemukan "SellerCase"
        Penjual found = repo.findByUsername("sellercase");
        assertNotNull(found);
        assertEquals("SellerCase", found.getUsername());
    }
    
    @Test
    public void testIsNamaTokoExistFalse() {
        PenjualRepository repo = new PenjualRepository();
        // Tanpa penjual terdaftar, nama toko tidak ada.
        assertFalse(repo.isNamaTokoExist("TokoA"));
    }
    
    @Test
    public void testIsNamaTokoExistTrue() {
        PenjualRepository repo = new PenjualRepository();
        repo.register("seller2", "passSeller2", "TokoB");
        assertTrue(repo.isNamaTokoExist("TokoB"));
    }
    
    @Test
    public void testIsNamaTokoExistCaseInsensitive() {
        PenjualRepository repo = new PenjualRepository();
        repo.register("seller3", "passSeller3", "TokoC");
        // Pencarian nama toko harus tidak peka terhadap kapitalisasi.
        assertTrue(repo.isNamaTokoExist("tokoc"));
    }
    
    @Test
    public void testLoginStatusSuccess() {
        PenjualRepository repo = new PenjualRepository();
        repo.register("seller4", "passSeller4", "TokoD");
        int status = repo.loginStatus("seller4", "passSeller4");
        assertEquals(0, status);
    }
    
    @Test
    public void testLoginStatusFailure() {
        PenjualRepository repo = new PenjualRepository();
        repo.register("seller5", "passSeller5", "TokoE");
        int status = repo.loginStatus("seller5", "wrongPass");
        assertEquals(2, status);
    }
    
    @Test
    public void testRegisterAndFind() {
        PenjualRepository repo = new PenjualRepository();
        repo.register("seller6", "passSeller6", "TokoF");
        Penjual p = repo.findByUsername("seller6");
        assertNotNull(p);
        assertEquals("passSeller6", p.getPassword());
        assertEquals("TokoF", p.getNamaToko());
    }
    
    // Test tambahan untuk memastikan output dari method register juga tercakup
    @Test
    public void testRegisterOutput() {
        // Menyimpan output asli System.out
        PrintStream originalOut = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        
        PenjualRepository repo = new PenjualRepository();
        repo.register("seller7", "passSeller7", "TokoG");
        
        // Mengembalikan System.out ke semula
        System.setOut(originalOut);
        String output = outContent.toString().trim();
        assertEquals("Registrasi akun penjual berhasil!", output);
    }
}
