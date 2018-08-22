package com.codetudes.codetudesapi.contracts;

import com.codetudes.codetudesapi.domain.Tag;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;

public class CodetudeDTO {

    private Long id;

    private Timestamp created;

    private Timestamp updated;

    private Date started;

    private Date finished;

    private String title;

    private String subtitle;

    private String description;

    private String sourceCodeLink;

    private String liveDemoLink;

    private List<TagDTO> tags;

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

    public List<TagDTO> getTags() {
        return tags;
    }

    public void setTags(List<TagDTO> tags) {
        this.tags = tags;
    }

    @Override
    public String toString() {
        return "CodetudeDTO{" +
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
                ", tags=" + tags +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CodetudeDTO that = (CodetudeDTO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(created, that.created) &&
                Objects.equals(updated, that.updated) &&
                Objects.equals(started, that.started) &&
                Objects.equals(finished, that.finished) &&
                Objects.equals(title, that.title) &&
                Objects.equals(subtitle, that.subtitle) &&
                Objects.equals(description, that.description) &&
                Objects.equals(sourceCodeLink, that.sourceCodeLink) &&
                Objects.equals(liveDemoLink, that.liveDemoLink) &&
                Objects.equals(tags, that.tags);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, created, updated, started, finished, title, subtitle, description, sourceCodeLink, liveDemoLink, tags);
    }
}