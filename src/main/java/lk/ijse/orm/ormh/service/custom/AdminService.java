package lk.ijse.orm.ormh.service.custom;

import lk.ijse.orm.ormh.dto.AdminDto;
import lk.ijse.orm.ormh.service.SuperService;

public interface AdminService extends SuperService {

    boolean authAdmin(String email, String password);

    boolean saveAdmin(AdminDto adminDto) throws Exception;
}
