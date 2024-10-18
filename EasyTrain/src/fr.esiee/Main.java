package fr.esiee.modele;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        System.out.println("===== Test de la classe Utilisateur =====");
        
        Utilisateur utilisateur1 = new Utilisateur();
        utilisateur1.setId(1);
        utilisateur1.setLogin("admin1");
        utilisateur1.setMdp("password1");
        utilisateur1.setNom("Doe");
        utilisateur1.setPrenom("John");
        utilisateur1.setDateEmbauche(LocalDate.of(2022, 1, 15));
        utilisateur1.setRole(Role.ADMIN);
        
        System.out.println("Utilisateur 1 : " + utilisateur1);

        Utilisateur utilisateur2 = new Utilisateur(2, "employe1", "password2", "Smith", "Jane", LocalDate.of(2023, 3, 20), Role.EMPLOYE);
        
        System.out.println("Utilisateur 2 : " + utilisateur2);

        System.out.println("\n===== Test des classes Arret et Trajet =====");

        Arret arret1 = new Arret(1, "Gare du Nord");
        Arret arret2 = new Arret(2, "Gare de Lyon");
        Arret arret3 = new Arret(3, "Gare Montparnasse");
        Arret arret4 = new Arret(4, "Gare Saint-Lazare");

        Trajet trajet1 = new Trajet("T001", LocalDateTime.of(2024, 10, 18, 8, 30), LocalDateTime.of(2024, 10, 18, 10, 0), arret1, arret2);
        Trajet trajet2 = new Trajet("T002", LocalDateTime.of(2024, 10, 18, 11, 0), LocalDateTime.of(2024, 10, 18, 12, 30), arret3, arret4);
        
        System.out.println("Trajet 1 : " + trajet1);
        System.out.println("Trajet 2 : " + trajet2);
    }
}
