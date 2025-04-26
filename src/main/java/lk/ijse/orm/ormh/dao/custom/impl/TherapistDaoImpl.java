package lk.ijse.orm.ormh.dao.custom.impl;

import lk.ijse.orm.ormh.config.FactoryConfiguration;
import lk.ijse.orm.ormh.dao.custom.TherapistDao;
import lk.ijse.orm.ormh.entity.Therapists;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class TherapistDaoImpl implements TherapistDao {
    FactoryConfiguration factoryConfiguration = FactoryConfiguration.getFactoryConfiguration();

    @Override
    public boolean save(Therapists entity) throws Exception {
        Session session = factoryConfiguration.getSessionFactory();
        Transaction transaction = session.beginTransaction();

        try {
            session.persist(entity);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return false;
        }finally{
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public boolean update(Therapists t) {
        Session session = factoryConfiguration.getSessionFactory();
        Transaction transaction = session.beginTransaction();

        try {
            session.merge(t);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return false;
        }finally{
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public boolean deleteByPK(int id) throws Exception {
        Session session = factoryConfiguration.getSessionFactory();
        Transaction transaction = session.beginTransaction();
        Therapists entity = session.get(Therapists.class, id);
        try {
            session.remove(entity);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return false;
        }finally{
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public List<Therapists> getAll() {
        Session session = factoryConfiguration.getSessionFactory();
        return session.createQuery("from therapist").list();
    }

    @Override
    public Therapists findByPK(int id) {
        Session session = factoryConfiguration.getSessionFactory();
        return session.get(Therapists.class, id);
    }

    @Override
    public Optional<String> getLastPK() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getLastPK'");
    }
}
