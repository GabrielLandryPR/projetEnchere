package fr.eni.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import fr.eni.bo.Utilisateur;
import fr.eni.dal.UtilisateurRepository;
import fr.eni.exception.UserNotPresentException;

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
                model.addAttribute("utilisateur", utilisateur);
                model.addAttribute("nom", utilisateur.getNom());
                model.addAttribute("prenom", utilisateur.getPrenom());
                model.addAttribute("pseudo", utilisateur.getPseudo());
                model.addAttribute("email", utilisateur.getEmail());
                model.addAttribute("motDePasse", "*******");
                model.addAttribute("telephone", utilisateur.getTelephone());
                model.addAttribute("rue", utilisateur.getRue());
                model.addAttribute("codePostal", utilisateur.getCodePostal());
                model.addAttribute("ville", utilisateur.getVille());
                model.addAttribute("noUtilisateur", utilisateur.getNoUtilisateur());
            });
        }

        return "monProfil";
    }
    
    
    
  
}


