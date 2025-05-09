import java.util.ArrayList;
import java.util.Scanner;

// (superclass) Barang mewakili konsep(abstraksi)
class Barang {
    // Konsep ENCAPSULATION -> atribut disembunyikan dengan private
    private String id;
    private String nama;
    private double harga;
    private int stok;

    // Constructor: digunakan untuk inisialisasi objek
    public Barang(String id, String nama, double harga, int stok) {
        this.id = id;
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    // Getter & Setter -> akses terbatas terhadap data (ENCAPSULATION)
    public String getId() { return id; }
    public String getNama() { return nama; }
    public double getHarga() { return harga; }
    public int getStok() { return stok; }
    public void setStok(int stok) { this.stok = stok; }
    public void setHarga(double harga) { this.harga = harga; }

    // Method umum yang dapat dioverride (POLYMORPHISM)
    public String getInfo() {
        return "ID: " + id +
               "\nNama: " + nama +
               "\nHarga: Rp " + String.format("%.2f", harga) +
               "\nStok: " + stok;
    }
}

// INHERITANCE: Smartphone mewarisi Barang
class Smartphone extends Barang {
    private String merk;
    private int ram;

    public Smartphone(String id, String nama, double harga, int stok, String merk, int ram) {
        super(id, nama, harga, stok); // Memanggil constructor superclass
        this.merk = merk;
        this.ram = ram;
    }

    // POLYMORPHISM: method getInfo dioverride
    @Override
    public String getInfo() {
        return super.getInfo() +
               "\nMerk: " + merk +
               "\nRAM: " + ram + " GB";
    }
}

// INHERITANCE & POLYMORPHISM: SmartphoneGaming adalah turunan dari Smartphone
class SmartphoneGaming extends Smartphone {
    private int refreshRate;

    public SmartphoneGaming(String id, String nama, double harga, int stok,
                            String merk, int ram, int refreshRate) {
        super(id, nama, harga, stok, merk, ram);
        this.refreshRate = refreshRate;
    }

    @Override
    public String getInfo() {
        return super.getInfo() +
               "\nRefresh Rate: " + refreshRate + " Hz";
    }
}

// INHERITANCE: Laptop adalah turunan dari Barang
class Laptop extends Barang {
    private String processor;
    private String storage;

    public Laptop(String id, String nama, double harga, int stok,
                  String processor, String storage) {
        super(id, nama, harga, stok);
        this.processor = processor;
        this.storage = storage;
    }

    @Override
    public String getInfo() {
        return super.getInfo() +
               "\nProcessor: " + processor +
               "\nStorage: " + storage;
    }
}

// INHERITANCE & POLYMORPHISM: LaptopUltrabook adalah subclass dari Laptop
class LaptopUltrabook extends Laptop {
    private double berat;

    public LaptopUltrabook(String id, String nama, double harga, int stok,
                           String processor, String storage, double berat) {
        super(id, nama, harga, stok, processor, storage);
        this.berat = berat;
    }

    @Override
    public String getInfo() {
        return super.getInfo() +
               "\nBerat: " + berat + " kg";
    }
}

public class TokoElektronikPlus {
    // ENCAPSULATION: daftarBarang disimpan sebagai koleksi privat
    private static ArrayList<Barang> daftarBarang = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static int idCounter = 5;

    public static void main(String[] args) {
        inisialisasiData(); // memisahkan logika inisialisasi
        tampilkanMenu();    // memisahkan logika UI
    }

    private static void inisialisasiData() {
        // daftarBarang dapat menyimpan semua objek turunan dari Barang
        daftarBarang.add(new Smartphone("SP01", "Galaxy S22", 23000000, 10, "Samsung", 12));
        daftarBarang.add(new SmartphoneGaming("SG01", "ROG Phone", 15000000, 5, "Asus", 16, 144));
        daftarBarang.add(new Laptop("LP01", "ThinkPad X1", 18000000, 7, "Intel i7", "512GB SSD"));
        daftarBarang.add(new LaptopUltrabook("UL01", "MacBook Air M2", 20000000, 3, "Apple M2", "1TB SSD", 1.2));
    }

    private static void tampilkanMenu() {
        while (true) {
            System.out.println("\n=== MENU TOKO ELEKTRONIK ===");
            System.out.println("1. Tampilkan Daftar Barang");
            System.out.println("2. Tambah Barang Baru");
            System.out.println("3. Tambah Stok Barang");
            System.out.println("4. Cari Barang");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu (1-5): ");

            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1 -> tampilkanDaftarBarang();
                case 2 -> tambahBarangBaru();
                case 3 -> tambahStokBarang();
                case 4 -> cariBarang();
                case 5 -> {
                    System.out.println("Terima kasih telah menggunakan program!");
                    System.exit(0);
                }
                default -> System.out.println("Pilihan tidak valid!");
            }
        }
    }

