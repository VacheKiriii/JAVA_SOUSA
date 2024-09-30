Sousa Mathys
ESIEE-IT BTS SIO SLAM
29/09/2024


Utilisateur :
- id : int(3)
- login : varchar(20)
- mdp : varchar(20)
- nom : varchar(20)
- prenom : varchar(10)
- dateEmbauche : datetime
- role : enum("ADMIN", "EMPLOYE")

- Clé primaire : id 
- Clé étrangère : il n'y en a pas

Arret :
- id : int(3)
- nom : varchar(30)

- Clé primaire : id 
- Clé étrangère : il n'y en a pas

Trajet
- code : varchar(20)
- tempsDepart : datetime
- tempsArrivee : datetime
- arretDepartId : int(3)
- arretArriveeId: int(3)

- Clé primaire : code 
- Clé étrangère : arretDepartId référence à Arret.id, arretArriveeId référence à Arret.id

Role(enum: "ADMIN", "EMPLOYE") 

- Clé primaire : il n'y en a pas
- Clé étrangère : il n'y en a pas