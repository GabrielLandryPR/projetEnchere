package fr.eni.dal;

import java.util.List;
import java.util.Optional;

import fr.eni.bo.Utilisateur;
import fr.eni.exception.UserNotPresentException;

public interface UtilisateurRepository {

	List<Utilisateur> findAllUsers();

	Optional<Utilisateur> findUserById(int id);

	Optional<Utilisateur> findByPseudo(String username);
	
	Optional<Utilisateur> saveUser(Utilisateur utilisateur);
	
	Optional<Utilisateur> findUserByEmail(String email);
	
	// DELETE
	
	// REMONTER CRUD REPOSITORY VERS SERVICE
	void deleteUser(int noUtilisateur) throws UserNotPresentException;

}
