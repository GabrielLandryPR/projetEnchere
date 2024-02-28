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
	
}