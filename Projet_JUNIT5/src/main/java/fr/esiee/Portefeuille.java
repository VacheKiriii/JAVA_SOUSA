package fr.esiee;

import java.util.HashMap;

public class Portefeuille {
    private HashMap<String, Devise> contenu;

    public Portefeuille() {
        contenu = new HashMap<String, Devise>();
    }

    public HashMap<String, Devise> getContenu() {
        return contenu;
    }

    public void ajouteDevise(Devise d) throws MonnaieDifferenteException {
        if (contenu.containsKey(d.getMonnaie())) {
            // Si la devise existe déjà, on l'ajoute à la quantité existante
            Devise existingDevise = contenu.get(d.getMonnaie());
            contenu.put(d.getMonnaie(), existingDevise.add(d));
        } else {
            // Sinon, on l'ajoute simplement au portefeuille
            contenu.put(d.getMonnaie(), d);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Devise devise : contenu.values()) {
            sb.append(devise.getQuantite()).append(" ").append(devise.getMonnaie()).append("\n");
        }
        return sb.toString();
    }
}
