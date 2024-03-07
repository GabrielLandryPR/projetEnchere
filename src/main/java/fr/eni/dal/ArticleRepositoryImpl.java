package fr.eni.dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import fr.eni.bo.Article;
import fr.eni.exception.ArticleNotPresentException;

@Repository
public class ArticleRepositoryImpl implements ArticleRepository {

	private UtilisateurRepository utilisateurRepository;
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	public ArticleRepositoryImpl(UtilisateurRepository utilisateurRepository, JdbcTemplate jdbcTemplate,
			NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.utilisateurRepository = utilisateurRepository;
		this.jdbcTemplate = jdbcTemplate;
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	@Override
	public List<Article> findAllArticles() {
		String sql = "SELECT a.*, c.libelle, u.pseudo FROM ARTICLES a INNER JOIN UTILISATEURS u ON a.no_utilisateur = u.no_utilisateur INNER JOIN CATEGORIES c ON a.no_categorie = c.no_categorie";

		RowMapper<Article> rowmap = new RowMapper<>() {

			@Override
			public Article mapRow(ResultSet rs, int rowNum) throws SQLException {
				Article article = new Article();
				article.setNoArticle(rs.getInt("no_article"));
				article.setNomArticle(rs.getString("nom_article"));
				article.setDescription(rs.getString("description"));
				article.setDebutEncheres(rs.getDate("date_debut_encheres"));
				article.setFinEncheres(rs.getDate("date_fin_encheres"));
				article.setMiseAPrix(rs.getInt("prix_initial"));
				article.setPrixVente(rs.getInt("prix_vente"));
				article.setIdUtilisateur(rs.getInt("no_utilisateur"));
				article.setCategorie(rs.getInt("no_categorie"));
				article.setEtatVente("etat_vente");
				article.setLibelleCategorie(rs.getString("libelle"));
				article.setPseudoUtilisateur(rs.getString("pseudo"));
				return article;
			}
		};

		return jdbcTemplate.query(sql, rowmap);
	}

	@Override
	public Optional<Article> findArticleById(int id) {

		//String sql = "SELECT no_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie FROM ARTICLES WHERE no_article = ?";
		String sql = "SELECT a.*, c.libelle, u.pseudo FROM ARTICLES a INNER JOIN UTILISATEURS u ON a.no_utilisateur = u.no_utilisateur INNER JOIN CATEGORIES c ON a.no_categorie = c.no_categorie WHERE a.no_article = ?";

		RowMapper<Article> rowmap = new RowMapper<>() {

			@Override
			public Article mapRow(ResultSet rs, int rowNum) throws SQLException {
				Article article = new Article();
				article.setNoArticle(rs.getInt("no_article"));
				article.setNomArticle(rs.getString("nom_article"));
				article.setDescription(rs.getString("description"));
				article.setDebutEncheres(rs.getDate("date_debut_encheres"));
				article.setFinEncheres(rs.getDate("date_fin_encheres"));
				article.setMiseAPrix(rs.getInt("prix_initial"));
				article.setPrixVente(rs.getInt("prix_vente"));
				article.setIdUtilisateur(rs.getInt("no_utilisateur"));
				article.setCategorie(rs.getInt("no_categorie"));
				article.setLibelleCategorie(rs.getString("libelle"));
				article.setPseudoUtilisateur(rs.getString("pseudo"));
				return article;
			}
		};
		Optional<Article> optArticle = null;
		try {
			Article article = jdbcTemplate.queryForObject(sql, rowmap, id);
			optArticle = Optional.of(article);
		} catch (EmptyResultDataAccessException exc) {
			optArticle = Optional.empty();
		}
		return optArticle;
	}

	@Override
	public Optional<Article> saveArticle(Article article) {
		if (article.getNoArticle() == 0) {
			String sql = "insert into ARTICLES(nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie, etat_vente) values(:nomArticle, :description, :dateDebutEnchere, :dateFinEnchere, :prixInitial, :prixVente, :noUtilisateur, :noCategorie, :etatVente)";
			MapSqlParameterSource parameterSource = new MapSqlParameterSource();
			parameterSource.addValue("nomArticle", article.getNomArticle());
			parameterSource.addValue("description", article.getDescription());
			parameterSource.addValue("dateDebutEnchere", article.getDebutEncheres());
			parameterSource.addValue("dateFinEnchere", article.getFinEncheres());
			parameterSource.addValue("prixInitial", article.getMiseAPrix());
			parameterSource.addValue("prixVente", article.getPrixVente());
			parameterSource.addValue("noUtilisateur", article.getIdUtilisateur());
			parameterSource.addValue("noCategorie", article.getIdCategorie());
			parameterSource.addValue("etatVente", article.getEtatVente());

			KeyHolder keyHolder = new GeneratedKeyHolder();

			namedParameterJdbcTemplate.update(sql, parameterSource, keyHolder, 
					new String[] {"noUtilisateur"});
			article.setNoArticle(keyHolder.getKey().intValue());
		} else {
			String sql = "update ARTICLES set nomArticle=?, description=?, dateDebutEnchere=?, dateFinEnchere=?, prixInitial=?, prixVente=?, noUtilisateur=?, noCategorie=? where no_article=?";
			int nbLignes = jdbcTemplate.update(sql, article.getNomArticle(),article.getDescription(),
					article.getDebutEncheres(), article.getFinEncheres(), article.getMiseAPrix(),
					article.getPrixVente(), article.getIdUtilisateur(), article.getIdCategorie(),
					article.getIdCategorie());
			System.out.println("nbLigne" + nbLignes);

		}
		return Optional.of(article);

	}

	@Override
	public void deleteArticle(int noArticle) throws ArticleNotPresentException {
		String sql = "delete from ARTICLES where no_article=?";
		int nbLignes = jdbcTemplate.update(sql, noArticle);
		if (nbLignes == 0) {
			throw new ArticleNotPresentException();
		}
	}
}
