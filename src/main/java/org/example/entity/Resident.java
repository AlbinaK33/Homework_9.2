package org.example.entity;

import javax.persistence.*;

@Entity
@Table(name = "residents")
public class Resident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "resident_data")
    private String residentData;

    public String getResidentData() {
        return residentData;
    }

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "flat_id")
    private Flat flats;

    @Column(name = "contact_data")
    private String contactData;

    public String getContactData() {
        return contactData;
    }

    private String residence;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "charter_id")
    private Charter charters;

    public String toString() {
        return  getResidentData() + ", "+
                getContactData() + ", "+
                flats.getBuilding()+ ", "+
                flats.getNumberFlat() + ", "+
                flats.getSquare() + ";\n";
    }
}

