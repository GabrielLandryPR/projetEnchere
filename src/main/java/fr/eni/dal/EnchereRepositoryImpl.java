package fr.eni.dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import fr.eni.bo.Enchere;

@Repository
public class EnchereRepositoryImpl implements EnchereRepository{
	
	private JdbcTemplate jdbcTemplate;
	private UtilisateurRepository utilisateurRepository;
	
	

	public EnchereRepositoryImpl(JdbcTemplate jdbcTemplate, UtilisateurRepository utilisateurRepository) {
		this.jdbcTemplate = jdbcTemplate;
		this.utilisateurRepository = utilisateurRepository;
	}

	@Override
	public List<Enchere> findAllEnchere() {
		String sql = "SELECT no_utilisateur, no_article, date_enchere, montant_enchere FROM ENCHERES";
		RowMapper<Enchere> rowmap = new RowMapper<>() {
			@Override
			public Enchere mapRow(ResultSet rs, int rowNum) throws SQLException {
				Enchere enchere = new Enchere();
				enchere.setUtilisateur(rs.getInt("no_utilisateur"));
				enchere.setArticleVendu(rs.getInt("no_article"));
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
				
				enchere.setUtilisateur(rs.getInt("no_utilisateur"));
				enchere.setArticleVendu(rs.getInt("no_article"));
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
	public Enchere SaveEnchere(Enchere enchere) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void DeleteEnchere(Enchere enchere) {
		// TODO Auto-generated method stub
		
	}
	
	

}
