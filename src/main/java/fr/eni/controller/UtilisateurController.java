package fr.eni.controller;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.eni.bll.ArticleService;
import fr.eni.bll.UtilisateurService;
import fr.eni.bo.Article;
import fr.eni.bo.Utilisateur;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@Controller
public class UtilisateurController {

	private UtilisateurService utilisateurService;
	private PasswordEncoder passwordEncoder;
	private ArticleService articleService;

	public UtilisateurController(UtilisateurService utilisateurService, PasswordEncoder passwordEncoder) {
		this.utilisateurService = utilisateurService;
		this.passwordEncoder = passwordEncoder;
	}

	@GetMapping("/createUser")
	public String affichageCreaCompte(Model model) {
		Utilisateur utilisateur = new Utilisateur(); // Création d'un nouvel utilisateur
		model.addAttribute("utilisateur", utilisateur); // Ajout de l'utilisateur au modèle
		
		return "createUser"; // Retourne le nom de la vue à afficher
	}

	@PostMapping("/createUser")
	public String createNewUser(@Valid @ModelAttribute("utilisateur") Utilisateur utilisateur,
			BindingResult bindingResult,HttpServletRequest request) {
		if (bindingResult.hasErrors()) {
			return "createUser";
		} else {
			utilisateurService.saveUser(utilisateur);
			return "redirect:/";
		}
	}

//	@GetMapping("/newSell")
//	public String affichageNewSell() {
//
//		return "newSell";
//	}
//
//	@PostMapping("/newSell")
//	public String ajouterVente(@ModelAttribute("article") Article article) {
//		articleService.saveArticle(article);
//		return "newSell";
//	}

	@PostMapping("/monProfil")
	public String supprimerProfil(@RequestParam("noUtilisateur") int noUtilisateur, HttpServletRequest request) {
		System.out.println(noUtilisateur);
		this.utilisateurService.deleteUser(noUtilisateur);
		request.getSession().invalidate();
		return "redirect:/";
	}
	
	@PostMapping("/modifyProfil")
	public String modifyUser(@Valid @ModelAttribute("utilisateur") Utilisateur utilisateur , BindingResult bindingResult,
	                         @RequestParam("motDePasse") String motDePasse,
	                         @RequestParam("confirmation") String confirmation,
	                         Model model) {
	    if (bindingResult.hasErrors()) {
	        return "monProfil";
	    } else {
	        if (motDePasse.equals(confirmation)) {
	            utilisateurService.saveUser(utilisateur);
	            return "redirect:/";
	        } else {
	            return "monProfil";
	        }
	    }
	}

}
