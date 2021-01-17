package com.mvc.tvshows.models;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Email(message="Email must be valid")
    @Size(min=1, message="email cannot be blank")
    private String email;

    @Size(min=1, message="Please provide a name")
    private String name;

    @Size(min=8, message="Password must be 8 characters or longer")
    private String password;

    @Transient
    private String passwordConfirmation;

    @Column(updatable=false)
    private Date createdAt;

    private Date updatedAt;

    @OneToMany(mappedBy="userTitle", fetch=FetchType.LAZY)
    private List<Show> shows;

    @OneToMany(mappedBy="user", fetch=FetchType.LAZY)
    private List<Rate> reviews;

    public User() {
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirmation() {
        return passwordConfirmation;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<Show> getShows() {
        return shows;
    }

    public void setShows(List<Show> shows) {
        this.shows = shows;
    }

    public List<Rate> getReviews() {
        return reviews;
    }

    public void setReviews(List<Rate> reviews) {
        this.reviews = reviews;
    }

    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }

    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }

}

