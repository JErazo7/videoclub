package com.certificacion.videoclub.models.entities;


import javax.persistence.*;

@Entity
@Table(name="actor_pelicula")
public class ActorPelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="apl_id")
    private long id;

    @Column(name="apl_papel")
    private String papel;

    @ManyToOne
    @JoinColumn(name = "pel_id",referencedColumnName = "pel_id")
    private Pelicula pelicula;

    @ManyToOne
    @JoinColumn(name = "act_id",referencedColumnName = "act_id")
    private Actor actor;

    public ActorPelicula() {
        super();
    }


    public ActorPelicula(String papel, Actor actor) {
        super();
        this.papel = papel;
        this.actor = actor;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPapel() {
        return papel;
    }

    public void setPapel(String papel) {
        this.papel = papel;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }
}
