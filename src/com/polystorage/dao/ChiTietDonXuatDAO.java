package com.polystorage.dao;

import com.polystorage.entity.ChiTietDonXuat;
import com.polystorage.entity.ChiTietDonXuatId;
import java.util.List;

public interface ChiTietDonXuatDAO {

    public List<ChiTietDonXuat> getListChiTietDonXuat(int maDX);

    public ChiTietDonXuat getInfoChiTietDonXuat(ChiTietDonXuatId maDX);

    public boolean insertChiTietDonXuat(ChiTietDonXuat chiTietDonXuat);

    public boolean updateChiTietDonXuat(ChiTietDonXuat chiTietDonXuat);

    public boolean deleteChiTietDonXuat(int maDX);
}
