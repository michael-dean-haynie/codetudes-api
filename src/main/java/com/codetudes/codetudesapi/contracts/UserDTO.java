package com.codetudes.codetudesapi.contracts;

import java.sql.Timestamp;
import java.util.Objects;

public class UserDTO {
    private Long id;

    private String email;

    private String secret;

    private Timestamp created;

    private Timestamp updated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public Timestamp getCreated() {
        return created;
    }

    public void setCreated(Timestamp created) {
        this.created = created;
    }

    public Timestamp getUpdated() {
        return updated;
    }

    public void setUpdated(Timestamp updated) {
        this.updated = updated;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", secret='" + secret + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDTO userDTO = (UserDTO) o;
        return Objects.equals(id, userDTO.id) &&
                Objects.equals(email, userDTO.email) &&
                Objects.equals(secret, userDTO.secret) &&
                Objects.equals(created, userDTO.created) &&
                Objects.equals(updated, userDTO.updated);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, email, secret, created, updated);
    }
}
