package com.example.sights.domain;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "sight")
public class Sight {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column (name="name_sight")
    private String nameSight;

    @Column (name="date")
    private Date date;

    @Column (name="description")
    private String description;

    @Column (name="type_sight")
    @Enumerated(EnumType.STRING)
    private TypeSight type;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "city_id", nullable = false)
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
