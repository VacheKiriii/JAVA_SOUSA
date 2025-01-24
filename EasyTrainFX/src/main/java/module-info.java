module fr.esiee.easytrainfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens fr.esiee.easytrainfx to javafx.fxml;
    exports fr.esiee.easytrainfx;
    exports fr.esiee.modele;
    opens fr.esiee.modele to javafx.fxml;
    exports fr.esiee.dao;
    opens fr.esiee.dao to javafx.fxml;
}