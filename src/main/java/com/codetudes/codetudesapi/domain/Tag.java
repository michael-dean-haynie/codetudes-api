package com.codetudes.codetudesapi.domain;

import javax.persistence.*;
import java.util.Objects;
import java.util.List;

@Entity
@Table(name = "tag")
public class Tag {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE },
                mappedBy = "tags")
    private List<Codetude> codetudes;

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

    @Override
    public String toString() {
        return "Tag{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tag tag = (Tag) o;
        return Objects.equals(id, tag.id) &&
                Objects.equals(name, tag.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name);
    }
}
