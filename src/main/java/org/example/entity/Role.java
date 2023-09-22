package org.example.entity;

import javax.persistence.*;

@Embeddable
@Table(name = "roles")
public class Role {

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "resident_id")
    private Resident residents;

    private String role;
}

