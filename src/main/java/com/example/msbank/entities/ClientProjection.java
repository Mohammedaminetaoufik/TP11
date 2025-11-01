// Fichier: src/main/java/com/example/msbank/entities/ClientProjection.java
package com.example.msbank.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "clientDetails", types = { Client.class })
public interface ClientProjection {
    String getNom();
    String getEmail();
}