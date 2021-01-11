package com.relationship.demo.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="licenses")
public class License {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private Integer number;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date expirationDate;


    private String state;


    @Column(updatable=false)
    private Date createdAt;


    private Date updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
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

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="person_id")
    private Person person;

    public License(Integer number, Date expirationDate, String state, Person person) {
        this.number = number;
        this.expirationDate = expirationDate;
        this.state = state;
        this.person = person;
    }

    public License() {

    }

    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){

        this.updatedAt = new Date();
    }

    public String getNumberAsString() {
        int numZeros = 7 - String.valueOf(this.number).length();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < numZeros; i++)
            sb.append('0');
        return String.format("%s%d", sb, this.number);
    }
}