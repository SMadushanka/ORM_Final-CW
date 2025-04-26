package lk.ijse.orm.ormh.service.custom.impl;

import lk.ijse.orm.ormh.dao.DaoFactory;
import lk.ijse.orm.ormh.dao.DaoFactory.daoType;
import lk.ijse.orm.ormh.dao.custom.ReceptionDao;
import lk.ijse.orm.ormh.dto.ReceptionDto;
import lk.ijse.orm.ormh.entity.Reception;
import lk.ijse.orm.ormh.service.custom.ReceptionService;

public class ReceptionServiceImpl implements ReceptionService {
    ReceptionDao receptionDao = (ReceptionDao) DaoFactory.getDaoFactory().getDao(daoType.RECEPTION);

    @Override
    public boolean saveReception(ReceptionDto receptionDto) throws Exception {
        return receptionDao.save(new Reception(receptionDto.getName(), receptionDto.getEmail(),
                receptionDto.getPassword(), receptionDto.getContact()));
    }

    @Override
    public boolean authLogin(String email, String password) {
        return receptionDao.authLogin(email,password);
    }

}
