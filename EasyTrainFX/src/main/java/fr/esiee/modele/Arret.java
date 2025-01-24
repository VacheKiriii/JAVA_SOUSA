package fr.esiee.modele;

public class Arret {
    private int id;
    private String nom;
    private TypeArret type;

    public Arret(String nom, TypeArret type) {
        this.nom = nom;
        this.type = type;
    }

    // Getters et setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public TypeArret getType() { return type; }
    public void setType(TypeArret type) { this.type = type; }

    @Override
    public String toString() {
        return "Arret{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", type=" + type +
                '}';
    }
}