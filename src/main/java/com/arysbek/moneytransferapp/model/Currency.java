package com.arysbek.moneytransferapp.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "currencies")
public class Currency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "native")
    private Integer id;

    @Column(length = 3, unique = true, nullable = false)
    private String name;


    public List<Transaction> getTransaction() {
        return transaction;
    }

    public void setTransaction(List<Transaction> transaction) {
        this.transaction = transaction;
    }

    @OneToMany(mappedBy = "currency")
    @JsonBackReference
    private List<Transaction> transaction;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}