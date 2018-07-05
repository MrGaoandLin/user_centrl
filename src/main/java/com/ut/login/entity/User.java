package com.ut.login.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;


@Data
@Entity
@Table(name = "user")
public class User implements Serializable {

    //设置主键策略，当插入数据库时设置主键自增长
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userName;

    private String password;

    private String sex;

    private Boolean state;

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public String getSex() {
//        return sex;
//    }
//
//    public void setSex(String sex) {
//        this.sex = sex;
//    }
//
//    public Boolean getState() {
//        return state;
//    }
//
//    public void setState(Boolean state) {
//        this.state = state;
//    }

    //    @Temporal(TemporalType.TIMESTAMP) //显示： 2011-04-12 22:51:34.0
//    @Column(name = "createTime")
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    private Date createTime;
//
//    @Temporal(TemporalType.TIMESTAMP) //显示： 2011-04-12 22:51:34.0
//    @Column(name = "updateTime")
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
//    private Date updateTime;
}
