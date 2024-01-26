package org.example;

import org.example.dao.EventoDAO;
import org.example.entities.Concerto;
import org.example.entities.PartitaDiCalcio;
import org.example.enums.ConcertoTypes;
import org.example.enums.EventTypes;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("U4-W3-D4");

    // EntityManagerFactory è l'oggetto che mi consente di creare gli EntityManager
    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();  // Entity Manager è responsabile della gestione delle interazioni col DB
        EventoDAO ed = new EventoDAO(em);

        PartitaDiCalcio lazioJuve = new PartitaDiCalcio("La coppa del nonno", LocalDate.now(), "Desc", EventTypes.PUBBLICO, 190, "Lazio", "Juventus", "Lazio", 2, 0);
//        ed.save(lazioJuve);

        Concerto concertoDiAury = new Concerto("Il concertone di aury", LocalDate.of(2025, 01, 01), "Aury si esibirà per i suoi fan", EventTypes.PUBBLICO, 10000, ConcertoTypes.POP, true);
        ed.save(concertoDiAury);
        // A fine programma è sempre bene ricordarsi di chiudere entitymanager e entitymanagerfactory
        em.close();
        emf.close();

    }
}
