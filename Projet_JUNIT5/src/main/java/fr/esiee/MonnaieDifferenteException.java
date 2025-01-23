package fr.esiee;

public class MonnaieDifferenteException extends Exception {
    private Devise devise1, devise2;

    public MonnaieDifferenteException(Devise d1, Devise d2) {
        devise1 = d1;
        devise2 = d2;
    }

    @Override
    public String toString() {
        return "Monnaie différente : " + devise1.getMonnaie() + " != " + devise2.getMonnaie();
    }
}