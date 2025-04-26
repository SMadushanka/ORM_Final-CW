package lk.ijse.orm.ormh.dao;

import lk.ijse.orm.ormh.dao.custom.impl.*;

public class DaoFactory {
    private static DaoFactory daoFactory;

    private DaoFactory(){}

    public static DaoFactory getDaoFactory(){
        return daoFactory != null ? daoFactory : new DaoFactory();
    }

    public SuperDao getDao(daoType type){
        switch (type) {
            case ADMIN:
                return new AdminDaoImpl();
            case RECEPTION:
                return new ReceptionDaoImpl();
            case PROGRAMME:
                return new ProgrammeDaoImpl();
            case THERAPIST:
                return new TherapistDaoImpl();
            case SESSIONS:
                return new SessionDaoImpl();
            case PATIENT:
                return new PatientDaoImpl();
            case PAYMENT:
                return new PaymentDaoImpl();
            default:
                return null;
        }
    }

    public enum daoType{
        ADMIN,RECEPTION,PROGRAMME,THERAPIST,SESSIONS,PATIENT,PAYMENT
    }
}

