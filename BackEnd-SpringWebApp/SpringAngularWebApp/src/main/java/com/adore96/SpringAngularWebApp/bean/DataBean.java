package com.adore96.SpringAngularWebApp.bean;

public class DataBean {
    private String id;
    private String fname;
    private String lname;
    private String username;
    private String password;
    private String telephone;

    public DataBean() {
    }

    public DataBean(String id, String fname, String lname, String username, String password, String telephone) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.username = username;
        this.password = password;
        this.telephone = telephone;
    }

    public DataBean(String fname, String lname, String username, String password, String telephone) {
        this.fname = fname;
        this.lname = lname;
        this.username = username;
        this.password = password;
        this.telephone = telephone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
