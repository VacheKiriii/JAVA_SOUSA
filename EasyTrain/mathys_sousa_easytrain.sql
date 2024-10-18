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
