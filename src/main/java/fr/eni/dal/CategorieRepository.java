package fr.eni.dal;

import java.util.List;

import fr.eni.bo.Categorie;

public interface CategorieRepository {
	public List<Categorie> findAll();
	public Categorie FindById(int id);
}
