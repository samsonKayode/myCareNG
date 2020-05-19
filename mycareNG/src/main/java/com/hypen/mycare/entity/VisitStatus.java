package com.hypen.mycare.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="WAITINGLIST")
public class VisitStatus {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="WID")
	private int id;
	
	@Column(name="patient_id")
	private String patient_id;
	
	@Column(name="date")
	private String date;
	
	@Column(name="atime")
	private String atime;
	
	@Column(name="status")
	private String status;
	
	public VisitStatus() {
		
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(String patient_id) {
		this.patient_id = patient_id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getAtime() {
		return atime;
	}

	public void setAtime(String atime) {
		this.atime = atime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "VisitStatus [id=" + id + ", patient_id=" + patient_id + ", date=" + date + ", atime=" + atime
				+ ", status=" + status + "]";
	}
	
	
}
