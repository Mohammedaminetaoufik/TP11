// Fichier: src/main/java/com/example/msbank/entities/Compte.java
package com.example.msbank.entities;

import jakarta.persistence.*;
import lombok.Data; // Si vous utilisez Lombok pour getters/setters
// Retirez @NoArgsConstructor et @AllArgsConstructor

import java.util.Date;

@Entity
// @Data // <-- Vous pouvez le garder si votre IDE/compilateur le gère bien pour getters/setters
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double solde;

    @Temporal(TemporalType.DATE)
    private Date dateCreation;

    @Enumerated(EnumType.STRING)
    private TypeCompte type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

    // Constructeur sans argument (nécessaire pour JPA/Hibernate)
    public Compte() {
    }

    // Constructeur avec tous les champs (remplace @AllArgsConstructor)
    public Compte(Long id, double solde, Date dateCreation, TypeCompte type, Client client) {
        this.id = id;
        this.solde = solde;
        this.dateCreation = dateCreation;
        this.type = type;
        this.client = client;
    }

    // Constructeur sans ID (utile pour la création)
    public Compte(double solde, Date dateCreation, TypeCompte type, Client client) {
        this.solde = solde;
        this.dateCreation = dateCreation;
        this.type = type;
        this.client = client;
    }

    // Constructeur sans ID ni Client (utile pour la création basique)
    public Compte(double solde, Date dateCreation, TypeCompte type) {
        this.solde = solde;
        this.dateCreation = dateCreation;
        this.type = type;
    }

    // Getters et Setters (générés manuellement ou avec @Data)
    // (Collez ici les getters/setters que vous aviez précédemment, ou assurez-vous que @Data fonctionne bien)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public TypeCompte getType() {
        return type;
    }

    public void setType(TypeCompte type) {
        this.type = type;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "Compte{" +
                "id=" + id +
                ", solde=" + solde +
                ", dateCreation=" + dateCreation +
                ", type=" + type +
                ", client=" + (client != null ? client.getId() : null) +
                '}';
    }
}