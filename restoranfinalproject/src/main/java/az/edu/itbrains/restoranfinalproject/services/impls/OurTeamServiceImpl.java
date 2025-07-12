package az.edu.itbrains.restoranfinalproject.services.impls;

import az.edu.itbrains.restoranfinalproject.dtos.ourTeam.OurTeamDto;
import az.edu.itbrains.restoranfinalproject.repositories.OurTeamRepository;
import az.edu.itbrains.restoranfinalproject.services.OurTeamService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OurTeamServiceImpl implements OurTeamService {
    private final OurTeamRepository teamRepository;

    public OurTeamServiceImpl(OurTeamRepository teamRepository) {
        this.teamRepository = teamRepository;
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
}
