package lk.ijse.orm.ormh.service.custom.impl;

import lk.ijse.orm.ormh.dao.DaoFactory;
import lk.ijse.orm.ormh.dao.custom.PatientDao;
import lk.ijse.orm.ormh.dao.custom.PaymentDao;
import lk.ijse.orm.ormh.dto.PaymentDto;
import lk.ijse.orm.ormh.entity.Patients;
import lk.ijse.orm.ormh.entity.Payment;
import lk.ijse.orm.ormh.service.custom.PaymentService;

import java.util.ArrayList;
import java.util.List;

public class PaymentServiceImpl implements PaymentService {
    PaymentDao paymentDao = (PaymentDao) DaoFactory.getDaoFactory().getDao(DaoFactory.daoType.PAYMENT);
    PatientDao patientDao = (PatientDao) DaoFactory.getDaoFactory().getDao(DaoFactory.daoType.PATIENT);

    @Override
    public boolean savePayment(PaymentDto paymentDto) throws Exception{
        Patients patients = patientDao.findByPK(paymentDto.getPatientId());
        return paymentDao.save(new Payment(
                paymentDto.getId(),
                paymentDto.getAmount(),
                patients
        ));
    }

    @Override
    public ArrayList<PaymentDto> getAllPayments() {
        ArrayList<PaymentDto>dtos = new ArrayList<>();
        List<Payment> payments = paymentDao.getAll();

        for (Payment payment : payments) {
            Patients patients = payment.getPatient();
            if (patients != null) {
                dtos.add(new PaymentDto(
                        payment.getId(),
                        payment.getAmount(),
                        payment.getPatient().getId()
                ));
            }
        }
        return dtos;
    }
}
