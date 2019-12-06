package com.polystorage.dao;

import com.polystorage.entity.Kho;
import java.util.List;

public interface KhoDAO {

    public List<Kho> getListKho();

    public Kho getInfoKho(String maKho);

    public boolean insertKho(Kho kho);

    public boolean updateKho(Kho kho);

    public boolean deleteKho(String maKho);
}
