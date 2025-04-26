package lk.ijse.orm.ormh.service.custom;

import lk.ijse.orm.ormh.dto.TherapistDto;
import lk.ijse.orm.ormh.service.SuperService;

import java.util.ArrayList;

public interface TherapistService extends SuperService {
    ArrayList<TherapistDto> getAllTherapists();

    boolean updateTherapist(TherapistDto therapistDto);

    boolean saveTherapist(TherapistDto therapistDto) throws Exception;

    boolean deleteTherapist(int int1) throws Exception;

    TherapistDto findByID(int i);
}
