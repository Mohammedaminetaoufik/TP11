// Fichier: src/main/java/com/example/msbank/MsBanqueApplication.java
package com.example.msbank;

import com.example.msbank.entities.Client;
import com.example.msbank.entities.Compte;
import com.example.msbank.entities.TypeCompte;
import com.example.msbank.repositories.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import com.example.msbank.repositories.ClientRepository;


import java.util.Date;

@SpringBootApplication
public class MsBanqueApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsBanqueApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CompteRepository compteRepository, ClientRepository clientRepository, RepositoryRestConfiguration restConfiguration) {
        return args -> {
            restConfiguration.exposeIdsFor(Compte.class, Client.class); // Expose aussi les IDs des Clients

            // Sauvegarde des clients
            Client c1 = clientRepository.save(new Client(null, "Amal", null));
            Client c2 = clientRepository.save(new Client(null, "Ali", null));

            // Sauvegarde des comptes liés aux clients
            compteRepository.save(new Compte(Math.random() * 9000, new Date(), TypeCompte.EPARGNE, c1));
            compteRepository.save(new Compte(Math.random() * 9000, new Date(), TypeCompte.COURANT, c1));
            compteRepository.save(new Compte(Math.random() * 9000, new Date(), TypeCompte.EPARGNE, c2));

            System.out.println("Données initiales (Clients et Comptes) sauvegardées.");
            compteRepository.findAll().forEach(System.out::println);
        };
    }
}