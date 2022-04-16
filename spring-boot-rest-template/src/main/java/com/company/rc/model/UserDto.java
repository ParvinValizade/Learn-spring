package com.company.rc.model;

import java.util.List;

public class UserDto {
    private Long id;

    private String name;

    private String surname;

    private List<String> allAddressList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<String> getAllAddressList() {
        return allAddressList;
    }

    public void setAllAddressList(List<String> allAddressList) {
        this.allAddressList = allAddressList;
    }
}
