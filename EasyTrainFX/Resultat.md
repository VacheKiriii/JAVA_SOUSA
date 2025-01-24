## Sousa Mathys 
## Modification sur EasyTrainFX
## 24/01/2025

# Modifications

- dans un premier temps j'ai récupérer le projet EasyTrainFX
- j'ai ajouter la classe Arret ainsi que la classe Enum Arret pour définir les types
- j'ai ajouter un type sur la table Arret en base de donnée;

# SQL

- J'ai re créé directement une table Arret avec les modifications pour choisir le type

CREATE TABLE Arret (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(100) NOT NULL UNIQUE,
    type ENUM('TERMINUS', 'INTERMEDIAIRE') NOT NULL
);

