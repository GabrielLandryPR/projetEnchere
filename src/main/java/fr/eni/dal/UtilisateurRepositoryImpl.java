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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import fr.eni.bo.Utilisateur;
import fr.eni.exception.UserNotPresentException;
import fr.eni.securingWeb.WebSecurityConfig;



@Repository
public class UtilisateurRepositoryImpl implements UtilisateurRepository {

	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedJdbcTemplate;
	private PasswordEncoder passwordEncoder;

	public UtilisateurRepositoryImpl(JdbcTemplate jdbcTemplate, NamedParameterJdbcTemplate namedJdbcTemplate, PasswordEncoder passwordEncoder) {
		this.jdbcTemplate = jdbcTemplate;
		this.namedJdbcTemplate = namedJdbcTemplate;
		this.passwordEncoder = passwordEncoder;
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
				utilisateur.setTelephone(rs.getString("telephone"));
				utilisateur.setRue(rs.getString("rue"));
				utilisateur.setCodePostal(rs.getString("code_postal"));
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
	public Optional<Utilisateur> findUserById(int id) {
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
				utilisateur.setTelephone(rs.getString("telephone"));
				utilisateur.setRue(rs.getString("rue"));
				utilisateur.setCodePostal(rs.getString("code_postal"));
				utilisateur.setVille(rs.getString("ville"));
				utilisateur.setMotDePasse(rs.getString("mot_de_passe"));
				utilisateur.setCredit(rs.getInt("credit"));
				utilisateur.setAdmin(rs.getBoolean("administrateur"));
				return utilisateur;
			}

		};
		Optional<Utilisateur> optUser = null;
		try {
			Utilisateur utilisateur = jdbcTemplate.queryForObject(sql, rowMapper, id);
			optUser = Optional.of(utilisateur);
		} catch (EmptyResultDataAccessException exc) {
			optUser = Optional.empty();
		}
		return optUser;

	}

	@Override
	public Optional<Utilisateur> findByPseudo(String username) {
		String sql = "SELECT no_utilisateur, pseudo, nom, prenom, email, telephone, rue, code_postal, ville, mot_de_passe, credit, administrateur FROM UTILISATEURS WHERE pseudo = ?";
		RowMapper<Utilisateur> rowMapper = new RowMapper<>() {

			@Override
			public Utilisateur mapRow(ResultSet rs, int rowNum) throws SQLException {
				Utilisateur utilisateur = new Utilisateur();
				utilisateur.setNoUtilisateur(rs.getInt("no_utilisateur"));
				utilisateur.setPseudo(rs.getString("pseudo"));
				utilisateur.setNom(rs.getString("nom"));
				utilisateur.setPrenom(rs.getString("prenom"));
				utilisateur.setEmail(rs.getString("email"));
				utilisateur.setTelephone(rs.getString("telephone"));
				utilisateur.setRue(rs.getString("rue"));
				utilisateur.setCodePostal(rs.getString("code_postal"));
				utilisateur.setVille(rs.getString("ville"));
				utilisateur.setMotDePasse(rs.getString("mot_de_passe"));
				utilisateur.setCredit(rs.getInt("credit"));
				utilisateur.setAdmin(rs.getBoolean("administrateur"));
				return utilisateur;
			}

		};
		Optional<Utilisateur> optUser = null;
		try {
			Utilisateur utilisateur = jdbcTemplate.queryForObject(sql, rowMapper, username);
			optUser = Optional.of(utilisateur);
		} catch (EmptyResultDataAccessException exc) {
			optUser = Optional.empty();
		}
		return optUser;

	}

	public Optional<Utilisateur> saveUser(Utilisateur utilisateur){
		if(utilisateur.getNoUtilisateur()== 0) {
			String sql = "insert into UTILISATEURS(pseudo,nom,prenom,email,telephone,rue,code_postal,ville,mot_de_passe,credit,administrateur) values(:pseudo, :nom, :prenom, :email, :telephone, :rue, :code_postal, :ville, :mot_de_passe, :credit, :administrateur)";
					MapSqlParameterSource parameterSource = new MapSqlParameterSource();
					parameterSource.addValue("pseudo", utilisateur.getPseudo());	
					parameterSource.addValue("nom", utilisateur.getNom());
					parameterSource.addValue("prenom", utilisateur.getPrenom());
					parameterSource.addValue("email", utilisateur.getEmail());
					parameterSource.addValue("telephone", utilisateur.getTelephone());
					parameterSource.addValue("rue", utilisateur.getRue());
					parameterSource.addValue("code_postal", utilisateur.getCodePostal());
					parameterSource.addValue("ville", utilisateur.getVille());
					parameterSource.addValue("mot_de_passe", passwordEncoder.encode(utilisateur.getMotDePasse()));
					parameterSource.addValue("credit", 54540);
					parameterSource.addValue("administrateur", utilisateur.isAdmin());
				KeyHolder keyHolder = new GeneratedKeyHolder();

				namedJdbcTemplate.update(sql, parameterSource, keyHolder, 
						new String[] {"noUtilisateur"});
				utilisateur.setNoUtilisateur(keyHolder.getKey().intValue());
		}else {
			String sql = "update UTILISATEURS set pseudo=?,nom=?,prenom=?,email=?,telephone=?, rue=?,code_postal=?, ville=?, mot_de_passe=?,credit=?,administrateur=? where no_utilisateur=?";
			int nbLignes = jdbcTemplate.update(sql, utilisateur.getPseudo(), utilisateur.getNom(), utilisateur.getPrenom(), utilisateur.getEmail(), utilisateur.getTelephone(), utilisateur.getRue(), utilisateur.getCodePostal(), utilisateur.getVille(), passwordEncoder.encode(utilisateur.getMotDePasse()) , utilisateur.getCredit(), utilisateur.isAdmin(), utilisateur.getNoUtilisateur());

			
		}
		return Optional.of(utilisateur);
		
	}


	@Override
	public Optional<Utilisateur> findUserByEmail(String email) {
		String sql = "SELECT * FROM UTILISATEURS WHERE email = ?";
		RowMapper<Utilisateur> rowMapper = new RowMapper<>() {

			@Override
			public Utilisateur mapRow(ResultSet rs, int rowNum) throws SQLException {
				Utilisateur utilisateur = new Utilisateur();
				utilisateur.setNoUtilisateur(rs.getInt("no_utilisateur"));
				utilisateur.setPseudo(rs.getString("pseudo"));
				utilisateur.setNom(rs.getString("nom"));
				utilisateur.setPrenom(rs.getString("prenom"));
				utilisateur.setEmail(rs.getString("email"));
				utilisateur.setTelephone(rs.getString("telephone"));
				utilisateur.setRue(rs.getString("rue"));
				utilisateur.setCodePostal(rs.getString("code_postal"));
				utilisateur.setVille(rs.getString("ville"));
				utilisateur.setMotDePasse(rs.getString("mot_de_passe"));
				utilisateur.setCredit(rs.getInt("credit"));
				utilisateur.setAdmin(rs.getBoolean("administrateur"));
				return utilisateur;
			}

		};
		Optional<Utilisateur> optUser = null;
		try {
			Utilisateur utilisateur = jdbcTemplate.queryForObject(sql, rowMapper, email);
			System.err.println(utilisateur);
			optUser = Optional.of(utilisateur);
		} catch (EmptyResultDataAccessException exc) {
			optUser = Optional.empty();
		}
		return optUser;
	}


	
	
	public void deleteUser(int noUtilisateur) throws UserNotPresentException {
		String sql="delete from UTILISATEURS where no_utilisateur=?";
		int nbLignes = jdbcTemplate.update(sql, noUtilisateur);
		if(nbLignes == 0) {
			throw new UserNotPresentException();
		}
		
	}
	
	

}
