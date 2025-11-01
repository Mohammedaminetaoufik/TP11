// Fichier: src/main/java/com/example/msbank/entities/CompteProjection1.java
package com.example.msbank.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "solde", types = { Compte.class })
public interface CompteProjection1 {
    double getSolde();
}