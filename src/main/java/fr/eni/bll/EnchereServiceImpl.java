package fr.eni.bll;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.bo.Enchere;
import fr.eni.dal.EnchereRepository;
import fr.eni.exception.EnchereNotPresentException;

@Service
public class EnchereServiceImpl implements EnchereService{
	@Autowired
	private EnchereRepository enchereRepository;

	@Override
	public List<Enchere> findAllEnchere(){
		List<Enchere> encheres = enchereRepository.findAllEnchere();
		return encheres;
	}

	@Override
	public Optional<Enchere> findEnchereById(int id) {
		Optional<Enchere> optEnchere = this.enchereRepository.findEnchereById(id);
		return optEnchere;
	}

	@Override
	public void SaveEnchere(Enchere enchere) {
		this.enchereRepository.SaveEnchere(enchere);
	}

	@Override
	public void deleteEnchere(int noEnchere) throws EnchereNotPresentException {
		this.enchereRepository.deleteEnchere(noEnchere);
		
	}

	@Override
	public Optional<Enchere> findEnchereBy2Id(int idUser, int idArticle) {
		Optional<Enchere> optEnchere = this.enchereRepository.findEnchereBy2Id(idUser, idArticle);
		return optEnchere;
	}
	
}
