Sousa Mathys
ESIEE-IT BTS SIO SLAM
29/09/2024

## Table `Utilisateur`

| Colonne         | Type           | Contrainte                 |
|-----------------|----------------|----------------------------|
| id              | INT            | PRIMARY KEY                |
| login           | VARCHAR(30)    | NOT NULL                   |
| mdp             | VARCHAR(16)    | NOT NULL                   |
| nom             | VARCHAR(15)    | NOT NULL                   |
| prenom          | VARCHAR(15)    | NOT NULL                   |
| dateEmbauche    | DATE           | NOT NULL                   |
| role            | VARCHAR(10)    |

## Table `Arret`

| Colonne         | Type           | Contrainte                 |
|-----------------|----------------|----------------------------|
| id              | INT            | PRIMARY KEY                |
| nom             | VARCHAR(50)    | NOT NULL                   |

## Table `Trajet`

| Colonne         | Type           | Contrainte                 |
|-----------------|----------------|----------------------------|
| code            | VARCHAR(10)    | PRIMARY KEY                |
| tempsDepart     | DATETIME       | NOT NULL                   |
| tempsArrivee    | DATETIME       | NOT NULL                   |
| arretDepart     | INT            | FOREIGN KEY REFERENCES Arret(id) |
| arretArrivee    | INT            | FOREIGN KEY REFERENCES Arret(id) |
