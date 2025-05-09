// Inheritance: Laptop mewarisi Barang
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
