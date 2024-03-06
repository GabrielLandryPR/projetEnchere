package fr.eni.bll;

import java.util.List;
import java.util.Optional;

import fr.eni.bo.Article;
import fr.eni.exception.ArticleNotPresentException;

public interface ArticleService {
	
	List<Article> findAllArticles();
	
	Optional<Article> findArticleById(int id);
	
	void saveArticle(Article article);
	
	void deleteArticle(int noArticle) throws ArticleNotPresentException;

}
