package fr.eni.controller;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.eni.bll.UtilisateurService;
import fr.eni.bo.Utilisateur;
import fr.eni.securingWeb.EnchereUserDetailService;
@Controller
public class LoginController {
	
	private UtilisateurService utilisateurService;
	private EnchereUserDetailService enchereUserDetailService;
	
	

	public LoginController(UtilisateurService utilisateurService,EnchereUserDetailService enchereUserDetailService) {
		this.utilisateurService = utilisateurService;
		this.enchereUserDetailService = enchereUserDetailService;
	}

	@GetMapping("/login")
	public String login() {
			return "login";
	}
	
	@PostMapping("/login")
	public String login(UserDetails utilisateur) throws UsernameNotFoundException {
		UserDetails user = this.enchereUserDetailService.loadUserByUsername(utilisateur.getUsername());
		user.getUsername();
		user.getPassword();
		if(user.getUsername().isEmpty()) {
			return"login";
		}
			return "index";
			
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