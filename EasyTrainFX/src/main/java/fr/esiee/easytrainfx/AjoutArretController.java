package fr.esiee.easytrainfx;

import fr.esiee.dao.EasyTrainDAO;
import fr.esiee.modele.Arret;
import fr.esiee.modele.TypeArret;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AjoutArretController {

    @FXML
    private TextField nomField;

    @FXML
    private ComboBox<TypeArret> typeComboBox;

    @FXML
    private Label messageLabel;

    @FXML
    public void initialize() {
        // Initialiser la ComboBox avec les types d'arrêt disponibles
        typeComboBox.getItems().setAll(TypeArret.values());
    }

    @FXML
    private void handleReinitialiser() {
        nomField.clear();
        typeComboBox.getSelectionModel().clearSelection();
        messageLabel.setText("Champs réinitialisés.");
    }

    @FXML
    private void handleAjouterArret() {
        String nom = nomField.getText();
        TypeArret type = typeComboBox.getValue();

        if (nom.isEmpty() || type == null) {
            messageLabel.setText("Veuillez remplir tous les champs.");
        } else {
            EasyTrainDAO dao = new EasyTrainDAO();

            // Vérifier si l'arrêt existe déjà
            if (dao.arretExiste(nom)) {
                messageLabel.setText("Un arrêt avec ce nom existe déjà. Veuillez en choisir un autre.");
            } else {
                Arret arret = new Arret(nom, type);
                boolean success = dao.ajouterArret(arret);

                if (success) {
                    messageLabel.setText("Arrêt ajouté avec succès : " + arret);
                } else {
                    messageLabel.setText("Erreur lors de l'ajout de l'arrêt.");
                }
            }
        }
    }
}