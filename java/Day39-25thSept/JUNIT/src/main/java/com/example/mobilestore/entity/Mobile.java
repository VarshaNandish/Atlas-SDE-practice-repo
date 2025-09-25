package com.example.mobilestore.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "mobiles")
public class Mobile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String brand;
    private Double price;
    private String storage;
    private String ram;
    private String processor;

    public Mobile() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public String getStorage() { return storage; }
    public void setStorage(String storage) { this.storage = storage; }

    public String getRam() { return ram; }
    public void setRam(String ram) { this.ram = ram; }

    public String getProcessor() { return processor; }
    public void setProcessor(String processor) { this.processor = processor; }
}
