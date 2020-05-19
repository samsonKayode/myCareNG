package com.hypen.mycare.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="hospitals_doctors")
public class HospitalDoctor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="doctor_name")
	private String doctor_name;
	
	@Column(name="specialization")
	private String specialization;
	
	@JsonIgnore()
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="hospital_id")
	private Hospitals hospitals;
	
	
	public HospitalDoctor() {
		
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getDoctor_name() {
		return doctor_name;
	}


	public void setDoctor_name(String doctor_name) {
		this.doctor_name = doctor_name;
	}


	public Hospitals getHospitals() {
		return hospitals;
	}


	public void setHospitals(Hospitals hospitals) {
		this.hospitals = hospitals;
	}


	public String getSpecialization() {
		return specialization;
	}


	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	
	
}
