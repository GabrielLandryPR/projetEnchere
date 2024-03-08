package fr.eni.bo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;


public class Enchere {
	
	
	//****Variable
	LocalDate dateEnchere;
	int montant_enchere;
	int idEnchere;
	

	private int idArticle;
	private int idUtilisateur;
	
	
	
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
	public Enchere(int utilisateur,int article, LocalDate dateEnchere, int montant_enchere) {
		this.montant_enchere = montant_enchere;
		this.idArticle = article;
		this.idUtilisateur = utilisateur;
	}
	


	public Enchere(int montant_enchere, int idArticle, int idUtilisateur) {
		this.montant_enchere = montant_enchere;
		this.idArticle = idArticle;
		this.idUtilisateur = idUtilisateur;
		this.dateEnchere = LocalDate.now();
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


	public int getIdArticle() {
		return idArticle;
	}


	public void setIdArticle(int article) {
		this.idArticle = article;
	}


	public int getIdUtilisateur() {
		return idUtilisateur;
	}


	public void setIdUtilisateur(int idUtilisateur) {
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
		return "Enchere [LocalDateEnchere=" + dateEnchere + ", montant_enchere=" + montant_enchere + ", idEnchere="
				+ idEnchere + ", idArticle=" + idArticle + ", idUtilisateur=" + idUtilisateur + "]";
	}

	
}
