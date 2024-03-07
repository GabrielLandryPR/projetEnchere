package fr.eni;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.eni.bo.Article;
import fr.eni.dal.ArticleRepositoryImpl;
import fr.eni.exception.ArticleNotPresentException;

@SpringBootTest
public class ArticleRepositoryImplTest {

	ArticleRepositoryImpl articleRepositoryImpl;

	@Autowired
	public ArticleRepositoryImplTest(ArticleRepositoryImpl articleRepositoryImpl) {
		this.articleRepositoryImpl = articleRepositoryImpl;
	}

	@Test
	@DisplayName("test du findAllArticle")
	void testFindAllArticle() {
		List<Article> articles = articleRepositoryImpl.findAllArticles();

	}

	@Test
	@DisplayName("test du testFindArticleById")
	void testFindArticleById() {
		Optional<Article> article = articleRepositoryImpl.findArticleById(1);
		System.out.println("findbyid "+article);

	}

	@Test
	@DisplayName("Test du saveArticle")
	void testSaveArticle() {
		Article article = new Article("test", "test description", Date.valueOf("2024-04-04"), Date.valueOf("2024-04-05"), 10, 20, 1, 1, "vendu");
		System.out.println(article);
		articleRepositoryImpl.saveArticle(article);
	}

	@Test
	@DisplayName("Test du deleteArticle")
	void testDeleteArticle() {
		try {
			articleRepositoryImpl.deleteArticle(7);
		} catch (ArticleNotPresentException e) {

			e.printStackTrace();
		}

	}

}
