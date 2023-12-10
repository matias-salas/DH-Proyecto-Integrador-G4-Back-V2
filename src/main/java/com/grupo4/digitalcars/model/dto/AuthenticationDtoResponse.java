package com.grupo4.digitalcars.model.dto;

public class AuthenticationDtoResponse {
    private final String jwt;
    private int id;
    private String name;
    private String lastName;
    private String email;
    private String transmission;
    private String role;


    public AuthenticationDtoResponse(String jwt, int id, String name, String lastName, String email, String transmission, String role) {
        this.jwt = jwt;
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.transmission = transmission;
        this.role = role;
    }

    public String getJwt() {
        return jwt;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getTransmission() {
        return transmission;
    }

    public String getRole() {
        return role;
    }
}
