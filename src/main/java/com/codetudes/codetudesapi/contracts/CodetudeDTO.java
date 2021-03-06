package com.codetudes.codetudesapi.contracts;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

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

	@Override
	public String toString() {
		return "CodetudeDTO [id=" + id + ", created=" + created + ", updated=" + updated + ", started=" + started
				+ ", finished=" + finished + ", title=" + title + ", subtitle=" + subtitle + ", description="
				+ description + ", sourceCodeLink=" + sourceCodeLink + ", liveDemoLink=" + liveDemoLink + ", live="
				+ live + ", previewImageId=" + previewImageId + ", tags=" + tags + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((created == null) ? 0 : created.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((finished == null) ? 0 : finished.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((live == null) ? 0 : live.hashCode());
		result = prime * result + ((liveDemoLink == null) ? 0 : liveDemoLink.hashCode());
		result = prime * result + ((previewImageId == null) ? 0 : previewImageId.hashCode());
		result = prime * result + ((sourceCodeLink == null) ? 0 : sourceCodeLink.hashCode());
		result = prime * result + ((started == null) ? 0 : started.hashCode());
		result = prime * result + ((subtitle == null) ? 0 : subtitle.hashCode());
		result = prime * result + ((tags == null) ? 0 : tags.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((updated == null) ? 0 : updated.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CodetudeDTO other = (CodetudeDTO) obj;
		if (created == null) {
			if (other.created != null)
				return false;
		} else if (!created.equals(other.created))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (finished == null) {
			if (other.finished != null)
				return false;
		} else if (!finished.equals(other.finished))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (live == null) {
			if (other.live != null)
				return false;
		} else if (!live.equals(other.live))
			return false;
		if (liveDemoLink == null) {
			if (other.liveDemoLink != null)
				return false;
		} else if (!liveDemoLink.equals(other.liveDemoLink))
			return false;
		if (previewImageId == null) {
			if (other.previewImageId != null)
				return false;
		} else if (!previewImageId.equals(other.previewImageId))
			return false;
		if (sourceCodeLink == null) {
			if (other.sourceCodeLink != null)
				return false;
		} else if (!sourceCodeLink.equals(other.sourceCodeLink))
			return false;
		if (started == null) {
			if (other.started != null)
				return false;
		} else if (!started.equals(other.started))
			return false;
		if (subtitle == null) {
			if (other.subtitle != null)
				return false;
		} else if (!subtitle.equals(other.subtitle))
			return false;
		if (tags == null) {
			if (other.tags != null)
				return false;
		} else if (!tags.equals(other.tags))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (updated == null) {
			if (other.updated != null)
				return false;
		} else if (!updated.equals(other.updated))
			return false;
		return true;
	}
	
}