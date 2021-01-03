package com.techhub.model;

import javax.persistence.*;

@Entity
@Table(name="studregister",
uniqueConstraints=
@UniqueConstraint(columnNames={"email", "password"})

		)
public class StudentRegisterModel {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="studentId")
	private int id;
    @Column(name="username")
	private String username;
    @Column(name="email")
	private String email;
    @Column(name="password")
	private String password;
    @Column(name="contact")
	private String contact;
    
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	
    
    
	
}
