package fr.eni.bo;

import java.util.Date;
import java.util.Optional;


public class Enchere {
	
	
	//****Variable
	Date dateEnchere;
	int montant_enchere;
	
	private int idArticle;
	private int idUtilisateur;
	
	
	
	//****Constructeur par défaut 
	public Enchere() {
		super();
	}
	
	
	//Constructeurs
	public Enchere(Date dateEnchere, int montant_enchere) {
		this.dateEnchere = dateEnchere;
		this.montant_enchere = montant_enchere;
	}

	//Constructeurs plein
	public Enchere(Date dateEnchere, int montant_enchere, int articleVendu, int utilisateur) {
		this.dateEnchere = dateEnchere;
		this.montant_enchere = montant_enchere;
		this.idArticle = articleVendu;
		this.idUtilisateur = utilisateur;
	}


	public Date getDateEnchere() {
		return dateEnchere;
	}


	public void setDateEnchere(Date dateEnchere) {
		this.dateEnchere = dateEnchere;
	}


	public float getMontant_enchere() {
		return montant_enchere;
	}


	public void setMontant_enchere(int montant_enchere) {
		this.montant_enchere = montant_enchere;
	}


	public int getArticleVendu() {
		return idArticle;
	}


	public void setArticleVendu(int articleVendu) {
		this.idArticle = articleVendu;
	}


	public int getUtilisateur() {
		return idUtilisateur;
	}


	public void setUtilisateur(int utilisateur) {
		this.idUtilisateur = utilisateur;
	}


	public void setUtilisateur(Optional<Utilisateur> findUserById) {
		this.idUtilisateur = idUtilisateur;
		
	}


	@Override
	public String toString() {
		return "Enchere [dateEnchere=" + dateEnchere + ", montant_enchere=" + montant_enchere + ", articleVendu="
				+ idArticle + ", utilisateur=" + idUtilisateur + "]";
	}
	
	

	
	
}
