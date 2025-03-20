package Model;

import java.util.UUID;

public class Pengiriman {
    private UUID id;
    private UUID penjualId;
    private boolean isSent;
    private boolean isArrived;

    public void setSent(boolean sent) {
        this.isSent = sent;
    }

    public boolean isSent() {
        return this.isSent;
    }

    public UUID getId() {
        return this.id;
    }
}
