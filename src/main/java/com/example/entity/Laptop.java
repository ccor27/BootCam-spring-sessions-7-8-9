package com.example.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@ApiModel("Class Laptop")
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("The id is auto-generate, the application give it the value")
    private Long id;
    @ApiModelProperty("Specification what company is the creator")
    private String brand;
    @ApiModelProperty("Brain of the laptop")
    private String processor;
    @ApiModelProperty("Capacity the storage that have the laptop")
    private int memory;

    public Laptop(){
    }

    public Laptop(String brand, String processor, int memory) {
        this.brand = brand;
        this.processor = processor;
        this.memory = memory;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }
}
