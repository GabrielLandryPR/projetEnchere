package fr.eni.bo;

import java.time.LocalDate;
import java.util.List;

public class ArticleVendu {
	
	//****Variables****
	int noArticle;
	String nomArticle;
	String description;
	LocalDate debutEncheres;
	LocalDate finEncheres;
	int miseAPrix;
	int prixVente;
	int etatVente;
	
	//****Association
    
	private Categorie categorie;
	
	List<Enchere> encheres;
	
	private Retrait retrait;
	
	public ArticleVendu(List<Enchere> encheres) {
		this.encheres = encheres;
	}

	private Utilisateur utilisateur;

	public ArticleVendu(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	//****Constructeur par défaut 
	public ArticleVendu() {
		super();
	}
	
	//****Constructeur sans id  
	public ArticleVendu(String nomArticle, String description, LocalDate debutEncheres, LocalDate finEncheres,
			int miseAPrix, int prixVente, int etatVente, List<Enchere> encheres, Utilisateur utilisateur) {
		this.nomArticle = nomArticle;
		this.description = description;
		this.debutEncheres = debutEncheres;
		this.finEncheres = finEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.etatVente = etatVente;
		this.encheres = encheres;
		this.utilisateur = utilisateur;
	}
	
	//****Constructeur plein
	public ArticleVendu(int noArticle, String nomArticle, String description, LocalDate debutEncheres,
			LocalDate finEncheres, int miseAPrix, int prixVente, int etatVente, List<Enchere> encheres,
			Utilisateur utilisateur) {
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.debutEncheres = debutEncheres;
		this.finEncheres = finEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.etatVente = etatVente;
		this.encheres = encheres;
		this.utilisateur = utilisateur;
	}
	
	//****Constructeur plein
	public ArticleVendu(int noArticle, String nomArticle, String description, LocalDate debutEncheres,
			LocalDate finEncheres, int miseAPrix, int prixVente, int etatVente, Categorie categorie,
			List<Enchere> encheres, Utilisateur utilisateur) {
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.debutEncheres = debutEncheres;
		this.finEncheres = finEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.etatVente = etatVente;
		this.categorie = categorie;
		this.encheres = encheres;
		this.utilisateur = utilisateur;
	}
	
	public ArticleVendu(int noArticle, String nomArticle, String description, LocalDate debutEncheres,
			LocalDate finEncheres, int miseAPrix, int prixVente, int etatVente, Categorie categorie,
			List<Enchere> encheres, Retrait retrait, Utilisateur utilisateur) {
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.debutEncheres = debutEncheres;
		this.finEncheres = finEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.etatVente = etatVente;
		this.categorie = categorie;
		this.encheres = encheres;
		this.retrait = retrait;
		this.utilisateur = utilisateur;
	}

	//******getters et setters******

	public int getNoArticle() {
		return noArticle;
	}
	
	public void setNoArticle(int noArticle) {
		this.noArticle = noArticle;
	}

	public String getNomArticle() {
		return nomArticle;
	}

	public void setNomArticle(String nomArticle) {
		this.nomArticle = nomArticle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDebutEncheres() {
		return debutEncheres;
	}

	public void setDebutEncheres(LocalDate debutEncheres) {
		this.debutEncheres = debutEncheres;
	}

	public LocalDate getFinEncheres() {
		return finEncheres;
	}

	public void setFinEncheres(LocalDate finEncheres) {
		this.finEncheres = finEncheres;
	}

	public float getMiseAPrix() {
		return miseAPrix;
	}

	public void setMiseAPrix(int miseAPrix) {
		this.miseAPrix = miseAPrix;
	}

	public float getPrixVente() {
		return prixVente;
	}

	public void setPrixVente(int prixVente) {
		this.prixVente = prixVente;
	}

	public int getEtatVente() {
		return etatVente;
	}

	public void setEtatVente(int etatVente) {
		this.etatVente = etatVente;
	}

	public List<Enchere> getEncheres() {
		return encheres;
	}

	public void setEncheres(List<Enchere> encheres) {
		this.encheres = encheres;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

    
	
}
