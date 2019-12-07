
import com.polystorage.dao.DonNhapDAOImpl;
import com.polystorage.dao.SanPhamDAOImpl;
import com.polystorage.entity.ChiTietDonNhap;
import com.polystorage.entity.SanPham;
import com.polystorage.view.PanelDanhSachNhaCungCap;
import com.polystorage.view.PanelDanhSachDonNhap;
import com.polystorage.view.PanelDanhSachDonXuat;
import com.polystorage.view.PanelDanhSachNhanVien;
import com.polystorage.view.PanelDanhSachSanPham;
import com.polystorage.view.PanelHangTonKho;
import com.polystorage.view.PanelTongSanPhamNhapXuat;
import java.awt.GraphicsEnvironment;
import java.util.ArrayList;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.UnsupportedLookAndFeelException;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author xPeter
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic heretry {
        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
            if ("Windows".equals(info.getName())) {
                try {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(NewMain.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;

            }
        }
//        JFrame jf = new JFrame();
//        jf.add(new PanelTongSanPhamNhapXuat(true));
//        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        jf.setSize(GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().getSize());
//        jf.setVisible(true);
        System.out.printf("%s %15d","hello",555);
    }

}
