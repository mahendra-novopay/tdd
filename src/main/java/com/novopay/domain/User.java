package com.novopay.domain;

import javax.persistence.Column;

@javax.persistence.Entity
@javax.persistence.Table(name = "user")
public class User {

    @javax.persistence.Id
    Long id;

    @Column(name="name")
    String name;

    public User() {
    }

    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
