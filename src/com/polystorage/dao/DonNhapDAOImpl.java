package com.polystorage.dao;

import com.polystorage.entity.DonNhap;
import com.polystorage.helper.ProcessString;
import com.polystorage.util.HibernateUtil;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class DonNhapDAOImpl implements DonNhapDAO {

    @Override
    public List<DonNhap> getListDonNhap(int maDN) {
        List<DonNhap> list = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String sql = "from DonNhap";
        if (maDN != -1) {
            sql += " and MaDN = '" + maDN + "'";
        }
        Query query = session.createQuery(sql);
        list = query.list();
        session.close();
        return list;
    }

    public List<DonNhap> getListDonNhap(Date min, Date max) {
        List<DonNhap> list = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String sql = "FROM DonNhap where NgayNhap >= :min AND NgayNhap <= :max";
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
                + " AND TABLE_NAME = 'donnhap'";
        Query query = session.createSQLQuery(sql);
        int nextId = Integer.parseInt(query.list().get(0).toString());
        session.close();
        return nextId;
    }

    public String getTongDonNhap(int maDN) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String sql = "CALL spGetTongDonNhap(" + maDN + ")";
        Query query = session.createSQLQuery(sql);
        List<Double> list = query.list();
        if (list.size() != 0) {
            return ProcessString.toVietnamMoney(list.get(0));
        }
        session.close();
        return "0";
    }

    @Override
    public DonNhap getInfoDonNhap(int maDN) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        DonNhap donHang = (DonNhap) session.get(DonNhap.class, maDN);
        session.close();
        return donHang;
    }

    @Override
    public boolean insertDonNhap(DonNhap dn) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(dn);
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
    public boolean updateDonNhap(DonNhap dn) {
        if (getInfoDonNhap(dn.getMaDN()) == null) {
            return false;
        }
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.update(dn);
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
    public boolean deleteDonNhap(int maDH) {
        DonNhap donNhap = getInfoDonNhap(maDH);
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.delete(donNhap);
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
