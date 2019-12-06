package com.polystorage.dao;

import com.polystorage.entity.NhanVien;
import java.util.List;

public interface NhanVienDAO {

    public List<NhanVien> getListNhanVien(String hoten);

    public NhanVien getInfoNhanVien(String manv);

    public boolean insertNhanVien(NhanVien nv);

    public boolean updateNhanVien(NhanVien nv);

    public boolean deleteNhanVien(String manv);
}
