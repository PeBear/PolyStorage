package com.polystorage.dao;

import com.polystorage.entity.KhachHang;
import java.util.List;

public interface KhachHangDAO {

    public List<KhachHang> getListKhachHang(String tenKhachHang);

    public KhachHang getInfoKhachHang(String maKH);

    public boolean insertKhachHang(KhachHang khachHang);

    public boolean updateKhachHang(KhachHang khachHang);

    public boolean deleteKhachHang(String maKH);
}
