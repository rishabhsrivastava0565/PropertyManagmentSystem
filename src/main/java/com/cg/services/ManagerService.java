package com.cg.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.entities.Manager;
import com.cg.exception.CertificationNotFoundException;
import com.cg.exception.PersonNotFoundException;
import com.cg.exception.QualificationNotFoundException;
import com.cg.repositories.ManagerRepository;

@Service
public class ManagerService {
	
	@Autowired
	private ManagerRepository mrepo;
	
	public String addManager(Manager manager)
	{
		mrepo.save(manager);
		return "Manager data added";
	}
	
	public List<Manager> getAll()
	{
		return mrepo.findAll();
	}
	
	public ResponseEntity<Object> getManagerById(long id) throws PersonNotFoundException
	{
		if(!mrepo.existsById(id))	
			throw new PersonNotFoundException("Person not found!!");
		else
		{
		return new ResponseEntity<>(mrepo.findById(id).get(),HttpStatus.OK);
		}
	}
	
	public String deleteManagerInfo(long id)
	{
		mrepo.deleteById(id);
		return "Information Deleted Successfully";
	}
	
	public List<Manager> updateManagerData(Manager manager)
	{
        mrepo.save(manager);
		return mrepo.findAll();
	}
	
	public List<Manager> updateManagerCertification(long id, String certification)
	{
		Manager manager=mrepo.findById(id).get();
		manager.setCertification(certification);
		mrepo.save(manager);
		return mrepo.findAll();
	}
	
	public String getDOJById(long id)
	{
		return mrepo.findById(id).get().getDateOfJoining();
	}
	
	public List<Manager> getByQualification(String qualification) throws QualificationNotFoundException
	{
		List<Manager> list=(List<Manager>) mrepo.findByQualification(qualification);
		if(list.isEmpty())
			throw new QualificationNotFoundException("No such qualification found!!");
		
		return list;
	}
	
	public List<Manager> getByCertification(String certification) throws CertificationNotFoundException
	{
		List<Manager> list=(List<Manager>) mrepo.findByCertification(certification);
		if(list.isEmpty())
			throw new CertificationNotFoundException("No such certification found!!");
		
		return list;
	}
 }
