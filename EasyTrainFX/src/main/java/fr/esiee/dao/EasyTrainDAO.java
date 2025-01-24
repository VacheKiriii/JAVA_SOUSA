package fr.esiee.dao;

import fr.esiee.modele.Utilisateur;
import fr.esiee.modele.Arret;
import fr.esiee.modele.TypeArret;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EasyTrainDAO {

    private static final String URL = "jdbc:mysql://localhost:3306/easytraindb"; // URL de la base de données
    private static final String USER = "root"; // Nom d'utilisateur MySQL
    private static final String PASSWORD = "password"; // Mot de passe MySQL

    /**
     * Ajoute un utilisateur dans la base de données.
     *
     * @param utilisateur L'utilisateur à ajouter.
     * @return true si l'ajout a réussi, false sinon.
     */
    public boolean ajouterUtilisateur(Utilisateur utilisateur) {
        String sql = "INSERT INTO Utilisateur (nom, prenom, role, email) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Remplir les paramètres de la requête
            pstmt.setString(1, utilisateur.getNom());
            pstmt.setString(2, utilisateur.getPrenom());
            pstmt.setString(3, utilisateur.getRole().toString());
            pstmt.setString(4, utilisateur.getEmail());

            // Exécuter la requête
            int rowsInserted = pstmt.executeUpdate();
            return rowsInserted > 0; // Retourne true si l'insertion a réussi

        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Retourne false en cas d'erreur
        }
    }

    /**
     * Ajoute un arrêt dans la base de données.
     *
     * @param arret L'arrêt à ajouter.
     * @return true si l'ajout a réussi, false sinon.
     */
    public boolean ajouterArret(Arret arret) {
        String sql = "INSERT INTO Arret (nom, type) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Remplir les paramètres de la requête
            pstmt.setString(1, arret.getNom());
            pstmt.setString(2, arret.getType().toString());

            // Exécuter la requête
            int rowsInserted = pstmt.executeUpdate();
            return rowsInserted > 0; // Retourne true si l'insertion a réussi

        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Retourne false en cas d'erreur
        }
    }

    /**
     * Vérifie si un arrêt avec le même nom existe déjà dans la base de données.
     *
     * @param nom Le nom de l'arrêt à vérifier.
     * @return true si l'arrêt existe déjà, false sinon.
     */
    public boolean arretExiste(String nom) {
        String sql = "SELECT COUNT(*) FROM Arret WHERE nom = ?";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nom);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return rs.getInt(1) > 0; // Retourne true si un arrêt avec ce nom existe
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false; // Retourne false en cas d'erreur ou si l'arrêt n'existe pas
    }
}