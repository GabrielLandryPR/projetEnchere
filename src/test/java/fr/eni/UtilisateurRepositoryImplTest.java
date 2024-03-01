package fr.eni;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import fr.eni.bo.ArticleVendu;
import fr.eni.bo.Enchere;
import fr.eni.bo.Utilisateur;
import fr.eni.dal.UtilisateurRepositoryImpl;

@SpringBootTest
public class UtilisateurRepositoryImplTest {
	@Autowired
	private UtilisateurRepositoryImpl UtilisateurRepository;
	@Autowired
    private PasswordEncoder passwordEncoder;  // Assurez-vous que l'encodeur est injecté correctement

	@Test
	@DisplayName("Test find all users")
	void testFindAllUsers() {
		List<Utilisateur> utilisateurs = UtilisateurRepository.findAllUsers();
		System.out.println(utilisateurs);
	}
	
	@Test
	@DisplayName("Test find by id")
	void testFindUserById() {
		int idUser = 6;
		Optional<Utilisateur> optUser = UtilisateurRepository.findUserById(idUser);
		assertTrue(optUser.isPresent());
		assertEquals(idUser, optUser.get().getNoUtilisateur());
		System.out.println(optUser);
	}
	

    @Test
    @DisplayName("Test encrypteur")
    void testEncrypt() {
        // Données de test
        String rawPassword = "Pa$$w0rd";

        // Utilisation de l'encodeur
        String encodedPassword = passwordEncoder.encode(rawPassword);

        // Affichage des résultats
        System.out.println("Raw Password: " + rawPassword);
        System.out.println("Encoded Password: " + encodedPassword);

        // Vérification que le mot de passe encodé correspond à la version en clair
        assertTrue(passwordEncoder.matches(rawPassword, encodedPassword));
    }
    
    
 /*   @Test//Finir le test unitaire avant de push sur git 
    @DisplayName("Test SAVEUSER")
    void testSave() {
    	  List<ArticleVendu> articlesVendus = new ArrayList<>();
    	    List<Enchere> encheres = new ArrayList<>();

    	    // Création de l'utilisateur en passant les listes vides
    	    Utilisateur utilisateur = new Utilisateur("pTESTT", "REUSSI", "pTEST", "eTEST", 10, "rTESTTT", 1, "TEST", "mdpTESTT", 10, false);
    	    utilisateur.setNoUtilisateur(7);
    	    UtilisateurRepository.saveUser(utilisateur);
    	    // Assurez-vous d'ajouter d'autres assertions pour tester le comportement attendu
    	    assertNotNull(utilisateur);
    	    assertEquals("pTESTT", utilisateur.getPseudo());
    	    assertEquals("REUSSI", utilisateur.getNom());
    }*/
}
