package com.neu.film.pojo;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
@Table(name = "user", schema = "film", catalog = "")
public class UserEntity {
    private int uId;
    private String uName;
    private String uPwd;
    private Date uBirth;
    private Integer uScore;
    private String uMobile;
    private String uImg;
    private String uRloe;
    private Double uBalance;
    private Integer uState;

    @Id
    @Column(name = "U_ID")
    public int getuId() {
        return uId;
    }

    public void setuId(int uId) {
        this.uId = uId;
    }

    @Basic
    @Column(name = "U_NAME")
    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    @Basic
    @Column(name = "U_PWD")
    public String getuPwd() {
        return uPwd;
    }

    public void setuPwd(String uPwd) {
        this.uPwd = uPwd;
    }

    @Basic
    @Column(name = "U_BIRTH")
    public Date getuBirth() {
        return uBirth;
    }

    public void setuBirth(Date uBirth) {
        this.uBirth = uBirth;
    }

    @Basic
    @Column(name = "U_SCORE")
    public Integer getuScore() {
        return uScore;
    }

    public void setuScore(Integer uScore) {
        this.uScore = uScore;
    }

    @Basic
    @Column(name = "U_MOBILE")
    public String getuMobile() {
        return uMobile;
    }

    public void setuMobile(String uMobile) {
        this.uMobile = uMobile;
    }

    @Basic
    @Column(name = "U_IMG")
    public String getuImg() {
        return uImg;
    }

    public void setuImg(String uImg) {
        this.uImg = uImg;
    }

    @Basic
    @Column(name = "U_RLOE")
    public String getuRloe() {
        return uRloe;
    }

    public void setuRloe(String uRloe) {
        this.uRloe = uRloe;
    }

    @Basic
    @Column(name = "U_BALANCE")
    public Double getuBalance() {
        return uBalance;
    }

    public void setuBalance(Double uBalance) {
        this.uBalance = uBalance;
    }

    @Basic
    @Column(name = "U_STATE")
    public Integer getuState() {
        return uState;
    }

    public void setuState(Integer uState) {
        this.uState = uState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return uId == that.uId &&
                Objects.equals(uName, that.uName) &&
                Objects.equals(uPwd, that.uPwd) &&
                Objects.equals(uBirth, that.uBirth) &&
                Objects.equals(uScore, that.uScore) &&
                Objects.equals(uMobile, that.uMobile) &&
                Objects.equals(uImg, that.uImg) &&
                Objects.equals(uRloe, that.uRloe) &&
                Objects.equals(uBalance, that.uBalance) &&
                Objects.equals(uState, that.uState);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uId, uName, uPwd, uBirth, uScore, uMobile, uImg, uRloe, uBalance, uState);
    }
}
