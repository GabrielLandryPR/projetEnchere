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
import org.springframework.stereotype.Repository;

import fr.eni.bo.Enchere;
import fr.eni.exception.EnchereNotPresentException;

@Repository
public class EnchereRepositoryImpl implements EnchereRepository{
	
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	private UtilisateurRepository utilisateurRepository;
	
	

	public EnchereRepositoryImpl(JdbcTemplate jdbcTemplate, UtilisateurRepository utilisateurRepository) {
		this.jdbcTemplate = jdbcTemplate;
		this.utilisateurRepository = utilisateurRepository;
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(jdbcTemplate.getDataSource());
	}

	@Override
	public List<Enchere> findAllEnchere() {
		String sql = "SELECT no_utilisateur, no_article, date_enchere, montant_enchere FROM ENCHERES";
		RowMapper<Enchere> rowmap = new RowMapper<>() {
			@Override
			public Enchere mapRow(ResultSet rs, int rowNum) throws SQLException {
				Enchere enchere = new Enchere();
				enchere.setIdUtilisateur(rs.getInt("no_utilisateur"));
				enchere.setIdArticle(rs.getInt("no_article"));
				enchere.setDateEnchere(rs.getDate("date_enchere"));
				enchere.setMontant_enchere(rs.getInt("montant_enchere"));
				
				return enchere;
			}
		};
		return jdbcTemplate.query(sql, rowmap);
	}

	@Override
	public Optional<Enchere> findEnchereById(int id) {
		String sql = "SELECT no_utilisateur, no_article, date_enchere, montant_enchere FROM ENCHERES WHERE no_article = ?";
		
		RowMapper<Enchere> rowmap = new RowMapper<>() {
			
			@Override
			public Enchere mapRow(ResultSet rs, int rowNum) throws SQLException {
				Enchere enchere = new Enchere();
				
				enchere.setIdUtilisateur(rs.getInt("no_utilisateur"));
				enchere.setIdArticle(rs.getInt("no_article"));
				enchere.setDateEnchere(rs.getDate("date_enchere"));
				enchere.setMontant_enchere(rs.getInt("montant_enchere"));
				return enchere;
			}
		};
		Optional<Enchere> optEnchere = null;
		try {
			Enchere enchere = jdbcTemplate.queryForObject(sql, rowmap, id);
			System.err.println(enchere);
			optEnchere = Optional.of(enchere);
		} catch (EmptyResultDataAccessException exc) {
			optEnchere = Optional.empty();
		}
		return optEnchere;
	}

	@Override
	public Optional<Enchere> SaveEnchere(Enchere enchere) {
		if(findEnchereBy2Id(enchere.getIdUtilisateur(), enchere.getIdArticle()).isEmpty()) {
			String sql = "INSERT INTO Encheres(no_utilisateur, no_article, date_enchere, montant_enchere) values (:noUtilisateur, :noArticle, :dateEnchere, :montantEnchere)";
			MapSqlParameterSource parameterSource = new MapSqlParameterSource();
			parameterSource.addValue("noUtilisateur", enchere.getIdUtilisateur());	
			parameterSource.addValue("noArticle", enchere.getIdArticle());
			parameterSource.addValue("dateEnchere", enchere.getDateEnchere());
			parameterSource.addValue("montantEnchere", enchere.getMontant_enchere());
			System.out.println("avant jdbc");
			namedParameterJdbcTemplate.update(sql, parameterSource);
			System.out.println("fin if");
			return Optional.of(enchere);
		
		}else {
			String sql = "UPDATE Encheres SET date_enchere=?, montant_enchere=? WHERE no_utilisateur=? AND no_article=?";
			int nbLignes = jdbcTemplate.update(sql, enchere.getDateEnchere(), enchere.getMontant_enchere(), enchere.getIdUtilisateur(), enchere.getIdArticle());

		
		System.out.println("else"+ enchere);
		return Optional.of(enchere);
		}
	}

	@Override
	public void deleteEnchere(int noEnchere) throws EnchereNotPresentException {
		String sql = "delete from Encheres where id_enchere=?";
		int nbLigne = jdbcTemplate.update(sql, noEnchere);
		if(nbLigne == 0) {
			throw new EnchereNotPresentException();
		}
	}

	@Override
	public Optional<Enchere> findEnchereBy2Id(int idUser, int idArticle) {
		String sql = "SELECT no_utilisateur, no_article, id_enchere, date_enchere, montant_enchere FROM ENCHERES WHERE no_utilisateur = ? AND no_article=?";
		RowMapper<Enchere> rowmap = new RowMapper<>() {
			
			@Override
			public Enchere mapRow(ResultSet rs, int rowNum) throws SQLException {
				Enchere enchere = new Enchere();
				
				enchere.setIdUtilisateur(rs.getInt("no_utilisateur"));
				enchere.setIdArticle(rs.getInt("no_article"));
				enchere.setIdEnchere(rs.getInt("id_enchere"));
				enchere.setDateEnchere(rs.getDate("date_enchere"));
				enchere.setMontant_enchere(rs.getInt("montant_enchere"));
				return enchere;
			}
		};
		Optional<Enchere> optEnchere = null;
		try {
			Enchere enchere = jdbcTemplate.queryForObject(sql, rowmap, idUser, idArticle);
			System.err.println(enchere);
			optEnchere = Optional.of(enchere);
		} catch (EmptyResultDataAccessException exc) {
			optEnchere = Optional.empty();
		}
		return optEnchere;
	}


	
	

}
