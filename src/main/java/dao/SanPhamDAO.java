package dao;

import context.DbContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.SanPham;

/**
 * Data Access Object cho bảng SanPham
 * @author ADMIN
 */
public class SanPhamDAO {
    
    /**
     * Lấy 6 sản phẩm khuyến mãi, sắp xếp theo giá giảm dần
     * @return Danh sách 6 sản phẩm khuyến mãi
     */
    public ArrayList<SanPham> getTop6Promotion() {
        ArrayList<SanPham> list = new ArrayList<>();
        String query = "SELECT TOP 6 * FROM SanPham WHERE KhuyenMai = 1 ORDER BY DonGia DESC";
        
        try (Connection con = new DbContext().getConnection();
             PreparedStatement stmt = con.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                SanPham sp = mapResultSetToSanPham(rs);
                list.add(sp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return list;
    }
    
    /**
     * Lấy danh sách sản phẩm theo mã thể loại
     * @param maLoai Mã thể loại
     * @return Danh sách sản phẩm thuộc thể loại đó
     */
    public ArrayList<SanPham> getByCategory(int maLoai) {
        ArrayList<SanPham> list = new ArrayList<>();
        String query = "SELECT * FROM SanPham WHERE MaLoai = ?";
        
        try (Connection con = new DbContext().getConnection();
             PreparedStatement stmt = con.prepareStatement(query)) {
            
            stmt.setInt(1, maLoai);
            
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    SanPham sp = mapResultSetToSanPham(rs);
                    list.add(sp);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return list;
    }
    
    /**
     * Đếm số lượng sản phẩm theo mã thể loại
     * @param maLoai Mã thể loại
     * @return Số lượng sản phẩm
     */
    public int countByCategory(int maLoai) {
        int count = 0;
        String query = "SELECT COUNT(*) FROM SanPham WHERE MaLoai = ?";
        
        try (Connection con = new DbContext().getConnection();
             PreparedStatement stmt = con.prepareStatement(query)) {
            
            stmt.setInt(1, maLoai);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    count = rs.getInt(1);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return count;
    }
    
    /**
     * Chuyển đổi ResultSet thành đối tượng SanPham
     * @param rs ResultSet từ database
     * @return Đối tượng SanPham
     * @throws Exception nếu có lỗi khi đọc dữ liệu
     */
private SanPham mapResultSetToSanPham(ResultSet rs) throws Exception {
        SanPham sp = new SanPham();
        sp.setMaSP(rs.getInt("MaSP"));
        sp.setTenSP(rs.getString("TenSP"));
        sp.setDonGia(rs.getDouble("DonGia"));
        sp.setHinh(rs.getString("Hinh"));
        sp.setMaLoai(rs.getInt("MaLoai"));
        sp.setNgayCapNhat(rs.getDate("NgayCapNhat"));
        sp.setKhuyenMai(rs.getBoolean("KhuyenMai"));
        return sp;
    }
}