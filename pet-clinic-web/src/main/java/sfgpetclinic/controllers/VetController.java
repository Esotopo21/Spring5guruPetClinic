package sfgpetclinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/vets")
@Controller
public class VetController {

    @GetMapping({"","/","/list","/list.html"})
    public String getVets(){

        return "vets/list";
    }
}
