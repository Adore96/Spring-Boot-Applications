package com.adore96.BootJPA.model;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name = "roledetails")
@XmlRootElement
public class Roledetails implements Serializable {

    @Id
    @Basic(optional = false)
    @Column(name = "roleid")
    private String roleid;

    @Basic(optional = false)
    @Column(name = "rolename")
    private String rolename;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "roleid")
    private Collection<Users> usersCollection;

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public Collection<Users> getUsersCollection() {
        return usersCollection;
    }

    public void setUsersCollection(Collection<Users> usersCollection) {
        this.usersCollection = usersCollection;
    }

    public Roledetails() {
    }

    public void roledetails(Collection<Users> usersCollection) {
        this.usersCollection = usersCollection;
    }


    public Roledetails(String roleid, String roleName) {
        this.roleid = roleid;
        this.rolename = roleName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (roleid != null ? roleid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Roledetails)) {
            return false;
        }

        Roledetails other = (Roledetails) object;
        if ((this.roleid == null && other.roleid != null) || (this.roleid != null && !this.roleid.equals(other.roleid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.security.entity.UserRole[ roleId=" + roleid + " ]";
    }

}