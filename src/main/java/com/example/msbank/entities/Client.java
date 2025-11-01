// Fichier: src/main/java/com/example/msbank/entities/Client.java
package com.example.msbank.entities;

import jakarta.persistence.*;
import lombok.Data; // Si vous utilisez Lombok pour getters/setters
// Retirez @NoArgsConstructor et @AllArgsConstructor

import java.util.List;

@Entity
// @Data // <-- Vous pouvez le garder si votre IDE/compilateur le gère bien pour getters/setters
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String email;

    @OneToMany(mappedBy = "client", fetch = FetchType.LAZY)
    private List<Compte> comptes;

    // Constructeur sans argument (nécessaire pour JPA/Hibernate)
    public Client() {
    }

    // Constructeur avec tous les champs (remplace @AllArgsConstructor)
    public Client(Long id, String nom, String email) {
        this.id = id;
        this.nom = nom;
        this.email = email;
    }

    // Getters et Setters (générés manuellement ou avec @Data)
    // (Collez ici les getters/setters que vous aviez précédemment, ou assurez-vous que @Data fonctionne bien)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Compte> getComptes() {
        return comptes;
    }

    public void setComptes(List<Compte> comptes) {
        this.comptes = comptes;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}