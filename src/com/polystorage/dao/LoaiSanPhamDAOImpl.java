package com.polystorage.dao;

import com.polystorage.entity.LoaiSanPham;
import com.polystorage.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class LoaiSanPhamDAOImpl {

    public List<LoaiSanPham> getListLoai(String loai) {
        List<LoaiSanPham> list = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String sql = "from LoaiSanPham";
        if (loai != null) {
            sql += " where Loai like '" + loai + "%'";
        }
        Query query = session.createQuery(sql);
        list = query.list();
        session.close();
        return list;
    }

    public LoaiSanPham getInfoLoai(String maLoai) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        LoaiSanPham loai = (LoaiSanPham) session.get(LoaiSanPham.class, maLoai);
        session.close();
        return loai;
    }

    public boolean insertLoai(LoaiSanPham loai) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(loai);
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

    public boolean updateLoai(LoaiSanPham loai) {
        if (getInfoLoai(loai.getMaLoai()) == null) {
            return false;
        }
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.update(loai);
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

    public boolean deleteLoai(String maLoai) {
        LoaiSanPham loai = getInfoLoai(maLoai);
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.delete(loai);
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
