package fr.eni.bll;

import java.util.List;

import fr.eni.bo.Categorie;
import fr.eni.dal.CategorieRepository;

public class CategorieServiceImpl implements CategorieService {

	private CategorieRepository categorieRepository;

	public CategorieServiceImpl(CategorieRepository categorieRepository) {
		this.categorieRepository = categorieRepository;
	}
	
	public List<Categorie> findAll() {
		return categorieRepository.findAll();
	}
	
	public Categorie findById(int id) {
		return categorieRepository.FindById(id);
	}
	
}
