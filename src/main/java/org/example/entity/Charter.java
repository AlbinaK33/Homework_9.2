package org.example.entity;

import javax.persistence.*;

@Entity
@Table(name = "charters")
public class Charter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String autopark;

    private int ownership;

}

