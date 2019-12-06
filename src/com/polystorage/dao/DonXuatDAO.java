package com.polystorage.dao;

import com.polystorage.entity.DonXuat;
import java.util.List;

public interface DonXuatDAO {

    public List<DonXuat> getListDonXuat(int maDX);

    public DonXuat getInfoDonXuat(int maDX);

    public boolean insertDonXuat(DonXuat dx);

    public boolean updateDonXuat(DonXuat dx);

    public boolean deleteDonXuat(int maDX);
}
