package team.nti.test.galaxy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import team.nti.test.galaxy.model.Planet;
import team.nti.test.galaxy.service.LordService;
import team.nti.test.galaxy.service.PlanetService;
@Controller
public class PlanetController {

    private final PlanetService planetService;
    private final LordService lordService;

    @Autowired
    public PlanetController(PlanetService planetService, LordService lordService) {
        this.lordService = lordService;
        this.planetService = planetService;
    }

    @GetMapping("/planet_list")
    public String planetList(Model model){
        model.addAttribute("planets",planetService.getAllPlanets());
        return "planet_list";
    }

    @GetMapping("/planet_list/remove/{id}")
    public String removePlanet(@PathVariable(value = "id") Long id){
        Planet planet = planetService.getById(id);
        planetService.remove(planet);
        return "redirect:/planet_list";
    }

    @GetMapping("/planet_list/{id}")
    public String lordsPlanetList(@PathVariable(value = "id") Long id, Model model){
        model.addAttribute("planets",planetService.getPlanetsByLordId(id));
        return "planet_list";
    }

    @GetMapping("/create_planet_form")
    public String createPlanetForm (Model model){
        Planet planet = new Planet();
        model.addAttribute("planet",planet);
        model.addAttribute("lords", lordService.getAllLords());
        return "create_planet_form";
    }

    @GetMapping("/edit_planet_form/edit/{id}")
    public String editPlanetForm(@PathVariable(value = "id") Long id, Model model){
        Planet planet = planetService.getById(id);
        model.addAttribute("planet",planet);
        model.addAttribute("lords", lordService.getAllLords());
        return "edit_planet_form";
    }

    @PostMapping("/create_planet_form/add")
    public String addPlanet (@ModelAttribute(value = "planet") Planet planet){
        planetService.add(planet);
        return "redirect:/";
    }
    @PostMapping("/edit_planet_form/save/{id}")
    public String editPlanet (@ModelAttribute(value = "planet") Planet editPlanet, @PathVariable(value = "id") Long id){
        Planet planet = planetService.getById(id);
        planet.setLord(editPlanet.getLord());
        planet.setName(editPlanet.getName());
        planetService.add(planet);
        return "redirect:/planet_list";
    }
}
