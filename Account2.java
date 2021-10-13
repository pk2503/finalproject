package com.example.finalproject;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Account2 {

    public final SimpleStringProperty name;
    public final SimpleStringProperty password;
    public final SimpleStringProperty sex;
    public final SimpleIntegerProperty id;
    public final SimpleStringProperty dob;

    public Account2(String name, String password, int id, String sex, String dob) {
        this.name = new SimpleStringProperty(name);
        this.password = new SimpleStringProperty(password);
        this.id = new SimpleIntegerProperty(id);
        this.sex = new SimpleStringProperty(sex);
        this.dob = new SimpleStringProperty(dob);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getPassword() {
        return password.get();
    }

    public SimpleStringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    public String getSex() {
        return sex.get();
    }

    public SimpleStringProperty sexProperty() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex.set(sex);
    }

    public int getId() {
        return id.get();
    }

    public SimpleIntegerProperty idProperty() {
        return id;
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getDob() {
        return dob.get();
    }

    public SimpleStringProperty dobProperty() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob.set(dob);
    }
}