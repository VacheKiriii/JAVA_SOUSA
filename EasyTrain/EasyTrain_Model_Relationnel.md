
# Modele Relationnel

#### Sousa Mathys
#### ESIEE-IT BTS SIO SLAM
#### 29/09/2024


### Utilisateur :
    -utilisateur (id : int(3), login : varchar(30), mdp : varchar(256), nom : varchar(30), prenom : varchar(30), dateEmbauche : datetime, role : enum("ADMIN",             "EMPLOYE"))
    - Clé primaire : id 
    - Clé étrangère : aucune
    - Champs unique : aucun

### Arret :
    - arret (id : int(3), nom : varchar(30))
    - Clé primaire : id 
    - Clé étrangère : aucune
    - Champs unique : aucun

### Trajet
    - trajet (code : varchar(30), tempsDepart : datetime, tempsArrivee : datetime, arretDepartId : int(3), arretArriveeId: int(3))
    - Clé primaire : code 
    - Clé étrangère : arretDepartId référence à Arret.id, arretArriveeId référence à Arret.id
    - Champs unique : aucun
