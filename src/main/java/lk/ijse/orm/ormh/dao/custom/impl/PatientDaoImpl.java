package lk.ijse.orm.ormh.dao.custom.impl;

import lk.ijse.orm.ormh.config.FactoryConfiguration;
import lk.ijse.orm.ormh.dao.custom.PatientDao;
import lk.ijse.orm.ormh.entity.Patients;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class PatientDaoImpl implements PatientDao {
    FactoryConfiguration factoryConfiguration = FactoryConfiguration.getFactoryConfiguration();

    @Override
    public boolean save(Patients entity)throws Exception {
//        Session session = factoryConfiguration.getSessionFactory();
//        Transaction tx = session.beginTransaction();
//        try{
//            session.persist(entity);
//            tx.commit();
//            return true;
//        }catch (Exception e) {
//            e.printStackTrace();
//            tx.rollback();
//            return false;
//        }finally{
//            if (session != null){
//                session.close();
//            }
//        }
        return false;
    }

    @Override
    public boolean update(Patients patients) {
        Session session = factoryConfiguration.getSessionFactory();
        Transaction tx = session.beginTransaction();
        try{
            session.merge(patients);
            tx.commit();
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            tx.rollback();
            return false;
        }finally{
            if (session != null){
                session.close();
            }
        }
    }

    @Override
    public boolean deleteByPK(int id)throws Exception {
        Session session = factoryConfiguration.getSessionFactory();
        Transaction transaction = session.beginTransaction();
        Patients patients = session.get(Patients.class, id);
        try{
            session.remove(patients);
            transaction.commit();
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
            return false;
        }finally{
            if (session != null){
                session.close();
            }
        }
    }

    @Override
    public List<Patients> getAll() {
        Session session = factoryConfiguration.getSessionFactory();
        return session.createQuery("from patient").list();
    }

    @Override
    public Patients findByPK(int id) {
        Session session = factoryConfiguration.getSessionFactory();
        return session.get(Patients.class, id);
    }

    @Override
    public Optional<String> getLastPK() {
        return Optional.empty();
    }
    @Override
    public int saves(Patients patient) {
        int generatedId;
        Session session = factoryConfiguration.getSessionFactory();
        Transaction tx = session.beginTransaction();
        try {
            generatedId = (int) session.save(patient); // Hibernate assigns ID here
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }

        return generatedId;
    }
}
