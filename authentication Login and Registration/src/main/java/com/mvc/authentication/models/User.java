package com.mvc.authentication.models;

import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 2, message = "Must be at least 2 characters long")
    @Pattern(regexp = "[a-zA-Z]+", message = "Must contain only letters")
    private String firstName;

    @Size(min = 2, message = "Must be at least 2 characters long")
    @Pattern(regexp = "[a-zA-Z]+", message = "Must contain only letters")
    private String lastName;

    @Email(message = "Not a valid email format")
    private String email;

    @Size(min = 2, message = "Must be at least 2 characters long")
    private String city;

    private String state;

    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{6,}$",
            message = "Not a valid password format. Please check the requirements and try again")
    private String password;

    @Transient
    private String passwordConfirmation;

    @Column(updatable=false)
    private Date createdAt;

    private Date updatedAt;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Message> comments;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "users_events",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "event_id")
    )
    private List<Event> events;

    @OneToMany(mappedBy = "creator", fetch = FetchType.LAZY)
    private List<Event> created_events;

    public User() {

    }

    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }

    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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

    public List<Message> getComments() {
        return comments;
    }

    public void setComments(List<Message> comments) {
        this.comments = comments;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public List<Event> getCreated_events() {
        return created_events;
    }

    public void setCreated_events(List<Event> created_events) {
        this.created_events = created_events;
    }
}