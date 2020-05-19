package com.hypen.mycare.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="hospitals")
public class Hospitals {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="hospitalName")
	private String hospitalName;

	@Column(name="hospitalDesc")
	private String hospitalDesc;
	
	@Column(name="hospitalLogo")
	private byte[] hospitalLogo;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="hospitals", 
			cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	//@JsonManagedReference
	private Set<HospitalAddress> hospitalAddress; 
	
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="hospitals", 
			cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	//@JsonManagedReference
	private Set<HospitalSpeciality> hospitalSpeciality; 
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="hospitals", 
			cascade= {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
	//@JsonManagedReference
	private Set<HospitalDoctor> hospitalDoctor; 
	
	
	
	public Hospitals() {
		
	}
	
	
	public Hospitals(String hospitalName, String hospitalDesc) {
		this.hospitalName = hospitalName;
		this.hospitalDesc = hospitalDesc;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHospitalName() {
		return hospitalName;
	}

	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}

	public String getHospitalDesc() {
		return hospitalDesc;
	}

	public void setHospitalDesc(String hospitalDesc) {
		this.hospitalDesc = hospitalDesc;
	}
	
	

	public Set<HospitalAddress> getHospitalAddress() {
		return hospitalAddress;
	}



	public void setHospitalAddress(Set<HospitalAddress> hospitalAddress) {
		this.hospitalAddress = hospitalAddress;
	}

	

	public Set<HospitalSpeciality> getHospitalSpeciality() {
		return hospitalSpeciality;
	}



	public void setHospitalSpeciality(Set<HospitalSpeciality> hospitalSpeciality) {
		this.hospitalSpeciality = hospitalSpeciality;
	}
	
	

	public Set<HospitalDoctor> getHospitalDoctor() {
		return hospitalDoctor;
	}


	public void setHospitalDoctor(Set<HospitalDoctor> hospitalDoctor) {
		this.hospitalDoctor = hospitalDoctor;
	}


	public byte[] getHospitalLogo() {
		return hospitalLogo;
	}


	public void setHospitalLogo(byte[] hospitalLogo) {
		this.hospitalLogo = hospitalLogo;
	}


	@Override
	public String toString() {
		return "Hospitals [id=" + id + ", hospitalName=" + hospitalName + ", hospitalDesc=" + hospitalDesc + "]";
	}



	public void add(HospitalAddress tempAddress) {
		
		if(hospitalAddress==null) {
			hospitalAddress = new HashSet<>();
		}
		hospitalAddress.add(tempAddress);
		tempAddress.setHospitals(this);
	}
	
	//add speciality..
	
	public void addSpeciality(HospitalSpeciality tempSpeciality) {
		
		if(hospitalSpeciality==null) {
			hospitalSpeciality = new HashSet<>();
		}
		hospitalSpeciality.add(tempSpeciality);
		tempSpeciality.setHospitals(this);
	}
	
	//add doctors..

	public void addDoctor(HospitalDoctor tempDoctor) {
		
		if(hospitalDoctor==null) {
			hospitalDoctor = new HashSet<>();
		}
		hospitalDoctor.add(tempDoctor);
		tempDoctor.setHospitals(this);
	}
	
	
}
