package fr.eni.bll;

import java.util.List;
import java.util.Optional;

import fr.eni.bo.Enchere;
import fr.eni.exception.EnchereNotPresentException;

public interface EnchereService {
	
	List<Enchere> findAllEnchere();
	
	Optional<Enchere> findEnchereById(int id);
	
	void SaveEnchere(Enchere enchere);
	
	void deleteEnchere (int noEnchere) throws EnchereNotPresentException;
	
	Optional<Enchere> findEnchereBy2Id(int idUser, int idArticle);

}
