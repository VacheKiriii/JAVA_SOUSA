// Sousa Mathys / 04/09/2024 / TP Exploratoire

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Voyage alger = new Voyage();
        alger.setDestination("Kasba");
        alger.setDuree(2);
        alger.setPrix(3000);
        System.out.println("La destination est " + alger.getDestination());
        System.out.println("La duree est de " + alger.getDuree() + " semaines ");
        System.out.println("Le prix est de " + alger.getPrix() + " euros ");
    }
}