package fr.eni.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.eni.bll.ArticleService;
import fr.eni.bll.CategorieService;
import fr.eni.bo.Article;
import fr.eni.bo.Categorie;
import fr.eni.bo.Retrait;
import fr.eni.bo.Utilisateur;
import fr.eni.dal.UtilisateurRepository;

@Controller
public class ArticleController {

	@Autowired
	private ArticleService articleService;
	@Autowired
	private CategorieService categorieService;
	@Autowired
	private UtilisateurRepository utilisateurRepository;

	public ArticleController(ArticleService articleService) {
		this.articleService = articleService;
	}

	@GetMapping("/vendre")
	public String affichageCreaArticle(Model model, Authentication authentication) {
		Article article = new Article();
		Retrait retrait = new Retrait();
		if (authentication != null) {
			String username = authentication.getName();
			Optional<Utilisateur> optUtilisateur = utilisateurRepository.findByPseudo(username);
			optUtilisateur.ifPresent(utilisateur -> {
				model.addAttribute("utilisateur", utilisateur);
				model.addAttribute("nom", utilisateur.getNom());
				model.addAttribute("prenom", utilisateur.getPrenom());
				model.addAttribute("pseudo", utilisateur.getPseudo());
				model.addAttribute("email", utilisateur.getEmail());
				model.addAttribute("motDePasse", "*******");
				model.addAttribute("telephone", utilisateur.getTelephone());
				model.addAttribute("rue", utilisateur.getRue());
				model.addAttribute("codePostal", utilisateur.getCodePostal());
				model.addAttribute("ville", utilisateur.getVille());
				model.addAttribute("noUtilisateur", utilisateur.getNoUtilisateur());
				System.out.println("noUtilisateur qui arrive sur la page VENDRE : " + utilisateur.getNoUtilisateur());
			});
		}
		List<Categorie> categories = categorieService.findAll();
		model.addAttribute("article", article);
		model.addAttribute("categories", categories);
		model.addAttribute("retrait", retrait);
		model.addAttribute("etatVente", "pas en vente");
		return "vendre"; //
	}

	@PostMapping("/vendre")
	public String affichageNewSell(@RequestParam("noUtilisateur") int noUtilisateur,
			@ModelAttribute("article") Article article) {
		article.setEtatVente("pas en vente");
		article.setIdUtilisateur(noUtilisateur);
		System.out.println("INT categorie : " + article.getIdCategorie());
		System.out.println("INT user : " + article.getIdUtilisateur());
		articleService.saveArticle(article);
		return "redirect:/";
	}
}
