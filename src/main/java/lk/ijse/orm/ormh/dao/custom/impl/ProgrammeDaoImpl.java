package lk.ijse.orm.ormh.dao.custom.impl;

import lk.ijse.orm.ormh.config.FactoryConfiguration;
import lk.ijse.orm.ormh.dao.custom.ProgrammeDao;
import lk.ijse.orm.ormh.entity.Programme;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class ProgrammeDaoImpl implements ProgrammeDao {
    FactoryConfiguration configuration = FactoryConfiguration.getFactoryConfiguration();

    @Override
    public boolean save(Programme entity) throws Exception {
        Session session = configuration.getSessionFactory();
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
    public boolean update(Programme t) {

        Session session = configuration.getSessionFactory();
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
        Session session = configuration.getSessionFactory();
        Transaction transaction = session.beginTransaction();
        Programme programme = session.get(Programme.class, id);
        try {
            session.remove(programme);
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
    public List<Programme> getAll() {
        Session session = configuration.getSessionFactory();
        return session.createQuery("from programme").list();
    }


    @Override
    public Optional<String> getLastPK() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getLastPK'");
    }

    @Override
    public Programme findByPK(int id) {
        Session session = configuration.getSessionFactory();
        return session.get(Programme.class, id);
    }
}
