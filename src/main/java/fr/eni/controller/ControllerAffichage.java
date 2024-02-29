package fr.eni.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControllerAffichage {
	
    @GetMapping({"/encheres/","/enchere/","/encheres","/enchere"})
    public String redirectToIndex() {
        return "redirect:/";
    }
	
	@GetMapping("/newSell")
	public String affichageNewSell() {
		return "newSell";
	}
	
	@GetMapping("/detailsVente")
	public String affichagedetailsVente() {
		return "detailsVente";
	}
	
	@GetMapping("/remporterVente")
	public String affichageremporterVente() {
		return "remporterVente";
	}
}
