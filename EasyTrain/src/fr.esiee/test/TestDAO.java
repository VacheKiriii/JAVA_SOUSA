package eu.hautil;

import eu.hautil.dao.EasyTrainDAO;
import fr.esiee.modele.Utilisateur;
import fr.esiee.modele.Arret;
import fr.esiee.modele.Trajet;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class TestDAO {

    public static void main(String[] args) {
        EasyTrainDAO dao = new EasyTrainDAO();

        // Test des méthodes pour Utilisateur
        Utilisateur utilisateur = dao.getUtilisateurById(1);
        System.out.println("Utilisateur avec ID 1: " + utilisateur);

        List<Utilisateur> utilisateurs = dao.getAllUtilisateurs();
        System.out.println("Tous les utilisateurs: " + utilisateurs);

        Utilisateur nouvelUtilisateur = new Utilisateur(0, "newUser", "password", "New", "User", LocalDate.now(), Role.EMPLOYE);
        boolean ajoutReussi = dao.ajouterUtilisateur(nouvelUtilisateur);
        System.out.println("Ajout utilisateur réussi: " + ajoutReussi);

        // Test des méthodes pour Arret
        Arret arret = dao.getArretById(1);
        System.out.println("Arret avec ID 1: " + arret);

        List<Arret> arrets = dao.getAllArrets();
        System.out.println("Tous les arrêts: " + arrets);

        Arret nouvelArret = new Arret(0, "Nouvel Arret");
        boolean ajoutArretReussi = dao.ajouterArret(nouvelArret);
        System.out.println("Ajout arrêt réussi: " + ajoutArretReussi);

        // Test des méthodes pour Trajet
        Trajet trajet = dao.getTrajetById("T001");
        System.out.println("Trajet avec code T001: " + trajet);

        List<Trajet> trajets = dao.getAllTrajets();
        System.out.println("Tous les trajets: " + trajets);

        Arret arretDepart = dao.getArretById(1);
        Arret arretArrivee = dao.getArretById(2);
        Trajet nouveauTrajet = new Trajet("T003", LocalDateTime.now(), LocalDateTime.now().plusHours(2), arretDepart, arretArrivee);
        boolean ajoutTrajetReussi = dao.ajouterTrajet(nouveauTrajet);
        System.out.println("Ajout trajet réussi: " + ajoutTrajetReussi);
    }
}