/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Frame;

import Connection.Koneksi;
import Connection.ResultSetTableModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author windows8
 */
public class InputKelas extends javax.swing.JFrame {

    /**
     * Creates new form InputKelas
     */
    public InputKelas() {
        initComponents();
        tampiltabel();
    }
    String kelas="xmm1";
    int kodekelas;
    
    void tampiltabel()
    {
        try
        {
            Koneksi objkoneksi = new Koneksi();
            Connection con = objkoneksi.bukakoneksi();
            Statement st = con.createStatement();
            String sql = "select *from "+kelas+"";
            ResultSet set = st.executeQuery(sql);
            ResultSetTableModel model = new ResultSetTableModel (set);
            tabel.setModel (model);
        }
        catch (SQLException e)
        {
            System.out.println("gagal query ini"+e);
        }
    }
    
    void pilihkelas()
    {
        kodekelas=klas.getSelectedIndex();
        if (kodekelas==1)
        {
            kelas = "xmm1";
        }
        if (kodekelas==2)
        {
            kelas = "xmm2";
        }
    }
    
    void bersih()
    {
        no.setText("");
        //klas.setSelectedIndex(0);
        nama.setText("");
    }
    
    void simpan()
    {
        pilihkelas();
         try {
            Koneksi objkoneksi = new Koneksi();
            Connection con =objkoneksi.bukakoneksi();
            Statement st = con.createStatement();

            String sql = "insert into "+kelas+" (no, nama)"
                    + "values ('"+no.getText()+"','"+nama.getText()+"')";
            int row =st.executeUpdate(sql);
            if (row==1)
            {
                JOptionPane.showMessageDialog(null,"Data sudah ditambahkan ke database","informasi",JOptionPane.INFORMATION_MESSAGE);
                con.close();
            }
        }
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null,"data tidak ditambahkan ke database"+e,"informasi",JOptionPane.INFORMATION_MESSAGE);
        }
         bersih();
         tampiltabel();
    }
    
    void  edit()
    {
        try
        {
            Koneksi objkoneksi = new Koneksi();
            Connection con =objkoneksi.bukakoneksi();
            Statement st = con.createStatement();
            String sql = "update '"+kelas+"' set nama='"+nama.getText()+"', "
                    + "where no ='" +no.getText()+"'";
            int row =st.executeUpdate(sql);
            if (row==1)
            {
                JOptionPane.showMessageDialog(null,"Data sudah diupdate","informasi",JOptionPane.INFORMATION_MESSAGE);
                con.close();
            }
        }
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null,"data tidak diubah"+ e,"informasi",JOptionPane.INFORMATION_MESSAGE);
        }
        bersih();
        tampiltabel();
    }
    
    void hapus()
    {
        try
        {
            Koneksi objkoneksi = new Koneksi();
            Connection con = objkoneksi.bukakoneksi();
            Statement st = con.createStatement();
            String sql = "delete from '"+kelas+"' where no= '"+no.getText()+"'";
            int confirm =JOptionPane.showConfirmDialog(this,
            "Yakin untuk menghapus data ini?",
            "Konfirmasi Hapus ",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE);
            if (confirm==JOptionPane.YES_OPTION) {
            int row = st.executeUpdate(sql);
            if (row ==1)
            {
                JOptionPane.showMessageDialog(null,"data sudah dihapus dari database","informasi",JOptionPane.INFORMATION_MESSAGE);
                con.close();
            }}}

        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "data tidak dihapus"+e,"informasi",JOptionPane.INFORMATION_MESSAGE);
        }
        bersih();
        tampiltabel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        no = new javax.swing.JTextField();
        nama = new javax.swing.JTextField();
        klas = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Cooper Black", 0, 18)); // NOI18N
        jLabel1.setText("Input Kelas");

        jLabel2.setFont(new java.awt.Font("Cooper Black", 0, 12)); // NOI18N
        jLabel2.setText("No Absen");

        jLabel3.setFont(new java.awt.Font("Cooper Black", 0, 12)); // NOI18N
        jLabel3.setText("Kelas");

        jLabel4.setFont(new java.awt.Font("Cooper Black", 0, 12)); // NOI18N
        jLabel4.setText("Nama");

        no.setFont(new java.awt.Font("Cooper Black", 0, 12)); // NOI18N

        nama.setFont(new java.awt.Font("Cooper Black", 0, 12)); // NOI18N
        nama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                namaActionPerformed(evt);
            }
        });

        klas.setFont(new java.awt.Font("Cooper Black", 0, 12)); // NOI18N
        klas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Pilih", "X MM 1", "X MM 2", "X RPL 1", "X RPL 2", "XI MM 1", "XI MM 2", "XI RPL 1", "XI RPL 2", "XII MM 1", "XII MM 2", "XII RPL 1", "XII RPL 2" }));

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabel);

        jButton1.setBackground(new java.awt.Color(51, 255, 255));
        jButton1.setFont(new java.awt.Font("Cooper Black", 0, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Addnew toolbar.png"))); // NOI18N
        jButton1.setText("Tambah");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(51, 255, 255));
        jButton2.setFont(new java.awt.Font("Cooper Black", 0, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Edit toolbar.png"))); // NOI18N
        jButton2.setText("Edit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(51, 255, 255));
        jButton3.setFont(new java.awt.Font("Cooper Black", 0, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Delete toolbar.png"))); // NOI18N
        jButton3.setText("Hapus");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(51, 255, 255));
        jButton4.setFont(new java.awt.Font("Cooper Black", 0, 12)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Back.png"))); // NOI18N
        jButton4.setText("Kembali");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(nama)
                            .addComponent(no, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(klas, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(26, 26, 26))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(254, 254, 254))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButton1, jButton2, jButton3, jButton4});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(no, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(klas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void namaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namaActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        simpan();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        edit();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        hapus();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        new MenuUtama().setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InputKelas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InputKelas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InputKelas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InputKelas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InputKelas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox klas;
    private javax.swing.JTextField nama;
    private javax.swing.JTextField no;
    private javax.swing.JTable tabel;
    // End of variables declaration//GEN-END:variables
}
