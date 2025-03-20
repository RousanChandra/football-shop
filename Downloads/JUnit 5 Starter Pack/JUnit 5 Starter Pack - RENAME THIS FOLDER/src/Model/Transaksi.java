package Model;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Transaksi {
    private UUID id;
    private Date timestamp;
    private String statusPengiriman; // misal: "Belum dikirim", "Dikirim", "Selesai", dll.
    private List<TransaksiProduct> productDibeli;

    public Transaksi() {
        this.id = UUID.randomUUID();
        this.timestamp = new Date(); // atau LocalDateTime, sesuai kebutuhan
        this.statusPengiriman = "Belum dikirim";
        this.productDibeli = new ArrayList<>();
    }

    // Getter dan Setter
    public UUID getId() {
        return id;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getStatusPengiriman() {
        return statusPengiriman;
    }

    public void setStatusPengiriman(String statusPengiriman) {
        this.statusPengiriman = statusPengiriman;
    }

    public List<TransaksiProduct> getProductDibeli() {
        return productDibeli;
    }

    public void addProduct(TransaksiProduct tp) {
        this.productDibeli.add(tp);
    }


    public int calculateTotalPrice() {
        // Contoh: total = jumlah item * 10000 (dummy)
        int total = 0;
        for (TransaksiProduct tp : productDibeli) {
            total += (tp.getProductAmount() * 10000); 
        }
        return total;
    }
}
