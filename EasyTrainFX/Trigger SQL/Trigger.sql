-- Trigger pour vérifier le nom test dans l'INSERT

CREATE TRIGGER before_insert_check_name
BEFORE INSERT ON utilisateur
FOR EACH ROW
BEGIN
    IF NEW.nom = 'test' THEN -- Si le nom est égal à 'test'
        SIGNAL SQLSTATE '45000' -- Création du message d'erreur personnalisé
        SET MESSAGE_TEXT = 'Le nom "test" n''est pas autorisé'; -- Affiché le message d'erreur
    END IF;
END


-- Trigger pour vérifier le nom test dans l'UPDATE

CREATE TRIGGER before_update_check_name
BEFORE UPDATE ON utilisateur
FOR EACH ROW
BEGIN
    IF NEW.nom = 'test' THEN -- Si le nom est égal à 'test'
        SIGNAL SQLSTATE '45000' -- Création du message d'erreur personnalisé
        SET MESSAGE_TEXT = 'Le nom "test" n''est pas autorisé'; -- Affiché le message d'erreur
    END IF;
END