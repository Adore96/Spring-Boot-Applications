package com.adore96.SpringPOS.model;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author kalharaperera ON 12/22/20
 * @project SpringJWT
 */

@Entity
@Table(name = "users")
public class User {

    @Id
    @Column(name = "userID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;

    private String fname;
    private String lname;
    private String username;
    private String password;
    private int telephone;
    private int roleid;
    private String timeStamp;

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    @GeneratedValue(strategy = GenerationType.AUTO)
    private String createdTime;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }
}
