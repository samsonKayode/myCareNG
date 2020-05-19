package com.hypen.mycare.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="APPOINTMENTS")
public class LocalAppointment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="aid")
	private int id;
	
	@Column(name="patient_id")
	private String patient_id;
	
	@Column(name="date")
	private String date;
	
	@Column(name="time")
	private String time;
	
	@Column(name="doctor_id")
	private int doctor_id;
	
	@Column(name="type")
	private String type;
	
	@Column(name="dt")
	private String dt;
	
	@Column(name="cname")
	private String cname;
	
	@Column(name="dur")
	private String dur;
	
	public LocalAppointment() {
		
	}
	

	public LocalAppointment(String patient_id, String date, String time, int doctor_id, String type) {
		this.patient_id = patient_id;
		this.date = date;
		this.time = time;
		this.doctor_id = doctor_id;
		this.type = type;
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

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public int getDoctor_id() {
		return doctor_id;
	}

	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "LocalAppointment [patient_id=" + patient_id + ", date=" + date + ", time=" + time + ", doctor_id="
				+ doctor_id + ", type=" + type + "]";
	}

}
