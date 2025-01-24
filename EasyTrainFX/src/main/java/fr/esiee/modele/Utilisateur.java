package fr.esiee.modele;

public class Utilisateur {
    private int id;
    private String nom;
    private String prenom;
    private Role role;
    private String email;

    public Utilisateur(String nom, String prenom, Role role, String email) {
        this.nom = nom;
        this.prenom = prenom;
        this.role = role;
        this.email = email;
    }

    // Getters et setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }
    public Role getRole() { return role; }
    public void setRole(Role role) { this.role = role; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", role=" + role +
                ", email='" + email + '\'' +
                '}';
    }
}