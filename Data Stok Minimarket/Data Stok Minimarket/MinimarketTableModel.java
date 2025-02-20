package prokel;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
//  sebagai model tabel
public class MinimarketTableModel extends AbstractTableModel {

    // Daftar untuk menyimpan data Minimarket
    private List<Minimarket> daftarMinimarket = new ArrayList<>();

    // Konstruktor untuk menginisialisasi daftar minimarket
    public MinimarketTableModel(List<Minimarket> mhs) {
        this.daftarMinimarket = mhs;  
    }
    
    // Mengembalikan jumlah baris (data) dalam tabel
    @Override
    public int getRowCount() {
        return daftarMinimarket.size(); 
    }

    // Mengembalikan jumlah kolom dalam tabel (6 kolom)
    @Override
    public int getColumnCount() {
        return 6;  
    }

    // Mengambil nilai data pada baris dan kolom tertentu
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        // Ambil data minimarket berdasarkan indeks baris
        Minimarket mm = daftarMinimarket.get(rowIndex);  
        switch (columnIndex) {
            case 0:
                return mm.getKodeBarang(); 
            case 1:
                return mm.getNamaBarang();  
            case 2:
                return mm.getKategori(); 
            case 3:
                return mm.getJumlahStok(); 
            case 4:
                return mm.getHargaSatuan(); 
            case 5:
                return mm.getSupplier();
            default:
                return ""; 
        }
    }

    // Mengambil nama kolom untuk header tabel
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "KODEBARANG";  
            case 1:
                return "NAMABARANG";  
            case 2:
                return "KATEGORI";  
            case 3:
                return "STOKTERSEDIA";  
            case 4:
                return "HARGA";
            case 5:
                return "SUPPLIER"; 
            default:
                return ""; 
        }
    }
}
