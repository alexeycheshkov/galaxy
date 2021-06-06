package team.nti.test.galaxy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String mainPage(){
        return "main";
    }

    @GetMapping("/showLordList")
    public String showLordList(){
        return "redirect:/lord_list";
    }
    @GetMapping("/showPlanetList")
    public String showPlanetList(){
        return "redirect:/planet_list";
    }
    @GetMapping("/createLordForm")
    public String createLord(){
        return "redirect:/create_lord_form";
    }
    @GetMapping("/createPlanetForm")
    public String createPlanet(){
        return "redirect:/create_planet_form";
    }
}
