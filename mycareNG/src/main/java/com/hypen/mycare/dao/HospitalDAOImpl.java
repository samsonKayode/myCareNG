package com.hypen.mycare.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hypen.mycare.entity.HospitalAddress;
import com.hypen.mycare.entity.HospitalDoctor;
import com.hypen.mycare.entity.HospitalSpeciality;
import com.hypen.mycare.entity.Hospitals;

@Repository
public class HospitalDAOImpl implements HospitalDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public Hospitals saveHospital(Hospitals theHospital) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		/*
		
		String imLoc = "/Users/kayode/Downloads/OH-Logo-3.jpeg";
		
		File file = new File(imLoc);
        byte[] hospitalLogo = new byte[(int) file.length()];
        
        try {
	     FileInputStream fileInputStream = new FileInputStream(file);
	     //convert file into array of bytes
	     fileInputStream.read(hospitalLogo);
	     fileInputStream.close();
        } catch (Exception e) {
	     e.printStackTrace();
        }
		
		theHospital.setHospitalLogo(hospitalLogo);
		
		*/
		
		currentSession.saveOrUpdate(theHospital);
		
		return theHospital;
	}

	@Override
	public List<Hospitals> getHospitalList() {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		//Query theQuery = currentSession.createQuery("from Hospitals order by hospitalName", Hospitals.class);
		Query<Hospitals> theQuery = currentSession.createQuery("select h from Hospitals h "
				+ "JOIN FETCH h.hospitalAddress JOIN FETCH h.hospitalSpeciality JOIN FETCH h.hospitalDoctor ", Hospitals.class);
		
		List<Hospitals> theList = theQuery.getResultList();

		
		return theList;
	}

	@Override
	public Hospitals saveHospitalAddress(HospitalAddress theAddress, int hospital_id) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Hospitals theHospitals = currentSession.get(Hospitals.class, hospital_id);
		
		theHospitals.add(theAddress);
		
		currentSession.saveOrUpdate(theAddress);
		
		return theHospitals;
	}

	@Override
	public Hospitals getSingle(int hospital_id) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Hospitals> theQuery = currentSession.createQuery("Select h from Hospitals h "
				+ "JOIN FETCH h.hospitalAddress JOIN FETCH h.hospitalSpeciality "
				+ "JOIN FETCH h.hospitalDoctor where h.id=:hospitalId", Hospitals.class);
		
		theQuery.setParameter("hospitalId", hospital_id);
		
		Hospitals theHospitals = theQuery.getSingleResult();
		
		System.out.println("HOSPITALS ===>> "+theHospitals);
		
		System.out.println("ADDRESSES ===>> "+theHospitals.getHospitalAddress());
		System.out.println("DOCTORS =====>>"+ theHospitals.getHospitalDoctor());
		
		return theHospitals;
	}


	//Save Speciality..
	
	@Override
	public Hospitals saveSpeciality(HospitalSpeciality theSpeciality, int hospital_id) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		
		Hospitals theHospitals = currentSession.get(Hospitals.class, hospital_id);
		
		theHospitals.addSpeciality(theSpeciality);
		
		currentSession.save(theSpeciality);
		
		return theHospitals;
	}
	
	
	//save Doctor..

	@Override
	public Hospitals saveDoctor(HospitalDoctor theDoctor, int hospital_id) {
		
		Session currentSession = sessionFactory.getCurrentSession();
		Hospitals theHospitals = currentSession.get(Hospitals.class, hospital_id);
		
		theHospitals.addDoctor(theDoctor);
		currentSession.save(theDoctor);
		
		return theHospitals;
	}

	@Override
	public List<HospitalAddress> getAddresses(int hospital_id) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<HospitalAddress> theQuery = session.createQuery
				("Select ha from HospitalAddress ha where hospital_id=:hospital_id", HospitalAddress.class);
		
		theQuery.setParameter("hospital_id", hospital_id);
		
		List<HospitalAddress> theList = theQuery.getResultList();
		
		return theList;
	}

	@Override
	public List<HospitalSpeciality> getSpecialities(int hospital_id) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<HospitalSpeciality> theQuery = session.createQuery
				("Select hs from HospitalSpeciality hs where hospital_id=:hospital_id", HospitalSpeciality.class);
		
		theQuery.setParameter("hospital_id", hospital_id);
		
		List<HospitalSpeciality> theList = theQuery.getResultList();
		
		return theList;
	}

	@Override
	public List<HospitalDoctor> getDoctors(int hospital_id, String speciality) {
		
		Session session = sessionFactory.getCurrentSession();
		
		Query<HospitalDoctor> theQuery = session.createQuery
				("select hd from HospitalDoctor hd where hospital_id=:hospital_id and hd.specialization=:speciality", HospitalDoctor.class);
		
		theQuery.setParameter("hospital_id", hospital_id);
		theQuery.setParameter("speciality", speciality);
		
		List<HospitalDoctor> theList = theQuery.getResultList();
		
		return theList;
	}
	

}
