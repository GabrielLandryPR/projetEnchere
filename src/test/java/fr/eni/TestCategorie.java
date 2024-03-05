package fr.eni;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.eni.bo.Categorie;
import fr.eni.dal.CategorieRepository;

@SpringBootTest
public class TestCategorie {

	@Autowired
	private CategorieRepository categorieRepository;
	

	@Test
	public void testFindAllCategories(){
		List<Categorie> categorie = categorieRepository.findAll(); 
		System.out.println(categorie);
	}
	
	@Test
	public void testFindById() {
		Categorie categorie = categorieRepository.FindById(1);
		System.err.println(categorie);
	}
	
}
