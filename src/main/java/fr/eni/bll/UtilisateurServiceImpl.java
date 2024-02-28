package fr.eni.bll;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import fr.eni.bo.Utilisateur;
import fr.eni.dal.UtilisateurRepository;

import fr.eni.bo.Utilisateur;
import fr.eni.dal.UtilisateurRepository;

@Service
public class UtilisateurServiceImpl implements UtilisateurService{

	@Autowired
	private UtilisateurRepository utilisateurRepository;

//	@Autowired
//	private PasswordEncoder passwordEncoder;

	

	@Override
	public Optional<Utilisateur> loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Utilisateur> user = utilisateurRepository.findByPseudo(username);
		
		if(user == null) {
			throw new UsernameNotFoundException(username);
		}
		
		return user;
	}
	
//	private UtilisateurRepository utilisateurRepository;
//	
//	
//	@Autowired
//	public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository) {
//		this.utilisateurRepository = utilisateurRepository;
//	}
//
//
//
//	public Optional<Utilisateur> consulterUserId(int id) {
//		Optional<Utilisateur> optUser = this.utilisateurRepository.findUserById(id); 
//		System.out.println(optUser);
//		return optUser;
//		
//	}
}
