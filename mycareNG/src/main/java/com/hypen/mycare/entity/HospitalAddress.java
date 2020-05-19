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
@Table(name="hospitals_address")
public class HospitalAddress {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="address")
	private String address;
	
	@Column(name="city")
	private String city;
	
	@Column(name="state")
	private String state;
	
	@JsonIgnore
	@ManyToOne( cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="hospital_id")

	private Hospitals hospitals;
	
	
	public HospitalAddress() {
		
		
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}
	

	public Hospitals getHospitals() {
		return hospitals;
	}


	public void setHospitals(Hospitals hospitals) {
		this.hospitals = hospitals;
	}


	public HospitalAddress(String address, String city, String state) {
		this.address = address;
		this.city = city;
		this.state = state;
	}


	@Override
	public String toString() {
		return "HospitalAddress [id=" + id + ", address=" + address + ", city=" + city + ", state=" + state + "]";
	}

}
