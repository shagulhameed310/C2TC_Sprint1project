package com.placement.certificate.entity;


import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Column;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "certificate")
public class Certificate {
	@Id
	private Long id;

	private String name;
	private String issuer;

	@JsonProperty("issueDate")
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "issue_date", nullable = false)
	private LocalDate issueDate;

	@JsonProperty("expiryDate")
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(name = "expiry_date", nullable = false)
	private LocalDate expiryDate;

	// 🔹 Extra fields added
	@JsonProperty("description")
	@Column(name = "description")
	private String description;

	@JsonProperty("certificateUrl")
	@Column(name = "certificate_url")
	private String certificateUrl;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIssuer() {
		return issuer;
	}

	public void setIssuer(String issuer) {
		this.issuer = issuer;
	}

	public LocalDate getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}

	public LocalDate getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCertificateUrl() {
		return certificateUrl;
	}

	public void setCertificateUrl(String certificateUrl) {
		this.certificateUrl = certificateUrl;
	}

	@Override
	public String toString() {
		return "Certificate [id=" + id + ", name=" + name + ", issuer=" + issuer + ", issueDate=" + issueDate
				+ ", expiryDate=" + expiryDate + ", description=" + description + ", certificateUrl=" + certificateUrl
				+ "]";
	}    
    
}

