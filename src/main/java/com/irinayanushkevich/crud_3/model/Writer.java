package com.irinayanushkevich.crud_3.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "writers", schema = "public", catalog = "postgres")
public class Writer {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "writer_id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "firstname", nullable = false, length = 30)
    private String firstName;
    @Basic
    @Column(name = "lastname", nullable = false, length = 30)
    private String lastName;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "writer_id")
    private List<Post> posts;

    public Writer() {
    }

    public Writer(Long id, String firstName, String lastName, List<Post> posts) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.posts = posts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Writer w = (Writer) o;
        if (firstName == null) {
            if (w.firstName != null) {
                return false;
            }
        } else if (!firstName.equals(w.firstName)) {
            return false;
        }
        if (lastName == null) {
            if (w.lastName != null) {
                return false;
            }
        } else if (!lastName.equals(w.lastName)) {
            return false;
        }
        if (posts == null) {
            if (w.posts != null) {
                return false;
            }
        } else if (!posts.equals(w.posts)) {
            return false;
        }
        return id.intValue() == w.id.intValue();
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
        result = prime * result + ((posts == null) ? 0 : posts.hashCode());
        result = prime * result + id.intValue();
        return result;
    }

    @Override
    public String toString() {
        return "\nWriter id: " + id + ", " + firstName + " " + lastName + "\nposts:\n" + posts;
    }
}
