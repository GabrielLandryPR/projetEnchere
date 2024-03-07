package fr.eni.bo;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class Article {

	// ****Variables****
	int noArticle;
	String nomArticle;
	String description;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date debutEncheres;

	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date finEncheres;
	int miseAPrix;
	int prixVente;
	String etatVente = "pas en vente";

	private byte[] image;

	private int idUtilisateur;
	private String pseudoUtilisateur;
	private int idCategorie;
	private Categorie categorie;
	private String libelleCategorie;
	private Retrait retrait;
	private List<Enchere> encheres;
	
	public Article(List<Enchere> encheres) {
		this.encheres = encheres;
	}

	// ****Constructeur par défaut
	public Article() {
		super();
	}

	public Article(String nomArticle, String description, Date debutEncheres, Date finEncheres,
			int miseAPrix, int prixVente, int idUtilisateur, int idCategorie, String etatVente) {

		super();
		this.nomArticle = nomArticle;
		this.description = description;
		this.debutEncheres = debutEncheres;
		this.finEncheres = finEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.idUtilisateur = idUtilisateur;
		this.idCategorie = idCategorie;
		this.etatVente = etatVente;
	}


	//****Constructeur sans id  
	public Article(String nomArticle, String description, Date debutEncheres, Date finEncheres,
			int miseAPrix, int prixVente, String etatVente, List<Enchere> encheres, int idUtilisateur) {
		this.nomArticle = nomArticle;
		this.description = description;
		this.debutEncheres = debutEncheres;
		this.finEncheres = finEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.etatVente = etatVente;
		this.encheres = encheres;
		this.idUtilisateur = idUtilisateur;
	}
	
	//****Constructeur plein
	public Article(int noArticle, String nomArticle, String description, Date debutEncheres,
			Date finEncheres, int miseAPrix, int prixVente, String etatVente, List<Enchere> encheres,
			int idUtilisateur) {
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.debutEncheres = debutEncheres;
		this.finEncheres = finEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.etatVente = etatVente;
		this.encheres = encheres;
		this.idUtilisateur = idUtilisateur;
	}

	// ****Constructeur plein
	public Article(int noArticle, String nomArticle, String description, Date debutEncheres, Date finEncheres,
			int miseAPrix, int prixVente, String etatVente, int idCategorie, List<Enchere> encheres, int idUtilisateur) {

		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.debutEncheres = debutEncheres;
		this.finEncheres = finEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.etatVente = etatVente;
		this.idCategorie = idCategorie;
		this.encheres = encheres;
		this.idUtilisateur = idUtilisateur;
	}

	public Article(int noArticle, String nomArticle, String description, Date debutEncheres, Date finEncheres,
			int miseAPrix, int prixVente, String etatVente, int idCategorie, List<Enchere> encheres, Retrait retrait,
			int idUtilisateur) {
		this.noArticle = noArticle;
		this.nomArticle = nomArticle;
		this.description = description;
		this.debutEncheres = debutEncheres;
		this.finEncheres = finEncheres;
		this.miseAPrix = miseAPrix;
		this.prixVente = prixVente;
		this.etatVente = etatVente;
		this.idCategorie = idCategorie;
		this.encheres = encheres;
		this.retrait = retrait;
		this.idUtilisateur = idUtilisateur;
	}

	// ******getters et setters******

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

	public Date getDebutEncheres() {
		return debutEncheres;
	}

	public void setDebutEncheres(Date debutEncheres) {
		this.debutEncheres = debutEncheres;
	}

	public Date getFinEncheres() {
		return finEncheres;
	}

	public void setFinEncheres(Date finEncheres) {
		this.finEncheres = finEncheres;
	}

	public int getMiseAPrix() {
		return miseAPrix;
	}

	public void setMiseAPrix(int miseAPrix) {
		this.miseAPrix = miseAPrix;
	}

	public int getPrixVente() {
		return prixVente;
	}

	public void setPrixVente(int prixVente) {
		this.prixVente = prixVente;
	}

	public String getEtatVente() {
		return etatVente;
	}

	public void setEtatVente(String etatVente) {
		this.etatVente = etatVente;
	}

	public List<Enchere> getEncheres() {
		return encheres;
	}

	public void setEncheres(List<Enchere> encheres) {
		this.encheres = encheres;
	}

	public int getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(int idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public int getIdCategorie() {
		return idCategorie;
	}

	public void setCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Retrait getRetrait() {
		return retrait;
	}

	public void setRetrait(Retrait retrait) {
		this.retrait = retrait;
	}



	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}
	
	public String getPseudoUtilisateur() {
		return pseudoUtilisateur;
	}


	public void setPseudoUtilisateur(String pseudoUtilisateur) {
		this.pseudoUtilisateur = pseudoUtilisateur;
	}


	public String getLibelleCategorie() {
		return libelleCategorie;
	}


	public void setLibelleCategorie(String libelleCategorie) {
		this.libelleCategorie = libelleCategorie;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Article [getNoArticle()=").append(getNoArticle()).append(", getNomArticle()=")
				.append(getNomArticle()).append(", getDescription()=").append(getDescription())
				.append(", getDebutEncheres()=").append(getDebutEncheres()).append(", getFinEncheres()=")
				.append(getFinEncheres()).append(", getMiseAPrix()=").append(getMiseAPrix()).append(", getPrixVente()=")
				.append(getPrixVente()).append(", getEtatVente()=").append(getEtatVente()).append(", getEncheres()=")
				.append(getEncheres()).append(", getIdUtilisateur()=").append(getIdUtilisateur())
				.append(", getIdCategorie()=").append(getIdCategorie()).append(", getRetrait()=").append(getRetrait())
				.append(", getPseudoUtilisateur()=").append(getPseudoUtilisateur()).append(", getLibelleCategorie()=")
				.append(getLibelleCategorie()).append("]");
		return builder.toString();
	}

}
