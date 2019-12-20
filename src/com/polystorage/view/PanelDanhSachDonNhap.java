package com.polystorage.view;

import com.polystorage.dao.DonNhapDAO;
import com.polystorage.entity.DonNhap;
import com.polystorage.helper.DialogHelper;
import com.polystorage.helper.ExportPDF;
import com.polystorage.helper.ProcessString;
import com.polystorage.helper.RemoveButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author xPeter
 */
public class PanelDanhSachDonNhap extends javax.swing.JPanel {

    public static PanelDanhSachDonNhap reload;
    boolean isNhanVien;

    /**
     * Creates new form NewJPanel
     */
    public PanelDanhSachDonNhap(boolean isNhanVien) {
        reload = this;
        this.isNhanVien = isNhanVien;
        initComponents();
        this.setTableUI();
        txtNgayMin.setDate(new Date(119, 0, 1));
        txtNgayMax.setDate(new Date(119, 12, 31));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlControl = new javax.swing.JPanel();
        btnThemMoi = new javax.swing.JButton();
        btnXuatPDF = new javax.swing.JButton();
        txtNgayMin = new com.toedter.calendar.JDateChooser();
        txtNgayMax = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        pnlRoot = new javax.swing.JPanel();
        lblTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDonNhap = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lblTongHoaDon = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        pnlControl.setBackground(new java.awt.Color(255, 255, 255));

        btnThemMoi.setText("Thêm Mới");
        btnThemMoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemMoiActionPerformed(evt);
            }
        });

        btnXuatPDF.setText("Xuất PDF");
        btnXuatPDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatPDFActionPerformed(evt);
            }
        });

        txtNgayMin.setDateFormatString("dd-MM-yyyy");
        txtNgayMin.setFocusable(false);
        txtNgayMin.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtNgayMinPropertyChange(evt);
            }
        });

        txtNgayMax.setDateFormatString("dd-MM-yyyy");
        txtNgayMax.setFocusable(false);
        txtNgayMax.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                txtNgayMaxPropertyChange(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel1.setText("Từ Ngày:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel2.setText("Đến Ngày:");

        javax.swing.GroupLayout pnlControlLayout = new javax.swing.GroupLayout(pnlControl);
        pnlControl.setLayout(pnlControlLayout);
        pnlControlLayout.setHorizontalGroup(
            pnlControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlControlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNgayMin, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNgayMax, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnXuatPDF)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnThemMoi)
                .addContainerGap())
        );
        pnlControlLayout.setVerticalGroup(
            pnlControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlControlLayout.createSequentialGroup()
                .addGroup(pnlControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtNgayMax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addGroup(pnlControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnlControlLayout.createSequentialGroup()
                            .addGap(9, 9, 9)
                            .addGroup(pnlControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnThemMoi)
                                .addComponent(btnXuatPDF)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlControlLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(txtNgayMin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        pnlRoot.setBackground(new java.awt.Color(35, 124, 196));

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 255, 255));
        lblTitle.setText("     ĐƠN NHẬP");

        tblDonNhap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Đơn Hàng", "Ngày Lập", "Đối Tác", "Nhân Viên", "Trạng Thái", "Tổng Đơn", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDonNhap.setFocusable(false);
        tblDonNhap.setIntercellSpacing(new java.awt.Dimension(0, 0));
        tblDonNhap.setRowHeight(25);
        tblDonNhap.setSelectionBackground(new java.awt.Color(130, 168, 212));
        tblDonNhap.setShowVerticalLines(false);
        tblDonNhap.getTableHeader().setReorderingAllowed(false);
        tblDonNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDonNhapMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDonNhap);

        javax.swing.GroupLayout pnlRootLayout = new javax.swing.GroupLayout(pnlRoot);
        pnlRoot.setLayout(pnlRootLayout);
        pnlRootLayout.setHorizontalGroup(
            pnlRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 678, Short.MAX_VALUE)
            .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        pnlRootLayout.setVerticalGroup(
            pnlRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlRootLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(102, 102, 255));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel3.setText("Tổng Hóa Đơn:");

        lblTongHoaDon.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTongHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblTongHoaDon))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlControl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlRoot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlControl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlRoot, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblDonNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDonNhapMouseClicked
        if (evt.getClickCount() == 2) {
            int index = tblDonNhap.getSelectedRow();
            int maDN = (int) tblDonNhap.getValueAt(index, 0);
            DonNhap donNhap = donNhapDAOImpl.getInfoDonNhap(maDN);
            new FrameThemDonNhap(donNhap).setVisible(true);
        }
    }//GEN-LAST:event_tblDonNhapMouseClicked

    private void btnThemMoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemMoiActionPerformed
        new FrameThemDonNhap(null).setVisible(true);
    }//GEN-LAST:event_btnThemMoiActionPerformed

    private void btnXuatPDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatPDFActionPerformed
        int index = tblDonNhap.getSelectedRow();
        if (index == -1) {
            DialogHelper.showMessageDialog(null, "Vui lòng chọn hóa đơn cần xuất pdf");
        } else {
            int maDN = (int) tblDonNhap.getValueAt(index, 0);
            int ok = JOptionPane.showConfirmDialog(null, "Xác nhận xuất pdf hóa đơn " + maDN, "Bạn muốn xuấts?", JOptionPane.YES_NO_OPTION);
            if (ok == 0) {
                JFileChooser jfc = new JFileChooser();
                jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                if (jfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                    String path = jfc.getSelectedFile().getAbsolutePath();
                    if (!path.endsWith(".pdf")) {
                        path += ".pdf";
                    }
                    ExportPDF exportPDF = new ExportPDF();
                    exportPDF.FILE = path;
                    exportPDF.exportDonNhap(donNhapDAOImpl.getInfoDonNhap(2));
                    DialogHelper.showMessageDialog(null, "Xuất pdf thành công.");
                }

            }
        }

    }//GEN-LAST:event_btnXuatPDFActionPerformed

    private void txtNgayMinPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtNgayMinPropertyChange
        this.fillToTableDonHang(txtNgayMin.getDate(), txtNgayMax.getDate());
    }//GEN-LAST:event_txtNgayMinPropertyChange

    private void txtNgayMaxPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_txtNgayMaxPropertyChange
        this.fillToTableDonHang(txtNgayMin.getDate(), txtNgayMax.getDate());
    }//GEN-LAST:event_txtNgayMaxPropertyChange


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnThemMoi;
    private javax.swing.JButton btnXuatPDF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblTongHoaDon;
    private javax.swing.JPanel pnlControl;
    private javax.swing.JPanel pnlRoot;
    private javax.swing.JTable tblDonNhap;
    private com.toedter.calendar.JDateChooser txtNgayMax;
    private com.toedter.calendar.JDateChooser txtNgayMin;
    // End of variables declaration//GEN-END:variables
    List<DonNhap> list;
    int index = 0;

    DonNhapDAO donNhapDAOImpl = new DonNhapDAO();

    private void setTableUI() {
        tblDonNhap.getTableHeader().setFont(new Font("Segoe UI", Font.PLAIN, 15));
        tblDonNhap.getTableHeader().setOpaque(false);
        //tblNhanVien.getTableHeader().setBackground(new Color(32, 136, 203));
        tblDonNhap.getTableHeader().setBackground(new Color(255, 255, 255));
        tblDonNhap.getTableHeader().setForeground(new Color(0, 0, 0));
        tblDonNhap.setRowHeight(25);
    }

    public void fillToTableDonHang(int maDH) {
        list = donNhapDAOImpl.getListDonNhap(maDH);
        if (list != null) {
            DefaultTableModel model = (DefaultTableModel) tblDonNhap.getModel();
            ActionListener actionListener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    removeDonNhap();
                }
            };
            tblDonNhap.getColumnModel().getColumn(6).setCellRenderer(new RemoveButton(tblDonNhap, 6, actionListener));
            model.setRowCount(0);
            double sum = 0;
            for (DonNhap x : list) {
                double tongGia = donNhapDAOImpl.getTongDonNhap(x.getMaDN());
                String tongDon = ProcessString.toVietnamMoney(tongGia) + " VNĐ";
                sum += tongGia;
                String trangThai = "";
                if (x.isTrangThai()) {
                    trangThai = "Đã xác nhận";
                } else {
                    trangThai = "Đang chờ";
                }
                Object[] row = new Object[]{x.getMaDN(), x.getNgayNhap(), x.getNhaCungCap().getTenNCC(), x.getNhanvien().getMaNv(), trangThai, tongDon};
                model.addRow(row);
            }
            lblTongHoaDon.setText(ProcessString.toVietnamMoney(sum));
        }
    }

    public void fillToTableDonHang(Date min, Date max) {
        list = donNhapDAOImpl.getListDonNhap(min, max);
        if (list != null) {
            DefaultTableModel model = (DefaultTableModel) tblDonNhap.getModel();
            ActionListener actionListener = new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    removeDonNhap();
                }
            };
            tblDonNhap.getColumnModel().getColumn(6).setCellRenderer(new RemoveButton(tblDonNhap, 6, actionListener));
            model.setRowCount(0);
            double sum = 0;
            for (DonNhap x : list) {
                double tongGia = donNhapDAOImpl.getTongDonNhap(x.getMaDN());
                String tongDon = ProcessString.toVietnamMoney(tongGia);
                sum += tongGia;
                String trangThai = "";
                if (x.isTrangThai()) {
                    trangThai = "Đã xác nhận";
                } else {
                    trangThai = "Đang chờ";
                }
                Object[] row = new Object[]{x.getMaDN(), x.getNgayNhap(), x.getNhaCungCap().getTenNCC(), x.getNhanvien().getMaNv(), trangThai, tongDon};
                model.addRow(row);
            }
            lblTongHoaDon.setText(ProcessString.toVietnamMoney(sum));
        }
    }

    private void removeDonNhap() {
        if (isNhanVien) {
            DialogHelper.showMessageDialog(null, "Nhân viên không có quyền xóa");
        } else {
            int index = tblDonNhap.getSelectedRow();
            int maDN = (int) tblDonNhap.getValueAt(index, 0);
            int ok = JOptionPane.showConfirmDialog(null, "Xác nhận xóa đơn nhập " + maDN, "Bạn muốn xóa?", JOptionPane.YES_NO_OPTION);
            if (ok == 0) {
                if (donNhapDAOImpl.deleteDonNhap(maDN)) {
                    PanelDanhSachDonNhap.reload.fillToTableDonHang(-1);
                    DialogHelper.showMessageDialog(null, "Xóa đơn nhập " + maDN + " thành công");
                } else {
                    DialogHelper.showMessageDialog(null, "Xóa đơn nhập " + maDN + " thất bại");
                }
            }
        }
    }
}
