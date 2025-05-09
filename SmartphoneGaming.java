public // Inheritance bertingkat: SmartphoneGaming -> Smartphone -> Barang
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
