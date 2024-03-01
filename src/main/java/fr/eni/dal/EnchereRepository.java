package fr.eni.dal;

import java.util.List;
import java.util.Optional;

import fr.eni.bo.Enchere;

public interface EnchereRepository {
	
	List<Enchere> findAllEnchere();
	
	Optional<Enchere> findEnchereById(int id);
	
	Enchere SaveEnchere(Enchere enchere);
	
	void DeleteEnchere(Enchere enchere);
	
	

}
