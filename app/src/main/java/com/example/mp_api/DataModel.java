package com.example.mp_api;

public class DataModel {

    private int id;
    private String name;
    private String type;
    private String address;
    private String fee;

    public DataModel(int id, String name, String address, String fee, String type) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.type = type;
        this.fee = fee;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getAddress(){
        return address;
    }

    public String getType(){
        return type;
    }

    public String getFee(){
        return fee;
    }

}
