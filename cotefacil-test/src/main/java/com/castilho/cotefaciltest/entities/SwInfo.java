package com.castilho.cotefaciltest.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "planets_tb")
public class SwInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String climate;
    private String terrainType;
    private Integer quantityTimesAppeared;

    public SwInfo() {
    }

    public SwInfo(Integer id, String name, String climate, String terrainType, Integer quantityTimesAppeared) {
        this.id = id;
        this.name = name;
        this.climate = climate;
        this.terrainType = terrainType;
        this.quantityTimesAppeared = quantityTimesAppeared;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClimate() {
        return climate;
    }

    public void setClimate(String climate) {
        this.climate = climate;
    }

    public String getTerrainType() {
        return terrainType;
    }

    public void setTerrainType(String terrainType) {
        this.terrainType = terrainType;
    }

    public Integer getQuantityTimesAppeared() {
        return quantityTimesAppeared;
    }

    public void setQuantityTimesAppeared(Integer quantityTimesAppeared) {
        this.quantityTimesAppeared = quantityTimesAppeared;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SwInfo swInfo = (SwInfo) o;
        return id.equals(swInfo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "SwInfo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", climate='" + climate + '\'' +
                ", terrainType='" + terrainType + '\'' +
                ", quantityTimesAppeared=" + quantityTimesAppeared +
                '}';
    }
}
