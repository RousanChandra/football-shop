package Model;
import Repository.*;

public class Voucher {
    private String ID;       
    private boolean isUsed;

    public Voucher(String ID) {
        this.ID = ID;
        this.isUsed = false;
    }

    public String getId() {
        return ID;
    }

    public boolean isUsed() {
        return isUsed;
    }

   
    public void setUsed(boolean used) {
        this.isUsed = used;
    }

    public int calculateDisc() {
        // Contoh diskon 5000 rupiah
        return 5000;
    }
}
