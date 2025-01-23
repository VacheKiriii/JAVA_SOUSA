package fr.esiee;

public class Devise {
    private int quantite;
    private String monnaie;

    public Devise(int somme, String monnaie) {
        this.quantite = somme;
        this.monnaie = monnaie;
    }

    public int getQuantite() {
        return quantite;
    }

    public String getMonnaie() {
        return monnaie;
    }

    public Devise add(Devise m) throws MonnaieDifferenteException {
        if (!this.monnaie.equals(m.getMonnaie())) {
            throw new MonnaieDifferenteException(this, m);
        }
        return new Devise(getQuantite() + m.getQuantite(), getMonnaie());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Devise devise = (Devise) obj;
        return quantite == devise.quantite && monnaie.equals(devise.monnaie);
    }
}