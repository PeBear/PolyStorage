package com.polystorage.dao;

import com.polystorage.entity.Kho;
import com.polystorage.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

public class KhoDAO{

    public List<Kho> getListKho() {
        List<Kho> list = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        String sql = "from Kho";
        Query query = session.createQuery(sql);
        list = query.list();
        session.close();
        return list;
    }

    public Kho getInfoKho(String maKho) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Kho kho = (Kho) session.get(Kho.class, maKho);
        session.close();
        return kho;
    }

    public boolean insertKho(Kho kho) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(kho);
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

    public boolean updateKho(Kho kho) {
        if (getInfoKho(kho.getMaKho()) == null) {
            return false;
        }
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.update(kho);
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

    public boolean deleteKho(String maKho) {
        Kho kho = getInfoKho(maKho);
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.delete(kho);
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
