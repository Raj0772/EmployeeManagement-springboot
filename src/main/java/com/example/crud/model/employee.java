package com.example.crud.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="employees")
public class employee {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long id;

    @Column(name="emp_name")
    private String ename;

    @Column(name="emp_address")
    private String eaddress;

    @Column(name="emp_phone")
    private String ephone;

    @Column(name="emp_email")
    private String eemail;

    @Column(name="emp_type")
    private String etype;

    @Column(name="emp_jdate")
    private String ejoiningdate;

    @Column(name="emp_did")
    private int did;

    @Column(name="emp_pid")
    private int pid;

    public employee() {
    }

    public employee(String ename, String eaddress, String ephone, String eemail, String etype, String ejoiningdate,
            int did, int pid) {
        super();
        this.ename = ename;
        this.eaddress = eaddress;
        this.ephone = ephone;
        this.eemail = eemail;
        this.etype = etype;
        this.ejoiningdate = ejoiningdate;
        this.did = did;
        this.pid = pid;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getEaddress() {
        return eaddress;
    }

    public void setEaddress(String eaddress) {
        this.eaddress = eaddress;
    }

    public String getEphone() {
        return ephone;
    }

    public void setEphone(String ephone) {
        this.ephone = ephone;
    }

    public String getEemail() {
        return eemail;
    }

    public void setEemail(String eemail) {
        this.eemail = eemail;
    }

    public String getEtype() {
        return etype;
    }

    public void setEtype(String etype) {
        this.etype = etype;
    }

    public String getEjoiningdate() {
        return ejoiningdate;
    }

    public void setEjoiningdate(String ejoiningdate) {
        this.ejoiningdate = ejoiningdate;
    }

    public int getDid() {
        return did;
    }

    public void setDid(int did) {
        this.did = did;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }
}
