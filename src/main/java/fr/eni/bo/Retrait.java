package fr.eni.bo;

public class Retrait {

	
	//****Variables****
	String rue;
	int code_postal;
	String ville;
	
	//****Association****
	private Article articleVendu;
	
	
	//****Constructeurs
	public Retrait(String rue, int code_postale, String ville, Article articleVendu) {
		this.rue = rue;
		this.code_postal = code_postale;
		this.ville = ville;
		this.articleVendu = articleVendu;
	}

	//****Constructeur sans article vendu
	public Retrait(String rue, int code_postale, String ville) {
		this.rue = rue;
		this.code_postal = code_postale;
		this.ville = ville;
	}
	public Retrait() {
	}


	
	//****Getters et Setters 
	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public int getCode_postal() {
		return code_postal;
	}

	public void setCode_postal(int code_postale) {
		this.code_postal = code_postale;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public Article getArticleVendu() {
		return articleVendu;
	}

	public void setArticleVendu(Article articleVendu) {
		this.articleVendu = articleVendu;
	}

}
