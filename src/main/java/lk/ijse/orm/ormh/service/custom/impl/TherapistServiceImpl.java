package lk.ijse.orm.ormh.service.custom.impl;

import lk.ijse.orm.ormh.dao.DaoFactory;
import lk.ijse.orm.ormh.dao.DaoFactory.daoType;
import lk.ijse.orm.ormh.dao.custom.TherapistDao;
import lk.ijse.orm.ormh.dto.TherapistDto;
import lk.ijse.orm.ormh.entity.Therapists;
import lk.ijse.orm.ormh.service.custom.TherapistService;

import java.util.ArrayList;
import java.util.List;

public class TherapistServiceImpl implements TherapistService {

    TherapistDao therapistDao = (TherapistDao) DaoFactory.getDaoFactory().getDao(daoType.THERAPIST);

    @Override
    public ArrayList<TherapistDto> getAllTherapists() {
        ArrayList<TherapistDto>therapistDtos = new ArrayList<>();
        List<Therapists>therapists = therapistDao.getAll();

        for (Therapists therapist : therapists) {
            TherapistDto dto = new TherapistDto(
                    therapist.getId(),
                    therapist.getName(),
                    therapist.getEmail(),
                    therapist.getPhone()
            );
            therapistDtos.add(dto);
        }
        return therapistDtos;
    }

    @Override
    public boolean saveTherapist(TherapistDto therapistDto) throws Exception {
        return therapistDao.save(new Therapists(
                therapistDto.getId(),
                therapistDto.getName(),
                therapistDto.getEmail(),
                therapistDto.getPhone()
        ));
    }

    @Override
    public boolean updateTherapist(TherapistDto therapistDto) {
        Therapists therapists = therapistDao.findByPK(therapistDto.getId());

        if (therapists != null) {
            return therapistDao.update(new Therapists(
                    therapistDto.getId(),
                    therapistDto.getName(),
                    therapistDto.getEmail(),
                    therapistDto.getPhone()
            ));
        }else{
            return false;
        }
    }

    @Override
    public boolean deleteTherapist(int int1) throws Exception {
        return therapistDao.deleteByPK(int1);
    }

    @Override
    public TherapistDto findByID(int i) {
        Therapists therapists = therapistDao.findByPK(i);
        if (therapists != null) {
            return new TherapistDto(
                    therapists.getId(), therapists.getName(), therapists.getEmail(), therapists.getPhone()
            );
        };
        return null;
    }
}


