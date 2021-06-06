package team.nti.test.galaxy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import team.nti.test.galaxy.model.Lord;
import team.nti.test.galaxy.service.LordService;

@Controller
public class LordController {

    private final LordService lordService;
    @Autowired
    public LordController(LordService lordService) {
        this.lordService = lordService;
    }

    @GetMapping ("/lord_list")
    public String lordList (Model model){
        model.addAttribute("lords",lordService.getAllLordsWithoutNull());
        return "lord_list";
    }

    @GetMapping("/lord_list/lazy")
    public String lazyLordList(Model model){
        model.addAttribute("lords", lordService.getAllLazyLords());
        return "lord_list";
    }

    @GetMapping("/lord_list/youngest10")
    public String youngLordList (Model model){
        model.addAttribute("lords", lordService.getTenYoungest());
        return "lord_list";
    }

    @GetMapping("/lord_list/remove/{id}")
    public String removeLord(@PathVariable(value = "id") Long id){
        Lord lord = lordService.getById(id);
        lordService.remove(lord);
        return "redirect:/lord_list";
    }

    @GetMapping("/create_lord_form")
    public String createLordForm (Model model){
        Lord lord = new Lord();
        model.addAttribute("lord",lord);
        return "create_lord_form";
    }

    @PostMapping("/create_lord_form/add")
    public String addLord (@ModelAttribute(value = "lord") Lord lord){
        lordService.add(lord);
        return "redirect:/";
    }
}
