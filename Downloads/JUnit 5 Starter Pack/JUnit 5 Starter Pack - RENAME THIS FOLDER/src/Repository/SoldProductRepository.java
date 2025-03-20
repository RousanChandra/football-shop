package Repository;

import Model.*;


public class SoldProductRepository {
    private SoldProduct[] produkTerjual;
    private long pendapatan;

    public SoldProductRepository() {
        this.produkTerjual = new SoldProduct[10];
        this.pendapatan = 0;
    }

    public void addSoldProduct(SoldProduct sp) {
        for (int i = 0; i < produkTerjual.length; i++) {
            if (produkTerjual[i] == null) {
                produkTerjual[i] = sp;
                return;
            }
        }
    }

    public void addRevenue(long nominal) {
        this.pendapatan += nominal;
    }

    public SoldProduct[] getProdukTerjual() {
        return produkTerjual;
    }

    public long getPendapatan() {
        return pendapatan;
    }
}
