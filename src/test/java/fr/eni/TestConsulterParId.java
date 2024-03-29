package fr.eni;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.eni.bo.Utilisateur;
import fr.eni.dal.UtilisateurRepositoryImpl;

@SpringBootTest
public class TestConsulterParId {
	 @Autowired
	    private UtilisateurRepositoryImpl UtilisateurRepository;
	    
	    @Test
	    @DisplayName("Test find all users")
	    void testFindAllUsers() {
	        List<Utilisateur> utilisateurs = UtilisateurRepository.findAllUsers();
	        System.out.println(utilisateurs);
	    }
	    
	    @Test
	    @DisplayName("Test find by id")
	    void testFindUserById() {
	        int idUser = 1;
	        Optional<Utilisateur> optUser = UtilisateurRepository.findUserById(idUser);
	        assertTrue(optUser.isPresent());
	        assertEquals(idUser, optUser.get().getNoUtilisateur());
	        System.out.println(optUser);
	    }
	    

	    @Test
	    @DisplayName("Test encropteur")
	    void testEncript() {

	    }
}
