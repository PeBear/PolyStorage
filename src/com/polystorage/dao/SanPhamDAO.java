package com.polystorage.dao;

import com.polystorage.entity.SanPham;
import java.util.List;

public interface SanPhamDAO {

    public List<SanPham> getListSanPham(String tensp);

    public SanPham getInfoSanPham(String masp);

    public boolean insertSanPham(SanPham sp);

    public boolean updateSanPham(SanPham sp);

    public boolean deleteSanPham(String masp);
}
