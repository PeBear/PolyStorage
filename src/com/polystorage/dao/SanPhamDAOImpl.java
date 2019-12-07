package com.polystorage.dao;

import com.polystorage.entity.SanPham;
import com.polystorage.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class SanPhamDAOImpl {

    public List<SanPham> getListSanPham(String tensp) {
        List<SanPham> list = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String sql = "FROM SanPham";
        if (tensp != null) {
            sql += " where SanPham like '" + tensp + "%'";
        }
        Query query = session.createQuery(sql);
        list = query.list();
        session.close();
        return list;
    }

    public SanPham getInfoSanPham(String masp) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        SanPham nv = (SanPham) session.get(SanPham.class, masp);
        session.close();
        return nv;
    }

    public boolean insertSanPham(SanPham sp) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(sp);
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

    public boolean updateSanPham(SanPham sp) {
        if (getInfoSanPham(sp.getMaSp()) == null) {
            return false;
        }
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.update(sp);
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

    public boolean deleteSanPham(String masp) {
        SanPham sp = this.getInfoSanPham(masp);
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.delete(sp);
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
