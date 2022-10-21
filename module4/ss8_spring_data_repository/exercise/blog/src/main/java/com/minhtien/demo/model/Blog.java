package com.minhtien.demo.model;

import javax.persistence.*;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String topic;
    private String author;
    @ManyToOne(targetEntity = ECommerce.class)
    private ECommerce eCommerce;

    public Blog() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public ECommerce geteCommerce() {
        return eCommerce;
    }

    public void seteCommerce(ECommerce eCommerce) {
        this.eCommerce = eCommerce;
    }
}
