package az.edu.itbrains.restoranfinalproject.services.impls;

import az.edu.itbrains.restoranfinalproject.dtos.ourTeam.*;
import az.edu.itbrains.restoranfinalproject.models.OurTeam;
import az.edu.itbrains.restoranfinalproject.repositories.OurTeamRepository;
import az.edu.itbrains.restoranfinalproject.services.OurTeamService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OurTeamServiceImpl implements OurTeamService {

    private final OurTeamRepository teamRepository;
    private final ModelMapper modelMapper;

    public OurTeamServiceImpl(OurTeamRepository teamRepository, ModelMapper modelMapper) {
        this.teamRepository = teamRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<OurTeamDto> getAllTeam() {
        List<OurTeamDto> teamDtos = teamRepository.findAll().stream()
                .map(ourTeam -> {
                    OurTeamDto teamDto = new OurTeamDto();
                    teamDto.setId(ourTeam.getId());
                    teamDto.setFullName(ourTeam.getFullName());
                    teamDto.setImageUrl(ourTeam.getImageUrl());
                    teamDto.setDesignation(ourTeam.getDesignation());
                    teamDto.setFacebookIcon(ourTeam.getFacebookIcon());
                    teamDto.setTwitterIcon(ourTeam.getTwitterIcon());
                    teamDto.setInstagramIcon(ourTeam.getInstagramIcon());
                    return teamDto;
                }).collect(Collectors.toList());
        return teamDtos;
    }

    @Override
    public List<TeamGetAllDto> teamGetAll() {
        List<TeamGetAllDto> teams=teamRepository.findAll()
                .stream().map(ourTeam -> modelMapper.map(ourTeam, TeamGetAllDto.class)).collect(Collectors.toList());
        return teams;
    }

    @Override
    public TeamGetIdDto teamgetIdDto(Long id) {
        OurTeam findTeam=teamRepository.findById(id).orElseThrow();
        TeamGetIdDto result = modelMapper.map(findTeam, TeamGetIdDto.class);
        return result;
    }

    @Override
    public void createTeam(TeamCreateDto teamCreateDto) {
        OurTeam team = new OurTeam();
        team.setFullName(teamCreateDto.getFullName());
        team.setImageUrl(teamCreateDto.getImageUrl());
        team.setDesignation(teamCreateDto.getDesignation());
        team.setFacebookIcon(teamCreateDto.getFacebookIcon());
        team.setTwitterIcon(teamCreateDto.getTwitterIcon());
        team.setInstagramIcon(teamCreateDto.getInstagramIcon());
        teamRepository.save(team);
    }

    @Override
    public void updateTeam(TeamUpdateDto teamUpdateDto, Long id) {
        OurTeam team = teamRepository.findById(id).orElseThrow();
        team.setFullName(teamUpdateDto.getFullName());
        team.setImageUrl(teamUpdateDto.getImageUrl());
        team.setDesignation(teamUpdateDto.getDesignation());
        team.setFacebookIcon(teamUpdateDto.getFacebookIcon());
        team.setTwitterIcon(teamUpdateDto.getTwitterIcon());
        team.setInstagramIcon(teamUpdateDto.getInstagramIcon());
        teamRepository.save(team);

    }

    @Override
    public void deleteTeam(Long id) {
        OurTeam findTeam = teamRepository.findById(id).orElseThrow();
        teamRepository.delete(findTeam);

    }
}
