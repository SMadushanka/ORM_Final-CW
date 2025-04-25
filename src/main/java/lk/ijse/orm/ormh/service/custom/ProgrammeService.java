package lk.ijse.orm.ormh.service.custom;

import lk.ijse.orm.ormh.dto.ProgrammeDto;
import lk.ijse.orm.ormh.service.SuperService;

import java.util.ArrayList;

public interface ProgrammeService extends SuperService {
    ArrayList<ProgrammeDto> getAllProgrammes();
}
