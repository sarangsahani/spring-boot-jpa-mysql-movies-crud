package com.sarang.moviewreviews.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "movies")
@JsonIgnoreProperties(value = { "entryDate" }, allowGetters = true)
public class Movie {
	@Id
	@GeneratedValue
	private Long movieId;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String yearOfRelease;
	
	@Column(nullable = false)
	private String description;
	
	@Column(nullable = false)
	private String language;
	
	private String poster;

	@Column(nullable = false)
	@CreationTimestamp
	private LocalDateTime entryDate;
	
	@Column(nullable = false)
	@UpdateTimestamp
	private LocalDateTime updateDate;
	
	protected Movie() {
	}

	public Movie(String name, String yearOfRelease, String description, String language, String poster) {
		super();
		this.name = name;
		this.yearOfRelease = yearOfRelease;
		this.description = description;
		this.language = language;
		this.poster = poster;
	}

	public Long getMovieId() {
		return movieId;
	}

	public String getName() {
		return name;
	}

	public String getYearOfRelease() {
		return yearOfRelease;
	}

	public String getDescription() {
		return description;
	}

	public String getLanguage() {
		return language;
	}

	public String getPoster() {
		return poster;
	}


	public LocalDateTime getEntryDate() {
		return entryDate;
	}
	
	public LocalDateTime getUpdateDate() {
		return updateDate;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setYearOfRelease(String yearOfRelease) {
		this.yearOfRelease = yearOfRelease;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}
	
	public void setEntryDate(LocalDateTime entryDate) {
		this.entryDate = entryDate;
	}

	public void setUpdateDate(LocalDateTime updateDate) {
		this.updateDate = updateDate;
	}

	@Override
	public String toString() {
		return "Movies [movieId=" + movieId + ", name=" + name + ", yearOfRelease=" + yearOfRelease + ", description="
				+ description + ", language=" + language + ", poster=" + poster + ", entryDate=" + entryDate
				+ ", updateDate=" + updateDate + "]";
	}

	
}
