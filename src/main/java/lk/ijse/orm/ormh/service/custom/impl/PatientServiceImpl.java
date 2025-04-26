package lk.ijse.orm.ormh.service.custom.impl;

import lk.ijse.orm.ormh.dao.DaoFactory;
import lk.ijse.orm.ormh.dao.custom.PatientDao;
import lk.ijse.orm.ormh.dao.custom.ProgrammeDao;
import lk.ijse.orm.ormh.dao.custom.SessionDao;
import lk.ijse.orm.ormh.dto.PatientDto;
import lk.ijse.orm.ormh.entity.Patients;
import lk.ijse.orm.ormh.entity.Programme;
import lk.ijse.orm.ormh.entity.Sessions;
import lk.ijse.orm.ormh.service.custom.PatientService;

import java.util.ArrayList;
import java.util.List;

public class PatientServiceImpl implements PatientService {
    PatientDao patientDao = (PatientDao) DaoFactory.getDaoFactory().getDao(DaoFactory.daoType.PATIENT);
    ProgrammeDao programmeDao = (ProgrammeDao) DaoFactory.getDaoFactory().getDao(DaoFactory.daoType.PROGRAMME);
    SessionDao sessionDao = (SessionDao) DaoFactory.getDaoFactory().getDao(DaoFactory.daoType.SESSIONS);
    @Override
    public ArrayList<PatientDto> getAllPatients() {
        ArrayList<PatientDto>patientDtos = new ArrayList<>();
        List<Patients> patients = patientDao.getAll();

        for (Patients patient : patients ) {
            Programme programme = patient.getProgrammeID();
            Sessions sessions = patient.getSessionID();

            if (programme != null && sessions != null) {
                PatientDto patientDto = new PatientDto(
                        patient.getId(),
                        patient.getName(),
                        patient.getEmail(),
                        patient.getPhone(),
                        patient.getProgrammeID().getId(),
                        patient.getSessionID().getId()
                );
                patientDtos.add(patientDto);
            }
        }
        return patientDtos;
    }

    @Override
    public boolean deletePatient(int i) throws Exception {
        return patientDao.deleteByPK(i);
    }

    @Override
    public boolean updatePatient(PatientDto patientDto) {
        Patients patients = patientDao.findByPK(patientDto.getId());
        Programme programme = programmeDao.findByPK(patientDto.getProgrammeId());
        Sessions sessions = sessionDao.findByPK(patientDto.getSessionId());

        if (patients != null) {
            return patientDao.update(new Patients(
                    patientDto.getId(),
                    patientDto.getName(),
                    patientDto.getEmail(),
                    patientDto.getPhone(),
                    programme,
                    sessions
            ));
        }else {
            return false;
        }
    }

    @Override
    public int savePatient(PatientDto patientDto) throws Exception{
        Programme programme = programmeDao.findByPK(patientDto.getProgrammeId());
        Sessions sessions = sessionDao.findByPK(patientDto.getSessionId());

        Patients patient = new Patients(
                patientDto.getId(),  // If this is auto-generated, set it to 0 or ignore it
                patientDto.getName(),
                patientDto.getEmail(),
                patientDto.getPhone(),
                programme,
                sessions
        );

        return patientDao.saves(patient);
    }
}
