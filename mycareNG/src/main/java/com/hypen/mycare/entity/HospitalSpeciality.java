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
@Table(name="hospitals_speciality")
public class HospitalSpeciality {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="speciality")
	private String speciality;
	
	@JsonIgnore()
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="hospital_id")
	private Hospitals hospitals;
	
	public HospitalSpeciality() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public Hospitals getHospitals() {
		return hospitals;
	}

	public void setHospitals(Hospitals hospitals) {
		this.hospitals = hospitals;
	}

	public HospitalSpeciality(String speciality) {
		this.speciality = speciality;
	}

	@Override
	public String toString() {
		return "HospitalSpeciality [id=" + id + ", speciality=" + speciality + ", hospitals=" + hospitals + "]";
	}
	
	
}
