package lk.ijse.orm.ormh.dao.custom;

import lk.ijse.orm.ormh.dao.CrudDao;
import lk.ijse.orm.ormh.entity.Admin;

import java.util.List;
import java.util.Optional;

public interface AdminDao extends CrudDao<Admin> {
    boolean authAdmin(String email, String password);
}
