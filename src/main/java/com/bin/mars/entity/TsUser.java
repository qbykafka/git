package com.bin.mars.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "ts_user", schema = "mytodb", catalog = "")
public class TsUser implements Serializable {
    private long id;
    private String username;
    private String password;
    private String name;
    private String phone;
    private Timestamp createTm;

    @Id
    @Column(name = "id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "username", nullable = false, length = 50)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "password", nullable = false, length = 50)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "name", nullable = false, length = 50)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "phone", nullable = false, length = 50)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "create_tm", nullable = false)
    public Timestamp getCreateTm() {
        return createTm;
    }

    public void setCreateTm(Timestamp createTm) {
        this.createTm = createTm;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TsUser tsUser = (TsUser) o;
        return id == tsUser.id &&
                Objects.equals(username, tsUser.username) &&
                Objects.equals(password, tsUser.password) &&
                Objects.equals(name, tsUser.name) &&
                Objects.equals(phone, tsUser.phone) &&
                Objects.equals(createTm, tsUser.createTm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, name, phone, createTm);
    }
}
