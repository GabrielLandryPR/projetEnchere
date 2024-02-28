package fr.eni;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

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
		int idUser = 2;
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
}
