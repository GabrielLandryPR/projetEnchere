package fr.eni.bll;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import fr.eni.bo.Article;
import fr.eni.dal.ArticleRepository;
import fr.eni.exception.ArticleNotPresentException;

@Service
public class ArticleServiceImpl implements ArticleService{
	
	private ArticleRepository articleRepository;

	public ArticleServiceImpl(ArticleRepository articleRepository) {
		super();
		this.articleRepository = articleRepository;
	}

	@Override
	public List<Article> findAllArticles() {
		List<Article> articles = this.articleRepository.findAllArticles();
		return articles;
	}

	@Override
	public Optional<Article> findArticleById(int id) {
		Optional<Article> optArticle = this.articleRepository.findArticleById(id);
		return optArticle;
	}

	@Override
	public void saveArticle(Article article) {
		this.articleRepository.saveArticle(article);
	}

	@Override
	public void deleteArticle(int noArticle) throws ArticleNotPresentException {
		this.articleRepository.deleteArticle(noArticle);
		
	}

}
