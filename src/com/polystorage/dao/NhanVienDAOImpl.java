package com.polystorage.dao;

import com.polystorage.entity.NhanVien;
import com.polystorage.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class NhanVienDAOImpl {

    public List<NhanVien> getListNhanVien(String hoten) {
        List<NhanVien> list = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String sql = "from NhanVien";
        if (hoten != null) {
            sql += " where HoTen like '" + hoten + "%'";
        }
        Query query = session.createQuery(sql);
        list = query.list();
        session.close();
        return list;
    }

    public NhanVien getInfoNhanVien(String manv) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        NhanVien nv = (NhanVien) session.get(NhanVien.class, manv);
        session.close();
        return nv;
    }

    public boolean insertNhanVien(NhanVien nv) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(nv);
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

    public boolean updateNhanVien(NhanVien nv) {
        if (getInfoNhanVien(nv.getMaNv()) == null) {
            return false;
        }
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.update(nv);
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

    public boolean deleteNhanVien(String manv) {
        NhanVien nv = getInfoNhanVien(manv);
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.delete(nv);
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
