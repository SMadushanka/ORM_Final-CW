package lk.ijse.orm.ormh.dao.custom.impl;

import lk.ijse.orm.ormh.config.FactoryConfiguration;
import lk.ijse.orm.ormh.dao.custom.SessionDao;
import lk.ijse.orm.ormh.entity.Sessions;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class SessionDaoImpl implements SessionDao {
    FactoryConfiguration factoryConfiguration = FactoryConfiguration.getFactoryConfiguration();

    @Override
    public boolean save(Sessions entity) throws Exception {
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
    public boolean update(Sessions t) {
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
        Sessions entity = session.get(Sessions.class,id);
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
    public List<Sessions> getAll() {
        Session session = factoryConfiguration.getSessionFactory();
        return session.createQuery("from session").list();
    }

    @Override
    public Sessions findByPK(int id) {
        Session session = factoryConfiguration.getSessionFactory();
        return session.get(Sessions.class,id);
    }

    @Override
    public Optional<String> getLastPK() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getLastPK'");
    }
}
