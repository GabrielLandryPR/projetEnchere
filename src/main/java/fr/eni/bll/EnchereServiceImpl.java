package fr.eni.bll;

import java.util.List;

import fr.eni.bo.Enchere;
import fr.eni.dal.EnchereRepository;

public class EnchereServiceImpl implements EnchereService{
	
	private EnchereRepository enchereRepository;

	@Override
	public List<Enchere> findAllEnchere() {
		List<Enchere> encheres = enchereRepository.findAllEnchere();
		System.out.println(encheres);
		return encheres;
	}

}
