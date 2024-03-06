package fr.eni.dal;

import java.util.List;
import java.util.Optional;

import fr.eni.bo.Article;
import fr.eni.exception.ArticleNotPresentException;

public interface ArticleRepository {
	
	List<Article> findAllArticles();
	
	Optional<Article> findArticleById(int id);
	
	Optional<Article> saveArticle(Article article);
	
	void deleteArticle(int noArticle) throws ArticleNotPresentException;

}
