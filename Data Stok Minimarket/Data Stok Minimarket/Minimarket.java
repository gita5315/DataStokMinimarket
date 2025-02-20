package prokel;
public class Minimarket {
    private String kodeBarang;
    private String namaBarang;
    private String kategori;
    private String jumlahStok;
    private String hargaSatuan;
    private String supplier;
    
    // Konstruktor untuk menginisialisasi objek Minimarket dengan data barang
    public Minimarket(String kodeBarang, String namaBarang, String kategori, String jumlahStok, String hargaSatuan, String supplier) {
        this.kodeBarang = kodeBarang; 
        this.namaBarang = namaBarang;  
        this.kategori = kategori;  
        this.jumlahStok = jumlahStok; 
        this.hargaSatuan = hargaSatuan;  
        this.supplier = supplier;    
    }

    // Getter dan setter untuk atribut kodeBarang
    public String getKodeBarang() {
        return kodeBarang;
    }

    public void setKodeBarang(String kodeBarang) {
        this.kodeBarang = kodeBarang;
    }

    // Getter dan setter untuk atribut namaBarang
    public String getNamaBarang() {
        return namaBarang;
    }

    public void setNamaBarang(String namaBarang) {
        this.namaBarang = namaBarang;
    }

    // Getter dan setter untuk atribut kategori
    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    // Getter dan setter untuk atribut jumlahStok
    public String getJumlahStok() {
        return jumlahStok;
    }

    public void setJumlahStok(String jumlahStok) {
        this.jumlahStok = jumlahStok;
    }

    // Getter dan setter untuk atribut hargaSatuan
    public String getHargaSatuan() {
        return hargaSatuan;
    }

    public void setHargaSatuan(String hargaSatuan) {
        this.hargaSatuan = hargaSatuan;
    }

    // Getter dan setter untuk atribut supplier
    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
}
