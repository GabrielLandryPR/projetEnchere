package fr.eni.securingWeb;

import java.util.Optional;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import fr.eni.bo.Utilisateur;
import fr.eni.dal.UtilisateurRepository;

@Component
public class EnchereUserDetailService implements UserDetailsService{
	private UtilisateurRepository utilisateurRepository;

	public EnchereUserDetailService(UtilisateurRepository utilisateurRepository) {
		this.utilisateurRepository = utilisateurRepository;
	}
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
	    Optional<Utilisateur> optMembre = utilisateurRepository.findByPseudo(username);
	    System.out.println("findByPseudo" + optMembre);
	    if (optMembre.isEmpty()) {
	        optMembre = utilisateurRepository.findUserByEmail(username);
	        System.out.println("findByEmail" + optMembre);
	    };
	    if(optMembre.isEmpty()){
	    	System.out.println("echec");
	    	throw new UsernameNotFoundException("Utilisateur non trouvé : " + username);
	    }

	    Utilisateur utilisateur = optMembre.get();

	    return User.withUsername(utilisateur.getPseudo())
	            .password(utilisateur.getMotDePasse())
	            .roles("MEMBRE")
	            .build();
	}
}
