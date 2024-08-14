package com.example.simplewebspring.model;

import jakarta.persistence.*;

import jakarta.persistence.Entity;

@Entity
@Table(name = "list_apps")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_list")
    private Long id;
    private String nmApp;

    @ManyToOne
    @JoinColumn(name = "branch_id")
    private Branch branch;

    public String getNmApp() {
        return nmApp;
    }

    public void setNmApp(String nmApp) {
        this.nmApp = nmApp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }
}
