// Fichier: src/main/java/com/example/msbank/repositories/ClientRepository.java
package com.example.msbank.repositories;

import com.example.msbank.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "clients", collectionResourceRel = "clients") // Enlèvez le '/' initial
public interface ClientRepository extends JpaRepository<Client, Long> {
}