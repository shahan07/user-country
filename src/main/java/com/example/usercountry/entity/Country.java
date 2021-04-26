package com.example.usercountry.entity;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "country")
public class Country {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cid")
    private int cid;
    @Column(unique = true)
    private int code;
    private String countryName;
    @OneToMany(targetEntity = Users.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "users_countryCode",referencedColumnName = "countryCode")
    private List<Users> users;

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }
}
