package fr.eni.bll;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.bo.Categorie;
import fr.eni.dal.CategorieRepository;

@Service
public class CategorieServiceImpl implements CategorieService {

	@Autowired
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
