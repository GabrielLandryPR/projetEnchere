package fr.eni.bll;

import java.util.Optional;

import org.springframework.stereotype.Service;

import fr.eni.bo.Utilisateur;

public interface UtilisateurService {
	
	public Optional<Utilisateur> consulterUserId(int id);
	
	
}
