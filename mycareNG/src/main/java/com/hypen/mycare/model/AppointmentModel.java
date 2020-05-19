package com.hypen.mycare.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AppointmentModel {
	
	
	//@JsonProperty("id")
	private int id;
	
	//@JsonProperty("profile_id")
    private String profile_id;

    //@JsonProperty("hospital_name")
    private String hospital_name;

    //@JsonProperty("hospital_address")
    private String hospital_address;

    //@JsonProperty("hospital_city")
    private String hospital_city;

    //@JsonProperty("hospital_state")
    private String hospital_state;

    //@JsonProperty("department")
    private String department;

    //@JsonProperty("date")
    private String date;

    //@JsonProperty("time")
    private String time;

    //@JsonProperty("doctor_name")
    private String doctor_name;

    private String ddate;

    //@JsonProperty("code")
    private String code;

    //@JsonProperty("status")
    private String status;

	
	public AppointmentModel() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProfile_id() {
		return profile_id;
	}

	public void setProfile_id(String profile_id) {
		this.profile_id = profile_id;
	}

	public String getHospital_name() {
		return hospital_name;
	}

	public void setHospital_name(String hospital_name) {
		this.hospital_name = hospital_name;
	}

	public String getHospital_address() {
		return hospital_address;
	}

	public void setHospital_address(String hospital_address) {
		this.hospital_address = hospital_address;
	}

	public String getHospital_city() {
		return hospital_city;
	}

	public void setHospital_city(String hospital_city) {
		this.hospital_city = hospital_city;
	}

	public String getHospital_state() {
		return hospital_state;
	}

	public void setHospital_state(String hospital_state) {
		this.hospital_state = hospital_state;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
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

	public String getDoctor_name() {
		return doctor_name;
	}

	public void setDoctor_name(String doctor_name) {
		this.doctor_name = doctor_name;
	}

	public String getDdate() {
		return ddate;
	}

	public void setDdate(String ddate) {
		this.ddate = ddate;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "AppointmentModel [id=" + id + ", profile_id=" + profile_id + ", hospital_name=" + hospital_name
				+ ", hospital_address=" + hospital_address + ", hospital_city=" + hospital_city + ", hospital_state="
				+ hospital_state + ", department=" + department + ", date=" + date + ", time=" + time + ", doctor_name="
				+ doctor_name + ", ddate=" + ddate + ", code=" + code + ", status=" + status + "]";
	}
	
	
	

}
