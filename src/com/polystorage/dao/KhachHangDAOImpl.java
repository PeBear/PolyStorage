package com.polystorage.dao;

import com.polystorage.entity.KhachHang;
import com.polystorage.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class KhachHangDAOImpl {

    public List<KhachHang> getListKhachHang(String tenKhachHang) {
        List<KhachHang> list = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String sql = "from KhachHang";
        if (tenKhachHang != null) {
            sql += " where HoTen like '" + tenKhachHang + "%'";
        }
        Query query = session.createQuery(sql);
        list = query.list();
        session.close();
        return list;
    }

    public KhachHang getInfoKhachHang(String maKH) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        KhachHang khachHang = (KhachHang) session.get(KhachHang.class, maKH);
        session.close();
        return khachHang;
    }

    public boolean insertKhachHang(KhachHang khachHang) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(khachHang);
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

    public boolean updateKhachHang(KhachHang khachHang) {
        if (getInfoKhachHang(khachHang.getMaKH()) == null) {
            return false;
        }
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.update(khachHang);
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

    public boolean deleteKhachHang(String maKH) {
        KhachHang khachHang = getInfoKhachHang(maKH);
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.delete(khachHang);
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
