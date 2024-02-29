package fr.eni.controller;

import java.security.Principal;
import java.util.Optional;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.eni.bll.UtilisateurServiceImpl;
import fr.eni.bo.Utilisateur;
@Controller
public class LoginController {
	
	private UtilisateurServiceImpl utilisateurServiceImpl;
	
	
	
	
	public LoginController(UtilisateurServiceImpl utilisateurServiceImpl) {
		this.utilisateurServiceImpl = utilisateurServiceImpl;
	}


	@GetMapping("/login")
	public String afficherLogin() {
		return "login";
	}
		
		
//	@GetMapping("/monProfil")
//	public String afficherMonProfil(Model model, Principal principal) {
//		 String username = principal.getName(); // Obtenez le nom d'utilisateur de l'authentification principale
//		    Optional<Utilisateur> utilisateur = utilisateurServiceImpl.loadUserByUsername(username);
//		    // Ajouter l'utilisateur au modèle
//		    model.addAttribute("user", utilisateur);
//		    
//		    return "monProfil";
//	}
	
	
//	@PostMapping("/monProfil")
//	public String formulaireMonProfil(@ModelAttribute("utilisateur")Utilisateur utilisateur) {
//		
//		return "monProfil";
//	}
		
		
}