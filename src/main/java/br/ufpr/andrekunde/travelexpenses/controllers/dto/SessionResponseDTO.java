package br.ufpr.andrekunde.travelexpenses.controllers.dto;

import java.io.Serializable;

public class SessionResponseDTO implements Serializable {

    private Long id;
    private String name;
    private String email;
    private Boolean isAdmin;
    private Boolean isActive;

    public SessionResponseDTO() { }

    public SessionResponseDTO(
            Long id,
            String name,
            String email,
            Boolean isAdmin,
            Boolean isActive
    ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.isAdmin = isAdmin;
        this.isActive = isActive;
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

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
