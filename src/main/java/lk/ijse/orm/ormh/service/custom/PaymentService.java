package lk.ijse.orm.ormh.service.custom;

import lk.ijse.orm.ormh.dto.PaymentDto;
import lk.ijse.orm.ormh.service.SuperService;

public interface PaymentService extends SuperService {
    boolean savePayment(PaymentDto paymentDto) throws Exception;
}
