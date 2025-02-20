package prokel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;
public class TampilanStokData extends javax.swing.JFrame {

    private List<Minimarket> daftarMinimarket = new ArrayList();  // simpan objek Minimarket
    private Localhost data = new Localhost();  // mengelola data

    // Constructor tanpa parameter
    public TampilanStokData() {
        initializeData();
        initComponents();
        tombolDelete.setEnabled(false);

        // Menampilkan data di jTable
        MinimarketTableModel tableModel = new MinimarketTableModel(daftarMinimarket);
        lihatData.setModel(tableModel);
    }
    //menyegarkan data tabel dengan mengambil data terbaru dari database
    public void refreshTable() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            // Dapatkan koneksi ke database
            conn = this.getConnection();

           // Query untuk mengambil semua data dari tabel MINIMARKET dengan pengurutan
            String sql = "SELECT * FROM MINIMARKET ORDER BY KODEBARANG";
            ps = conn.prepareStatement(sql);

            // Eksekusi query
            rs = ps.executeQuery();

            // Kosongkan daftar lokal
            daftarMinimarket.clear();

            // Tambahkan data dari hasil query ke daftarMinimarket
            while (rs.next()) {
                String kodeBarang = rs.getString("KODEBARANG");
                String namaBarang = rs.getString("NAMABARANG");
                String kategori = rs.getString("KATEGORI");
                String stokTersedia = rs.getString("STOKTERSEDIA");
                String harga = rs.getString("HARGA");
                String supplier = rs.getString("SUPPLIER");

                // Tambahkan objek Minimarket ke daftar
                daftarMinimarket.add(new Minimarket(kodeBarang, namaBarang, kategori, stokTersedia, harga, supplier));
            }

