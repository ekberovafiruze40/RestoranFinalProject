package az.edu.itbrains.restoranfinalproject.controllers.dashboard;

import az.edu.itbrains.restoranfinalproject.dtos.ourTeam.TeamCreateDto;
import az.edu.itbrains.restoranfinalproject.dtos.ourTeam.TeamGetAllDto;
import az.edu.itbrains.restoranfinalproject.dtos.ourTeam.TeamGetIdDto;
import az.edu.itbrains.restoranfinalproject.dtos.ourTeam.TeamUpdateDto;
import az.edu.itbrains.restoranfinalproject.services.OurTeamService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TeamController {
    private final OurTeamService ourTeamService;

    public TeamController(OurTeamService ourTeamService) {
        this.ourTeamService = ourTeamService;
    }

    @GetMapping("/admin/team")
    public String team(Model model){
        List<TeamGetAllDto> result = ourTeamService.teamGetAll();
        model.addAttribute("teams", result);
        return "/dashboard/team/index";
    }

    @GetMapping("/admin/team/create")
    public String teamCreate(Model model){
        return "/dashboard/team/create";
    }

    @PostMapping("/admin/team/create")
    public String createTeam(@ModelAttribute("team")TeamCreateDto teamCreateDto){
        ourTeamService.createTeam(teamCreateDto);
        return "redirect:/admin/team";
    }

    @GetMapping("/admin/team/update/{id}")
    public String teamUpdate(@PathVariable Long id, Model model){
        TeamGetIdDto teamGetIdDto = ourTeamService.teamgetIdDto(id);
        model.addAttribute("team", teamGetIdDto);
        return "/dashboard/team/update";
    }

    @PostMapping("/admin/team/update/{id}")
    public String teamUpdate(@PathVariable Long id, @ModelAttribute("team")TeamUpdateDto teamUpdateDto){
        ourTeamService.updateTeam(teamUpdateDto, id);
        return "redirect:/admin/team";
    }

    @GetMapping("/admin/team/delete/{id}")
    public String deleteTeam(@PathVariable Long id){
        return "/dashboard/team/delete";
    }

    @PostMapping("/admin/team/delete/{id}")
    public String removeTeam(@PathVariable Long id){
        ourTeamService.deleteTeam(id);
        return "redirect:/admin/team";
    }
}
