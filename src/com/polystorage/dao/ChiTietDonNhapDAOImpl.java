package com.polystorage.dao;

import com.polystorage.entity.ChiTietDonNhap;
import com.polystorage.entity.ChiTietDonNhapId;
import com.polystorage.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class ChiTietDonNhapDAOImpl implements ChiTietDonNhapDAO {

    @Override
    public List<ChiTietDonNhap> getListChiTietDonNhap(int maDN) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String sql = "FROM ChiTietDonNhap WHERE MaDN = " + maDN;
        Query query = session.createQuery(sql);
        List<ChiTietDonNhap> list = query.list();
        session.close();
        return list;
    }

    @Override
    public ChiTietDonNhap getInfoChiTietDonNhap(ChiTietDonNhapId chiTietDonHangId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        ChiTietDonNhap chiTietDonNhap = (ChiTietDonNhap) session.get(ChiTietDonNhap.class, chiTietDonHangId);
        session.close();
        return chiTietDonNhap;
    }

    @Override
    public boolean insertChiTietDonNhap(ChiTietDonNhap chiTietDonNhap) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(chiTietDonNhap);
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

    @Override
    public boolean updateChiTietDonNhap(ChiTietDonNhap chiTietDonNhap) {
        if (getInfoChiTietDonNhap(chiTietDonNhap.getId()) == null) {
            return false;
        }
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.update(chiTietDonNhap);
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

    @Override
    public boolean deleteChiTietDonNhap(int maDN) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery("DELETE FROM ChiTietDonNhap where maDN = :maDN");
            query.setParameter("maDN", maDN);
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
