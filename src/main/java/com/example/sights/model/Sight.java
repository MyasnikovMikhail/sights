package com.example.sights.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="sights")
public class Sight {

    @Id
    @Column(name="id")
    @SequenceGenerator(name="clientsIdSeq", sequenceName="clients_id_seq", allocationSize = 1)
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    @Column(name="name_sight")
    private String nameSight;

    @Column(name="date")
    private Date date;

    @Column(name="description")
    private String description;

    @Column(name="type_sight")
    @Enumerated(EnumType.STRING)
    private TypeSight type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_city", nullable = false)
    //@JsonBackReference
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameSight() {
        return nameSight;
    }

    public void setNameSight(String nameSight) {
        this.nameSight = nameSight;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TypeSight getType() {
        return type;
    }

    public void setType(TypeSight type) {
        this.type = type;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

}
