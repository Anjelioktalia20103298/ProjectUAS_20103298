/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package promhs;

import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import java.awt.image.BufferedImage;
import javax.swing.JOptionPane;

/**
 *
 * @author Anjeli Oktalia_20103298
 */

public class frmhs extends javax.swing.JInternalFrame {
    private DefaultTableModel model;
    static ResultSet rs;
    static Statement stmt;
    dbKoneksi cnn = new dbKoneksi();
    loadIMG img = new loadIMG();
    
    /**
     * Creates new form frmhs
     */
    public frmhs() {
        initComponents();
        this.initTable();
        this.getdata();
        this.cmdBatal.setVisible(false);
    }
    
    private void initTable(){
        model = new DefaultTableModel();
        tMHS.setModel(model);
        model.addColumn("NIM");
        model.addColumn("Nama Mahasiswa");
        model.addColumn("Tgl Lahir");
        model.addColumn("Jurusan");
        model.addColumn("JenisKelamin");
    }
    private void tampildata(String sql){
        try{
            Statement stmt = cnn.koneksi().createStatement();
            this.rs = stmt.executeQuery(sql);
        }catch(Exception e){
            System.out.println("Terjadi Kendala pada query");
        }
    }
    private void getdata(){
        String sql = "Select NIM, NAMA, TGLLAHIR, JURUSAN, JK FROM mhs;";
        model.getDataVector().removeAllElements();
        model.fireTableDataChanged();
        try{
            this.tampildata(sql);
            while(this.rs.next()){
                Object[] obj = new Object[5];
                obj[0] = this.rs.getString("NIM");
                obj[1] = this.rs.getString("NAMA");
                obj[2] = this.rs.getString("TGLLAHIR");
                obj[3] = this.rs.getString("JURUSAN");
                String txJK = this.rs.getString("JK");
                if(txJK.equals("L")){
                    obj[4] = "Laki-Laki";
                }else{
                    obj[4] = "Perempuan";
                }
                model.addRow(obj);
            }
        }catch(Exception e){
        }
    }
    private boolean UpdateData(String SQL){
        boolean hsl = false;
        try{
            Statement stmt = cnn.koneksi().createStatement();
            stmt.executeUpdate(SQL);
            hsl = true;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Terjadi kendala pada instruksi SQL");
        }
        return hsl;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        cmdBaru = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tMHS = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        lbCURD = new javax.swing.JLabel();
        imgphoto = new javax.swing.JLabel();
        txNIM = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txNAMA = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txTGL = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txJKL = new javax.swing.JRadioButton();
        txJKP = new javax.swing.JRadioButton();
        jLabel8 = new javax.swing.JLabel();
        txJUR = new javax.swing.JComboBox<>();
        cmdStore = new javax.swing.JButton();
        cmdUpdate = new javax.swing.JButton();
        cmdDelete = new javax.swing.JButton();
        cmdBatal = new javax.swing.JButton();
        cmdClose = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("List Data Mahasiswa");

        cmdBaru.setText("Data Baru");
        cmdBaru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdBaruActionPerformed(evt);
            }
        });

        tMHS.setModel(new javax.swing.table.DefaultTableModel(
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
        tMHS.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tMHSMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tMHS);

        lbCURD.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lbCURD.setText("Detail");

        imgphoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/gambar.jpg"))); // NOI18N

        jLabel4.setText("NIM");

        jLabel5.setText("Nama Mahasiswa");

        jLabel6.setText("Tgl Lahir");

        jLabel7.setText("Jenis Kelamin");

        buttonGroup1.add(txJKL);
        txJKL.setText("Laki-Laki");

        buttonGroup1.add(txJKP);
        txJKP.setText("Perempuan");

        jLabel8.setText("Jurusan");

        txJUR.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Jurusan", "MTI", "SK", "KAB" }));

        cmdStore.setText("Simpan Data");
        cmdStore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdStoreActionPerformed(evt);
            }
        });

        cmdUpdate.setText("Update Data");
        cmdUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdUpdateActionPerformed(evt);
            }
        });

        cmdDelete.setText("Hapus Data");
        cmdDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdDeleteActionPerformed(evt);
            }
        });

        cmdBatal.setText("Batal");
        cmdBatal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdBatalActionPerformed(evt);
            }
        });

        cmdClose.setText("Tutup Form");
        cmdClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbCURD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 365, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(cmdBaru, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(imgphoto)
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel5)
                                    .addComponent(txNAMA, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(txNIM, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(50, 50, 50)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6)
                                            .addComponent(txTGL))))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txJKL)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txJKP))
                                    .addComponent(jLabel8)
                                    .addComponent(txJUR, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cmdStore)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmdUpdate)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmdDelete)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cmdBatal)
                                .addGap(45, 45, 45)
                                .addComponent(cmdClose)))
                        .addGap(0, 16, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmdBaru))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbCURD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txNIM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txTGL, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txJKL)
                            .addComponent(txJKP))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txNAMA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txJUR, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(imgphoto))
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmdStore)
                    .addComponent(cmdUpdate)
                    .addComponent(cmdDelete)
                    .addComponent(cmdBatal)
                    .addComponent(cmdClose))
                .addGap(0, 35, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdCloseActionPerformed
        this.dispose();
    }//GEN-LAST:event_cmdCloseActionPerformed

    private void tMHSMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tMHSMouseClicked
        String urlGambarNull = "src/img/gambar.jpg";
        this.txNIM.setText( model.getValueAt(tMHS.getSelectedRow(), 0).toString());
        this.txNAMA.setText( model.getValueAt(tMHS.getSelectedRow(), 1).toString());
        this.txTGL.setText( model.getValueAt(tMHS.getSelectedRow(), 2).toString());
        this.txJUR.setSelectedItem(model.getValueAt(tMHS.getSelectedRow(), 3).toString());
        String txJK = model.getValueAt(tMHS.getSelectedRow(), 4).toString();
        if(txJK.equals("Perempuan")){
            this.txJKP.setSelected(true);
        }else{
            this.txJKL.setSelected(true);
        }
        String urlGambar = "src/img/"+this.txNIM.getText() + ".jpg";
        BufferedImage loadImg = img.loadImage(urlGambar);
        if(loadImg == null){
            loadImg = img.loadImage(urlGambarNull);
        }
        ImageIcon imageIcon = new ImageIcon(loadImg);
        this.imgphoto.setIcon(imageIcon);
        
        this.lbCURD.setText("Edit Data "+this.txNIM.getText());
        this.cmdStore.setEnabled(false);
        this.cmdUpdate.setEnabled(true);
        this.cmdDelete.setEnabled(true);
    }//GEN-LAST:event_tMHSMouseClicked

    private void cmdUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdUpdateActionPerformed
        String NIM = this.txNIM.getText();
        String NAMA = this.txNAMA.getText();
        String TGL = this.txTGL.getText();
        String JUR = this.txJUR.getSelectedItem().toString();
        String JKEL = "L";
        if(this.txJKP.isSelected()){
            JKEL = "P";
        }
        String SQLUpdate = "UPDATE mhs SET NAMA='"+NAMA+"', JURUSAN='"+JUR+"', JK='"+JKEL+"', TGLLAHIR='"+TGL+"' WHERE NIM='"+NIM+"';";
        if(this.UpdateData(SQLUpdate)){
            this.getdata();
            JOptionPane.showMessageDialog(null, "Data telah di Update");
        }
    }//GEN-LAST:event_cmdUpdateActionPerformed

    private void cmdDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdDeleteActionPerformed
        String NIM = this.txNIM.getText();
        String NAMA = this.txNAMA.getText();
        
        int opsi = JOptionPane.showConfirmDialog(null,"Yakin akan menghapus data dari "+NAMA+"("+NIM+")?","Konfirmasi", JOptionPane.YES_NO_OPTION );
        if(opsi == JOptionPane.YES_OPTION){
            String SQLDelete = "DELETE FROM mhs WHERE NIM='"+NIM+"';";
            if(this.UpdateData(SQLDelete)){
                this.getdata();
                JOptionPane.showMessageDialog(null, "Data telah dihapus");
            }
        }
    }//GEN-LAST:event_cmdDeleteActionPerformed

    private void cmdBaruActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdBaruActionPerformed
        this.cmdBaru.setEnabled(false);
        this.cmdUpdate.setEnabled(false);
        this.cmdDelete.setEnabled(false);
        this.cmdClose.setEnabled(false);
        this.cmdStore.setEnabled(true);
        this.cmdBatal.setVisible(true);
        
        this.txNIM.setText("");
        this.txNAMA.setText("");
        this.txTGL.setText("");
        this.txJUR.setSelectedIndex(0);
        
        this.lbCURD.setText("Tambah data Mahasiswa");
        
    }//GEN-LAST:event_cmdBaruActionPerformed

    private void cmdBatalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdBatalActionPerformed
        this.cmdClose.setEnabled(true);
        this.cmdBaru.setEnabled(true);
        this.cmdStore.setEnabled(false);
        this.cmdBatal.setVisible(false);

    }//GEN-LAST:event_cmdBatalActionPerformed

    private void cmdStoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdStoreActionPerformed
        String NIM = this.txNIM.getText();
        String NAMA = this.txNAMA.getText();
        String TGL = this.txTGL.getText();
        String JUR = this.txJUR.getSelectedItem().toString();
        String JKEL = "L";
        if(this.txJKP.isSelected()){
            JKEL = "P";
        }
        String SQLInsert = "INSERT INTO mhs(NIM,NAMA,JURUSAN,JK,TGLLAHIR) VALUES('"+NIM+"','"+NAMA+"','"+JUR+"','"+JKEL+"','"+TGL+"');";
        if(this.UpdateData(SQLInsert)){
            this.getdata();
            JOptionPane.showMessageDialog(null, "Data telah di Tambahkan");
        }
        this.cmdStore.setEnabled(false);
        this.cmdBatal.setVisible(false);
        this.cmdClose.setEnabled(true);
        this.cmdBaru.setEnabled(true);
    }//GEN-LAST:event_cmdStoreActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cmdBaru;
    private javax.swing.JButton cmdBatal;
    private javax.swing.JButton cmdClose;
    private javax.swing.JButton cmdDelete;
    private javax.swing.JButton cmdStore;
    private javax.swing.JButton cmdUpdate;
    private javax.swing.JLabel imgphoto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbCURD;
    private javax.swing.JTable tMHS;
    private javax.swing.JRadioButton txJKL;
    private javax.swing.JRadioButton txJKP;
    private javax.swing.JComboBox<String> txJUR;
    private javax.swing.JTextField txNAMA;
    private javax.swing.JTextField txNIM;
    private javax.swing.JTextField txTGL;
    // End of variables declaration//GEN-END:variables
}
