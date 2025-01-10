package fr.esiee;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Devise euro = new Devise(100, "euro");
        Devise euro2 = new Devise(50, "euro");

        int qte = euro.getQuantite();
        String monnaie = euro.getMonnaie();

        System.out.println("Ma devise : quantité : " + qte + " Monnaie : " + monnaie);
        System.out.println("Ma devise2 : quantité : " + euro2.getQuantite() + " monnaie : " + euro2.getMonnaie());

        Devise somme = euro2.add(euro);

        System.out.println("Ma somme : quanité : " + qte + "")
    }
}