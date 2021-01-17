package com.mvc.tvshows.models;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="shows")
public class Show {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Size(min=1, message="no title provided")
    private String title;

    @Size(min=1, message="no network provided")
    private String network;

    private Double avgRate;

    @Column(updatable=false)
    private Date createdAt;

    private Date updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id")
    private User userTitle;

    @OneToMany(cascade=CascadeType.REMOVE, mappedBy="show", fetch = FetchType.LAZY)
    private List<Rate> reviews;

    public Show() {
    }

    public Show(Long id, @Size(min = 1, message = "no title provided") String title,
                @Size(min = 1, message = "no network provided") String network, Double avgRate, User userT,
                List<Rate> reviews, Date createdAt, Date updatedAt) {
        this.id = id;
        this.title = title;
        this.network = network;
        this.avgRate = avgRate;
        this.userTitle = userT;
        this.reviews = reviews;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }


    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public String getNetwork() {

        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public Double getAvgRating() {
        return avgRate;
    }

    public void setAvgRating(Double avgRating) {
        this.avgRate = avgRating;
    }

    public User getUserTitle() {
        return userTitle;
    }

    public void setUserTitle(User userT) {
        this.userTitle = userT;
    }

    public List<Rate> getReviews() {
        return reviews;
    }

    public void setReviews(List<Rate> reviews) {
        this.reviews = reviews;
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
    protected void onCreate(){

        this.createdAt = new Date();
    }

    @PreUpdate
    protected void onUpdate(){

        this.updatedAt = new Date();
    }
}
