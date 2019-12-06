package com.polystorage.dao;

import com.polystorage.entity.DonNhap;
import java.util.List;

public interface DonNhapDAO {

    public List<DonNhap> getListDonNhap(int maDN);

    public DonNhap getInfoDonNhap(int maDN);

    public boolean insertDonNhap(DonNhap dn);

    public boolean updateDonNhap(DonNhap dn);

    public boolean deleteDonNhap(int maDH);
}
