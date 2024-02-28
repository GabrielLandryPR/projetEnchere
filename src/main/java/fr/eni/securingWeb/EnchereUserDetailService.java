package fr.eni.securingWeb;

import java.util.Optional;
import org.springframework.security.core.userdetails.User.UserBuilder;
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

		if(optMembre.isEmpty()) {
			throw new UsernameNotFoundException("utilisateur non trouve : "+username);
		}

		Utilisateur utilisateur = optMembre.get();
		
		 UserBuilder userBuilder = User.withUsername(utilisateur.getPseudo())
            .password(utilisateur.getMotDePasse());
//            .roles("MEMBRE");
		 
//		 if(utilisateur.isAdmin()) {
//			 userBuilder.roles("ADMINISTRATEUR");
//		 }	
		 UserDetails user = userBuilder.build();
		 
		
		return user;
	}
}