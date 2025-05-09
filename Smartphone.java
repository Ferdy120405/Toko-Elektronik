// Inheritance: Smartphone mewarisi Barang
// Polymorphism: Meng-override method getInfo
class Smartphone extends Barang {
    private String merk;
    private int ram;

    public Smartphone(String id, String nama, double harga, int stok, String merk, int ram) {
        super(id, nama, harga, stok); // Memanggil konstruktor dari superclass
        this.merk = merk;
        this.ram = ram;
    }

    @Override
    public String getInfo() {
        return super.getInfo() +           // Polymorphism: Memperluas getInfo dari superclass
               "\nMerk: " + merk +
               "\nRAM: " + ram + " GB";
    }
}
