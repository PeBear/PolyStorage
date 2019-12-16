package com.polystorage.dao;

import com.polystorage.entity.ChiTietDonXuat;
import com.polystorage.entity.ChiTietDonXuatId;
import com.polystorage.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class ChiTietDonXuatDAO{

    public List<ChiTietDonXuat> getListChiTietDonXuat(int maDX) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String sql = "FROM ChiTietDonXuat WHERE MaDX = '" + maDX + "'";
        Query query = session.createQuery(sql);
        List<ChiTietDonXuat> list = query.list();
        session.close();
        return list;
    }

    public ChiTietDonXuat getInfoChiTietDonXuat(ChiTietDonXuatId chiTietDonHangId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        ChiTietDonXuat chiTietDonNhap = (ChiTietDonXuat) session.get(ChiTietDonXuat.class, chiTietDonHangId);
        session.close();
        return chiTietDonNhap;
    }

    public boolean insertChiTietDonXuat(ChiTietDonXuat chiTietDonXuat) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(chiTietDonXuat);
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

    public boolean updateChiTietDonXuat(ChiTietDonXuat chiTietDonXuat) {
        if (getInfoChiTietDonXuat(chiTietDonXuat.getId()) == null) {
            return false;
        }
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.update(chiTietDonXuat);
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

    public boolean deleteChiTietDonXuat(int maDX) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery("DELETE FROM ChiTietDonXuat where maDX = :maDX");
            query.setParameter("maDX", maDX);
            if (query.executeUpdate() > 0) {
                session.getTransaction().commit();
                return true;
            } else {
                session.getTransaction().commit();
                return false;
            }

        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

}
