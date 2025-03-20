package Repository;
import org.junit.jupiter.api.Test;

import Model.*;

import static org.junit.jupiter.api.Assertions.*;

public class PembeliRepositoryTest {

    @Test
    public void testRegisterAndFindPembeli() {
        PembeliRepository repo = new PembeliRepository();
        repo.register("pembeliTest", "testPass");
        Pembeli p = repo.findByUsername("pembeliTest");
        assertNotNull(p);
        assertEquals("pembeliTest", p.getUsername());
        assertEquals("testPass", p.getPassword());
    }

    @Test
    public void testLoginStatusSuccess() {
        PembeliRepository repo = new PembeliRepository();
        repo.register("pembeliTest2", "pass2");
        int status = repo.loginStatus("pembeliTest2", "pass2");
        assertEquals(0, status);
    }

    @Test
    public void testLoginStatusFailure() {
        PembeliRepository repo = new PembeliRepository();
        repo.register("pembeliTest3", "pass3");
        int status = repo.loginStatus("pembeliTest3", "wrongPass");
        assertEquals(2, status);
    }
}
