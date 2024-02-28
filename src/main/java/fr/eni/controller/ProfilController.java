package fr.eni.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import fr.eni.bo.Utilisateur;
import fr.eni.dal.UtilisateurRepository;

@Controller
public class ProfilController {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @GetMapping("/monProfil")
    public String afficherMonProfil(Model model, Authentication authentication) {
        if (authentication != null) {
            String username = authentication.getName();
            Optional<Utilisateur> optUtilisateur = utilisateurRepository.findByPseudo(username);
            optUtilisateur.ifPresent(utilisateur -> {
                model.addAttribute("nom", utilisateur.getNom());
                model.addAttribute("prenom", utilisateur.getPrenom());
            });
        }

        return "monProfil";
    }
}
