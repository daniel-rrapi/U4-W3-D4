package org.example;

import org.example.dao.EventoDAO;
import org.example.entities.EventTypes;
import org.example.entities.Evento;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("U4-W3-D2");

    // EntityManagerFactory è l'oggetto che mi consente di creare gli EntityManager
    public static void main(String[] args) {
        EntityManager em = emf.createEntityManager();  // Entity Manager è responsabile della gestione delle interazioni col DB
        EventoDAO ed = new EventoDAO(em);

        Evento concertoPippo = new Evento("Concerto pippo", LocalDate.of(2022, 12, 12), "Concerto di pippo e pluto", EventTypes.PRIVATO, 50);

        // SAVE
        ed.save(concertoPippo);

        // Find
        long id = 1;
        Evento eventFromDB = ed.findById(id);
        if (eventFromDB != null) {
            System.out.println(eventFromDB);
        } else {
            System.out.println("Evento con id " + id + " non trovato");
        }

        // Delete
        ed.delete(id);

        // A fine programma è sempre bene ricordarsi di chiudere entitymanager e entitymanagerfactory
        em.close();
        emf.close();

    }
}
