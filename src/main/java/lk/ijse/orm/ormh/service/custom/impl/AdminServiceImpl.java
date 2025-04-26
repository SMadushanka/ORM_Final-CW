package lk.ijse.orm.ormh.service.custom.impl;

import lk.ijse.orm.ormh.dao.DaoFactory;
import lk.ijse.orm.ormh.dao.DaoFactory.daoType;
import lk.ijse.orm.ormh.dao.custom.AdminDao;
import lk.ijse.orm.ormh.dto.AdminDto;
import lk.ijse.orm.ormh.entity.Admin;
import lk.ijse.orm.ormh.service.custom.AdminService;

public class AdminServiceImpl implements AdminService {
    AdminDao adminDao = (AdminDao) DaoFactory.getDaoFactory().getDao(daoType.ADMIN);
    @Override
    public boolean saveAdmin(AdminDto adminDto) throws Exception{
        return adminDao.save(new Admin(
                adminDto.getName(),
                adminDto.getEmail(),
                adminDto.getPassword(),
                adminDto.getContact()
        ));
    }

    @Override
    public boolean authAdmin(String email, String password) {
        return adminDao.authAdmin(email, password);
    }

}