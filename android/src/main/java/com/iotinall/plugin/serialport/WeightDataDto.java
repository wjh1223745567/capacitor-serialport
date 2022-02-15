package com.iotinall.plugin.serialport;

public class WeightDataDto {

    private Double[] weight;

    private String id;

    public WeightDataDto() {
    }

    public Double[] getWeight() {
        return weight;
    }

    public void setWeight(Double[] weight) {
        this.weight = weight;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
