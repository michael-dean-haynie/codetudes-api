package com.codetudes.codetudesapi.contracts;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

public class CodetudeDTO {

    private Long id;

    private Timestamp created;

    private Timestamp updated;

    private Date started;

    private String title;

    private String subtitle;

    private String description;

    private String sourceCodeLink;

    private String liveDemoLink;

    private Boolean live;
    
    private Long previewImageId;

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

    public Boolean getLive() {
        return live;
    }

    public void setLive(Boolean live) {
        this.live = live;
    }

	public Long getPreviewImageId() {
		return previewImageId;
	}

	public void setPreviewImageId(Long previewImageId) {
		this.previewImageId = previewImageId;
	}
	
}