// Fichier: src/main/java/com/example/msbank/entities/CompteProjection2.java
package com.example.msbank.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "mobile", types = { Compte.class })
public interface CompteProjection2 {
    double getSolde();
    TypeCompte getType();
}