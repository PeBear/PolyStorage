package com.polystorage.view;

import com.polystorage.dao.LoaiSanPhamDAO;
import com.polystorage.dao.NhaCungCapDAO;
import com.polystorage.dao.SanPhamDAO;
import com.polystorage.entity.LoaiSanPham;
import com.polystorage.entity.NhaCungCap;
import com.polystorage.entity.SanPham;
import com.polystorage.helper.DialogHelper;
import java.awt.Color;
import java.awt.Cursor;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author xPeter
 */
public class FrameThemSanPham extends javax.swing.JFrame {

    /**
     * Creates new form FrameUpdate
     */
    public FrameThemSanPham(SanPham sp) {
        initComponents();
        setLocationRelativeTo(null);
        this.sp = sp;
        this.fillToNhaCC();
        this.fillToLoaiSanPham();

        this.updateUI();
        if (sp != null) {
            capNhat = true;
            txtMaSP.setEditable(false);
            lblChucNang.setText("CẬP NHẬT");
            this.showDetailSanPham();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        lblChucNang = new javax.swing.JLabel();
        pnlCenter = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtMaSP = new javax.swing.JTextField();
        txtTenSP = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        cboLoai = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        cboNhaCungCap = new javax.swing.JComboBox<>();
        cboDonViTinh = new javax.swing.JComboBox<>();
        txtGia = new javax.swing.JTextField();
        pnlControl = new javax.swing.JPanel();
        btnSave = new javax.swing.JLabel();
        btnCancel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(java.awt.Color.blue, 2));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 145, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Sản Phẩm");

        lblChucNang.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblChucNang.setForeground(new java.awt.Color(0, 145, 255));
        lblChucNang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblChucNang.setText("THÊM MỚI");

        pnlCenter.setBackground(new java.awt.Color(255, 255, 255));
        pnlCenter.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 255)));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel3.setText("Mã Sản Phẩm:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel4.setText("Tên Sản Phẩm:");

        txtMaSP.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        txtTenSP.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel5.setText("Loại:");

        cboLoai.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel6.setText("Nhà Cung Cấp:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel7.setText("Đơn Vị Tính:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel8.setText("Giá:");

        cboNhaCungCap.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        cboDonViTinh.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        cboDonViTinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Thùng", "Chai" }));

        txtGia.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        javax.swing.GroupLayout pnlCenterLayout = new javax.swing.GroupLayout(pnlCenter);
        pnlCenter.setLayout(pnlCenterLayout);
        pnlCenterLayout.setHorizontalGroup(
            pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCenterLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCenterLayout.createSequentialGroup()
                        .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTenSP)
                            .addComponent(txtMaSP)
                            .addComponent(cboLoai, 0, 200, Short.MAX_VALUE))
                        .addGap(36, 36, 36)
                        .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cboDonViTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGia, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlCenterLayout.createSequentialGroup()
                        .addComponent(cboNhaCungCap, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 74, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlCenterLayout.setVerticalGroup(
            pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCenterLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMaSP))
                .addGap(18, 18, 18)
                .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTenSP)
                    .addComponent(jLabel7)
                    .addComponent(cboDonViTinh))
                .addGap(18, 18, 18)
                .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cboLoai)
                    .addComponent(jLabel8)
                    .addComponent(txtGia))
                .addGap(30, 30, 30)
                .addGroup(pnlCenterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cboNhaCungCap))
                .addGap(151, 151, 151))
        );

        pnlControl.setBackground(new java.awt.Color(102, 255, 204));

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/button_luu.png"))); // NOI18N
        btnSave.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSaveMouseClicked(evt);
            }
        });

        btnCancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/button_huy(1).png"))); // NOI18N
        btnCancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlControlLayout = new javax.swing.GroupLayout(pnlControl);
        pnlControl.setLayout(pnlControlLayout);
        pnlControlLayout.setHorizontalGroup(
            pnlControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlControlLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSave)
                .addGap(18, 18, 18)
                .addComponent(btnCancel)
                .addContainerGap())
        );
        pnlControlLayout.setVerticalGroup(
            pnlControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlControlLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCancel)
                    .addComponent(btnSave))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(jSeparator1)
                    .addComponent(lblChucNang, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlCenter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlControl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblChucNang, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlCenter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlControl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelMouseClicked
        this.dispose();
    }//GEN-LAST:event_btnCancelMouseClicked

    private void btnSaveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSaveMouseClicked
        this.setWhite();
        String loi = this.checkInput();
        if (loi.equals("")) {
            SanPham model = this.getModel();
            if (capNhat) {
                if (sanPhamDAOImpl.updateSanPham(model)) {
                    DialogHelper.showMessageDialog(this, "Câp nhật sản phẩm thành công.");
                    PanelDanhSachSanPham.reload.fillToTableSanPham(null);
                } else {
                    DialogHelper.showMessageDialog(this, "Câp nhật sản phẩm thất bại.");
                }
            } else {
                if (sanPhamDAOImpl.insertSanPham(model)) {
                    DialogHelper.showMessageDialog(this, "Thêm sản phẩm thành công.");
                    PanelDanhSachSanPham.reload.fillToTableSanPham(null);
                } else {
                    DialogHelper.showMessageDialog(this, "Thêm sản phẩm thất bại.");
                }
            }
        } else {
            DialogHelper.showMessageDialog(this, loi);
        }
    }//GEN-LAST:event_btnSaveMouseClicked

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrameThemSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameThemSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameThemSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameThemSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameThemSanPham(null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnCancel;
    private javax.swing.JLabel btnSave;
    private javax.swing.JComboBox<String> cboDonViTinh;
    private javax.swing.JComboBox<String> cboLoai;
    private javax.swing.JComboBox<String> cboNhaCungCap;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblChucNang;
    private javax.swing.JPanel pnlCenter;
    private javax.swing.JPanel pnlControl;
    private javax.swing.JTextField txtGia;
    private javax.swing.JTextField txtMaSP;
    private javax.swing.JTextField txtTenSP;
    // End of variables declaration//GEN-END:variables
    SanPham sp;
    SanPhamDAO sanPhamDAOImpl = new SanPhamDAO();
    NhaCungCapDAO nhaCungCapDAOImpl = new NhaCungCapDAO();
    LoaiSanPhamDAO loaiSanPhamDAOImpl = new LoaiSanPhamDAO();
    boolean capNhat = false;

    private void showDetailSanPham() {
        txtMaSP.setText(sp.getMaSp());
        txtTenSP.setText(sp.getTenSp());
        txtGia.setText(String.valueOf(sp.getGiaDv()));
        cboNhaCungCap.setSelectedItem("(" + sp.getNhaCungCap().getMaNCC() + ") " + sp.getNhaCungCap().getTenNCC());
        cboLoai.setSelectedItem("(" + sp.getLoaiSanPham().getMaLoai() + ") " + sp.getLoaiSanPham().getTenLoai());
        if (sp.getDonViTinh().equals("Thùng")) {
            cboDonViTinh.setSelectedIndex(0);
        } else {
            cboDonViTinh.setSelectedIndex(1);
        }
    }

    private void fillToNhaCC() {
        List<NhaCungCap> list = nhaCungCapDAOImpl.getListNhaCungCap(null);
        DefaultComboBoxModel model = (DefaultComboBoxModel) cboNhaCungCap.getModel();
        model.removeAllElements();
        for (NhaCungCap x : list) {
            model.addElement("(" + x.getMaNCC() + ") " + x.getTenNCC());
        }
        cboNhaCungCap.setSelectedIndex(0);
    }

    private void fillToLoaiSanPham() {
        List<LoaiSanPham> list = loaiSanPhamDAOImpl.getListLoai(null);
        DefaultComboBoxModel model = (DefaultComboBoxModel) cboLoai.getModel();
        model.removeAllElements();
        for (LoaiSanPham x : list) {
            model.addElement("(" + x.getMaLoai() + ") " + x.getTenLoai());
        }
        cboLoai.setSelectedIndex(0);
    }

    private void updateUI() {
        btnCancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnSave.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    private String checkInput() {
        if (txtMaSP.getText().isEmpty()) {
            txtMaSP.setBackground(Color.yellow);
            txtMaSP.requestFocus();
            return "Mã sản phẩm trống.";
        } else if (!txtMaSP.getText().matches("[a-zA-Z0-9]+")) {
            txtMaSP.setBackground(Color.yellow);
            txtMaSP.requestFocus();
            return "Sai định dạng mã sản phẩm.";
        }

        if (txtTenSP.getText().isEmpty()) {
            txtTenSP.setBackground(Color.yellow);
            txtTenSP.requestFocus();
            return "Tên sản phẩm trống.";
        } else if (!txtTenSP.getText().matches("[\\p{L} ]+")) {
            txtTenSP.setBackground(Color.yellow);
            txtTenSP.requestFocus();
            return "Sai định dạng tên sản phẩm.";
        }

        if (txtTenSP.getText().isEmpty()) {
            txtTenSP.setBackground(Color.yellow);
            txtTenSP.requestFocus();
            return "Tên sản phẩm trống.";
        } else {
            try {
                Float.valueOf(txtTenSP.getText());
            } catch (Exception e) {
                txtTenSP.setBackground(Color.yellow);
                txtTenSP.requestFocus();
                return "Sai định dạng sản phẩm.";
            }
        }

        return "";
    }

    private void setWhite() {
        txtMaSP.setBackground(Color.white);
        txtTenSP.setBackground(Color.white);
        txtGia.setBackground(Color.white);
        cboNhaCungCap.setSelectedIndex(0);
        cboDonViTinh.setSelectedIndex(0);
        cboLoai.setSelectedIndex(0);
    }

    private SanPham getModel() {
        String maSP = txtMaSP.getText();
        String tenSP = txtTenSP.getText();
        float giaSP = Float.parseFloat(txtGia.getText());
        String maNCC = (String) cboNhaCungCap.getSelectedItem();
        NhaCungCap nhaCungCap = nhaCungCapDAOImpl.getInfoNhaCungCap(maNCC.substring(1, maNCC.lastIndexOf(")")));
        String maLoai = (String) cboLoai.getSelectedItem();
        LoaiSanPham loaiSanPham = loaiSanPhamDAOImpl.getInfoLoai(maLoai.substring(1, maLoai.lastIndexOf(")")));
        String donViTinh = (String) cboDonViTinh.getSelectedItem();

        SanPham sanPham = new SanPham(maSP, loaiSanPham, nhaCungCap, tenSP, donViTinh, giaSP);
        return sanPham;
    }
}
