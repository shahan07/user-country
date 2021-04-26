package com.example.usercountry.entity;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "country")
public class Country {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long cid;
    @Column(unique = true)
    private Long code;
    private String countryName;
    @OneToMany(targetEntity = Users.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "country_code",referencedColumnName = "code")
    private List<Users> users;

    public Long getCid() {
        return cid;
    }

    public void setCid(Long cid) {
        this.cid = cid;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
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
