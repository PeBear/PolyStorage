package com.polystorage.entity;
// Generated Nov 22, 2019 11:47:05 PM by Hibernate Tools 4.3.1

/**
 * Chitietdonxuat generated by hbm2java
 */
public class ChiTietDonXuat implements java.io.Serializable {

    private ChiTietDonXuatId id;
    private DonXuat donXuat;
    private SanPham sanPham;
    private int soLuong;

    public ChiTietDonXuat() {
    }

    public ChiTietDonXuat(ChiTietDonXuatId id, DonXuat donxuat, SanPham sanpham, int soLuong) {
        this.id = id;
        this.donXuat = donxuat;
        this.sanPham = sanpham;
        this.soLuong = soLuong;
    }

    public ChiTietDonXuatId getId() {
        return id;
    }

    public void setId(ChiTietDonXuatId id) {
        this.id = id;
    }

    public DonXuat getDonXuat() {
        return donXuat;
    }

    public void setDonXuat(DonXuat donXuat) {
        this.donXuat = donXuat;
    }

    public SanPham getSanPham() {
        return sanPham;
    }

    public void setSanPham(SanPham sanPham) {
        this.sanPham = sanPham;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

}
