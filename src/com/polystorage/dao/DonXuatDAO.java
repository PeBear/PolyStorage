package com.polystorage.dao;

import com.polystorage.entity.DonXuat;
import com.polystorage.util.HibernateUtil;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class DonXuatDAO{

    public List<DonXuat> getListDonXuat(int maDX) {
        List<DonXuat> list = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String sql = "from DonXuat";
        if (maDX != -1) {
            sql += " and MaDX = '" + maDX + "'";
        }
        Query query = session.createQuery(sql);
        list = query.list();
        session.close();
        return list;
    }

    public List<DonXuat> getListDonXuat(Date min, Date max) {
        List<DonXuat> list = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String sql = "FROM DonXuat where NgayXuat >= :min AND NgayXuat <= :max";
        Query query = session.createQuery(sql);
        query.setParameter("min", min);
        query.setParameter("max", max);
        list = query.list();
        session.close();
        return list;
    }

    public int getNextId() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String sql = "SELECT AUTO_INCREMENT FROM information_schema.TABLES"
                + " WHERE TABLE_SCHEMA = 'polystorage'"
                + " AND TABLE_NAME = 'donxuat'";
        Query query = session.createSQLQuery(sql);
        int nextId = Integer.parseInt(query.list().get(0).toString());
        session.close();
        return nextId;
    }

    public double getTongDonXuat(int maDX) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String sql = "CALL spGetTongDonXuat(" + maDX + ")";
        Query query = session.createSQLQuery(sql);
        List<Double> list = query.list();
        if (list.size() == 0) {
            return 0;
        }
        session.close();
        return list.get(0);
    }

    public DonXuat getInfoDonXuat(int maDX) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        DonXuat donHang = (DonXuat) session.get(DonXuat.class, maDX);
        session.close();
        return donHang;
    }

    public boolean insertDonXuat(DonXuat dx) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(dx);
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

    public boolean updateDonXuat(DonXuat dx) {
        if (getInfoDonXuat(dx.getMaDX()) == null) {
            return false;
        }
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.update(dx);
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

    public boolean deleteDonXuat(int maDX) {
        DonXuat donXuat = getInfoDonXuat(maDX);
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.delete(donXuat);
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
