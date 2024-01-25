package org.example.dao;

import org.example.entities.Evento;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class EventoDAO {
    // DAO (Data Access Object) è un Design Pattern. Serve per nascondere i dettagli implementativi
    // dei metodi che accederanno al database, i quali possono esser anche abbastanza complessi.
    // Nascondendoli forniamo al main e a chi ne avrà bisogno una classe con dei comodi metodi, con dei
    // nomi parlanti, che andranno ad interagire col DB fornendo tutte le operazioni necessarie.

    private final EntityManager em; // Tutti i metodi qua sotto avranno bisogno dell'EntityManager poichè dovranno interagire col DB

    public EventoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Evento event) {
        // 0. Ho bisogno di una transazione (mi viene fornita dall'EntityManager
        EntityTransaction transaction = em.getTransaction();

        // 1. Inizio la transazione
        transaction.begin();

        // 2. Aggiungo l'evento al Persistence Context (ma non è ancora salvato a DB in questo momento)
        em.persist(event);

        // 3. Concludo la transazione col salvataggio effettivo di una nuova riga nella tabella students
        transaction.commit();

        System.out.println("Evento " + event.getTitolo() + " aggiunto correttamente!");
    }

    public Evento findById(long id) {
        // SELECT * FROM events WHERE id = xyz
        return em.find(Evento.class, id); // Primo parametro è l'Entity, secondo l'id da ricercare
    }

    public void delete(long id) {
        // 1. Cerco l'evento in db
        Evento found = this.findById(id);

        if (found != null) {
            // 2. Se l'evento c'è lo elimino

            // 2.0 Ho bisogno di una transizione
            EntityTransaction transaction = em.getTransaction();

            // 2.1 Inizio la transizione
            transaction.begin();

            // 2.2 Elimino l'oggetto del Persistence Context (in questo momento non sarà ancora rimosso da DB)
            em.remove(found);

            // 2.3 Concludo la transizione con la rimozione effettiva di una riga dalla tabbella events
            transaction.commit();

            System.out.println("Evento " + found.getTitolo() + " è stato rimosso!");

        } else {
            System.out.println("Evento " + found.getTitolo() + " non trovato");
        }
    }
}
