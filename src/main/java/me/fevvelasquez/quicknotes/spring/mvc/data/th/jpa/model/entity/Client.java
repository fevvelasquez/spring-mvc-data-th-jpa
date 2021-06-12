package me.fevvelasquez.quicknotes.spring.mvc.data.th.jpa.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Quick Notes.
 * 
 * {@code Client} model to {@code clients} table.<br>
 * <br>
 * 
 * This class may implement {@link java.io.Serializable}.
 * 
 * @version 0.0.1-QUICKNOTES
 * @author fevvelasquez
 *
 */
@Entity
@Table(name = "clients")
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // SEQUENCE: POSTGRE, ORACLE
	private Long id;
	private String fname;
	private String lname;
	private String email;
	@Temporal(TemporalType.DATE)
	@Column(name = "created_at")
	private Date createdAt;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

}
