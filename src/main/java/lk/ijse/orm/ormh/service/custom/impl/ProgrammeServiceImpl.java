package lk.ijse.orm.ormh.service.custom.impl;

import lk.ijse.orm.ormh.dao.DaoFactory;
import lk.ijse.orm.ormh.dao.DaoFactory.daoType;
import lk.ijse.orm.ormh.dao.custom.ProgrammeDao;
import lk.ijse.orm.ormh.dto.ProgrammeDto;
import lk.ijse.orm.ormh.entity.Programme;
import lk.ijse.orm.ormh.service.custom.ProgrammeService;

import java.util.ArrayList;
import java.util.List;

public class ProgrammeServiceImpl implements ProgrammeService {
    ProgrammeDao programmeDao = (ProgrammeDao) DaoFactory.getDaoFactory().getDao(daoType.PROGRAMME);

    @Override
    public ArrayList<ProgrammeDto> getAllProgrammes() {
        ArrayList<ProgrammeDto> programmeDtos = new ArrayList<>();
        List<Programme> programmes = programmeDao.getAll();

        for (Programme programme : programmes) {
            ProgrammeDto programmeDto = new ProgrammeDto(programme.getId(),programme.getName(),programme.getDuration(),programme.getFees());
            programmeDtos.add(programmeDto);
        }
        return programmeDtos;

    }

    @Override
    public boolean saveProgramme(ProgrammeDto programmeDto) throws Exception {
        return programmeDao.save(new Programme(
                programmeDto.getId(),
                programmeDto.getName(),
                programmeDto.getDuration(),
                programmeDto.getFees()
        ));
    }

    @Override
    public boolean updateProgramme(ProgrammeDto programmeDto) {

        Programme programme = programmeDao.findByPK(programmeDto.getId());
        if (programme != null) {
            return programmeDao.update(new Programme(
                    programmeDto.getId(),
                    programmeDto.getName(),
                    programmeDto.getDuration(),
                    programmeDto.getFees()
            ));
        }else{
            return false;
        }
    }

    @Override
    public boolean deleteProgramme(int id) throws Exception {
        return programmeDao.deleteByPK(id);
    }
}
