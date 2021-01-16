package com.mvc.authentication.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "events")
public class Event {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Size(min = 2, message = "Must be at least 2 characters long")
        private String name;

        private String date;

        @Size(min = 2, message = "Must be at least 2 characters long")
        private String city;

        private String state;

        @Column(updatable=false)
        private Date createdAt;

        private Date updatedAt;

        @ManyToMany(fetch = FetchType.LAZY)
        @JoinTable(
                name = "users_events",
                joinColumns = @JoinColumn(name = "event_id"),
                inverseJoinColumns = @JoinColumn(name = "user_id")
        )
        private List<User> users;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "creator_id")
        private User creator;

        @OneToMany(mappedBy = "event", fetch = FetchType.LAZY)
        private List <Message> comments;

        public Event() {

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

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
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

        public List<User> getUsers() {
            return users;
        }

        public void setUsers(List<User> users) {
            this.users = users;
        }

        public User getCreator() {
            return creator;
        }

        public void setCreator(User creator) {
            this.creator = creator;
        }

        public List<Message> getComments() {
            return comments;
        }

        public void setComments(List<Message> comments) {
            this.comments = comments;
        }
}
