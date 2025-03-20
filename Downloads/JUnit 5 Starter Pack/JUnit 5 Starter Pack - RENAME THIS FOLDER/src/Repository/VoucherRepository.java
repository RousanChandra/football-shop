package Repository;

import java.util.Random;

import Model.*;

public class VoucherRepository {
    private Voucher[] voucherList;

    public VoucherRepository() {
        // Kapasitas tetap, misal 10 voucher
        this.voucherList = new Voucher[10];
    }


    public Voucher generateVoucher() {
        // Generate 10 huruf acak (A-Z) lalu dikonversi ke digit 0-9
        Random random = new Random();
        String charset = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < 10; i++) {
            int index = random.nextInt(charset.length());
            char ch = charset.charAt(index);
            int digit = (ch - 'A') % 10;
            sb.append(digit);
        }
        String generatedId = sb.toString();
        Voucher newVoucher = new Voucher(generatedId);

        // Cari slot kosong (null) di voucherList untuk menyimpan voucher baru
        for (int i = 0; i < voucherList.length; i++) {
            if (voucherList[i] == null) {
                voucherList[i] = newVoucher;
                return newVoucher; // Voucher berhasil disimpan dan dikembalikan
            }
        }
        // Jika tidak ada slot kosong (array penuh), kembalikan null
        return null;
    }

    /**
     * getVoucherById(String id)
     * Mencari voucher berdasarkan ID dan mengembalikannya.
     * Jika tidak ditemukan, akan mengembalikan null.
     */
    // public Voucher getVoucherById(String id) {
    //     for (int i = 0; i < voucherList.length; i++) {
    //         if (voucherList[i] != null && voucherList[i].getId().equals(id)) {
    //             return voucherList[i];
    //         }
    //     }
    //     return null;
    // }
    public Voucher[] getAllVouchers() {
        return voucherList;
    }
    
}
