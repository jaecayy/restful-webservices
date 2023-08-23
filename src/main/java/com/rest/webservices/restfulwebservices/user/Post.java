package com.rest.webservices.restfulwebservices.user;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import net.minidev.json.annotate.JsonIgnore;

@Entity(name="post")
public class Post {

    @Id
    @GeneratedValue
    private Integer id;
    @Size(min=10)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonBackReference
    private User user;

    public Post() {
    }

    public Post(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", description='" + description + '\'' +
                '}';
    }
}
