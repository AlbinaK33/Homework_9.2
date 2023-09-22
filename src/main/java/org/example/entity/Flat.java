package org.example.entity;

import javax.persistence.*;

@Entity
@Table(name = "flats")
public class Flat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "number_flat")
    private String numberFlat;

    public String getNumberFlat() {
        return numberFlat;
    }

    private float square;

    public float getSquare() {
        return square;
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "building_id")

    private Building building;

    public Building getBuilding() {
        return building;
    }
}

