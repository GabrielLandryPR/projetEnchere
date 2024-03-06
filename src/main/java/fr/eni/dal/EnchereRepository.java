package fr.eni.dal;

import java.util.List;
import java.util.Optional;

import fr.eni.bo.Enchere;
import fr.eni.exception.EnchereNotPresentException;

public interface EnchereRepository {
	
	List<Enchere> findAllEnchere();
	
	Optional<Enchere> findEnchereById(int id);
	
	Optional<Enchere> SaveEnchere(Enchere enchere);
	
	void deleteEnchere (int noArticle) throws EnchereNotPresentException;
	
	Optional<Enchere> findEnchereBy2Id(int idUser, int idArticle);
	
	
	

}
