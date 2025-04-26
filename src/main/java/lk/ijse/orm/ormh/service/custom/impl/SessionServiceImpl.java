package lk.ijse.orm.ormh.service.custom.impl;

import lk.ijse.orm.ormh.dao.DaoFactory;
import lk.ijse.orm.ormh.dao.custom.SessionDao;
import lk.ijse.orm.ormh.dao.custom.TherapistDao;
import lk.ijse.orm.ormh.dto.SessionDto;
import lk.ijse.orm.ormh.entity.Sessions;
import lk.ijse.orm.ormh.entity.Therapists;
import lk.ijse.orm.ormh.service.custom.SessionService;

import java.util.ArrayList;
import java.util.List;

public class SessionServiceImpl implements SessionService {
    SessionDao sessionDao = (SessionDao) DaoFactory.getDaoFactory().getDao(DaoFactory.daoType.SESSIONS);
    TherapistDao therapistDao = (TherapistDao) DaoFactory.getDaoFactory().getDao(DaoFactory.daoType.THERAPIST);

    @Override public ArrayList<SessionDto> getAllSessions() {
        ArrayList<SessionDto>sessionDtos = new ArrayList<>();
        List<Sessions> sessions = sessionDao.getAll();

        for (Sessions session : sessions) {
            Therapists therapists = session.getTherapists();
            if (therapists != null) {
                SessionDto sessionDto = new SessionDto(
                        session.getId(),
                        session.getName(),
                        session.getStart(),
                        session.getEnd(),
                        session.getTherapists().getId()
                );
                sessionDtos.add(sessionDto);
            }
        }
        return sessionDtos;
    }

    @Override
    public boolean saveSession(SessionDto sessionDto) throws Exception{

        Therapists therapist = therapistDao.findByPK(sessionDto.getTherapistId());

        return sessionDao.save(new Sessions(
                sessionDto.getId(),
                sessionDto.getName(),
                sessionDto.getStart(),
                sessionDto.getEnd(),
                therapist
        ));
    }

    @Override
    public boolean deleteSession(int i) throws  Exception{
        return sessionDao.deleteByPK(i);
    }

    @Override
    public boolean updateService(SessionDto sessionDto) {
        Sessions sessions = sessionDao.findByPK(sessionDto.getId());
        Therapists therapistDto = therapistDao.findByPK(sessionDto.getTherapistId());
        if (sessions != null) {
            return sessionDao.update(new Sessions(
                    sessionDto.getId(),
                    sessionDto.getName(),
                    sessionDto.getStart(),
                    sessionDto.getEnd(),
                    therapistDto
            ));
        }else {
            return false;
        }
    }
}

