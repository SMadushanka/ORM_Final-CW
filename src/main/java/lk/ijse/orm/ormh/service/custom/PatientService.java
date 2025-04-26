package lk.ijse.orm.ormh.service.custom;

import lk.ijse.orm.ormh.dto.PatientDto;
import lk.ijse.orm.ormh.service.SuperService;

import java.util.ArrayList;

public interface PatientService extends SuperService {
    boolean deletePatient(int i) throws Exception;

    int savePatient(PatientDto patientDto) throws Exception;

    ArrayList<PatientDto> getAllPatients();

    boolean updatePatient(PatientDto patientDto);

}