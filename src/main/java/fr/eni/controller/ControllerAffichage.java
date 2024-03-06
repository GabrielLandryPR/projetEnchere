package fr.eni.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.eni.bll.UtilisateurService;
import fr.eni.bo.Utilisateur;


@Controller
public class ControllerAffichage {
	
	private UtilisateurService utilisateurService;
	
	
	
    public ControllerAffichage(UtilisateurService utilisateurService) {
		this.utilisateurService = utilisateurService;
	}

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
	
	@GetMapping("/listeUtilisateurs")
	public String afficherListeUsers(Model model) {
		List<Utilisateur> utilisateur = this.utilisateurService.afficherAllUsers();
		System.out.println(utilisateur);
		model.addAttribute("utilisateur", utilisateur);
		return "listeUtilisateurs";
	}

	
	@GetMapping("/listeUtilisateurs/detail")
	public String afficherdetailsUtilisateur(@RequestParam("noUtilisateur")int noUtilisateur,Model  model) {
		Optional<Utilisateur> optUtilisateur = utilisateurService.consulterUserId(noUtilisateur);
		Utilisateur utilisateur = optUtilisateur.get();
		model.addAttribute("utilisateur", utilisateur);
		return "listeUtilisateursDetail";
	}
}
