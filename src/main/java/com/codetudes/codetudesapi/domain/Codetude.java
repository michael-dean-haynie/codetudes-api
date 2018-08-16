package com.codetudes.codetudesapi.domain;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Codetude {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    private Timestamp created;

    @UpdateTimestamp
    private Timestamp updated;

    private Date started;

    private Date finished;

    private String title;

    private String subtitle;

    private String description;

    private String sourceCodeLink;

    private String liveDemoLink;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getStarted() {
        return started;
    }

    public void setStarted(Date started) {
        this.started = started;
    }

    public Date getFinished() {
        return finished;
    }

    public void setFinished(Date finished) {
        this.finished = finished;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSourceCodeLink() {
        return sourceCodeLink;
    }

    public void setSourceCodeLink(String sourceCodeLink) {
        this.sourceCodeLink = sourceCodeLink;
    }

    public String getLiveDemoLink() {
        return liveDemoLink;
    }

    public void setLiveDemoLink(String liveDemoLink) {
        this.liveDemoLink = liveDemoLink;
    }

    @Override
    public String toString() {
        return "Codetude{" +
                "id=" + id +
                ", created=" + created +
                ", updated=" + updated +
                ", started=" + started +
                ", finished=" + finished +
                ", title='" + title + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", description='" + description + '\'' +
                ", sourceCodeLink='" + sourceCodeLink + '\'' +
                ", liveDemoLink='" + liveDemoLink + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Codetude codetude = (Codetude) o;
        return Objects.equals(id, codetude.id) &&
                Objects.equals(created, codetude.created) &&
                Objects.equals(updated, codetude.updated) &&
                Objects.equals(started, codetude.started) &&
                Objects.equals(finished, codetude.finished) &&
                Objects.equals(title, codetude.title) &&
                Objects.equals(subtitle, codetude.subtitle) &&
                Objects.equals(description, codetude.description) &&
                Objects.equals(sourceCodeLink, codetude.sourceCodeLink) &&
                Objects.equals(liveDemoLink, codetude.liveDemoLink);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, created, updated, started, finished, title, subtitle, description, sourceCodeLink, liveDemoLink);
    }
}
