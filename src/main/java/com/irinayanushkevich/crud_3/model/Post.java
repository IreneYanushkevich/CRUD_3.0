package com.irinayanushkevich.crud_3.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "posts", schema = "public")
public class Post {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "post_id", nullable = false)
    private Long id;
    @Column(name = "content", nullable = false, length = -1)
    private String content;
    @CreationTimestamp
    @Column(name = "created", nullable = false)
    private LocalDateTime created;
    @UpdateTimestamp
    @Column(name = "updated", nullable = false)
    private LocalDateTime updated;
    @Enumerated(EnumType.STRING)
    @Column(name = "post_status", nullable = false, length = 10)
    private PostStatus status;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinTable(name = "posts_labels",
            joinColumns = @JoinColumn(name = "post_id"),
            inverseJoinColumns = @JoinColumn(name = "label_id"))
    private List<Label> labels;

    public Post() {
    }

    public Post(Long id, String content, LocalDateTime created, List<Label> labels) {
        this.id = id;
        this.content = content;
        this.created = created;
        this.labels = labels;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    public List<Label> getLabels() {
        return labels;
    }

    public void setLabels(List<Label> labels) {
        this.labels = labels;
    }

    public PostStatus getStatus() {
        return status;
    }

    public void setStatus(PostStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != this.getClass()) return false;
        Post p = (Post) o;
        if (content == null) {
            if (p.content != null) {
                return false;
            }
        } else if (!content.equals(p.content)) {
            return false;
        }
        if (labels == null) {
            if (p.labels != null) {
                return false;
            }
        } else if (!labels.equals(p.labels)) {
            return false;
        }
        if (updated == null) {
            if (p.updated != null) {
                return false;
            }
        } else if (!updated.equals(p.updated)) {
            return false;
        }
        if (created == null) {
            if (p.created != null) {
                return false;
            }
        } else if (!created.equals(p.created)) {
            return false;
        }
        if (status == null) {
            if (p.status != null) {
                return false;
            }
        } else if (!status.equals(p.status)) {
            return false;
        }
        return id.intValue() == p.id.intValue();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((content == null) ? 0 : content.hashCode());
        result = prime * result + ((labels == null) ? 0 : labels.hashCode());
        result = prime * result + ((created == null) ? 0 : created.hashCode());
        result = prime * result + ((updated == null) ? 0 : updated.hashCode());
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        result = prime * result + id.intValue();
        return result;
    }

    @Override
    public String toString() {
        return "\nPost id:" + id + ", created: " + created + ", updated: " + updated + ", status: " + status +
                ",\nlabels: " + labels + "\ncontent:\n" + content;
    }
}
