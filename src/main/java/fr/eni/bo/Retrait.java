package fr.eni.bo;

public class Retrait {

	
	//****Variables****
	String rue;
	int code_postale;
	String ville;
	
	//****Association****
	private ArticleVendu articleVendu;
	
	
	//****Constructeurs
	public Retrait(String rue, int code_postale, String ville, ArticleVendu articleVendu) {
		this.rue = rue;
		this.code_postale = code_postale;
		this.ville = ville;
		this.articleVendu = articleVendu;
	}

	//****Constructeur sans article vendu
	public Retrait(String rue, int code_postale, String ville) {
		this.rue = rue;
		this.code_postale = code_postale;
		this.ville = ville;
	}

	
	//****Getters et Setters 
	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public int getCode_postale() {
		return code_postale;
	}

	public void setCode_postale(int code_postale) {
		this.code_postale = code_postale;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public ArticleVendu getArticleVendu() {
		return articleVendu;
	}

	public void setArticleVendu(ArticleVendu articleVendu) {
		this.articleVendu = articleVendu;
	}

}
