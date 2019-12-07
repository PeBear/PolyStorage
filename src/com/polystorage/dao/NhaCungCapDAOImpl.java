package com.polystorage.dao;

import com.polystorage.entity.NhaCungCap;
import com.polystorage.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class NhaCungCapDAOImpl {

    public List<NhaCungCap> getListNhaCungCap(String tenNhaCungCap) {
        List<NhaCungCap> list = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String sql = "from NhaCungCap";
        if (tenNhaCungCap != null) {
            sql += " where tenNCC like '" + tenNhaCungCap + "%'";
        }
        Query query = session.createQuery(sql);
        list = query.list();
        session.close();
        return list;
    }

    public NhaCungCap getInfoNhaCungCap(String maNCC) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        NhaCungCap nhaCungCap = (NhaCungCap) session.get(NhaCungCap.class, maNCC);
        session.close();
        return nhaCungCap;
    }

    public boolean insertNhaCungCap(NhaCungCap nhaCungCap) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(nhaCungCap);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    public boolean updateNhaCungCap(NhaCungCap nhaCungCap) {
        if (getInfoNhaCungCap(nhaCungCap.getMaNCC()) == null) {
            return false;
        }
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.update(nhaCungCap);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    public boolean deleteNhaCungCap(String maNCC) {
        NhaCungCap nhaCungCap = getInfoNhaCungCap(maNCC);
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.delete(nhaCungCap);
            session.getTransaction().commit();
            return true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

}
