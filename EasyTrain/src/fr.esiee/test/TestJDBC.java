package fr.esiee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJDBC {
    public static void main(String[] args) {

        String urlLocal = "jdbc:mariadb://localhost:3306/EasyTrain";
        String userLocal = "root";
        String pwdLocal = "";
        String urlDistant = "jdbc:mariadb://XXX";
        String userDistant = "XXX";
        String pwdDistant = "XXX";

        Connection connectionLocal = null;
        Connection connectionDistant = null;

        try {
            // Connexion à la base de données locale
            connectionLocal = DriverManager.getConnection(urlLocal, userLocal, pwdLocal);
            System.out.println("Connexion locale OK");

            // Connexion à la base de données distante
            connectionDistant = DriverManager.getConnection(urlDistant, userDistant, pwdDistant);
            System.out.println("Connexion distante OK");

            // Étape 2 : Requête de mise à jour
            Statement statementLocal = connectionLocal.createStatement();
            String requeteUpdate = "UPDATE table_exemple SET colonne = 'nouvelleValeur' WHERE id = 1";
            int resultatUpdate = statementLocal.executeUpdate(requeteUpdate);
            System.out.println("Mise à jour exécutée, lignes affectées : " + resultatUpdate);
            statementLocal.close();

            // Étape 3 : Requête SELECT par ID
            statementLocal = connectionLocal.createStatement();
            String requeteSelectById = "SELECT * FROM table_exemple WHERE id = 1";
            ResultSet resultatSelectById = statementLocal.executeQuery(requeteSelectById);

            while (resultatSelectById.next()) {
                System.out.println("ID : " + resultatSelectById.getInt("id"));
                System.out.println("Colonne : " + resultatSelectById.getString("colonne"));
            }
            resultatSelectById.close();
            statementLocal.close();

            // Étape 4 : Requête SELECT pour plusieurs éléments
            statementLocal = connectionLocal.createStatement();
            String requeteSelectAll = "SELECT * FROM table_exemple";
            ResultSet resultatSelectAll = statementLocal.executeQuery(requeteSelectAll);

            while (resultatSelectAll.next()) {
                System.out.println("ID : " + resultatSelectAll.getInt("id"));
                System.out.println("Colonne : " + resultatSelectAll.getString("colonne"));
            }
            resultatSelectAll.close();
            statementLocal.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Fermeture des connexions
            try {
                if (connectionLocal != null && !connectionLocal.isClosed()) {
                    connectionLocal.close();
                    System.out.println("Connexion locale fermée.");
                }
                if (connectionDistant != null && !connectionDistant.isClosed()) {
                    connectionDistant.close();
                    System.out.println("Connexion distante fermée.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
