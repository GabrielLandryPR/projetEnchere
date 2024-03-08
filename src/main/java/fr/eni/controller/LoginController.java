package fr.eni.controller;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import fr.eni.bll.UtilisateurService;
import fr.eni.securingWeb.EnchereUserDetailService;
import jakarta.validation.Valid;
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
	public String login(@Valid UserDetails utilisateur) throws UsernameNotFoundException {
		UserDetails user = this.enchereUserDetailService.loadUserByUsername(utilisateur.getUsername());
		if(user.getUsername().isEmpty()) {
			return"login";
		}
			return "index";
			
	}
	
	@PostMapping("/logout")
	public String logout() {
		return "redirect:/";
	}
		
		
}