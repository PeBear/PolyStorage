package com.polystorage.dao;

import com.polystorage.entity.ChiTietDonNhap;
import com.polystorage.entity.ChiTietDonNhapId;
import java.util.List;

public interface ChiTietDonNhapDAO {

    public List<ChiTietDonNhap> getListChiTietDonNhap(int maDN);

    public ChiTietDonNhap getInfoChiTietDonNhap(ChiTietDonNhapId maDN);

    public boolean insertChiTietDonNhap(ChiTietDonNhap chiTietDonNhap);

    public boolean updateChiTietDonNhap(ChiTietDonNhap chiTietDonNhap);

    public boolean deleteChiTietDonNhap(int maDN);
}
