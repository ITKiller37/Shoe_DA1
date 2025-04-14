/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;
import model.KhachHang;
import repository.RP_KhachHang;

/**
 *
 * @author trankhanhmobi
 */
public class KhachHangView extends javax.swing.JPanel {

    private final RP_KhachHang rP_KhachHang;
    private List<KhachHang> lstKhachHang;
    private DefaultTableModel model;
    

    /**
     * Creates new form KhachHangView1
     */
    public KhachHangView() {
        initComponents();
        rP_KhachHang = new RP_KhachHang();
        lstKhachHang = new ArrayList<>();
        model = (DefaultTableModel) tblkhachhang.getModel();
        // SỬA: Tách logic load dữ liệu thành phương thức riêng
        loadDataToTable();
        loadToTableKhachHangAn();
        clearForm();
    }

    // THÊM: Phương thức load dữ liệu để tái sử dụng
    private void loadDataToTable() {
        lstKhachHang = rP_KhachHang.getAll();
        model.setRowCount(0);
        for (KhachHang kh : lstKhachHang) {
            model.addRow(new Object[]{
                kh.getId(),
                kh.getMaKhachHang(),
                kh.getHoTen(),
                kh.getSoDienThoai()
            });
        }
    }

   // SỬA: Bỏ kiểm tra thông báo lỗi không cần thiết
    private void showData(int index) {
        if (index >= 0 && index < tblkhachhang.getRowCount()) {
            txtmakhachhang.setText(tblkhachhang.getValueAt(index, 1).toString());
            txthoten.setText(tblkhachhang.getValueAt(index, 2).toString());
            txtsdt.setText(tblkhachhang.getValueAt(index, 3).toString());
            btnthem.setEnabled(false);
            txtmakhachhang.setEnabled(false);
        }
    }

   // SỬA: Đổi tên và đơn giản hóa regex
    private boolean isValidPhone(String sdt) {
        return sdt.matches("0[0-9]{9,10}");
    }
    
    // SỬA: Gộp getFormKhachHang và cải thiện validate
    private KhachHang getFormData() {
        String ma = txtmakhachhang.getText().trim();
        String ten = txthoten.getText().trim();
        String sdt = txtsdt.getText().trim();

        if (ma.isEmpty() || ten.isEmpty() || sdt.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập đầy đủ thông tin!");
            return null;
        }

        if (!isValidPhone(sdt)) {
            JOptionPane.showMessageDialog(this, "Số điện thoại không đúng định dạng (0xxxxxxxxx)!");
            return null;
        }

        KhachHang kh = new KhachHang();
        kh.setMaKhachHang(ma);
        kh.setHoTen(ten);
        kh.setSoDienThoai(sdt);
        return kh;
    }

   // SỬA: Thêm clear selection của bảng
    private void clearForm() {
        txtmakhachhang.setText("");
        txthoten.setText("");
        txtsdt.setText("");
        tblkhachhang.clearSelection();
        btnthem.setEnabled(true);
        txtmakhachhang.setEnabled(true);
    }
    
