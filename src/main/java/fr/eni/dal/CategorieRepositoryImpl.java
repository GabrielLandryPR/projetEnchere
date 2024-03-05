package fr.eni.dal;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import fr.eni.bo.Categorie;

@Repository
public class CategorieRepositoryImpl implements CategorieRepository {

	private JdbcTemplate jdbcTemplate;

	public CategorieRepositoryImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	public List<Categorie> findAll(){
		String sql="SELECT no_categorie, libelle FROM CATEGORIES";
		RowMapper<Categorie> rowMapper = new RowMapper<Categorie>() {
			
			@Override
			public Categorie mapRow(ResultSet rs, int rowNum) throws SQLException {
				Categorie categorie = new Categorie();
				categorie.setNoCategorie(rs.getInt("no_categorie"));
				categorie.setLibelle(rs.getString("libelle"));
				return categorie;
			}
		};
		return jdbcTemplate.query(sql, rowMapper);
	}
	
	public Categorie FindById(int id){
		String sql ="SELECT no_categorie, libelle FROM CATEGORIES WHERE no_categorie = ?";
		RowMapper<Categorie> rowMapper = new RowMapper<Categorie>() {
			
			@Override
			public Categorie mapRow(ResultSet rs, int rowNum) throws SQLException {
				Categorie categorie = new Categorie();
				categorie.setNoCategorie(rs.getInt("no_categorie"));
				categorie.setLibelle(rs.getString("libelle"));
				return categorie;
			}
		};
		Categorie categorie  =jdbcTemplate.queryForObject(sql, rowMapper, id);
		return  categorie;
	}
}
