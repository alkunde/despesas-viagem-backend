package br.ufpr.andrekunde.travelexpenses.entities;

import javax.persistence.*;

@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne()
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private Users user;

    @Column()
    private String role;

    public Role() {}

    public Role(Users user, String role) {
        this.user = user;
        this.role = role;
    }

    public Role(Long id, Users user, String role) {
        this.id = id;
        this.user = user;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;

        result = prime * result + ((user == null) ? 0 : user.hashCode());
        result = prime * result + ((role == null) ? 0 : role.hashCode());

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

        Role role = (Role) obj;
        if (user == null) {
            if (role.user != null) {
                return false;
            }
        } else if (!user.equals(role.user)) {
            return false;
        }

        if (role == null) {
            if (role.role != null) {
                return false;
            }
        } else if (!role.equals(role.role)) {
            return false;
        }

        return true;
    }
}
