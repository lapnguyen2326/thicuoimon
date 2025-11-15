package dao;

import context.DbContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.TheLoai;


public class TheLoaiDAO {
    

    public ArrayList<TheLoai> getAll() {
        ArrayList<TheLoai> list = new ArrayList<>();
        String query = "SELECT * FROM TheLoai";
        
        try (Connection con = new DbContext().getConnection();
             PreparedStatement stmt = con.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {
            
            while (rs.next()) {
                TheLoai tl = new TheLoai();
                tl.setMaLoai(rs.getInt("MaLoai"));
                tl.setTenLoai(rs.getString("TenLoai"));
                list.add(tl);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return list;
    }
    
    public TheLoai findById(int maLoai) {
        TheLoai tl = null;
        String query = "SELECT * FROM TheLoai WHERE MaLoai = ?";
        
        try (Connection con = new DbContext().getConnection();
             PreparedStatement stmt = con.prepareStatement(query)) {
            
            stmt.setInt(1, maLoai);
            
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    tl = new TheLoai();
                    tl.setMaLoai(rs.getInt("MaLoai"));
                    tl.setTenLoai(rs.getString("TenLoai"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return tl;
    }
}