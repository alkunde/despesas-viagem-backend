package br.ufpr.andrekunde.travelexpenses.entities;

import javax.persistence.*;

@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;
    private String password;
    private String role;
    private String active;

    public Users() {}

    public Users(
            Long id,
            String name,
            String email,
            String password,
            String role,
            String active
    ) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.active = active;
    }

    public Users(
            String name,
            String email,
            String password,
            String role,
            String active
    ) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.active = active;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((password == null) ? 0 : password.hashCode());
        result = prime * result + ((role == null) ? 0 : role.hashCode());
        result = prime * result + ((active == null) ? 0 : active.hashCode());

        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Users user = (Users) obj;
        if (id == null) {
            if (user.id != null) {
                return false;
            }
        } else if (!id.equals(user.id)) {
            return false;
        }

        if (name == null) {
            if (user.name != null) {
                return false;
            }
        } else if (!name.equals(user.name)) {
            return false;
        }

        if (email == null) {
            if (user.email != null) {
                return false;
            }
        } else if (!email.equals(user.email)) {
            return false;
        }

        if (password == null) {
            if (user.password != null) {
                return false;
            }
        } else if (!password.equals(user.password)) {
            return false;
        }

        if (role == null) {
            if (user.role != null) {
                return false;
            }
        } else if (!role.equals(user.role)) {
            return false;
        }

        if (active == null) {
            if (user.active != null) {
                return false;
            }
        } else if (!active.equals(user.active)) {
            return false;
        }

        return true;
    }
}
