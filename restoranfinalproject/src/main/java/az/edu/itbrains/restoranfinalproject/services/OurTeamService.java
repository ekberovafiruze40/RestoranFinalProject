package az.edu.itbrains.restoranfinalproject.services;

import az.edu.itbrains.restoranfinalproject.dtos.ourTeam.*;

import java.util.List;

public interface OurTeamService {
    List<OurTeamDto> getAllTeam();

    List<TeamGetAllDto> teamGetAll();

    TeamGetIdDto teamgetIdDto(Long id);

    void createTeam(TeamCreateDto teamCreateDto);
    void updateTeam(TeamUpdateDto teamUpdateDto, Long id);
    void deleteTeam(Long id);
}
