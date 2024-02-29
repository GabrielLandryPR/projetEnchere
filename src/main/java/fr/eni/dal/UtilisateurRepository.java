package fr.eni.dal;

import java.util.List;
import java.util.Optional;

import fr.eni.bo.Utilisateur;

public interface UtilisateurRepository {

	List<Utilisateur> findAllUsers();

	Optional<Utilisateur> findUserById(int id);

	Optional<Utilisateur> findByPseudo(String username);
	
	Optional<Utilisateur> saveUser(Utilisateur utilisateur);
}
