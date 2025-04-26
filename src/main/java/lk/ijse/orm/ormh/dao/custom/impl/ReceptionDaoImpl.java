package lk.ijse.orm.ormh.dao.custom.impl;

import lk.ijse.orm.ormh.config.FactoryConfiguration;
import lk.ijse.orm.ormh.dao.custom.ReceptionDao;
import lk.ijse.orm.ormh.entity.Reception;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class ReceptionDaoImpl implements ReceptionDao {
    FactoryConfiguration configuration = FactoryConfiguration.getFactoryConfiguration();
    @Override
    public boolean save(Reception entity) throws Exception {
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
    public boolean update(Reception t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }
    @Override
    public boolean deleteByPK(int id) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteByPK'");
    }
    @Override
    public List<Reception> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public Optional<String> getLastPK() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getLastPK'");
    }
    @Override
    public Reception findByPK(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByPK'");
    }
    @Override
    public boolean authLogin(String email, String password) {
        Session session = configuration.getSessionFactory();
        return session.createQuery("from reception where email=:email and password=:password")
                .setParameter("email", email)
                .setParameter("password", password)
                .list().size() > 0;
    }
}
