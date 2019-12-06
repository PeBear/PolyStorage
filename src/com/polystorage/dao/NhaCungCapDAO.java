package com.polystorage.dao;

import com.polystorage.entity.NhaCungCap;
import java.util.List;

public interface NhaCungCapDAO {

    public List<NhaCungCap> getListNhaCungCap(String tenNhaCungCap);

    public NhaCungCap getInfoNhaCungCap(String maNCC);

    public boolean insertNhaCungCap(NhaCungCap nhaCungCap);

    public boolean updateNhaCungCap(NhaCungCap nhaCungCap);

    public boolean deleteNhaCungCap(String maNCC);
}
