package fr.eni;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.eni.bo.Enchere;
import fr.eni.dal.EnchereRepositoryImpl;
import fr.eni.dal.UtilisateurRepository;

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
		System.out.println(encheres);
	}
	
	@Test
	@DisplayName("test du testFindEnchereById")
	void testFindEnchereById() {
		Optional<Enchere> enchere = enchereRepository.findEnchereById(1);
		System.out.println(enchere);
	}

}
