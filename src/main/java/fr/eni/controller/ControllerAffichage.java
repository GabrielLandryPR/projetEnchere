package fr.eni.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class ControllerAffichage {

	
	
	
	
	
	@GetMapping("/formLog")
	public String affichageIndex() {
		return "formLog";
	}
	
}
