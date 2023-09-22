package org.example.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

    @Entity
    @Table(name = "buildings")
    public class Building {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        @Column(name = "adress_building")
        private String adressBuilding;

        public String getAdressBuilding() {
            return adressBuilding;
        }

        @Column(name = "total_number_flat")
        private float totalNumberFlat;

        @OneToMany(mappedBy = "building", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
        private List<Flat> flats = new ArrayList<>();

        public String toString() {
            return getAdressBuilding();
        }
    }


