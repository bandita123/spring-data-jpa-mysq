package com.mkyong;

import java.io.Serializable;

import javax.persistence.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
@Entity
@JsonIgnoreProperties(value= {"subject"})
public class ContactInfo{
	
	    @Id
	    @Column(name="cid")
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private int id_info;

	
	public int getId_info() {
			return id_info;
		}
		public void setId_info(int id_info) {
			this.id_info = id_info;
		}
	private String username;
	
	public ContactInfo(String username, String mobno, String email, String subject, String message) {
		super();
		this.username = username;
		this.mobno = mobno;
		this.email = email;
		this.subject = subject;
		this.message = message;
	}
	@JsonProperty("mob_no")
	private String mobno;
	
	
	private String email;
	
	@JsonIgnore
	private String subject;
	private String message;
	@Override
	public String toString() {
		return "Contact [username=" + username + ", mobno=" + mobno + ", email=" + email + ", subject=" + subject
				+ ", message=" + message + "]";
	}
	 public ContactInfo() {
	    }

	   

	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMobno() {
		return mobno;
	}
	public void setMobno(String mobno) {
		this.mobno = mobno;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	

}