    private static void tampilkanDaftarBarang() {
        System.out.println("\n=== DAFTAR BARANG TOKO ===");
        for (Barang barang : daftarBarang) {
            // POLYMORPHISM: method getInfo yang dipanggil sesuai tipe objek aslinya
            System.out.println("\n--------------------------");
            System.out.println(barang.getInfo());
        }
    }

    private static void tambahBarangBaru() {
        System.out.println("\n=== TAMBAH BARANG BARU ===");
        System.out.println("Pilih jenis barang:");
        System.out.println("1. Smartphone Biasa");
        System.out.println("2. Smartphone Gaming");
        System.out.println("3. Laptop Biasa");
        System.out.println("4. Laptop Ultrabook");
        System.out.print("Pilih jenis (1-4): ");
        int jenis = scanner.nextInt();
        scanner.nextLine();

        String id = generateID(jenis);
        System.out.println("ID Barang: " + id);

        System.out.print("Nama Barang: ");
        String nama = scanner.nextLine();

        System.out.print("Harga Barang: Rp ");
        double harga = scanner.nextDouble();

        System.out.print("Stok Awal: ");
        int stok = scanner.nextInt();
        scanner.nextLine();

        switch (jenis) {
            case 1 -> {
                System.out.print("Merk: ");
                String merk = scanner.nextLine();
                System.out.print("RAM (GB): ");
                int ram = scanner.nextInt();
                daftarBarang.add(new Smartphone(id, nama, harga, stok, merk, ram));
            }
            case 2 -> {
                System.out.print("Merk: ");
                String merkGaming = scanner.nextLine();
                System.out.print("RAM (GB): ");
                int ramGaming = scanner.nextInt();
                System.out.print("Refresh Rate (Hz): ");
                int refreshRate = scanner.nextInt();
                daftarBarang.add(new SmartphoneGaming(id, nama, harga, stok, merkGaming, ramGaming, refreshRate));
            }
            case 3 -> {
                scanner.nextLine();
                System.out.print("Processor: ");
                String processor = scanner.nextLine();
                System.out.print("Storage: ");
                String storage = scanner.nextLine();
                daftarBarang.add(new Laptop(id, nama, harga, stok, processor, storage));
            }
            case 4 -> {
                scanner.nextLine();
                System.out.print("Processor: ");
                String processorUltra = scanner.nextLine();
                System.out.print("Storage: ");
                String storageUltra = scanner.nextLine();
                System.out.print("Berat (kg): ");
                double berat = scanner.nextDouble();
                daftarBarang.add(new LaptopUltrabook(id, nama, harga, stok, processorUltra, storageUltra, berat));
            }
            default -> {
                System.out.println("Jenis barang tidak valid!");
                return;
            }
        }

        System.out.println("Barang berhasil ditambahkan!");
    }

    private static String generateID(int jenis) {
        String prefix = switch (jenis) {
            case 1 -> "SP";
            case 2 -> "SG";
            case 3 -> "LP";
            case 4 -> "UL";
            default -> "XX";
        };
        return prefix + String.format("%02d", idCounter++);
    }

    private static void tambahStokBarang() {
        tampilkanDaftarBarang();
        System.out.print("\nMasukkan ID Barang: ");
        String idBarang = scanner.nextLine();

        Barang barangDipilih = null;
        for (Barang barang : daftarBarang) {
            if (barang.getId().equalsIgnoreCase(idBarang)) {
                barangDipilih = barang;
                break;
            }
        }

        if (barangDipilih == null) {
            System.out.println("Barang tidak ditemukan!");
            return;
        }

        System.out.print("Masukkan Jumlah Stok yang Ditambahkan: ");
        int jumlah = scanner.nextInt();
        scanner.nextLine();

        barangDipilih.setStok(barangDipilih.getStok() + jumlah);
        System.out.println("Stok berhasil ditambahkan!");
    }

    private static void cariBarang() {
        System.out.print("\nMasukkan Nama Barang yang Dicari: ");
        String keyword = scanner.nextLine().toLowerCase();

        boolean ditemukan = false;
        for (Barang barang : daftarBarang) {
            if (barang.getNama().toLowerCase().contains(keyword)) {
                System.out.println("\n--------------------------");
                System.out.println(barang.getInfo());
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println("Tidak ditemukan barang dengan nama tersebut!");
        }
    }
}