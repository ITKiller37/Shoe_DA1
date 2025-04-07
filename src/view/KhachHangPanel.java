/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package view;

import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.KhachHangPanelModel;
import repository.BanHang;
import repository.KhachHangPanelRepo;

/**
 *
 * @author ADMIN
 */
public class KhachHangPanel extends javax.swing.JPanel {

    private KhachHangPanelRepo qLy = new KhachHangPanelRepo();
    private BanHang bhRepo = new BanHang();

    JFrame frame = new JFrame();
    int idHoaDon;
    int index;
    JTextField ten;
    JTextField soDienThoai;
    JTable table;

    /**
     * Creates new form KhachHangPanel
     */
    public KhachHangPanel(JFrame frame, JTextField ten, JTextField soDienThoai, int index, int idHoaDon, JTable table) {
        initComponents();

        this.frame = frame;
        this.idHoaDon = idHoaDon;
        this.ten = ten;
        this.soDienThoai = soDienThoai;
        this.table = table;

        this.fillTable();
        this.index = index;
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKhachHang = new javax.swing.JTable();
        btnXacNhan = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        txtTen = new javax.swing.JTextField();
        txtSoDienThoai = new javax.swing.JTextField();
        txtSearch = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        jLabel1.setText("Danh Sách Khách Hàng");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Tìm Kiếm:");

        tblKhachHang.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "STT", "Mã Khách Hàng", "Tên Khách Hàng", "Số Điện Thoại"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblKhachHang.setRowHeight(25);
        tblKhachHang.setSelectionBackground(new java.awt.Color(0, 153, 153));
        tblKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhachHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblKhachHang);

        btnXacNhan.setBackground(new java.awt.Color(0, 153, 153));
        btnXacNhan.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnXacNhan.setForeground(new java.awt.Color(255, 255, 255));
        btnXacNhan.setText("Xác Nhận");
        btnXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Số Điện Thoại:");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Tên Khách Hàng:");

        btnThem.setBackground(new java.awt.Color(0, 153, 153));
        btnThem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnThem.setForeground(new java.awt.Color(255, 255, 255));
        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        txtTen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtSoDienThoai.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtSearch.setBackground(new java.awt.Color(204, 204, 204));
        txtSearch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSearch.setBorder(null);
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(0, 153, 153));
        jSeparator1.setForeground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel7)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jSeparator1)
                                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(56, 56, 56)
                                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnXacNhan)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(btnThem)
                    .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnXacNhan)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 598, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 496, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhachHangMouseClicked

        this.showData(tblKhachHang.getSelectedRow());
    }//GEN-LAST:event_tblKhachHangMouseClicked

    private void btnXacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhanActionPerformed

        String tenKH = txtTen.getText().trim();
        String sdtKH = txtSoDienThoai.getText().trim();
        if (!tenKH.isEmpty() && !sdtKH.isEmpty()) {
            if (tblKhachHang.getSelectedRow() != -1) {
                if (tenKH.equals(tblKhachHang.getValueAt(tblKhachHang.getSelectedRow(), 2).toString())
                    && sdtKH.equals(tblKhachHang.getValueAt(tblKhachHang.getSelectedRow(), 3).toString())) {

                    ten.setText(tenKH);
                    soDienThoai.setText(sdtKH);
                    qLy.suaKhachHangHoaDon(qLy.getAll(txtSearch.getText()).get(tblKhachHang.getSelectedRow()).getId(), idHoaDon);
                    bhRepo.fillTableHoaDonCho(table);
                    table.setRowSelectionInterval(index, index);
                    frame.dispose();
                    JOptionPane.showMessageDialog(this, "Đã chọn khách hàng");
                } else {
                    JOptionPane.showMessageDialog(this, "Thông tin khách hàng không tồn tại");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Chưa chọn khách hàng nào");
            }
        } else {

            ten.setText(qLy.getAll(txtTen.getText()).get(0).getTen());
            soDienThoai.setText(null);
            qLy.suaKhachHangHoaDon(qLy.getAll(txtSearch.getText()).get(0).getId(), idHoaDon);
            bhRepo.fillTableHoaDonCho(table);
            table.setRowSelectionInterval(index, index);

            frame.dispose();
            JOptionPane.showMessageDialog(this, "Hóa đơn đã chuyển thành khách vãng lai");
        }
    }//GEN-LAST:event_btnXacNhanActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed

        this.them();
    }//GEN-LAST:event_btnThemActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased

        this.fillTable();
    }//GEN-LAST:event_txtSearchKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXacNhan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tblKhachHang;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtSoDienThoai;
    private javax.swing.JTextField txtTen;
    // End of variables declaration//GEN-END:variables
    public void fillTable() {
        DefaultTableModel tblModel = (DefaultTableModel) tblKhachHang.getModel();
        tblModel.setRowCount(0);  // Xóa tất cả các dòng hiện tại trong bảng

        int count = 0;
        // Lấy danh sách khách hàng từ cơ sở dữ liệu hoặc nguồn khác
        List<KhachHangPanelModel> list = qLy.getAll(txtSearch.getText().trim());

        if (list.isEmpty()) {  // Kiểm tra nếu không có kết quả
            JOptionPane.showMessageDialog(this, "Không có khách hàng nào thỏa mãn điều kiện tìm kiếm.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        }

        // Duyệt qua các khách hàng và thêm vào bảng
        for (KhachHangPanelModel x : list) {
            if (!x.getTen().equals("Khách Vãng Lai")) {  // Kiểm tra tên khách hàng
                count++;
                tblModel.addRow(x.toDataRow(count));  // Thêm dòng vào bảng
            }
        }
    }

    public void showData(int index) {
        if (index >= 0 && index < tblKhachHang.getRowCount()) {  // Kiểm tra nếu index hợp lệ
            txtTen.setText(tblKhachHang.getValueAt(index, 2).toString());
            txtSoDienThoai.setText(tblKhachHang.getValueAt(index, 3).toString());
        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một dòng hợp lệ.", "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }

    KhachHangPanelModel readForm() {
        String ten = txtTen.getText().trim();
        String soDienThoai = txtSoDienThoai.getText().trim();

        // Kiểm tra tính hợp lệ của dữ liệu đầu vào
        if (ten.isEmpty() || soDienThoai.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tên và số điện thoại không được để trống", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return null;  // Trả về null nếu dữ liệu không hợp lệ
        }

        return new KhachHangPanelModel(ten, soDienThoai);
    }

    public void them() {
        KhachHangPanelModel newKhachHang = readForm();
        if (newKhachHang != null) {  // Kiểm tra nếu đối tượng khách hàng hợp lệ
            qLy.them(newKhachHang, qLy.createMaKhachHang());  // Thêm khách hàng mới vào hệ thống
            this.fillTable();  // Làm mới bảng
            JOptionPane.showMessageDialog(this, "Thêm khách hàng thành công");
            tblKhachHang.setRowSelectionInterval(tblKhachHang.getRowCount() - 1, tblKhachHang.getRowCount() - 1);  // Chọn dòng mới
        }
    }

}
