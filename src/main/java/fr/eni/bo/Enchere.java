package fr.eni.bo;

import java.util.Date;
import java.util.Optional;


public class Enchere {
	
	
	//****Variable
	Date dateEnchere;
	int montant_enchere;
	int idEnchere;
	

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
	public Enchere(int utilisateur,int article, Date dateEnchere, int montant_enchere) {
		this.dateEnchere = dateEnchere;
		this.montant_enchere = montant_enchere;
		this.idArticle = article;
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


	public int getIdArticle() {
		return idArticle;
	}


	public void setIdArticle(int article) {
		this.idArticle = article;
	}


	public int getIdUtilisateur() {
		return idUtilisateur;
	}


	public void setIdUtilisateur(int utilisateur) {
		this.idUtilisateur = utilisateur;
	}


	public void setIdUtilisateur(Optional<Utilisateur> findUserById) {
		this.idUtilisateur = idUtilisateur;
		
	}

	public int getIdEnchere() {
		return idEnchere;
	}


	public void setIdEnchere(int idEnchere) {
		this.idEnchere = idEnchere;
	}


	@Override
	public String toString() {
		return "Enchere [dateEnchere=" + dateEnchere + ", montant_enchere=" + montant_enchere + ", idEnchere="
				+ idEnchere + ", idArticle=" + idArticle + ", idUtilisateur=" + idUtilisateur + "]";
	}

	
}
