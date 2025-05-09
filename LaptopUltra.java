// Inheritance bertingkat: LaptopUltrabook -> Laptop -> Barang
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
