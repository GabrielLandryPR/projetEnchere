package fr.eni.bll;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import fr.eni.bo.Utilisateur;
import fr.eni.dal.UtilisateurRepository;
import fr.eni.exception.UserNotPresentException;

@Service
public class UtilisateurServiceImpl implements UtilisateurService{

	@Autowired
	private UtilisateurRepository utilisateurRepository;


	@Override
	public List<Utilisateur> findAllUsers() {
		List<Utilisateur> utilisateurs = this.utilisateurRepository.findAllUsers();
		return utilisateurs;
	}
	
	@Override
	public Optional<Utilisateur> loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Utilisateur> user = utilisateurRepository.findByPseudo(username);
		
		if(user == null) {
			throw new UsernameNotFoundException(username);
		}
		
		return user;
	}
	
	
	public UtilisateurServiceImpl(UtilisateurRepository utilisateurRepository) {
		this.utilisateurRepository = utilisateurRepository;
	}



	public Optional<Utilisateur> consulterUserId(int id) {
		Optional<Utilisateur> optUser = this.utilisateurRepository.findUserById(id); 
		System.out.println(optUser);
		return optUser;
	}
	
	public void saveUser(Utilisateur utilisateur) {
		this.utilisateurRepository.saveUser(utilisateur);
	}



	@Override
	public Optional<Utilisateur> findUserByEmail(String email) {
		Optional<Utilisateur> optUser = this.utilisateurRepository.findUserByEmail(email);
		return optUser;
	}

	
	public void deleteUser(int noUtilisateur) {
		try {
			this.utilisateurRepository.deleteUser(noUtilisateur);
		} catch (UserNotPresentException e) {
			e.printStackTrace();
		}
	}
	
	public List<Utilisateur> afficherAllUsers(){
		return this.utilisateurRepository.findAllUsers();
	}

}
