package org.example.entities;

import org.example.enums.EventTypes;

import javax.persistence.*;
import java.time.LocalDate;

@Entity // <-- Mi indica che questa classe dovrà essere mappata ad una tabella del db
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Evento {
    @Id // Indica che sarà la chiave primaria (obbligatorio)
    @GeneratedValue // Si usa se si vuol far gestire gli id al database
    // Altrimenti devo inserirli io manualmente ogni volta che inserisco un nuovo Evento
    private long id; // Se uso un long con @GeneratedValue mi ritroverò ad avere un bigserial come tipo di dato della colonna

    @Column(name = "titolo")
    private String titolo;
    @Column(name = "data_evento")
    private LocalDate dataEvento;
    @Column(name = "descrizione")
    private String descrizione;
    @Column(name = "tipo")
    @Enumerated(EnumType.STRING) // Di default gli enum vengono convertiti in numeri interi, se voglio che essi siano invece Stringhe devo usare @Enumerated
    private EventTypes tipoEvento;
    @Column(name = "numero_massimo_partecipanti")
    private int numeroMassimoPartecipanti;

    public Evento() {
        // Se voglio che JPA sia in grado di leggere dati dal DB e crearmi un oggetto
        // è obbligatorio avere il costruttore vuoto
    }

    public Evento(String titolo, LocalDate dataEvento, String descrizione, EventTypes tipoEvento, int numeroMassimoPartecipanti) {
        this.titolo = titolo;
        this.dataEvento = dataEvento;
        this.descrizione = descrizione;
        this.tipoEvento = tipoEvento;
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }

    public String getTitolo() {
        return titolo;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public EventTypes getTipoEvento() {
        return tipoEvento;
    }

    public int getNumeroMassimoPartecipanti() {
        return numeroMassimoPartecipanti;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public void setTipoEvento(EventTypes tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public void setNumeroMassimoPartecipanti(int numeroMassimoPartecipanti) {
        this.numeroMassimoPartecipanti = numeroMassimoPartecipanti;
    }

    @Override
    public String toString() {
        return "Evento{" +
                "id=" + id +
                ", titolo='" + titolo + '\'' +
                ", dataEvento=" + dataEvento +
                ", descrizione='" + descrizione + '\'' +
                ", tipoEvento=" + tipoEvento +
                ", numeroMassimoPartecipanti=" + numeroMassimoPartecipanti +
                '}';
    }
}
