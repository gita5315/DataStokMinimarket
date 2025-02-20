package prokel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class StokMinimarket extends javax.swing.JFrame {

    // u  simpan objek Minimarket
    private List<Minimarket> dataStokMinimarket = new ArrayList();

    public StokMinimarket() {
        initComponents();
    }

    // membersihkan (clear) semua field input di form
    public void clearField() {
        isiNamaBarang.setText("");
        pilihanKategori.setSelectedIndex(0);
        isiJumlahStok.setText("");
        isiHargaSatuan.setText("");
        isiSupplier.setText("");
    }
    // mendapatkan koneksi ke database Oracle

    public Connection getConnection() {
        String host = "localhost";
        String port = "1521";
        String db = "xe";
        String user = "hr";
        String password = "sukmawati351";
        Connection conn = null;
        try { //Coba memuat driver JDBC Oracle 
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException ex) { //Tampil error kalau driver gak ketemu
            JOptionPane.showMessageDialog(this, "Driver tidak ditemukan");
            JOptionPane.showMessageDialog(this, "message:" + ex.getMessage());
        }

        try {
            // Mencoba membuat koneksi ke database menggunakan parameter yang telah ditentukan
            conn = DriverManager.getConnection("jdbc:oracle:thin:@" + host
                    + ":" + port + ":" + db, user, password);
        } catch (SQLException ex) {//Tampil pesan error kalau gagal 
            JOptionPane.showMessageDialog(this, "Koneksi gagal");
        }
        return conn;
    }
    //Validasi format KodBar

    private boolean isValidKode(String kode) {
        // Pola yang diterima: dua angka di depan diikuti oleh satu atau dua angka, atau 1000
        String pattern = "^(?:[0-9]{2}[1-9]{1}|1000)$";
        return kode.matches(pattern); //Periksa KodBar sesuai apa tidak
    }
    //Validasi JumStok 

    private boolean isValidJumStok(String jumlahStok) {
        String pattern = "[0-9]{1,5}"; // Menerima angka 1 hingga 5 digit
        if (jumlahStok.matches(pattern)) {// sesuai dgn pola atau tidak 
            int stok = Integer.parseInt(jumlahStok);
            return stok > 0; // Memastikan stok lebih dari 0
        }
        return false; // Jika tidak sesuai pola, kembalikan false
    }

    //Validasi format harga 
    private boolean isValidHarga(String harga) {
        // Pola yang diterima:                             
        String pattern = "^Rp[0-9]{1,3}(?:\\.[0-9]{1}[0]{2})*$";
        return harga.matches(pattern);//Periksa sudah sesuai atau tidak 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelTitle = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
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
        tombolCancel = new javax.swing.JButton();
        tombolSimpan = new javax.swing.JButton();
        tombolLihatData = new javax.swing.JButton();
        hargaSatuan1 = new javax.swing.JLabel();
        isiSupplier = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        panelTitle.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Yu Gothic", 3, 24)); // NOI18N
        jLabel1.setText("STOK");

        javax.swing.GroupLayout panelTitleLayout = new javax.swing.GroupLayout(panelTitle);
        panelTitle.setLayout(panelTitleLayout);
        panelTitleLayout.setHorizontalGroup(
            panelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTitleLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(207, 207, 207))
        );
        panelTitleLayout.setVerticalGroup(
            panelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTitleLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Input Stok"));

        kodeBarang.setText("Kode Barang");

        namaBarang.setText("Nama Barang");

        kategori.setText("Kategori");

        jumlahStok.setText("Jumlah Stok");

        hargaSatuan.setText("Harga Satuan");

        isiHargaSatuan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isiHargaSatuanActionPerformed(evt);
            }
        });

        pilihanKategori.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Pilih -- ", "Makanan ", "Minuman " }));

        tombolCancel.setText("CANCEL");
        tombolCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolCancelActionPerformed(evt);
            }
        });

        tombolSimpan.setText("SIMPAN");
        tombolSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolSimpanActionPerformed(evt);
            }
        });

        tombolLihatData.setText("LIHAT DATA");
        tombolLihatData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolLihatDataActionPerformed(evt);
            }
        });

        hargaSatuan1.setText("Supplier");

        isiSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isiSupplierActionPerformed(evt);
            }
        });

        jLabel2.setText("3 Digit Angka");

        jLabel3.setText("RpX.X00");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(kategori, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pilihanKategori, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(kodeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(isiKodeBarang))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jumlahStok, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(isiJumlahStok))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(namaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(isiNamaBarang))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(hargaSatuan, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(tombolCancel)
                                        .addGap(18, 18, 18)
                                        .addComponent(tombolSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(isiHargaSatuan)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(hargaSatuan1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(isiSupplier)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tombolLihatData)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(21, 21, 21))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kodeBarang)
                    .addComponent(isiKodeBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(namaBarang)
                    .addComponent(isiNamaBarang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kategori)
                    .addComponent(pilihanKategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jumlahStok)
                    .addComponent(isiJumlahStok, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hargaSatuan)
                    .addComponent(isiHargaSatuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(hargaSatuan1)
                    .addComponent(isiSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tombolCancel)
                    .addComponent(tombolSimpan)
                    .addComponent(tombolLihatData))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 500, Short.MAX_VALUE))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(panelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 17, Short.MAX_VALUE))
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

    private void tombolSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolSimpanActionPerformed
        // Deklarasi variabel untuk koneksi ke database dan pernyataan SQL
        Connection conn = null;
        PreparedStatement ps = null;
        // Mendapatkan koneksi ke database
        conn = this.getConnection();
        // Deklarasi variabel untuk validasi data
        boolean isValid = true;
        String kodBar = null;
        String pilKate = null;
        String jumStok = null;
        String harSatu = null;
        String namBar, supp;
        // Validasi kode barang
        if (this.isValidKode(isiKodeBarang.getText())) {
            kodBar = isiKodeBarang.getText();
        } else {
            JOptionPane.showMessageDialog(this,
                    "Kode barang tidak valid! Pastikan kode terdiri dari 3 digit angka yang dimulai dengan angka 001 hingga 1000.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            isValid = false;
        }
        // Mengambil nama barang dari input
        namBar = isiNamaBarang.getText();
         // Validasi kategori barang
        if (pilihanKategori.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Tolong pilih kategori",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            isValid = false;
        } else {
            pilKate = pilihanKategori.getSelectedItem().toString();
        }
        // Validasi jumlah stok
        if (this.isValidJumStok(isiJumlahStok.getText())) {
            jumStok = isiJumlahStok.getText();
        } else {
            JOptionPane.showMessageDialog(this,
                    "Jumlah stok tidak valid! Pastikan jumlah stok terdiri dari angka antara 1 hingga 100 digit.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            isValid = false;
        }
        // Validasi harga satuan
        if (this.isValidHarga(isiHargaSatuan.getText())) {
            harSatu = isiHargaSatuan.getText();
        } else {
            JOptionPane.showMessageDialog(this,
                    "Harga tidak valid! Pastikan harga dimulai dengan 'Rp' dan diikuti dengan angka 1.000!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            isValid = false;
        }
        // Mengambil nama supplier dari input
        supp = isiSupplier.getText();
        // Menyiapkan pernyataan SQL untuk memasukkan data ke database
        try {
            ps = conn.prepareStatement("insert into minimarket values(?,?,?,?,?,?)");
            ps.setString(1, kodBar);
            ps.setString(2, namBar);
            ps.setString(3, pilKate);
            ps.setString(4, jumStok);
            ps.setString(5, harSatu);
            ps.setString(6, supp);
            ps.executeUpdate();// Mengeksekusi pernyataan SQL
            conn.commit();// Mengonfirmasi perubahan ke database

            if (isValid) {
                // Jika validasi berhasil, tambahkan data ke list stok minimarket
                dataStokMinimarket.add(new Minimarket(kodBar, namBar, pilKate, jumStok, harSatu, supp));
                 // Menampilkan pesan sukses dan membersihkan input
                JOptionPane.showMessageDialog(this, "Data berhasil Tersimpan");
                clearField();
            } else {
                JOptionPane.showMessageDialog(this, "Data gagal Tersimpan");
            }
            // Mengupdate kode barang berikutnya secara otomatis
            int kode = Integer.parseInt(isiKodeBarang.getText());
            kode++;
            /*
            format string untuk angka 
            %d --> bilangan bulat
            03 --> mastiin hasil minimal 3 digit kalo kurang angka 0 (+)an  di depan 
            */
            kodBar = String.format("%03d", kode);
            isiKodeBarang.setText(kodBar);

        } catch (SQLException ex) {
            // Menampilkan pesan error jika terjadi kesalahan saat menyimpan data
            JOptionPane.showMessageDialog(this, "message: " + ex.getMessage());
        } finally {
            try {
                // Menutup PreparedStatement dan koneksi ke database
                ps.close();
                conn.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, "message: " + ex.getMessage());
            }
        }
    }//GEN-LAST:event_tombolSimpanActionPerformed

    private void tombolLihatDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolLihatDataActionPerformed
        //Buat objek buat tampil data stok 
        TampilanStokData lihatData = new TampilanStokData(); // Kirim data
        lihatData.setVisible(true);//Tampil tampilan data stok 

    }//GEN-LAST:event_tombolLihatDataActionPerformed

    private void isiHargaSatuanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isiHargaSatuanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_isiHargaSatuanActionPerformed

    private void isiSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isiSupplierActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_isiSupplierActionPerformed

    private void tombolCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolCancelActionPerformed
        clearField(); //membersihkan semua input atau isian di form
    }//GEN-LAST:event_tombolCancelActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // Membuat objek StokMinimarket dan menampilkannya
                new StokMinimarket().setVisible(true);
                // Membuat objek Localhost dan menyembunyikannya
                Localhost bd = new Localhost();
                bd.setVisible(false);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel hargaSatuan;
    private javax.swing.JLabel hargaSatuan1;
    private javax.swing.JTextField isiHargaSatuan;
    private javax.swing.JTextField isiJumlahStok;
    private javax.swing.JTextField isiKodeBarang;
    private javax.swing.JTextField isiNamaBarang;
    private javax.swing.JTextField isiSupplier;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel jumlahStok;
    private javax.swing.JLabel kategori;
    private javax.swing.JLabel kodeBarang;
    private javax.swing.JLabel namaBarang;
    private javax.swing.JPanel panelTitle;
    private javax.swing.JComboBox<String> pilihanKategori;
    private javax.swing.JButton tombolCancel;
    private javax.swing.JButton tombolLihatData;
    private javax.swing.JButton tombolSimpan;
    // End of variables declaration//GEN-END:variables
}
