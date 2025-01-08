package eu.hautil.dao;

import fr.esiee.modele.Utilisateur;
import fr.esiee.modele.Arret;
import fr.esiee.modele.Trajet;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EasyTrainDAO {

    private Connection getConnexion() throws SQLException {
        String url = "jdbc:mariadb://localhost:3306/EasyTrain";
        String user = "root";
        String password = "";
        return DriverManager.getConnection(url, user, password);
    }

    // Méthode pour récupérer un utilisateur par son ID
    public Utilisateur getUtilisateurById(int id) {
        Utilisateur utilisateur = null;
        String sql = "SELECT * FROM Utilisateur WHERE id = ?";

        try (Connection conn = getConnexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                utilisateur = new Utilisateur(
                        rs.getInt("id"),
                        rs.getString("login"),
                        rs.getString("mdp"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getDate("dateEmbauche").toLocalDate(),
                        Role.valueOf(rs.getString("role"))
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return utilisateur;
    }

    // Méthode pour récupérer tous les utilisateurs
    public List<Utilisateur> getAllUtilisateurs() {
        List<Utilisateur> utilisateurs = new ArrayList<>();
        String sql = "SELECT * FROM Utilisateur";

        try (Connection conn = getConnexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Utilisateur utilisateur = new Utilisateur(
                        rs.getInt("id"),
                        rs.getString("login"),
                        rs.getString("mdp"),
                        rs.getString("nom"),
                        rs.getString("prenom"),
                        rs.getDate("dateEmbauche").toLocalDate(),
                        Role.valueOf(rs.getString("role"))
                );
                utilisateurs.add(utilisateur);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return utilisateurs;
    }

    // Méthode pour ajouter un utilisateur
    public boolean ajouterUtilisateur(Utilisateur utilisateur) {
        String sql = "INSERT INTO Utilisateur (login, mdp, nom, prenom, dateEmbauche, role) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = getConnexion();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, utilisateur.getLogin());
            pstmt.setString(2, utilisateur.getMdp());
            pstmt.setString(3, utilisateur.getNom());
            pstmt.setString(4, utilisateur.getPrenom());
            pstmt.setDate(5, Date.valueOf(utilisateur.getDateEmbauche()));
            pstmt.setString(6, utilisateur.getRole().toString());

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        utilisateur.setId(generatedKeys.getInt(1));
                    }
                }
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Méthode pour récupérer un arrêt par son ID
    public Arret getArretById(int id) {
        Arret arret = null;
        String sql = "SELECT * FROM Arret WHERE id = ?";

        try (Connection conn = getConnexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                arret = new Arret(
                        rs.getInt("id"),
                        rs.getString("nom")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arret;
    }

    // Méthode pour récupérer tous les arrêts
    public List<Arret> getAllArrets() {
        List<Arret> arrets = new ArrayList<>();
        String sql = "SELECT * FROM Arret";

        try (Connection conn = getConnexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Arret arret = new Arret(
                        rs.getInt("id"),
                        rs.getString("nom")
                );
                arrets.add(arret);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return arrets;
    }

    // Méthode pour ajouter un arrêt
    public boolean ajouterArret(Arret arret) {
        String sql = "INSERT INTO Arret (nom) VALUES (?)";

        try (Connection conn = getConnexion();
             PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, arret.getNom());

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        arret.setId(generatedKeys.getInt(1));
                    }
                }
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Méthode pour récupérer un trajet par son code
    public Trajet getTrajetById(String code) {
        Trajet trajet = null;
        String sql = "SELECT * FROM Trajet WHERE code = ?";

        try (Connection conn = getConnexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, code);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                Arret arretDepart = getArretById(rs.getInt("arretDepart_id"));
                Arret arretArrivee = getArretById(rs.getInt("arretArrivee_id"));

                trajet = new Trajet(
                        rs.getString("code"),
                        rs.getTimestamp("tempsDepart").toLocalDateTime(),
                        rs.getTimestamp("tempsArrivee").toLocalDateTime(),
                        arretDepart,
                        arretArrivee
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trajet;
    }

    // Méthode pour récupérer tous les trajets
    public List<Trajet> getAllTrajets() {
        List<Trajet> trajets = new ArrayList<>();
        String sql = "SELECT * FROM Trajet";

        try (Connection conn = getConnexion();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Arret arretDepart = getArretById(rs.getInt("arretDepart_id"));
                Arret arretArrivee = getArretById(rs.getInt("arretArrivee_id"));

                Trajet trajet = new Trajet(
                        rs.getString("code"),
                        rs.getTimestamp("tempsDepart").toLocalDateTime(),
                        rs.getTimestamp("tempsArrivee").toLocalDateTime(),
                        arretDepart,
                        arretArrivee
                );
                trajets.add(trajet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trajets;
    }

    // Méthode pour ajouter un trajet
    public boolean ajouterTrajet(Trajet trajet) {
        String sql = "INSERT INTO Trajet (code, tempsDepart, tempsArrivee, arretDepart_id, arretArrivee_id) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = getConnexion();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, trajet.getCode());
            pstmt.setTimestamp(2, Timestamp.valueOf(trajet.getTempsDepart()));
            pstmt.setTimestamp(3, Timestamp.valueOf(trajet.getTempsArrivee()));
            pstmt.setInt(4, trajet.getArretDepart().getId());
            pstmt.setInt(5, trajet.getArretArrivee().getId());

            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}