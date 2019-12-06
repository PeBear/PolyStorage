package com.polystorage.dao;

import com.polystorage.entity.LoaiSanPham;
import java.util.List;

public interface LoaiSanPhamDAO {

    public List<LoaiSanPham> getListLoai(String loai);

    public LoaiSanPham getInfoLoai(String maLoai);

    public boolean insertLoai(LoaiSanPham loai);

    public boolean updateLoai(LoaiSanPham loai);

    public boolean deleteLoai(String maLoai);
}
