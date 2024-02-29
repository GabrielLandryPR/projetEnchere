package fr.eni.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import fr.eni.bll.UtilisateurServiceImpl;
@Controller
public class LoginController {
	
	private UtilisateurServiceImpl utilisateurServiceImpl;
	
	public LoginController(UtilisateurServiceImpl utilisateurServiceImpl) {
		this.utilisateurServiceImpl = utilisateurServiceImpl;
	}

	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/logout")
	public String logout() {
		return "redirect:/";
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