package com.example.sights.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "sights")
public class Sight {

    @Id
    @Column
    @SequenceGenerator(name = "clientsIdSeq", sequenceName = "clients_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private static Long id;

    @Column(name = "name_sight")
    private String nameSight;

    @Column(name = "date")
    private Date date;

    @Column(name = "description")
    private String description;

    @Column(name = "type_sight")
    @Enumerated(EnumType.STRING)
    private TypeSight type;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_city", nullable = false)
    @JsonBackReference
    private City city;

    public Sight() {
    }

    public Sight(String nameSight, Date date, String description, TypeSight type, City city) {
        this.nameSight = nameSight;
        this.date = date;
        this.description = description;
        this.type = type;
        this.city = city;
    }

    public static Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public static String getNameSight() {
        return nameSight;
    }

    public void setNameSight(String nameSight) {
        this.nameSight = nameSight;
    }

    public static Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public static String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static TypeSight getType() {
        return type;
    }

    public void setType(TypeSight type) {
        this.type = type;
    }

    public static City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
}
