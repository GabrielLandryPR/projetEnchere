package fr.eni.bll;

import java.util.Optional;


import org.springframework.stereotype.Service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


import fr.eni.bo.Utilisateur;

public interface UtilisateurService {

	
//	public Optional<Utilisateur> consulterUserId(int id);
	
	


	Optional<Utilisateur> loadUserByUsername(String username) throws UsernameNotFoundException;

}
