package lk.ijse.orm.ormh.service.custom;

import lk.ijse.orm.ormh.dto.ReceptionDto;
import lk.ijse.orm.ormh.service.SuperService;

public interface ReceptionService extends SuperService {
    boolean saveReception(ReceptionDto receptionDto) throws Exception;

    boolean authLogin(String email, String password);
}
