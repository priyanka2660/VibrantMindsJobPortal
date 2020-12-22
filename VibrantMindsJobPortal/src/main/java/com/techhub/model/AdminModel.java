package com.techhub.model;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name="jobprofile")
public class AdminModel 
{
	
@Id
@Column(name="Jid")
@GeneratedValue(strategy=GenerationType.IDENTITY)
 private int jid;

@Column(name="Jname")
 private String name;

@Column(name="Cname")
 private String cname;

@Column(name="package")
 private String jpackage;

@Column(name="status")
 private String status;
 
@Column(name="exp")
 private String exp;

@Column(name="postdate")
 private Date pdate;

@Column(name="lastdate")
 private Date ldate;

@Column(name="skill")
 private String skill;
 
@Column(name="jdes")
private String jdes;
 
 public int getJid() {
	return jid;
}
public void setJid(int jid) {
	this.jid = jid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getCname() {
	return cname;
}
public void setCname(String cname) {
	this.cname = cname;
}
public String getJpackage() {
	return jpackage;
}
public void setJpackage(String jpackage) {
	this.jpackage = jpackage;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getExp() {
	return exp;
}
public void setExp(String exp) {
	this.exp = exp;
}
public Date getPdate() {
	return pdate;
}
public void setPdate(Date pdate) {
	this.pdate = pdate;
}
public Date getLdate() {
	return ldate;
}
public void setLdate(Date ldate) {
	this.ldate = ldate;
}
public String getSkill() {
	return skill;
}
public void setSkill(String skill) {
	this.skill = skill;
}
public String getJdes() {
	return jdes;
}
public void setJdes(String jdes) {
	this.jdes = jdes;
} 
 
}
