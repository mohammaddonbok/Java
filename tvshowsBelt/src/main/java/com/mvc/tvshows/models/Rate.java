package com.mvc.tvshows.models;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Date;


    @Entity
    @Table(name = "reviews")
    public class Rate {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Min(value = 1, message = "Invalid Rating")
        @Max(value = 5, message = "Invalid Rating")
        private Integer rating;

        @Column(updatable = false)
        private Date createdAt;

        private Date updatedAt;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "user_id")
        private User user;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "show_id")
        private Show show;

        public Rate() {
        }

        public Rate(Long id,
                    @Min(value = 1, message = "Unacceptable Rating") @Max(value = 5, message = "Unacceptable Rating") Integer rating,
                    User user, Show show, Date createdAt, Date updatedAt) {
            this.id = id;
            this.rating = rating;
            this.user = user;
            this.show = show;
            this.createdAt = createdAt;
            this.updatedAt = updatedAt;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Integer getRating() {
            return rating;
        }

        public void setRating(Integer rating) {
            this.rating = rating;
        }

        public User getUser() {
            return user;
        }

        public void setUser(User user) {
            this.user = user;
        }

        public Show getShow() {
            return show;
        }

        public void setShow(Show show) {
            this.show = show;
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

        @PrePersist
        protected void onCreate() {
            this.createdAt = new Date();
        }

        @PreUpdate
        protected void onUpdate() {
            this.updatedAt = new Date();
        }
    }

