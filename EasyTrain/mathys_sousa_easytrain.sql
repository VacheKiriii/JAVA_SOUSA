-- Création de l'énumération Role
CREATE TABLE Role (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nom ENUM('ADMIN', 'EMPLOYE') NOT NULL
);

-- Création de la table Utilisateur
CREATE TABLE Utilisateur (
    id INT PRIMARY KEY AUTO_INCREMENT,
    login VARCHAR(50) NOT NULL,
    mdp VARCHAR(50) NOT NULL,
    nom VARCHAR(50) NOT NULL,
    prenom VARCHAR(50) NOT NULL,
    dateEmbauche DATE NOT NULL,
    role_id INT,
    FOREIGN KEY (role_id) REFERENCES Role(id)
);

-- Création de la table Arret
CREATE TABLE Arret (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nom VARCHAR(50) NOT NULL
);

-- Création de la table Trajet
CREATE TABLE Trajet (
    code VARCHAR(10) PRIMARY KEY,
    tempsDepart DATETIME NOT NULL,
    tempsArrivee DATETIME NOT NULL,
    arretDepart_id INT NOT NULL,
    arretArrivee_id INT NOT NULL,
    FOREIGN KEY (arretDepart_id) REFERENCES Arret(id),
    FOREIGN KEY (arretArrivee_id) REFERENCES Arret(id)
);

-- Insertion de données dans la table Role
INSERT INTO Role (nom) VALUES ('ADMIN'), ('EMPLOYE');

-- Insertion de données dans la table Utilisateur
INSERT INTO Utilisateur (login, mdp, nom, prenom, dateEmbauche, role_id) VALUES
('admin1', 'password1', 'Doe', 'John', '2022-01-15', 1),
('employe1', 'password2', 'Smith', 'Jane', '2023-03-20', 2);

-- Insertion de données dans la table Arret
INSERT INTO Arret (nom) VALUES ('Gare du Nord'), ('Gare de Lyon'), ('Gare Montparnasse'), ('Gare Saint-Lazare');

-- Insertion de données dans la table Trajet
INSERT INTO Trajet (code, tempsDepart, tempsArrivee, arretDepart_id, arretArrivee_id) VALUES
('T001', '2024-10-18 08:30:00', '2024-10-18 10:00:00', 1, 2),
('T002', '2024-10-18 11:00:00', '2024-10-18 12:30:00', 3, 4);

-- recuperer l utilisateur qui ont un login = ...
SELECT id,login,mdp,nom,prenom,dateEmbauche,role FROM Utilisateur
WHERE login = 'login_specifique';

-- lister les utilisateurs qui sont admin
SELECT id,login,mdp,nom,prenom,dateEmbauche,role FROM Utilisateur
WHERE role = 'ADMIN';

-- récuperer les trajets sur une periode donnée

SELECT code, tempsDepart, tempsArrivee, arretDepart_id, arretArrivee_id, ad.nom as nomAD, ad.id as idAD, aa.nom as nomAA, aa.id as idAA
    FROM Trajet t, Arret ad, Arret aa
    WHERE ad.id = arretDepart_id
        AND aa.id = arretArrivee_id
        AND tempsDepart BETWEEN '<date1>' AND '<date2>'
        And tempsArrivee BETWEEN '<date1>' AND '<date2>'

    -- Plus optimiser (jointure)
    SELECT code, tempsDepart, tempsArrivee, arretDepart_id, arretArrivee_id, ad.nom as nomAD, ad.id as idAD, aa.nom as nomAA, aa.id as idAA
    FROM Trajet t JOIN Arret ad ON t.arretDepart_id = ad.id JOIN Arret aa ON t.arretArrivee_id = aa.id
    WHERE tempsDepart BETWEEN '<date1>' AND '<date2>'
    And tempsArrivee BETWEEN '<date1>' AND '<date2>'

    SELECT code, tempsDepart, tempsArrivee, arretDepart_id, arretArrivee_id, ad.nom as nomAD, ad.id as idAD, aa.nom as nomAA, aa.id as idAA
    FROM Trajet t JOIN Arret ad ON t.arretDepart_id = ad.id JOIN Arret aa ON t.arretArrivee_id = aa.id
    WHERE tempsDepart BETWEEN '2024-09-28 09:00:00' AND '2024-09-28 14:00:00'
        And tempsArrivee BETWEEN '2024-10-04 17:30:11' AND '2024-09-28 17:00:00'

-- ajouter un employé avec toute les infos
INSERT INTO Utilisateur (login, mdp, nom, prenom, dateEmbauche, role)
VALUES ('nouveauLogin', SHA2('motDePasse', 256), 'Nom', 'Prenom', '2024-10-04', 'EMPLOYE');

-- suppression un employé avec son id ou son login
DELETE FROM Utilisateur
WHERE id = 123;

DELETE FROM Utilisateur
WHERE login = 'login_employe';

-- modifier le temps d arrive d un trajet avec son code
UPDATE Trajet
SET tempsArrivee = '2024-10-04 17:30:00'
WHERE code = 'code_trajet';
