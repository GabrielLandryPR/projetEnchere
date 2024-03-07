package fr.eni.bll;

import java.util.List;
import java.util.Optional;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import fr.eni.bo.Utilisateur;

public interface UtilisateurService {
	
	List<Utilisateur> findAllUsers();

	Optional<Utilisateur> loadUserByUsername(String username) throws UsernameNotFoundException;
	
	public void saveUser(Utilisateur utilisateur);
	
	Optional<Utilisateur> findUserByEmail(String email);
	
	void deleteUser(int id);
	
	Optional<Utilisateur> consulterUserId(int id);

}
