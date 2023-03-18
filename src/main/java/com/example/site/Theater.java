package com.example.site;//1-й класс

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.criteria.CriteriaBuilder;


@Entity
public class Theater {
    public long id;//id

    public String name_;//вид техники
    public String actors_name;//тип техники
    public String date_theater;//Дата ввоза на склад
    public String time_theater;//Дата вывоза со склада
    public Integer all_ticket;//Имя
    public Integer purchased_ticket;
    public Integer ticket;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getActors_name() {
        return actors_name;
    }

    public void setActors_name(String actors_name) {
        this.actors_name = actors_name;
    }

    public String getDate_theater() {
        return date_theater;
    }

    public void setDate_theater(String date_theater) {
        this.date_theater = date_theater;
    }

    public String getTime_theater() {
        return time_theater;
    }

    public void setTime_theater(String time_theater) {
        this.time_theater = time_theater;
    }

    public Integer getAll_ticket() {
        return all_ticket;
    }

    public void setAll_ticket(Integer all_ticket) {
        this.all_ticket = all_ticket;
    }

    public Integer getPurchased_ticket() {
        return purchased_ticket;
    }

    public void setPurchased_ticket(Integer purchased_ticket) {
        this.purchased_ticket = purchased_ticket;
    }
    public String getName_() {
        return name_;
    }

    public void setName_(String name_) {
        this.name_ = name_;
    }
    public Integer ticket(){
        return all_ticket - purchased_ticket;
    }
}

