package lk.ijse.orm.ormh.service.custom;

import lk.ijse.orm.ormh.dto.SessionDto;
import lk.ijse.orm.ormh.service.SuperService;

import java.util.ArrayList;

public interface SessionService extends SuperService {
    ArrayList<SessionDto> getAllSessions();

}
