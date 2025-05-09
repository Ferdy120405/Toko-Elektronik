// Abstraction: Membuat representasi umum dari barang
// Encapsulation: Menyembunyikan detail data dengan private dan mengakses melalui getter/setter
class Barang {
    private String id;
    private String nama;
    private double harga;
    private int stok;

    public Barang(String id, String nama, double harga, int stok) {
        this.id = id;
        this.nama = nama;
        this.harga = harga;
        this.stok = stok;
    }

    // Getter dan Setter -> bagian dari Encapsulation
    public String getId() { return id; }
    public String getNama() { return nama; }
    public double getHarga() { return harga; }
    public int getStok() { return stok; }
    public void setStok(int stok) { this.stok = stok; }
    public void setHarga(double harga) { this.harga = harga; }

    public String getInfo() {
        return "ID: " + id +
               "\nNama: " + nama +
               "\nHarga: Rp " + String.format("%.2f", harga) +
               "\nStok: " + stok;
    }
}
