// Fichier: src/main/java/com/example/msbank/repositories/CompteRepository.java
package com.example.msbank.repositories;

import com.example.msbank.entities.Compte;
import com.example.msbank.entities.TypeCompte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(path = "comptes", collectionResourceRel = "comptes") // Enlèvez le '/' initial
public interface CompteRepository extends JpaRepository<Compte, Long> {

    @RestResource(path = "/byType", rel = "byType")
    List<Compte> findByType(@Param("type") TypeCompte type);
}