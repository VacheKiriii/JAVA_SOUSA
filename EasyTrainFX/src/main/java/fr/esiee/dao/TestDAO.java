package fr.esiee.dao;

import fr.esiee.modele.Role;
import fr.esiee.modele.Utilisateur;

public class TestDAO {
    public static void main(String[] args) {
        EasyTrainDAO dao = new EasyTrainDAO();
        Utilisateur utilisateur = new Utilisateur("Doe", "John", Role.USER, "john.doe@example.com");
        boolean success = dao.ajouterUtilisateur(utilisateur);
        System.out.println("Ajout réussi ? " + success);
    }
}