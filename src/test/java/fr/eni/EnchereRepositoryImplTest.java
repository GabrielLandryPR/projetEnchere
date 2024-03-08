package fr.eni;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.eni.bo.Enchere;
import fr.eni.dal.EnchereRepositoryImpl;
import fr.eni.dal.UtilisateurRepository;
import fr.eni.exception.EnchereNotPresentException;

@SpringBootTest
public class EnchereRepositoryImplTest {
	

	private EnchereRepositoryImpl enchereRepository;
	private UtilisateurRepository utilisateurRepository;
	
	
	@Autowired
	public EnchereRepositoryImplTest(EnchereRepositoryImpl enchereRepository,
			UtilisateurRepository utilisateurRepository) {
		
		this.enchereRepository = enchereRepository;
		this.utilisateurRepository = utilisateurRepository;
	}



	@Test
	@DisplayName("test du findAllEnchere")
	void testFindAllEnchere() {
		List<Enchere> encheres = enchereRepository.findAllEnchere();
		
	}
	
	@Test
	@DisplayName("test du testFindEnchereById")
	void testFindEnchereById() {
		Optional<Enchere> enchere = enchereRepository.findEnchereById(1);
		System.out.println(enchere);
		
	}
	
	@Test
	@DisplayName("Test du saveEnchere")
	void testSaveEnchere() {
		Enchere enchere = new Enchere(1, 1, 10);
		System.out.println("apres"+enchere);
		enchereRepository.SaveEnchere(enchere);
	}

	@Test
	@DisplayName("test du testFindEnchereBy2Id")
	void testFindEnchereBy2Id() {
		
		Optional<Enchere> enchere = enchereRepository.findEnchereBy2Id(1, 1);
		System.out.println(enchere);
		
	}
	
	@Test
	@DisplayName("Test du deleteEnchere")
	void testDeleteEnchere() {
		try {
			enchereRepository.deleteEnchere(1);
		} catch (EnchereNotPresentException e) {
			
			e.printStackTrace();
		}
		
	}
}