    private void loadToTableKhachHangAn() {
        DefaultTableModel hiddenModel = (DefaultTableModel) tblKhachHangDialog.getModel();
        List<KhachHang> hiddenList = rP_KhachHang.getAllHidden();
        hiddenModel.setRowCount(0);
        for (KhachHang kh : hiddenList) {
            hiddenModel.addRow(new Object[]{
                    kh.getId(),
                    kh.getMaKhachHang(),
                    kh.getHoTen(),
                    kh.getSoDienThoai()
            });
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

        KhachHangDialog = new javax.swing.JDialog();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblKhachHangDialog = new javax.swing.JTable();
        btnHienThiLai = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtmakhachhang = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txthoten = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtsdt = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblkhachhang = new javax.swing.JTable();
        btnSearch = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();
        btnthem = new javax.swing.JButton();
        btnsua = new javax.swing.JButton();
        btnan = new javax.swing.JButton();
        btnhienthian = new javax.swing.JButton();
        btnmoi = new javax.swing.JButton();

        KhachHangDialog.setMinimumSize(new java.awt.Dimension(900, 400));

        tblKhachHangDialog.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Mã Khách Hàng", "Họ Tên", "Số Điện Thoại"
            }
        ));
        jScrollPane2.setViewportView(tblKhachHangDialog);

        btnHienThiLai.setBackground(new java.awt.Color(255, 204, 204));
        btnHienThiLai.setText("Hiển Thị Lại");
        btnHienThiLai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHienThiLaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout KhachHangDialogLayout = new javax.swing.GroupLayout(KhachHangDialog.getContentPane());
        KhachHangDialog.getContentPane().setLayout(KhachHangDialogLayout);
        KhachHangDialogLayout.setHorizontalGroup(
            KhachHangDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KhachHangDialogLayout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 824, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, KhachHangDialogLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnHienThiLai, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );
        KhachHangDialogLayout.setVerticalGroup(
            KhachHangDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KhachHangDialogLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnHienThiLai)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Quản Lý Khách Hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Roboto", 1, 14))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel3.setText("Mã Khách Hàng:");

        txtmakhachhang.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel4.setText("Họ Tên:");

        txthoten.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        jLabel6.setText("Số Điện Thoại:");

        txtsdt.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(txtmakhachhang, javax.swing.GroupLayout.DEFAULT_SIZE, 267, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtsdt, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txthoten, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtmakhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txthoten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(24, 24, 24)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtsdt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin Khách Hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Roboto", 1, 14))); // NOI18N

        tblkhachhang.setFont(new java.awt.Font("Roboto", 0, 12)); // NOI18N
        tblkhachhang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Mã Khách Hàng", "Họ Tên", "Số Điện Thoại "
            }
        ));
        tblkhachhang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblkhachhangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblkhachhang);

        btnSearch.setBackground(new java.awt.Color(255, 204, 204));
        btnSearch.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/icons8-search-20 (1).png"))); // NOI18N
        btnSearch.setText("Tìm Kiếm");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 978, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSearch)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSearch)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        btnthem.setBackground(new java.awt.Color(255, 204, 204));
        btnthem.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        btnthem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/icons8-add-20.png"))); // NOI18N
        btnthem.setText("Thêm");
        btnthem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemActionPerformed(evt);
            }
        });

        btnsua.setBackground(new java.awt.Color(255, 204, 204));
        btnsua.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        btnsua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/icons8-update-20 (1).png"))); // NOI18N
        btnsua.setText("Sửa");
        btnsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuaActionPerformed(evt);
            }
        });

        btnan.setBackground(new java.awt.Color(255, 204, 204));
        btnan.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        btnan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/icons8-hide-20.png"))); // NOI18N
        btnan.setText("Ẩn");
        btnan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnanActionPerformed(evt);
            }
        });

        btnhienthian.setBackground(new java.awt.Color(255, 204, 204));
        btnhienthian.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        btnhienthian.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/icons8-show-20.png"))); // NOI18N
        btnhienthian.setText("Hiện Thị Khách Hàng Ẩn");
        btnhienthian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnhienthianActionPerformed(evt);
            }
        });

        btnmoi.setBackground(new java.awt.Color(255, 204, 204));
        btnmoi.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N
        btnmoi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/icons8-refresh-20.png"))); // NOI18N
        btnmoi.setText("Mới");
        btnmoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmoiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(btnthem)
                .addGap(54, 54, 54)
                .addComponent(btnsua)
                .addGap(51, 51, 51)
                .addComponent(btnan)
                .addGap(47, 47, 47)
                .addComponent(btnmoi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnhienthian)
                .addGap(49, 49, 49))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnthem)
                    .addComponent(btnsua)
                    .addComponent(btnan)
                    .addComponent(btnmoi)
                    .addComponent(btnhienthian))
                .addGap(27, 27, 27))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblkhachhangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblkhachhangMouseClicked
       int row = tblkhachhang.getSelectedRow();
        if (row >= 0) {
            showData(row);
        }
    }//GEN-LAST:event_tblkhachhangMouseClicked

    private void btnmoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmoiActionPerformed
        // TODO add your handling code here:
        clearForm();

    }//GEN-LAST:event_btnmoiActionPerformed

    private void btnthemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemActionPerformed

        KhachHang kh = getFormData();
        if (kh == null) {
            return;
        }
        
         if (rP_KhachHang.checkMaKhachHang(kh.getMaKhachHang(), null) > 0) {
            JOptionPane.showMessageDialog(this, "Mã khách hàng đã tồn tại!");
            return;
        }


        if (rP_KhachHang.checkSdt(kh.getSoDienThoai(), null) > 0) {
            JOptionPane.showMessageDialog(this, "Số điện thoại đã tồn tại!");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this,
                "Bạn có chắc muốn thêm khách hàng này?",
                "Xác nhận",
                JOptionPane.YES_NO_OPTION);
        
        if (confirm == JOptionPane.YES_OPTION) {
            if (rP_KhachHang.add(kh)) {
                loadDataToTable();
                clearForm();
                JOptionPane.showMessageDialog(this, "Thêm khách hàng thành công!");
            } else {
                JOptionPane.showMessageDialog(this, "Thêm khách hàng thất bại!");
            }
        }
    }//GEN-LAST:event_btnthemActionPerformed

    private void btnsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuaActionPerformed
       int row = tblkhachhang.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn khách hàng cần sửa!");
            return;
        }

        KhachHang kh = getFormData();
        if (kh == null) {
            return;
        }

        int id = Integer.parseInt(tblkhachhang.getValueAt(row, 0).toString());
        kh.setId(id);
        
        if (rP_KhachHang.checkSdt(kh.getSoDienThoai(), kh.getId()) > 0) {
            JOptionPane.showMessageDialog(this, "Số điện thoại đã tồn tại!");
            return;
        }

       int confirm = JOptionPane.showConfirmDialog(this,
                "Bạn có chắc muốn sửa khách hàng này?",
                "Xác nhận",
                JOptionPane.YES_NO_OPTION);
        
        if (confirm == JOptionPane.YES_OPTION) {
            if (rP_KhachHang.update(kh)) {
                loadDataToTable();
                clearForm();
                JOptionPane.showMessageDialog(this, "Cập nhật khách hàng thành công!");
            } else {
                JOptionPane.showMessageDialog(this, "Cập nhật khách hàng thất bại!");
            }
        }

    }//GEN-LAST:event_btnsuaActionPerformed

    private void btnanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnanActionPerformed
        int row = tblkhachhang.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn khách hàng cần ẩn!");
            return;
        }

        int id = Integer.parseInt(tblkhachhang.getValueAt(row, 0).toString());
        int confirm = JOptionPane.showConfirmDialog(this, 
                "Bạn có chắc muốn ẩn khách hàng này?", 
                "Xác nhận", 
                JOptionPane.YES_NO_OPTION);
        
        if (confirm == JOptionPane.YES_OPTION) {
            if (rP_KhachHang.hideKhachHang(id)) {
                loadDataToTable();
                loadToTableKhachHangAn();
                clearForm();
                JOptionPane.showMessageDialog(this, "Ẩn khách hàng thành công!");
            } else {
                JOptionPane.showMessageDialog(this, "Ẩn khách hàng thất bại!");
            }
        }

    }//GEN-LAST:event_btnanActionPerformed

    private void btnhienthianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnhienthianActionPerformed
        KhachHangDialog.setLocationRelativeTo(null);
        KhachHangDialog.setVisible(true);
    }//GEN-LAST:event_btnhienthianActionPerformed

    private void btnHienThiLaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHienThiLaiActionPerformed
        int row = tblKhachHangDialog.getSelectedRow();
        if (row < 0) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn khách hàng cần hiển thị lại!");
            return;
        }

        int id = Integer.parseInt(tblKhachHangDialog.getValueAt(row, 0).toString());
        int confirm = JOptionPane.showConfirmDialog(this,
                "Bạn có chắc muốn hiển thị lại khách hàng này?",
                "Xác nhận",
                JOptionPane.YES_NO_OPTION);
        
        if (confirm == JOptionPane.YES_OPTION) {
            if (rP_KhachHang.showKhachHang(id)) {
                DefaultTableModel model = (DefaultTableModel) tblKhachHangDialog.getModel();
                model.removeRow(row); // Xóa dòng khỏi bảng trong JDialog
                loadDataToTable(); // Cập nhật bảng chính trong KhachHangView
                loadToTableKhachHangAn();
                JOptionPane.showMessageDialog(this, "Hiển thị lại khách hàng thành công!");
            } else {
                JOptionPane.showMessageDialog(this, "Hiển thị lại khách hàng thất bại!");
            }
        }
    }//GEN-LAST:event_btnHienThiLaiActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // Lấy từ khóa tìm kiếm từ ô txtSearch
    String tuKhoa = txtSearch.getText().trim();
    
    // Kiểm tra xem từ khóa có rỗng không
    if (tuKhoa.isEmpty()) {
        // Hiển thị lại toàn bộ danh sách khách hàng nếu từ khóa rỗng
        loadDataToTable();
        return;
    }
    
    // Gọi phương thức tìm kiếm từ repository
    List<KhachHang> ketQua = rP_KhachHang.timKiemKhachHang(tuKhoa);
    
    // Kiểm tra kết quả tìm kiếm
    if (ketQua.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Không tìm thấy khách hàng nào phù hợp!");
        // Xóa bảng nếu không tìm thấy kết quả
        model.setRowCount(0);
    } else {
        // Hiển thị kết quả tìm kiếm lên bảng
        model.setRowCount(0);
        for (KhachHang kh : ketQua) {
            model.addRow(new Object[]{
                kh.getId(),
                kh.getMaKhachHang(),
                kh.getHoTen(),
                kh.getSoDienThoai()
            });
        }
    }
    }//GEN-LAST:event_btnSearchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDialog KhachHangDialog;
    private javax.swing.JButton btnHienThiLai;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btnan;
    private javax.swing.JButton btnhienthian;
    private javax.swing.JButton btnmoi;
    private javax.swing.JButton btnsua;
    private javax.swing.JButton btnthem;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblKhachHangDialog;
    private javax.swing.JTable tblkhachhang;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txthoten;
    private javax.swing.JTextField txtmakhachhang;
    private javax.swing.JTextField txtsdt;
    // End of variables declaration//GEN-END:variables
}
