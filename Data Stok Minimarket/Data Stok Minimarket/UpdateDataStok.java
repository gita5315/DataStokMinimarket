package prokel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
public class UpdateDataStok extends javax.swing.JFrame {
    
    private List<Minimarket> daftarMinimarket = new ArrayList();  //simpan objek Minimarket
    private Localhost data = new Localhost();  // mengelola data

    public UpdateDataStok() {
        initComponents();
    }
    //mengosongkan semua field input pada form
    public void clearField() { 
        isiNamaBarang.setText("");
        pilihanKategori.setSelectedIndex(0);
        isiJumlahStok.setText("");
        isiHargaSatuan.setText("");
    }
    // Dapat koneksi ke database Oracle menggunakan JDBC
    public Connection getConnection() { 
        String host = "localhost";
        String port = "1521";
        String db = "xe";
        String user = "hr";
        String password = "sukmawati351";
        Connection conn = null;
        // Memuat driver JDBC Oracle untuk memungkinkan koneksi ke database Oracle
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver tidak ditemukan");
            System.out.println("message:" + ex.getMessage());
        }
        // Membuat koneksi ke database Oracle menggunakan informasi host, port, database, username, dan password
        try {
            conn = DriverManager.getConnection("jdbc:oracle:thin:@" + host
                    + ":" + port + ":" + db, user, password);
        } catch (SQLException ex) {
            System.out.println("Koneksi gagal");
            System.out.println("message: " + ex.getMessage());
        }

        return conn;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        kodeBarang = new javax.swing.JLabel();
        namaBarang = new javax.swing.JLabel();
        kategori = new javax.swing.JLabel();
        jumlahStok = new javax.swing.JLabel();
        hargaSatuan = new javax.swing.JLabel();
        isiKodeBarang = new javax.swing.JTextField();
        isiNamaBarang = new javax.swing.JTextField();
        isiJumlahStok = new javax.swing.JTextField();
        isiHargaSatuan = new javax.swing.JTextField();
        pilihanKategori = new javax.swing.JComboBox<>();
        tombolSave = new javax.swing.JButton();
        tombolCancel = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Update Data Stok"));

        kodeBarang.setText("Kode Barang");

        namaBarang.setText("Nama Barang");

        kategori.setText("Kategori");

        jumlahStok.setText("Jumlah Stok");

        hargaSatuan.setText("Harga Satuan");

        pilihanKategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Pilih -- ", "Makanan ", "Minuman" }));

        tombolSave.setText("SAVE ");
        tombolSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolSaveActionPerformed(evt);
            }
        });

        tombolCancel.setText("CANCEL");
        tombolCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolCancelActionPerformed(evt);
            }
        });

        jLabel1.setText("RpX.X00");

        jLabel2.setText("3 Digit Angka");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(hargaSatuan, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jumlahStok, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kategori, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(namaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kodeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(tombolSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(tombolCancel))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(isiKodeBarang)
                            .addComponent(isiNamaBarang, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                            .addComponent(isiJumlahStok, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                            .addComponent(isiHargaSatuan, javax.swing.GroupLayout.DEFAULT_SIZE, 206, Short.MAX_VALUE)
                            .addComponent(pilihanKategori, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))))
                .addContainerGap(68, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(kodeBarang)
                            .addComponent(isiKodeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addComponent(namaBarang))
                    .addComponent(isiNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kategori)
                    .addComponent(pilihanKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jumlahStok)
                    .addComponent(isiJumlahStok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hargaSatuan)
                    .addComponent(isiHargaSatuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tombolSave)
                    .addComponent(tombolCancel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Metode yang dipanggil saat tombol "Cancel" ditekan
    private void tombolCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolCancelActionPerformed
        // Menampilkan JOptionPane untuk konfirmasi keluar
        int cancel = javax.swing.JOptionPane.showConfirmDialog(this,
                " Apakah Anda ingin keluar sekarang?",
                "Konfirmasi Keluar",
                javax.swing.JOptionPane.YES_NO_OPTION);

        // Jika pengguna memilih "Yes", maka frame ditutup
        if (cancel == javax.swing.JOptionPane.YES_OPTION) {
            this.dispose(); // Menutup jendela frame saat ini
        }
        // Jika memilih "No", maka tidak ada yang dilakukan, frame tetap terbuka
    }//GEN-LAST:event_tombolCancelActionPerformed
    // Metode yang dipanggil saat tombol "Save" ditekan
    private void tombolSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolSaveActionPerformed
        Connection conn = null;
        PreparedStatement ps = null;

        // Ambil koneksi ke database
        conn = this.getConnection();

        // Ambil nilai input dari form
        String kodBar = isiKodeBarang.getText();
        String namBar = isiNamaBarang.getText();
        String pilKate = (String) pilihanKategori.getSelectedItem();
        String jumStok = isiJumlahStok.getText();
        String harSatu = isiHargaSatuan.getText();

        // Validasi input
        if (kodBar.isEmpty() || namBar.isEmpty() || pilKate.isEmpty() || jumStok.isEmpty() || harSatu.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Semua kolom harus diisi!");
            return;
        }

        try {
            // Nonaktifkan auto-commit
            conn.setAutoCommit(false);

            // Query SQL untuk update data
            String sql = "UPDATE MINIMARKET SET NAMABARANG = ?, KATEGORI = ?, STOKTERSEDIA = ?, HARGA = ? WHERE KODEBARANG = ?";
            ps = conn.prepareStatement(sql);

            // Set parameter query
            ps.setString(1, namBar);
            ps.setString(2, pilKate);
            ps.setString(3, jumStok);
            ps.setString(4, harSatu);
            ps.setString(5, kodBar);

            // Eksekusi update
            int rowsAffected = ps.executeUpdate();

            // Commit perubahan ke database
            conn.commit();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Data berhasil diubah!");

                // Perbarui daftar lokal dengan data baru
                for (Minimarket item : daftarMinimarket) {
                    if (item.getKodeBarang().equals(kodBar)) {
                        item.setNamaBarang(namBar);
                        item.setKategori(pilKate);
                        item.setJumlahStok(jumStok);
                        item.setHargaSatuan(harSatu);
                        break;
                    }
                }
                clearField();
            } else {
                JOptionPane.showMessageDialog(this, "Kode Barang tidak ditemukan!");
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
            try {
                if (conn != null) {
                    conn.rollback();
                }
            } catch (SQLException Ex) {
                JOptionPane.showMessageDialog(this, "Error saat rollback: " + Ex.getMessage());
            }
        } finally {
            // Tutup koneksi dan prepared statement
            try {
                ps.close();
                conn.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "Error saat menutup koneksi: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_tombolSaveActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UpdateDataStok().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel hargaSatuan;
    private javax.swing.JTextField isiHargaSatuan;
    private javax.swing.JTextField isiJumlahStok;
    private javax.swing.JTextField isiKodeBarang;
    private javax.swing.JTextField isiNamaBarang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jumlahStok;
    private javax.swing.JLabel kategori;
    private javax.swing.JLabel kodeBarang;
    private javax.swing.JLabel namaBarang;
    private javax.swing.JComboBox<String> pilihanKategori;
    private javax.swing.JButton tombolCancel;
    private javax.swing.JButton tombolSave;
    // End of variables declaration//GEN-END:variables
}
