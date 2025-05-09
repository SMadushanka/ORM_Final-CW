package lk.ijse.orm.ormh.dao.custom.impl;

import lk.ijse.orm.ormh.config.FactoryConfiguration;
import lk.ijse.orm.ormh.dao.custom.AdminDao;
import lk.ijse.orm.ormh.entity.Admin;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class AdminDaoImpl implements AdminDao {
    FactoryConfiguration configuration = FactoryConfiguration.getFactoryConfiguration();

    @Override
    public boolean save(Admin entity) throws Exception {
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
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public boolean update(Admin t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public boolean deleteByPK(int id) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteByPK'");
    }

    @Override
    public List<Admin> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public Optional<String> getLastPK() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getLastPK'");
    }

    @Override
    public Admin findByPK(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByPK'");
    }

    // Login Authentication with Hibernate
    @Override
    public boolean authAdmin(String email, String password) {
        Session session = configuration.getSessionFactory();
        return session.createQuery("from admin where email=:email and password=:password")
                .setParameter("email", email)
                .setParameter("password", password)
                .list().size() > 0;
    }
}
