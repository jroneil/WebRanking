package com.oneil.ranking.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "ranks")
public class Ranks implements Serializable {

	@Id 
	@SequenceGenerator(name="pk_sequence",sequenceName="ranks_id_seq", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="pk_sequence")
	@Column(name="id", unique=true, nullable=false)
	private Long id;
	@Column(name = "website", nullable = false )
	private String website;
	
	@Column(name = "rec_date") //columnDefinition="DATETIME")coment out for mysqlonly
	//@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "MM/dd/yyyy")
	private Date recDate;
	@Column(name = "visits", nullable = false)
	private int visits;

	protected Ranks() {
	}

	public Ranks(String website, Date recDate, int visits) {
		super();
		this.website = website;
		this.recDate = recDate;
		this.visits = visits;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	

	public Date getRecDate() {
		return recDate;
	}

	public void setRecDate(Date recDate) {
		this.recDate = recDate;
	}

	public int getVisits() {
		return visits;
	}

	public void setVisits(int visits) {
		this.visits = visits;
	}

}
