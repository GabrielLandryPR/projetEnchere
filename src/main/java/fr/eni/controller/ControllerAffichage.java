package fr.eni.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import fr.eni.bll.UtilisateurService;
import org.springframework.web.bind.annotation.PostMapping;
import fr.eni.bll.ArticleService;
import fr.eni.bll.EnchereService;
import fr.eni.bo.Article;
import fr.eni.bo.Enchere;
import fr.eni.bo.Utilisateur;

@Controller
public class ControllerAffichage {

	private ArticleService articleService;
	@Autowired
	private EnchereService enchereService;
	private UtilisateurService utilisateurService;

	public ControllerAffichage(ArticleService articleService, UtilisateurService utilisateurService, EnchereService enchereService) {
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
		return "index";
	}
	
	
	@GetMapping("/detailsVente")
	public String detailsVente(@RequestParam ("idArt")int id, Model model,Authentication authentication) {
		if (authentication != null) {
            String username = authentication.getName();
            Optional<Utilisateur> optUtilisateur = utilisateurService.loadUserByUsername(username);
            optUtilisateur.ifPresent(utilisateur -> {
                model.addAttribute("utilisateur", utilisateur);
                model.addAttribute("noUtilisateur", utilisateur.getNoUtilisateur());
            });
        }
		Optional<Article> article = this.articleService.findArticleById(id);
		Article a = article.get();
		model.addAttribute("a", a);
		return "detailsVente";
	}
	
	@PostMapping("/maProposition")
	public String propositionVente(@ModelAttribute("article") Article article,@ModelAttribute("utilisateur")Utilisateur utilisateur, Model model,@RequestParam("noArticle")int noArticle) {

		Optional<Article> optArticle = this.articleService.findArticleById(noArticle);
		Article a = optArticle.get();
		System.out.println("numero article = "+article.getNoArticle());
		model.addAttribute("article", a);
		a.setPrixVente(article.getPrixVente());
		a.setIdUtilisateur(utilisateur.getNoUtilisateur());
		System.out.println("noUtilisateur = "+article.getIdUtilisateur());
		articleService.saveArticle(a);
		System.out.println("article = " + article);
		System.out.println("noArticle = "+article.getNoArticle());
		Enchere enchere = new Enchere(a.getIdUtilisateur(), a.getNoArticle(), a.getDebutEncheres(), a.getPrixVente());
		enchereService.SaveEnchere(enchere);
		System.err.println(a);
		return "redirect:/";
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
