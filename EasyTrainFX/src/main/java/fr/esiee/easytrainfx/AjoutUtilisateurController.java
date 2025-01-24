package fr.esiee.easytrainfx;

import fr.esiee.dao.EasyTrainDAO;
import fr.esiee.modele.Role;
import fr.esiee.modele.Utilisateur;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AjoutUtilisateurController {

    @FXML
    private TextField nomField;

    @FXML
    private TextField prenomField;

    @FXML
    private ComboBox<Role> roleComboBox;

    @FXML
    private TextField emailField;

    @FXML
    private Label messageLabel;

    @FXML
    public void initialize() {
        // Initialiser la ComboBox avec les rôles disponibles
        roleComboBox.getItems().setAll(Role.values());
    }

    @FXML
    private void handleReinitialiser() {
        nomField.clear();
        prenomField.clear();
        roleComboBox.getSelectionModel().clearSelection();
        emailField.clear();
        messageLabel.setText("Champs réinitialisés.");
    }

    @FXML
    private void handleAjouterUtilisateur() {
        String nom = nomField.getText();
        String prenom = prenomField.getText();
        Role role = roleComboBox.getValue();
        String email = emailField.getText();

        if (nom.isEmpty() || prenom.isEmpty() || role == null || email.isEmpty()) {
            messageLabel.setText("Veuillez remplir tous les champs.");
        } else {
            Utilisateur utilisateur = new Utilisateur(nom, prenom, role, email);
            EasyTrainDAO dao = new EasyTrainDAO();
            boolean success = dao.ajouterUtilisateur(utilisateur);

            if (success) {
                messageLabel.setText("Utilisateur ajouté avec succès.");
            } else {
                messageLabel.setText("Erreur lors de l'ajout de l'utilisateur.");
            }
        }
    }
}