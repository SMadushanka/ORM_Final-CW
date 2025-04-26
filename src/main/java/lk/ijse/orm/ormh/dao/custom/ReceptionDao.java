package lk.ijse.orm.ormh.dao.custom;

import lk.ijse.orm.ormh.dao.CrudDao;
import lk.ijse.orm.ormh.entity.Reception;

import java.util.List;
import java.util.Optional;

public interface ReceptionDao extends CrudDao<Reception> {
    boolean authLogin(String email, String password);
}
