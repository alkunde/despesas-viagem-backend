package br.ufpr.andrekunde.travelexpenses.controllers.dto;

import java.io.Serializable;

public class SessionResponseDTO implements Serializable {

    private Long id;
    private String name;
    private String email;
    private Boolean isAdmin;

    public SessionResponseDTO() { }

    public SessionResponseDTO(
            Long id,
            String name,
            String email,
            Boolean isAdmin
    ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.isAdmin = isAdmin;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
}