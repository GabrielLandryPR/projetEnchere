package fr.eni.dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import fr.eni.bo.Utilisateur;

@Repository
public class UtilisateurRepositoryImpl implements UtilisateurRepository {

	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedJdbcTemplate;

	public UtilisateurRepositoryImpl(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedJdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
		this.namedJdbcTemplate = namedJdbcTemplate;
	}

	@Override
	public List<Utilisateur> findAllUsers() {
		String sql = "SELECT no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur FROM UTILISATEURS";
		RowMapper<Utilisateur> rowMapper = new RowMapper<>() {
			@Override
			public Utilisateur mapRow(ResultSet rs, int rowNum) throws SQLException {
				Utilisateur utilisateur = new Utilisateur();
				utilisateur.setNoUtilisateur(rs.getInt("no_utilisateur"));
				utilisateur.setPseudo(rs.getString("pseudo"));
				utilisateur.setNom(rs.getString("nom"));
				utilisateur.setPrenom(rs.getString("prenom"));
				utilisateur.setEmail(rs.getString("email"));
				utilisateur.setTelephone(rs.getInt("telephone"));
				utilisateur.setRue(rs.getString("rue"));
				utilisateur.setCodePostal(rs.getInt("code_postal"));
				utilisateur.setVille(rs.getString("ville"));
				utilisateur.setMotDePasse(rs.getString("mot_de_passe"));
				utilisateur.setCredit(rs.getInt("credit"));
				utilisateur.setAdmin(rs.getBoolean("administrateur"));
				return utilisateur;
			}
		};
		return jdbcTemplate.query(sql, rowMapper);
	}
	
	@Override
	public Optional<Utilisateur> findUserById(int id){
		String sql = "SELECT * FROM UTILISATEURS WHERE no_utilisateur = ?";
		RowMapper<Utilisateur> rowMapper = new RowMapper<>() {

			@Override
			public Utilisateur mapRow(ResultSet rs, int rowNum) throws SQLException {
				Utilisateur utilisateur = new Utilisateur();
				utilisateur.setNoUtilisateur(rs.getInt("no_utilisateur"));
				utilisateur.setPseudo(rs.getString("pseudo"));
				utilisateur.setNom(rs.getString("nom"));
				utilisateur.setPrenom(rs.getString("prenom"));
				utilisateur.setEmail(rs.getString("email"));
				utilisateur.setTelephone(rs.getInt("telephone"));
				utilisateur.setRue(rs.getString("rue"));
				utilisateur.setCodePostal(rs.getInt("code_postal"));
				utilisateur.setVille(rs.getString("ville"));
				utilisateur.setMotDePasse(rs.getString("mot_de_passe"));
				utilisateur.setCredit(rs.getInt("credit"));
				utilisateur.setAdmin(rs.getBoolean("administrateur"));
				return utilisateur;
			}
			
		};
		Optional<Utilisateur> optUser = null;
		try{
			Utilisateur utilisateur = jdbcTemplate.queryForObject(sql, rowMapper, id);
			System.err.println(utilisateur);
			optUser = Optional.of(utilisateur);
		}catch(EmptyResultDataAccessException exc) {
			optUser = Optional.empty();
		}
		return optUser;
		
	}

}
