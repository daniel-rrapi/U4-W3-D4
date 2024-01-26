package org.example.entities;

import org.example.enums.ConcertoTypes;
import org.example.enums.EventTypes;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Concerto extends Evento {
    private ConcertoTypes genere;
    private boolean inStreaming;

    public Concerto() {
    }

    public Concerto(String titolo, LocalDate dataEvento, String descrizione, EventTypes tipoEvento, int numeroMassimoPartecipanti, ConcertoTypes genere, boolean inStreaming) {
        super(titolo, dataEvento, descrizione, tipoEvento, numeroMassimoPartecipanti);
        this.genere = genere;
        this.inStreaming = inStreaming;
    }
}
