package fr.eni.bo;

import java.util.List;

public class Categorie {

	int noCategorie;
	String libelle;
	
	List<Article> articlesVendus;

	//****Constructeur par défaut 
	public Categorie() {
		super();
	}
	
	//****Constructeur sans id
	public Categorie(String libelle, List<Article> articlesVendus) {
		this.libelle = libelle;
		this.articlesVendus = articlesVendus;
	}

	//****Constructeur plein
	public Categorie(int noCategorie, String libelle, List<Article> articlesVendus) {
		super();
		this.noCategorie = noCategorie;
		this.libelle = libelle;
		this.articlesVendus = articlesVendus;
	}

	
	//****Getters et Setters 
	public int getNoCategorie() {
		return noCategorie;
	}

	public void setNoCategorie(int noCategorie) {
		this.noCategorie = noCategorie;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public List<Article> getArticlesVendus() {
		return articlesVendus;
	}

	public void setArticlesVendus(List<Article> articlesVendus) {
		this.articlesVendus = articlesVendus;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Categorie [noCategorie=");
		builder.append(noCategorie);
		builder.append(", libelle=");
		builder.append(libelle);
		builder.append("]");
		return builder.toString();
	}

	
	
	
}
