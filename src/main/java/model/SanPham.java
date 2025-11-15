package model;

import java.sql.Date;

/**
 * 
 * @author ADMIN
 */
public class SanPham {
    private int maSP;
    private String tenSP;
    private double donGia;
    private String hinh;
    private int maLoai;
    private Date ngayCapNhat;
    private boolean khuyenMai;

    // Constructor mặc định
    public SanPham() {
    }

    // Constructor đầy đủ tham số
    public SanPham(int maSP, String tenSP, double donGia, String hinh, 
                   int maLoai, Date ngayCapNhat, boolean khuyenMai) {
        this.maSP = maSP;
        this.tenSP = tenSP;
        this.donGia = donGia;
        this.hinh = hinh;
        this.maLoai = maLoai;
        this.ngayCapNhat = ngayCapNhat;
        this.khuyenMai = khuyenMai;
    }

    // Getter và Setter
    public int getMaSP() {
        return maSP;
    }

    public void setMaSP(int maSP) {
        this.maSP = maSP;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public double getDonGia() {
        return donGia;
    }

    public void setDonGia(double donGia) {
        this.donGia = donGia;
    }

    public String getHinh() {
        return hinh;
    }

    public void setHinh(String hinh) {
        this.hinh = hinh;
    }

    public int getMaLoai() {
        return maLoai;
    }

    public void setMaLoai(int maLoai) {
        this.maLoai = maLoai;
    }

    public Date getNgayCapNhat() {
        return ngayCapNhat;
    }

    public void setNgayCapNhat(Date ngayCapNhat) {
        this.ngayCapNhat = ngayCapNhat;
    }

    public boolean isKhuyenMai() {
        return khuyenMai;
    }

    public void setKhuyenMai(boolean khuyenMai) {
        this.khuyenMai = khuyenMai;
    }

    @Override
    public String toString() {
        return "SanPham{maSP=" + maSP + ", tenSP='" + tenSP + "', donGia=" + donGia 
                + ", hinh='" + hinh + "', maLoai=" + maLoai + ", ngayCapNhat=" + ngayCapNhat 
                + ", khuyenMai=" + khuyenMai + "}";
    }
}