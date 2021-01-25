package com.techhub.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.*;
import javax.persistence.GenerationType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
@Entity
@Table(name="studprofile")
public class StudentModel {
    @Id
	@Column(name="sid")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int sid;
    @Column(name="firstname")
	private String firstname;
    @Column(name="lastname")
    private String lastname;
    @Column(name="contact")
	private String contact;
    @Column(name="address")
	private String address;
    @Column(name="sscmarks")
	private String sscmarks;
    @Column(name="sscpassout")
	private String sscpassout;
    @Column(name="hscmarks")
	private String hscmarks;
    @Column(name="hscpassout")
	private String hscpassout;
    @Column(name="diplomamarks")
	private String diplomamarks;
    @Column(name="diplomapassout")
	private String diplomapassout;
    @Column(name="graduationmarks")
	private String graduationmarks;
    @Column(name="graduationstream")
	private String graduationstream;
    @Column(name="graduationpassout")
	private String graduationpassout;
    @Column(name="pgmarks")
	private String pgmarks;
    @Column(name="pgstream")
	private String pgstream;
    @Column(name="pgpassout")
	private String pgpassout;
    @Column(name="experience")
	private String experience;
    @Column(name="tskills")
	private String tskills;
    @Column(name="FileName")
    private String filename;
   
    @Transient
    @Column(name="resume")
	private MultipartFile resume; 
	@ManyToMany(fetch=FetchType.LAZY, cascade=CascadeType.ALL, mappedBy="emps")
	private Set<AdminModel> admin= new HashSet<AdminModel>();
	
	
	
	public Set<AdminModel> getAdmin() {
		return admin;
	}
	public void setAdmin(Set<AdminModel> admin) {
		this.admin = admin;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSscmarks() {
		return sscmarks;
	}
	public void setSscmarks(String scsmarks) {
		this.sscmarks = scsmarks;
	}
	public String getSscpassout() {
		return sscpassout;
	}
	public void setSscpassout(String sscpassout) {
		this.sscpassout = sscpassout;
	}
	public String getHscmarks() {
		return hscmarks;
	}
	public void setHscmarks(String hscmarks) {
		this.hscmarks = hscmarks;
	}
	public String getHscpassout() {
		return hscpassout;
	}
	public void setHscpassout(String hscpassout) {
		this.hscpassout = hscpassout;
	}
	public String getDiplomamarks() {
		return diplomamarks;
	}
	public void setDiplomamarks(String diplomamarks) {
		this.diplomamarks = diplomamarks;
	}
	public String getDiplomapassout() {
		return diplomapassout;
	}
	public void setDiplomapassout(String diplomapassout) {
		this.diplomapassout = diplomapassout;
	}
	public String getGraduationmarks() {
		return graduationmarks;
	}
	public void setGraduationmarks(String graduationmarks) {
		this.graduationmarks = graduationmarks;
	}
	public String getGraduationstream() {
		return graduationstream;
	}
	public void setGraduationstream(String graduationstream) {
		this.graduationstream = graduationstream;
	}
	public String getGraduationpassout() {
		return graduationpassout;
	}
	public void setGraduationpassout(String graduationpassout) {
		this.graduationpassout = graduationpassout;
	}
	public String getPgmarks() {
		return pgmarks;
	}
	public void setPgmarks(String pgmarks) {
		this.pgmarks = pgmarks;
	}
	public String getPgpassout() {
		return pgpassout;
	}
	public void setPgpassout(String pgpassout) {
		this.pgpassout = pgpassout;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public String getTskills() {
		return tskills;
	}
	public void setTskills(String tskills) {
		this.tskills = tskills;
	}

	public MultipartFile getResume() {
		return resume;
	}
	public void setResume(MultipartFile resume) {
		this.resume = resume;
	}
	public String getPgstream() {
		return pgstream;
	}
	public void setPgstream(String pgstream) {
		this.pgstream = pgstream;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}

	
	
	
	
	
	
	
}
