package com.example.simplewebspring.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private Long id;
    private String username;
    private String nmUser;
    private LocalDate dobUser;
    private String mobileUser;
    private Integer kdDepartemen;
    private Integer hakAkses;
    private Integer kdCabang;
    private String profileImg;

    private Date createdAt;
    private Date updatedAt;
    private String password;


    public String getUsername() {
        return username;
    }

    public Long getId() {
        return id;
    }

    public String getUserFullname() {
        return nmUser;
    }

    public LocalDate getUserDOB() {
        return dobUser;
    }

    public String getUserMobile() {
        return mobileUser;
    }

    public Integer getUserDept() {
        return kdDepartemen;
    }

    public Integer getUserAccess() {
        return hakAkses;
    }

    public Integer getUserSite() {
        return kdCabang;
    }

    public String getUserProfile() {
        return profileImg;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUserFullname(String userFullname) {
        this.nmUser = userFullname;
    }

    public void setUserDOB(LocalDate userDOB) {
        this.dobUser = userDOB;
    }

    public void setUserMobile(String userMobile) {
        this.mobileUser = userMobile;
    }

    public void setUserDept(Integer userDept) {
        this.kdDepartemen = userDept;
    }

    public void setUserAccess(Integer userAccess) {
        this.hakAkses = userAccess;
    }

    public void setUserSite(Integer userSite) {
        this.kdCabang = userSite;
    }

    public void setUserProfile(String userProfile) {
        this.profileImg = userProfile;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}