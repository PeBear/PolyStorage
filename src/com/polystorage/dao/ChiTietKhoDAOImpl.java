/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.polystorage.dao;

import com.polystorage.entity.ChiTietKho;
import com.polystorage.entity.ChiTietKhoId;
import com.polystorage.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author xpeter
 */
public class ChiTietKhoDAOImpl implements ChiTietKhoDAO {

    @Override
    public List<ChiTietKho> getListChiTietKho(String maKho) {
        List<ChiTietKho> list = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String sql = "from ChiTietKho";
        if (maKho != null){
            sql += " where maKho = '" + maKho + "'";
        }
        Query query = session.createQuery(sql);
        list = query.list();
        session.close();
        return list;
    }

    @Override
    public ChiTietKho getInfoChiTietKho(ChiTietKhoId chiTietKhoId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        ChiTietKho chiTietKho = (ChiTietKho) session.get(ChiTietKho.class, chiTietKhoId);
        session.close();
        return chiTietKho;
    }

    @Override
    public boolean insertChiTietKho(ChiTietKho chiTietKho) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(chiTietKho);
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
    public boolean updateChiTietKho(ChiTietKho chiTietKho) {
        if (getInfoChiTietKho(chiTietKho.getId()) == null) {
            return false;
        }
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.update(chiTietKho);
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
    public boolean deleteChiTietKho(ChiTietKhoId chiTietKhoId) {
        ChiTietKho chiTietKho = getInfoChiTietKho(chiTietKhoId);
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.delete(chiTietKho);
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

    public boolean insertSanPhamKho(String maKho, String maSP, int soLuong) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("UPDATE ChiTietKho SET SoLuong = :soLuong WHERE MaKho = :maKho AND MaSP = :maSP");
        ChiTietKhoId chiTietKhoId = new ChiTietKhoId(maKho, maSP);
        int soLuongOld = getInfoChiTietKho(chiTietKhoId).getSoLuong();
        int sum = soLuong + soLuongOld;
        query.setParameter("maKho", maKho);
        query.setParameter("maSP", maSP);
        System.out.println("sum " + sum);
        query.setParameter("soLuong", sum);
        int result = query.executeUpdate();
        return result > 0;
    }
}
