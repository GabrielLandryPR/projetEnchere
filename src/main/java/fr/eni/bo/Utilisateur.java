package fr.eni.bo;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Utilisateur implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8337029451390245757L;
	//****Variables	
	
	int noUtilisateur;
	@NotBlank
	@Size(min=1)
	String pseudo;
	String nom;
	String prenom;
	String confirmation;
	@NotBlank
	@Email
	String email;
	int telephone;
	String rue;
	int codePostal;
	String ville;
	@NotBlank
	@Size(min=1)
	String motDePasse;
	Integer credit=0 ;
	boolean isAdmin;
	
	
	//****Association****
	List<Article> articleVendus;
	List<Enchere> encheres;
	
	@Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Vous pouvez ajuster les rôles/autorités selon vos besoins
        return Collections.singleton(new SimpleGrantedAuthority("ROLE_USER"));
    }

	// Constructeurs, getters et setters
	    

	//****Constructeur par défaut 
	public Utilisateur() {
		super();
	}

	//****Constructeurs****
	public Utilisateur(int noUtilisateur, String pseudo, String nom, String prenom, String email, int telephone,
			String rue, int codePostal, String ville, String motDePasse, Integer credit, boolean isAdmin) {
		this.noUtilisateur = noUtilisateur;
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.motDePasse = motDePasse;
		this.credit = credit;
		this.isAdmin = isAdmin;
	}
	
	
	public Utilisateur(String pseudo, String nom, String prenom, String email, int telephone, String rue,
			int codePostal, String ville, String motDePasse, boolean isAdmin) {
		super();
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.motDePasse = motDePasse;
		this.isAdmin = isAdmin;
		System.out.println("##############");
	}

	//****Getters et setters****
	public int getNoUtilisateur() {
		return noUtilisateur;
	}

	public void setNoUtilisateur(int noUtilisateur) {
		this.noUtilisateur = noUtilisateur;
	}
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getTelephone() {
		return telephone;
	}
	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public int getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getMotDePasse() {
		return motDePasse;
	}
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	public Integer getCredit() {
		return credit;
	}
	public void setCredit(Integer credit) {
		this.credit = credit;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}


	public void setArticleVendus(List<Article> articleVendus) {
		this.articleVendus = articleVendus;
	}

	public List<Enchere> getEncheres() {
		return encheres;
	}

	public void setEncheres(List<Enchere> encheres) {
		this.encheres = encheres;
	}
	public List<Article> getArticles() {
        return articleVendus;
    }

public void setArticles(List<Article> articlesVendus) {
        this.articleVendus = articlesVendus;
    }

	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Utilisateur [getArticlesVendus()=").append(getArticles()).append(", getNoUtilisateur()=")
				.append(getNoUtilisateur()).append(", getPseudo()=").append(getPseudo()).append(", getNom()=")
				.append(getNom()).append(", getPrenom()=").append(getPrenom()).append(", getEmail()=")
				.append(getEmail()).append(", getTelephone()=").append(getTelephone()).append(", getRue()=")
				.append(getRue()).append(", getCodePostal()=").append(getCodePostal()).append(", getVille()=")
				.append(getVille()).append(", getMotDePasse()=").append(getMotDePasse()).append(", getCredit()=")
				.append(getCredit()).append(", isAdmin()=").append(isAdmin()).append(", getArticlesVendus()=")
				.append(getArticles()).append(", getEncheres()=").append(getEncheres()).append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(noUtilisateur);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Utilisateur other = (Utilisateur) obj;
		return noUtilisateur == other.noUtilisateur;
	}

	@Override
	public String getPassword() {
		return getMotDePasse();
	}

	@Override
	public String getUsername() {
		return getPseudo();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}

	public String getConfirmation() {
		return confirmation;
	}

	public void setConfirmation(String confirmation) {
		this.confirmation = confirmation;
	}

	
	
	
}
