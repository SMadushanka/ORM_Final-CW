package lk.ijse.orm.ormh.service;

import lk.ijse.orm.ormh.service.custom.impl.*;

import java.beans.beancontext.BeanContextServiceProvider;

public class ServiceFactory {
    private static ServiceFactory serviceFactory;

    private ServiceFactory(){}

    public static ServiceFactory getServiceFactory(){
        return serviceFactory != null ? serviceFactory : new ServiceFactory();
    }

    public SuperService getService(serviceType type){
        switch (type) {
            case ADMIN:
                return new AdminServiceImpl();
            case RECEPTION:
                return new ReceptionServiceImpl();
            case PROGRAMME:
                return new ProgrammeServiceImpl();
            case THERAPIST:
                return new TherapistServiceImpl();
            case SESSIONS:
                return new SessionServiceImpl();
            case PATIENT:
                return new PatientServiceImpl();
            case PAYMENT:
                return new PaymentServiceImpl();
            default:
                return null;
        }
    }

    public enum serviceType{
        ADMIN,RECEPTION,PROGRAMME,THERAPIST,SESSIONS,PATIENT,PAYMENT
    }
}
