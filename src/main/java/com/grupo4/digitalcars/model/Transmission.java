package com.grupo4.digitalcars.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="transmission")
public class Transmission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    @ManyToOne
    @JoinColumn(name="fuel_id", referencedColumnName = "id")
    private Fuel fuel;

    @OneToMany(mappedBy = "transmission")
    @JsonIgnore
    private List<Product> product;

    public Transmission() {
    }

    public Transmission(Integer id, String name, Fuel fuel) {
        this.id = id;
        this.name = name;
        this.fuel = fuel;
    }

    public Transmission(Integer id, String name, Fuel fuel, List<Product> product) {
        this.id = id;
        this.name = name;
        this.fuel = fuel;
        this.product = product;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

   public Fuel getFuel() {
        return fuel;
    }

    public void setFuel(Fuel fuel) {
        this.fuel = fuel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProduct() {
        return product;
    }

    public void setProduct(List<Product> product) {
        this.product = product;
    }
}
