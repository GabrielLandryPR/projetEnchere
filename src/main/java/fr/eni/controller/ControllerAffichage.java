package fr.eni.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import fr.eni.bo.Article;

@Controller
public class ControllerAffichage {
	
    @GetMapping({"/encheres/","/enchere/","/encheres","/enchere"})
    public String redirectToIndex() {
        return "redirect:/";
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
