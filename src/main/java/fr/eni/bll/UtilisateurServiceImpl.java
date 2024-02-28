package fr.eni.bll;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.bo.Utilisateur;
import fr.eni.dal.UtilisateurRepository;

@Service
public class UtilisateurServiceImpl implements UtilisateurService{
	
	private UtilisateurRepository utilisateurRepository;
	
	
	@Autowired
	public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository) {
		this.utilisateurRepository = utilisateurRepository;
	}



	public Optional<Utilisateur> consulterUserId(int id) {
		Optional<Utilisateur> optUser = this.utilisateurRepository.findUserById(id); 
		System.out.println(optUser);
		return optUser;
		
	}
}
