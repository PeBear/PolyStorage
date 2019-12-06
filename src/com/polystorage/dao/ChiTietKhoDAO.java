package com.polystorage.dao;

import com.polystorage.entity.ChiTietKho;
import com.polystorage.entity.ChiTietKhoId;
import java.util.List;

public interface ChiTietKhoDAO {

    public List<ChiTietKho> getListChiTietKho(String maKho);

    public ChiTietKho getInfoChiTietKho(ChiTietKhoId chiTietKhoId);

    public boolean insertChiTietKho(ChiTietKho chiTietKho);

    public boolean updateChiTietKho(ChiTietKho chiTietKho);

    public boolean deleteChiTietKho(ChiTietKhoId chiTietKhoId);
}
