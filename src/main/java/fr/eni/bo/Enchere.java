package fr.eni.bo;

import java.time.LocalDate;


public class Enchere {
	
	
	//****Variable
	LocalDate dateEnchere;
	int montant_enchere;
	
	private ArticleVendu articleVendu;
	private Utilisateur utilisateur;
	

	//****Constructeur par défaut 
	public Enchere() {
		super();
	}
	
	
	//Constructeurs
	public Enchere(LocalDate dateEnchere, int montant_enchere) {
		this.dateEnchere = dateEnchere;
		this.montant_enchere = montant_enchere;
	}

	//Constructeurs plein
	public Enchere(LocalDate dateEnchere, int montant_enchere, ArticleVendu articleVendu, Utilisateur utilisateur) {
		this.dateEnchere = dateEnchere;
		this.montant_enchere = montant_enchere;
		this.articleVendu = articleVendu;
		this.utilisateur = utilisateur;
	}


	public LocalDate getDateEnchere() {
		return dateEnchere;
	}


	public void setDateEnchere(LocalDate dateEnchere) {
		this.dateEnchere = dateEnchere;
	}


	public float getMontant_enchere() {
		return montant_enchere;
	}


	public void setMontant_enchere(int montant_enchere) {
		this.montant_enchere = montant_enchere;
	}


	public ArticleVendu getArticleVendu() {
		return articleVendu;
	}


	public void setArticleVendu(ArticleVendu articleVendu) {
		this.articleVendu = articleVendu;
	}


	public Utilisateur getUtilisateur() {
		return utilisateur;
	}


	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	

	
	
}