            // Perbarui tabel dengan model baru
            MinimarketTableModel tableModel = new MinimarketTableModel(daftarMinimarket);
            lihatData.setModel(tableModel);

        } catch (SQLException ex) {
            // Menangani error jika terjadi masalah saat mengambil data
            JOptionPane.showMessageDialog(this, "Error saat memuat data: " + ex.getMessage());
        } finally {
            // Menutup ResultSet, PreparedStatement, dan Connection jika tidak lagi digunakan
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                // Menangani error saat menutup koneksi
                JOptionPane.showMessageDialog(this, "Error saat menutup koneksi: " + ex.getMessage());
            }
        }
    }
    //mendapatkan koneksi ke database Oracle
    public Connection getConnection() {
        String host = "localhost";
        String port = "1521";
        String db = "xe";
        String user = "hr";
        String password = "sukmawati351";
        Connection conn = null;
        try { // Memuat driver Oracle JDBC
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException ex) {// Menampilkan pesan error jika driver tidak ditemukan
            JOptionPane.showMessageDialog(this, "message:" + ex.getMessage());
        }

        try { // Membuat koneksi ke database menggunakan JDBC URL
            conn = DriverManager.getConnection("jdbc:oracle:thin:@" + host
                    + ":" + port + ":" + db, user, password);
        } catch (SQLException ex) {// Menampilkan pesan error jika koneksi gagal
            JOptionPane.showMessageDialog(this, "Koneksi gagal");
        }
        return conn;
    }
    // Inisialisasi data dari database ke dalam daftar minimarket
    private void initializeData() {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        conn = this.getConnection();  // Mendapatkan koneksi ke database
        try {
            // Membuat statement untuk menjalankan query
            st = conn.createStatement();
            // Query SQL untuk mengambil semua data dari tabel MINIMARKET
            String query = "Select * from minimarket";
            // Menjalankan query dan mendapatkan hasilnya
            rs = st.executeQuery(query);

            // Menambahkan data dari hasil query ke daftarMinimarket
            while (rs.next()) {
                daftarMinimarket.add(new Minimarket(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6)));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "message: " + ex.getMessage());
        } finally {
            try {
                // Menutup ResultSet, Statement, dan Connection setelah penggunaan
                rs.close();
                st.close();
                conn.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "message: " + ex.getMessage());
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        isiTabelData = new javax.swing.JScrollPane();
        lihatData = new javax.swing.JTable();
        tombolBack = new javax.swing.JButton();
        tombolDelete = new javax.swing.JButton();
        tombolUpdate = new javax.swing.JButton();
        pilihanFilterKategori = new javax.swing.JComboBox<>();
        tombolRefresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("DATA STOK "));

        lihatData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "KODE BARANG", "NAMA BARANG", "KATEGORI", "STOK TERSEDIA", "HARGA ", "SUPPLIER"
            }
        ));
        lihatData.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lihatDataMouseClicked(evt);
            }
        });
        isiTabelData.setViewportView(lihatData);

        tombolBack.setText("BACK");
        tombolBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolBackActionPerformed(evt);
            }
        });

        tombolDelete.setText("DELETE");
        tombolDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tombolDeleteMouseClicked(evt);
            }
        });
        tombolDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolDeleteActionPerformed(evt);
            }
        });

        tombolUpdate.setText("UPDATE");
        tombolUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolUpdateActionPerformed(evt);
            }
        });

        pilihanFilterKategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-FILTER KATEGORI- ", "Makanan", "Minuman" }));
        pilihanFilterKategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pilihanFilterKategoriActionPerformed(evt);
            }
        });

        tombolRefresh.setText("REFRESH");
        tombolRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(isiTabelData, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(tombolBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tombolRefresh)
                        .addGap(18, 18, 18)
                        .addComponent(pilihanFilterKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tombolUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tombolDelete)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(isiTabelData, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tombolDelete)
                    .addComponent(tombolUpdate)
                    .addComponent(pilihanFilterKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tombolBack)
                    .addComponent(tombolRefresh))
                .addGap(6, 6, 6))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // menutup jendela saat tombol "Back" ditekan
    private void tombolBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolBackActionPerformed
        this.dispose();
    }//GEN-LAST:event_tombolBackActionPerformed
    // memanggil fungsi refreshTable() saat tombol "Refresh" ditekan
    private void tombolRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolRefreshActionPerformed
        refreshTable();
    }//GEN-LAST:event_tombolRefreshActionPerformed
    // melakukan filter data tabel berdasarkan kategori yang dipilih
    private void pilihanFilterKategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pilihanFilterKategoriActionPerformed
        // Mendapatkan model tabel dari JTable
        MinimarketTableModel tableModel = (MinimarketTableModel) lihatData.getModel();

        // Membuat TableRowSorter untuk melakukan filter
        TableRowSorter<MinimarketTableModel> sorter = new TableRowSorter<>(tableModel);
        lihatData.setRowSorter(sorter); // Mengaitkan sorter ke tabel

        // Mendapatkan kategori yang dipilih
        String selectedCategory = (String) pilihanFilterKategori.getSelectedItem();

        // Logika filtering berdasarkan pilihan kategori
        if ("-FILTER KATEGORI-".equals(selectedCategory.trim())) {
            sorter.setRowFilter(null); // Menampilkan semua data jika tidak ada filter
        } else {
            sorter.setRowFilter(RowFilter.regexFilter(selectedCategory, 2)); // Filter kolom kategori (index ke-2)
        }
    }//GEN-LAST:event_pilihanFilterKategoriActionPerformed
    // membuka jendela UpdateDataStok saat tombol "Update" ditekan
    private void tombolUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolUpdateActionPerformed
        UpdateDataStok update = new UpdateDataStok(); //buat objek
        update.setVisible(true); //tampil frame 
    }//GEN-LAST:event_tombolUpdateActionPerformed

    private void tombolDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tombolDeleteMouseClicked

    }//GEN-LAST:event_tombolDeleteMouseClicked
    //menghapus data yang dipilih dari tabel saat tombol "Delete" ditekan
    private void tombolDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolDeleteActionPerformed
        Connection conn = null; //koneksi ke database.
        PreparedStatement ps = null; //mengeksekusi pernyataan SQL

        try {
            // Validasi: Pastikan ada baris yang dipilih di tabel
            int selectedRow = lihatData.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Pilih data yang ingin dihapus!");
                return;
            }

            int confirmation = JOptionPane.showConfirmDialog(
                    this,
                    "Apakah Anda yakin ingin menghapus data ini?",
                    "Konfirmasi Hapus",
                    JOptionPane.YES_NO_OPTION
            );

            // Jika pengguna memilih 'No', batalkan penghapusan
            if (confirmation == JOptionPane.NO_OPTION) {
                return;
            }
            // Ambil nilai kode barang dari tabel
            String kodeBarang = lihatData.getValueAt(selectedRow, 0).toString(); // Asumsi kolom 0 adalah KODEBARANG

            // Koneksi ke database
            conn = this.getConnection();

            // SQL DELETE query
            String sql = "DELETE FROM MINIMARKET WHERE KODEBARANG = ?";
            ps = conn.prepareStatement(sql);

            // Set parameter kode barang
            ps.setString(1, kodeBarang);

            // Eksekusi query
            int exeUpd = ps.executeUpdate();

            // Commit perubahan ke database
            conn.commit();

            if (exeUpd > 0) {
                JOptionPane.showMessageDialog(this, "Data berhasil dihapus!");

                // Hapus baris dari daftar tabel
                daftarMinimarket.remove(selectedRow);

                // Perbarui tampilan tabel
                refreshTable();
            } else {
                JOptionPane.showMessageDialog(this, "Gagal menghapus data!");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        } finally {
            // Tutup koneksi dan prepared statement
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error saat menutup koneksi: " + ex.getMessage());
            }
        }

    }//GEN-LAST:event_tombolDeleteActionPerformed

    private void lihatDataMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lihatDataMouseClicked
       // Mengaktifkan tombol "Delete" ketika pengguna mengklik baris pada tabel
        tombolDelete.setEnabled(true);
    }//GEN-LAST:event_lihatDataMouseClicked

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TampilanStokData().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane isiTabelData;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTable lihatData;
    private javax.swing.JComboBox<String> pilihanFilterKategori;
    private javax.swing.JButton tombolBack;
    private javax.swing.JButton tombolDelete;
    private javax.swing.JButton tombolRefresh;
    private javax.swing.JButton tombolUpdate;
    // End of variables declaration//GEN-END:variables
}
