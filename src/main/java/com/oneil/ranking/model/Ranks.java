package com.oneil.ranking.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "ranks")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Ranks implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "website", nullable = false )
	private String website;
	
	@Column(name = "rec_date", columnDefinition="DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	@JsonFormat(pattern = "MM-dd-yyyy")
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
