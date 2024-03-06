package fr.eni.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.eni.bll.UtilisateurService;
import fr.eni.bo.Utilisateur;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class UtilisateurController {

	private UtilisateurService utilisateurService;
	


	public UtilisateurController(UtilisateurService utilisateurService) {
		this.utilisateurService = utilisateurService;
	}

	@GetMapping("/createUser")
	public String affichageCreaCompte(Model model) {
		Utilisateur utilisateur = new Utilisateur(); // Création d'un nouvel utilisateur
		model.addAttribute("utilisateur", utilisateur); // Ajout de l'utilisateur au modèle
		return "createUser"; // Retourne le nom de la vue à afficher
	}

	@PostMapping("/createUser")
	public String createNewUser(@ModelAttribute("utilisateur") Utilisateur utilisateur) {
		utilisateurService.saveUser(utilisateur);
		return "monProfil";
	}

	@PostMapping("/monProfil")
	public String supprimerProfil(@RequestParam("noUtilisateur") int noUtilisateur,HttpServletRequest request) {
		System.out.println(noUtilisateur);
		this.utilisateurService.deleteUser(noUtilisateur);
		request.getSession().invalidate();
		return "redirect:/";
	}
}
