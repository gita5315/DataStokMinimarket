package prokel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class Localhost extends javax.swing.JFrame {
    /* Deklarasi variabel untuk menyimpan username dan password
    untuk menyimpan nilai.*/
    private String username;
    private String password;

    public Localhost() {
        initComponents();//untuk menginisialisasi komponen GUI
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        panelPengaturan = new javax.swing.JPanel();
        isiUsername = new javax.swing.JTextField();
        tombolSambungkan = new javax.swing.JButton();
        tombolKeluar = new javax.swing.JButton();
        isiPassword = new javax.swing.JPasswordField();
        Passwoard = new javax.swing.JLabel();
        Username = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelPengaturan.setBackground(new java.awt.Color(204, 204, 204));
        panelPengaturan.setBorder(javax.swing.BorderFactory.createTitledBorder("Pengaturan"));

        isiUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                isiUsernameActionPerformed(evt);
            }
        });
        isiUsername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                isiUsernameKeyPressed(evt);
            }
        });

        tombolSambungkan.setText("Sambungkan");
        tombolSambungkan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tombolSambungkanMouseClicked(evt);
            }
        });
        tombolSambungkan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolSambungkanActionPerformed(evt);
            }
        });

        tombolKeluar.setText("Keluar");
        tombolKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolKeluarActionPerformed(evt);
            }
        });

        Passwoard.setText("passwoard");

        Username.setText("Username");

        javax.swing.GroupLayout panelPengaturanLayout = new javax.swing.GroupLayout(panelPengaturan);
        panelPengaturan.setLayout(panelPengaturanLayout);
        panelPengaturanLayout.setHorizontalGroup(
            panelPengaturanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPengaturanLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(panelPengaturanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Passwoard, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Username, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelPengaturanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(isiUsername)
                    .addComponent(isiPassword, javax.swing.GroupLayout.DEFAULT_SIZE, 163, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPengaturanLayout.createSequentialGroup()
                .addContainerGap(86, Short.MAX_VALUE)
                .addComponent(tombolSambungkan)
                .addGap(18, 18, 18)
                .addComponent(tombolKeluar)
                .addGap(95, 95, 95))
        );
        panelPengaturanLayout.setVerticalGroup(
            panelPengaturanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPengaturanLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addGroup(panelPengaturanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(isiUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Username))
                .addGap(18, 18, 18)
                .addGroup(panelPengaturanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(isiPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Passwoard))
                .addGap(32, 32, 32)
                .addGroup(panelPengaturanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tombolSambungkan)
                    .addComponent(tombolKeluar))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(panelPengaturan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(panelPengaturan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Event handler untuk tombol Keluar
    private void tombolKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolKeluarActionPerformed
        int konfirmasi = JOptionPane.showConfirmDialog(this,
                "Apakah Anda yakin ingin keluar?",
                "Konfirmasi Keluar",
                JOptionPane.YES_NO_OPTION);

        if (konfirmasi == JOptionPane.YES_OPTION) {
            System.exit(0); // Mengakhiri program
        }
    }//GEN-LAST:event_tombolKeluarActionPerformed
    // Event handler untuk tombol Sambungkan --> menyambungkan ke database atau server
    private void tombolSambungkanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolSambungkanActionPerformed
        getConnection();
    }//GEN-LAST:event_tombolSambungkanActionPerformed

    private void tombolSambungkanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tombolSambungkanMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tombolSambungkanMouseClicked

    private void isiUsernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_isiUsernameKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_isiUsernameKeyPressed

    private void isiUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_isiUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_isiUsernameActionPerformed
   
    public Connection getConnection() {
        username = isiUsername.getText();
        password = isiPassword.getText();

        String host = "localhost";
        String port = "1521";

        String db = "xe";
        Connection conn = null; //koneksi ke database
        try { // Memuat driver JDBC untuk Oracle
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException ex) { 
            // Jika driver tidak ditemukan, tampilkan pesan error di konsol
            System.out.println("Driver tidak ditemukan");
            System.out.println("message:" + ex.getMessage());
        }
        /*
        Mencoba melakukan koneksi ke database menggunakan DriverManager
        URL koneksi diambil dari host, port, dan database yang telah ditentukan
        */
        try {
            conn = DriverManager.getConnection("jdbc:oracle:thin:@" + host
                    + ":" + port + ":" + db, username, password);
        } catch (SQLException ex) {
            // Jika gagal menghubungkan, tampilkan pesan error menggunakan JOptionPane
            JOptionPane.showMessageDialog(this, "message: " + ex.getMessage());
        }
        if (conn != null) {// Jika koneksi berhasil
            JOptionPane.showMessageDialog(this, "Koneksi berhasil");
            // Membuka jendela baru untuk StokMinimarket
            StokMinimarket sambung = new StokMinimarket();
            sambung.setVisible(true);

            setVisible(false);//Tutup Jendela 
        } else { //Jika koneksi gagal tampil pesan error 
            JOptionPane.showMessageDialog(this, "Koneksi Gagal");
        }
        return conn;
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Localhost().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Passwoard;
    private javax.swing.JLabel Username;
    private javax.swing.JPasswordField isiPassword;
    private javax.swing.JTextField isiUsername;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel panelPengaturan;
    private javax.swing.JButton tombolKeluar;
    private javax.swing.JButton tombolSambungkan;
    // End of variables declaration//GEN-END:variables

}
