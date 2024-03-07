package fr.eni.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import fr.eni.bll.UtilisateurService;
import org.springframework.web.bind.annotation.PostMapping;
import fr.eni.bll.ArticleService;
import fr.eni.bo.Article;

import fr.eni.bo.Utilisateur;

@Controller
public class ControllerAffichage {

	private ArticleService articleService;
	private UtilisateurService utilisateurService;

	public ControllerAffichage(ArticleService articleService, UtilisateurService utilisateurService) {
		super();
		this.articleService = articleService;
		this.utilisateurService = utilisateurService;
	}

	@GetMapping({ "/encheres/", "/enchere/", "/encheres", "/enchere" })
	public String redirectToIndex() {
		return "redirect:/";
	}

	@GetMapping("/")
	public String index(Model model) {
		List<Article> articles = this.articleService.findAllArticles();
		model.addAttribute("articles", articles);
		System.out.println(articles);
		return "index";
	}
	
	
	@GetMapping("/detailsVente")
	public String detailsVente(@RequestParam ("idArt")int id, Model model) {
		Optional<Article> article = this.articleService.findArticleById(id);
		Article a = article.get();
		System.err.println(a);
		model.addAttribute("a", a);
		return "detailsVente";
	}
	
	@PostMapping("/search")
	public String searchArticle() {
		return "index";
	}

	@GetMapping("/newSell")
	public String affichageNewSell() {
		return "newSell";
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
