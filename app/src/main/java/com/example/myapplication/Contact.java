package com.example.myapplication;

public class Contact {
    private int id;
    private String name;
    private String phoneNumber;

    private String image;
    private int status;

    public Contact(int id, String name, String phoneNumber,String image, int status) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.image = image;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int isStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
