package com.irinayanushkevich.crud_3.model;

import jakarta.persistence.*;

@Entity
@Table(name = "labels", schema = "public", catalog = "postgres")
public class Label {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "label_id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "name", nullable = false, length = 10)
    private String name;

    public Label() {
    }

    public Label(Long id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        Label l = (Label) o;
        if (name == null) {
            if (l.name != null) {
                return false;
            }
        } else if (!name.equals(l.name)) {
            return false;
        }
        return id.equals(l.id);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + id.intValue();
        return result;
    }

    @Override
    public String toString() {
        return "Label id: " + id + " - " + name;
    }
}
