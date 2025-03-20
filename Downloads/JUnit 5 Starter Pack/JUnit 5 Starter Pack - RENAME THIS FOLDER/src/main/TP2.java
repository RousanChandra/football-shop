package main;

import Model.*;
import Repository.*;

import java.util.Scanner;

import Model.Admin;
import Model.Pembeli;
import Model.Penjual;
import Model.Product;
import Model.Voucher;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class TP2 {
    private Scanner scanner;
    private AdminRepository adminRepo;
    private PembeliRepository pembeliRepo;
    private PenjualRepository penjualRepo;
    private LocalDate tanggal;
    private VoucherRepository voucherRepo;

    // Constructor: inisialisasi semua variabel
    public TP2() {
        this.scanner = new Scanner(System.in);
        this.adminRepo = new AdminRepository();   
        this.pembeliRepo = new PembeliRepository();
        this.penjualRepo = new PenjualRepository();
        this.tanggal = LocalDate.now();
        this.voucherRepo = new VoucherRepository();
    }
    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("\n  ____             _                 _____         _ _       \r\n" +
                           " |  _ \\           | |               |  __ \\       | (_)      \r\n" +
                           " | |_) |_   _ _ __| |__   __ _ _ __ | |__) |__  __| |_  __ _ \r\n" +
                           " |  _ <| | | | '__| '_ \\ / _` | '_ \\|  ___/ _ \\/ _` | |/ _` |\r\n" +
                           " | |_) | |_| | |  | | | | (_| | | | | |  |  __/ (_| | | (_| |\r\n" +
                           " |____/ \\__,_|_|  |_| |_|\\__,_|_| |_|_|   \\___|\\__,_|_|\\__,_|\r\n" +
                           "                                                             \r\n" +
                           "                                                             ");
        System.out.println("=============================================================");
        System.out.println("============== Selamat datang di Burhanpedia! ===============");
        System.out.println("=============================================================");
        
        TP2 app = new TP2();  // Membuat instance TP2 agar variabel non-static bisa diakses
        
        int perintah = 0;
        while (perintah != 4) {
            System.out.println("\nPilih menu:");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Hari Selanjutnya");
            System.out.println("4. Keluar");
            System.out.print("\nPerintah: ");
            perintah = app.scanner.nextInt();  // Mengakses scanner melalui instance app
            app.scanner.nextLine(); // Buang newline
    
            switch (perintah) {
                case 1:
                    app.login();
                    break;
                case 2:
                    app.register();
                    break;
                case 3:
                    app.hariSelanjutnya();
                    break;
                case 4:
                    System.out.println("===========================================");
                    System.out.println("Terima kasih telah menggunakan Burhanpedia!");
                    System.out.println("===========================================");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }

    // Metode login dengan pengecekan username dan password menggunakan isUsernameExist()
    public void login() {
        System.out.println("\n===== LOGIN =====");
        System.out.print("Masukkan username: ");
        String username = scanner.nextLine();
    
        // Cek di AdminRepository
        if (adminRepo.isUsernameExist(username)) {
            System.out.print("Masukkan password: ");
            String password = scanner.nextLine();
            if (adminRepo.login(username, password)) {
                Admin admin = adminRepo.getAdmin(username);
                System.out.println("Login berhasil! Anda login sebagai Admin.");
                menuAdmin(admin);
            } else {
                System.out.println("Password salah!");
            }
            return;
        }
    
        // Cek di PenjualRepository
        if (penjualRepo.isUsernameExist(username)) {
            System.out.print("Masukkan password: ");
            String password = scanner.nextLine();
            if (penjualRepo.login(username, password)) {
                System.out.println("Login berhasil! Anda login sebagai Penjual.");
                Penjual penjual = penjualRepo.getPenjual(username);
                System.out.println("Login berhasil! Anda login sebagai Penjual.");
                menuPenjual(penjual);
            } else {
                System.out.println("Password salah!");
            }
            return;
        }
    
        // Cek di PembeliRepository
        if (pembeliRepo.isUsernameExist(username)) {
            System.out.print("Masukkan password: ");
            String password = scanner.nextLine();
            if (pembeliRepo.login(username, password)) {
                System.out.println("Login berhasil! Anda login sebagai Pembeli.");
                Pembeli pembeli = pembeliRepo.getPembeli(username);
                System.out.println("Login berhasil! Anda login sebagai Pembeli.");
                menuPembeli(pembeli);
            } else {
                System.out.println("Password salah!");
            }
            return;
        }
        
        System.out.println("Akun tidak ditemukan!");
    }
    
    // Metode register (untuk Penjual dan Pembeli)
    public void register() {
        System.out.println("\n===== REGISTRASI =====");
        String username;
        // Loop meminta username hingga belum terpakai
        while (true) {
            System.out.print("Masukkan username: ");
            username = scanner.next();
            // Gunakan isUsernameExist() untuk pengecekan
            if (pembeliRepo.isUsernameExist(username) || penjualRepo.isUsernameExist(username)) {
                System.out.println("Username sudah ada!");
            } else {
                break;
            }
        }
        System.out.print("Masukkan password: ");
        String password = scanner.next();
    
        System.out.println("\nPilih role yang ingin didaftarkan:");
        System.out.println("1. Penjual");
        System.out.println("2. Pembeli");
        System.out.print("\nPilihan: ");
        int role = scanner.nextInt();
        scanner.nextLine(); // Buang newline
    
        switch (role) {
            case 1:
                String namaToko;
                // Loop meminta nama toko hingga belum terpakai (cek melalui daftar penjual)
                while (true) {
                    System.out.print("Masukkan nama toko: ");
                    namaToko = scanner.next();
                    boolean namaSudahAda = false;
                    Penjual[] daftarPenjual = penjualRepo.getList();
                    for (Penjual pen : daftarPenjual) {
                        if (pen != null && pen.getRepo().getNamaToko().equals(namaToko)) {
                            namaSudahAda = true;
                            break;
                        }
                    }
                    if (namaSudahAda) {
                        System.out.println("Nama toko sudah ada!");
                    } else {
                        break;
                    }
                }
                penjualRepo.register(username, password, namaToko);
                break;
            case 2:
                pembeliRepo.register(username, password);
                break;
            default:
                System.out.println("Pilihan tidak valid!");
        }
    }

    // Metode hariSelanjutnya
    public void hariSelanjutnya() {
        tanggal = tanggal.plusDays(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.of("id"));
        System.out.println("Tanggal sekarang: " + tanggal.format(formatter));
    }




    // Menu penjual
    public void menuPenjual(Penjual penjual) {
        int perintah = 0;
        while (perintah != 7) {
            System.out.println("\n===== MENU PENJUAL =====");
            System.out.println("1. Cek Produk");
            System.out.println("2. Tambah Produk");
            System.out.println("3. Tambah Stok");
            System.out.println("4. Ubah Harga Barang");
            System.out.println("5. Kirim Barang");
            System.out.println("6. Lihat Laporan Pendapatan");
            System.out.println("7. Kembali ke menu utama");
            System.out.print("\nPerintah: ");
            perintah = scanner.nextInt();


            switch (perintah) {
                case 1:
                    cekProduk(penjual);
                    break;
                case 2:
                    tambahProduk(penjual);
                    break;
                case 3:
                    tambahStok(penjual);
                    break;
                case 4:
                    ubahHargaBarang(penjual);
                    break;
                case 5:
                    kirimBarang(penjual);
                    break;
                case 6:
                    lihatLaporanPendapatan(penjual);
                    break;
                case 7:
                    System.out.println("Kembali ke menu utama...");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }
    public void menuPembeli(Pembeli pembeli) {
        int perintah = 0;
        while (perintah != 8) {
            System.out.println("\n===== MENU PEMBELI =====");
            System.out.println("1. Cek Saldo");
            System.out.println("2. Top Up Saldo");
            System.out.println("3. Cek Daftar Barang");
            System.out.println("4. Tambah Barang ke Keranjang");
            System.out.println("5. Checkout Keranjang");
            System.out.println("6. Lacak Barang");
            System.out.println("7. Lihat Laporan Pengeluaran");
            System.out.println("8. Kembali ke menu utama");
            System.out.print("\nPerintah: ");
            perintah = scanner.nextInt();
            scanner.nextLine(); // buang newline
    
            switch (perintah) {
                case 1:
                    cekSaldo(pembeli);
                    break;
                case 2:
                    topUpSaldo(pembeli);
                    break;
                case 3:
                    cekDaftarBarang(pembeli);
                    break;
                case 4:
                    tambahBarangKeKeranjang(pembeli);
                    break;
                case 5:
                    checkoutKeranjang(pembeli);
                    break;
                case 6:
                    lacakBarang(pembeli);
                    break;
                case 7:
                    lihatLaporanPengeluaran(pembeli);
                    break;
                case 8:
                    System.out.println("Kembali ke menu utama...");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }
    
    // Menu admin
    public void menuAdmin(Admin admin) {
        int pilihan = 0;
        while (pilihan != 3) {
            System.out.println("\n===== MENU ADMIN =====");
            System.out.println("1. Generate Voucher");
            System.out.println("2. Lihat Voucher");
            System.out.println("3. Kembali ke menu utama");
            System.out.print("\nPilihan: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    // Panggil generateVoucher
                    Voucher newVoucher = voucherRepo.generateVoucher();
                    System.out.println("Voucher berhasil dibuat: " + newVoucher.getId());
                    break;
                case 2:
                    // Ambil seluruh voucher
                    Voucher[] allVouchers = voucherRepo.getAllVouchers();

                    // Cek apakah ada voucher
                    boolean foundAny = false;
                    for (Voucher v : allVouchers) {
                        if (v != null) { 
                            foundAny = true;
                            String status = v.isUsed() ? "[sudah digunakan]" : "[belum digunakan]";
                            System.out.println("{" + v.getId() + "} " + status);
                        }
                    }

                    // Jika tidak ada voucher sama sekali (semuanya null), tampilkan pesan
                    if (!foundAny) {
                        System.out.println("\n==============================");
                        System.out.println("Belum ada voucher yang dibuat!");
                        System.out.println("================================");
                    }
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }

    // Berikut beberapa stub method untuk Penjual
    private void cekProduk(Penjual penjual) {
        System.out.println("\n===== Cek Produk =====");
        Product[] daftarProduk = penjual.getRepo().getProductList();
    
        boolean adaProduk = false;
        for (Product p : daftarProduk) {
            if (p != null) {
                adaProduk = true;
                System.out.println(
                    "Nama: " + p.getName() +
                    ", Stok: " + p.getStock() +
                    ", Harga: " + p.getPrice()
                );
            }
        }
    
        if (!adaProduk) {
            System.out.println("Belum ada produk di toko!");
        }
    }
    
    private void tambahProduk(Penjual penjual) {
        System.out.println("\n===== Tambah Produk =====");
    
        // Minta nama produk
        System.out.print("Masukkan nama produk: ");
        String nama = scanner.nextLine();
    
        // Cek apakah nama produk sudah ada (case-insensitive)
        if (penjual.getRepo().isProductExist(nama)) {
            System.out.println("Nama produk sudah ada!");
            return;
        }
    
        // Minta stok (pastikan benar-benar angka)
        System.out.print("Masukkan stok produk: ");
        String stokStr = scanner.nextLine(); // Baca sebagai String dulu
        int stok;
        try {
            stok = Integer.parseInt(stokStr);
        } catch (NumberFormatException e) {
            System.out.println("Stok harus berupa angka!");
            return;
        }
        // Cek stok tidak negatif atau nol
        if (stok <= 0) {
            System.out.println("Stok tidak boleh bernilai 0 atau negatif!");
            return;
        }
    
        // Minta harga (pastikan benar-benar angka)
        System.out.print("Masukkan harga produk: ");
        String hargaStr = scanner.nextLine();
        double harga;
        try {
            harga = Double.parseDouble(hargaStr);
        } catch (NumberFormatException e) {
            System.out.println("Harga harus berupa angka!");
            return;
        }
        // Cek harga tidak negatif atau nol
        if (harga <= 0) {
            System.out.println("Harga tidak boleh bernilai 0 atau negatif!");
            return;
        }
    
        // Tambahkan produk ke repository
        penjual.getRepo().addProduct(nama, harga, stok);
        System.out.println("Produk berhasil ditambahkan!");
    }
    
    private void tambahStok(Penjual penjual) {
        System.out.println("\n===== Tambah Stok =====");

        // 1. Pastikan toko punya produk
        Product[] daftarProduk = penjual.getRepo().getProductList();
        boolean adaProduk = false;
        for (Product p : daftarProduk) {
            if (p != null) {
                adaProduk = true;
                break;
            }
        }
        if (!adaProduk) {
            System.out.println("Toko belum memiliki produk!");
            return; // Kembali ke menu penjual
        }
    
        // 2. Minta nama produk
        System.out.print("Masukkan nama produk yang ingin ditambah stok: ");
        String nama = scanner.nextLine();
    
        // 3. Cari produk berdasarkan nama (case-insensitive)
        Product foundProduct = null;
        for (Product p : daftarProduk) {
            if (p != null && p.getName().equalsIgnoreCase(nama)) {
                foundProduct = p;
                break;
            }
        }
    
        if (foundProduct == null) {
            // Produk tidak ditemukan
            System.out.println("Produk tidak ditemukan!");
            return; // Kembali ke menu penjual
        }
    
        // 4. Minta jumlah stok yang akan ditambah (harus angka positif)
        System.out.print("Masukkan jumlah stok yang ingin ditambah: ");
        String stokStr = scanner.nextLine();
        int stokTambah;
    
        try {
            stokTambah = Integer.parseInt(stokStr);
        } catch (NumberFormatException e) {
            System.out.println("Stok harus berupa angka!");
            return;
        }
    
        if (stokTambah < 0) {
            System.out.println("Stok tidak boleh bernilai negatif!");
            return;
        } else if (stokTambah == 0) {
            System.out.println("Jumlah stok bernilai 0, tidak bertambah!");
            return;
        }
    
        // 5. Tambahkan stok
        int stokLama = foundProduct.getStock();
        foundProduct.setStock(stokLama + stokTambah);
        System.out.println("Stok berhasil ditambah! Stok baru: " + foundProduct.getStock());
    }
    
    private void ubahHargaBarang(Penjual penjual) {
        System.out.println("\n===== Ubah Harga Barang =====");

        // 1. Pastikan toko punya produk
        Product[] daftarProduk = penjual.getRepo().getProductList();
        boolean adaProduk = false;
        for (Product p : daftarProduk) {
            if (p != null) {
                adaProduk = true;
                break;
            }
        }
        if (!adaProduk) {
            System.out.println("Toko belum memiliki produk!");
            return; // kembali ke menu penjual
        }
    
        // 2. Minta nama produk
        System.out.print("Masukkan nama produk yang ingin diubah harganya: ");
        String nama = scanner.nextLine();
    
        // 3. Cari produk berdasarkan nama (case-insensitive)
        Product foundProduct = null;
        for (Product p : daftarProduk) {
            if (p != null && p.getName().equalsIgnoreCase(nama)) {
                foundProduct = p;
                break;
            }
        }
    
        if (foundProduct == null) {
            System.out.println("Produk tidak ditemukan!");
            return; // kembali ke menu penjual
        }
    
        // 4. Minta harga baru (pastikan numerik)
        System.out.print("Masukkan harga baru: ");
        String hargaStr = scanner.nextLine();
        double hargaBaru;
        try {
            hargaBaru = Double.parseDouble(hargaStr);
        } catch (NumberFormatException e) {
            System.out.println("Harga harus berupa angka!");
            return;
        }
    
        // 5. Cek apakah harga negatif atau 0
        if (hargaBaru <= 0) {
            System.out.println("Harga tidak boleh bernilai negatif atau 0!");
            return;
        }
    
        // 6. Ubah harga
        foundProduct.setPrice(hargaBaru);
        System.out.println("Harga berhasil diubah! Harga baru: " + foundProduct.getPrice());
    }
    
    private void kirimBarang(Penjual penjual) {
        // Pengiriman[] daftarPengiriman = penjual.getPengirimanList(); 
        boolean adaYangBelumDikirim = false;
    
        // for (Pengiriman pg : daftarPengiriman) {
        //     if (pg != null && !pg.isSent()) {
        //         // Barang ini belum dikirim, kita kirim
        //         pg.setSent(true);
        //         adaYangBelumDikirim = true;
        //         System.out.println("Barang dengan ID " + pg.getId() + " berhasil dikirim!");
        //     }
        // }
    
        if (!adaYangBelumDikirim) {
            System.out.println("Tidak ada barang yang perlu dikirim!");
        }
    }
    
    private void lihatLaporanPendapatan(Penjual penjual) {
        System.out.println("Laporan pendapatan (belum diimplementasi)");
    }
    

    private void cekSaldo(Pembeli pembeli) {
        System.out.println("\n===== Cek Saldo =====");
        long saldo = pembeli.getBalance();
        System.out.println("Saldo Anda saat ini: " + saldo);
    }
    
    private void topUpSaldo(Pembeli pembeli) {
        System.out.println("\n===== Top Up Saldo =====");
        System.out.print("Masukkan jumlah top up: ");
        String input = scanner.nextLine();

        long nominal;
        try {
            nominal = Long.parseLong(input);
        } catch (NumberFormatException e) {
            System.out.println("Saldo tidak boleh bernilai non-numerik!");
            return;
        }

        if (nominal <= 0) {
            if (nominal < 0) {
                System.out.println("Saldo tidak boleh bernilai negatif!");
            } else {
                System.out.println("Jumlah top up tidak bertambah (0)!");
            }
            return;
        }

        // Tambahkan saldo ke pembeli
        pembeli.addBalance(nominal);
        System.out.println("Top up berhasil! Saldo Anda sekarang: " + pembeli.getBalance());
        }

    private void cekDaftarBarang(Pembeli pembeli) {
        Penjual[] semuaPenjual = penjualRepo.getList(); 
    boolean adaBarang = false;

    // Loop penjual
    for (Penjual penjual : semuaPenjual) {
        if (penjual != null) {
            // Ambil productList dari penjual ini
            Product[] daftarProduk = penjual.getRepo().getProductList();
            for (Product p : daftarProduk) {
                if (p != null) {
                    adaBarang = true;
                    // Tampilkan info produk
                    System.out.println(
                        "Toko: " + penjual.getRepo().getNamaToko() + 
                        " | Nama: " + p.getName() +
                        " | Harga: " + p.getPrice() +
                        " | Stok: " + p.getStock()
                    );
                }
            }
        }
    }

    if (!adaBarang) {
        System.out.println("Belum ada barang yang dijual!");
    }
}
    private void tambahBarangKeKeranjang(Pembeli pembeli) {
        System.out.println("\n===== Tambah Barang ke Keranjang =====");
    
        // 1. Pastikan ada setidaknya satu produk di seluruh penjual
        Penjual[] semuaPenjual = penjualRepo.getList();
        boolean adaBarang = false;
        for (Penjual pen : semuaPenjual) {
            if (pen != null) {
                Product[] daftarProduk = pen.getRepo().getProductList();
                for (Product p : daftarProduk) {
                    if (p != null) {
                        adaBarang = true;
                        break;
                    }
                }
            }
            if (adaBarang) break;
        }
        if (!adaBarang) {
            System.out.println("Belum ada barang yang dijual!");
            return; // Kembali ke menu pembeli
        }
    
        // 2. Minta user memasukkan nama toko
        System.out.print("Masukkan nama toko: ");
        String namaToko = scanner.nextLine();
    
        // Cari penjual dengan nama toko tersebut (case-insensitive)
        Penjual penjualDipilih = null;
        for (Penjual pen : semuaPenjual) {
            if (pen != null) {
                // Bandingkan dengan pen.getRepo().getNamaToko()
                if (pen.getRepo().getNamaToko().equalsIgnoreCase(namaToko)) {
                    penjualDipilih = pen;
                    break;
                }
            }
        }
    
        // Jika penjual tidak ditemukan
        if (penjualDipilih == null) {
            System.out.println("Toko tidak ditemukan!");
            return; // Kembali ke menu pembeli
        }
    
        // 3. Minta user memasukkan nama produk
        System.out.print("Masukkan nama produk: ");
        String namaProduk = scanner.nextLine();
    
        // Cari produk di penjualDipilih (case-insensitive)
        Product[] produkToko = penjualDipilih.getRepo().getProductList();
        Product produkDipilih = null;
        for (Product p : produkToko) {
            if (p != null && p.getName().equalsIgnoreCase(namaProduk)) {
                produkDipilih = p;
                break;
            }
        }
    
        // Jika produk tidak ditemukan
        if (produkDipilih == null) {
            System.out.println("Produk tidak ditemukan!");
            return; // Kembali ke menu pembeli
        }
    
        // 4. Minta user memasukkan jumlah produk
        System.out.print("Masukkan jumlah produk yang ingin dibeli: ");
        int jumlah = scanner.nextInt();
        scanner.nextLine(); // Buang newline
    
        // Cek jumlah valid
        if (jumlah <= 0) {
            System.out.println("Jumlah produk tidak valid!");
            return;
        }
        if (jumlah > produkDipilih.getStock()) {
            System.out.println("Jumlah produk melebihi batas!");
            return;
        }
    
        // 5. Tambahkan ke keranjang
        // Asumsikan Cart punya method addToCart(UUID productId, int quantity)
        pembeli.getCart().addToCart(produkDipilih.getProductID(), jumlah);
        System.out.println("Barang berhasil ditambahkan ke keranjang!");
    
        // 6. Kurangi stok
        produkDipilih.setStock(produkDipilih.getStock() - jumlah);
    }
        
    private void checkoutKeranjang(Pembeli pembeli) {
        // Proses pembelian, potong saldo, tandai barang dibeli, dsb.
        System.out.println("Checkout Keranjang (belum diimplementasi)");
    }
    private void lacakBarang(Pembeli pembeli) {
        // Lacak status pengiriman barang
        System.out.println("Lacak Barang (belum diimplementasi)");
    }
    private void lihatLaporanPengeluaran(Pembeli pembeli) {
        // Tampilkan total pengeluaran, riwayat pembelian, dsb.
        System.out.println("Lihat Laporan Pengeluaran (belum diimplementasi)");
    }
}