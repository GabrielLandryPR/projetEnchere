package fr.eni.bll;

import java.util.Optional;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import fr.eni.bo.Utilisateur;

public interface UtilisateurService {

	Optional<Utilisateur> loadUserByUsername(String username) throws UsernameNotFoundException;
	
	public void saveUser(Utilisateur utilisateur);
	
	Optional<Utilisateur> findUserByEmail(String email);

}
