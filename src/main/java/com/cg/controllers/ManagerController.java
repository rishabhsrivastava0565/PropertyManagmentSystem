package com.cg.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entities.Manager;
import com.cg.exception.CertificationNotFoundException;
import com.cg.exception.PersonNotFoundException;
import com.cg.exception.QualificationNotFoundException;
import com.cg.services.ManagerService;


@RestController
public class ManagerController {
	

	@Autowired
	private ManagerService mservice;
	
	@PostMapping("/addManager")
	public String addManagerDetails(@RequestBody Manager manager)
	{
		return mservice.addManager(manager);
	}
	
	@GetMapping("/getAllManager")
	public List<Manager> getAllManagers()
	{
		return mservice.getAll();
	}
	
    @GetMapping("/getManager/{id}")
    public ResponseEntity<Object> getManagerById(@PathVariable("id") int id)
    		throws PersonNotFoundException
    {
		return new ResponseEntity<>(mservice.getManagerById(id),HttpStatus.OK);
    }
	
	@DeleteMapping("/delManager/{id}")
	public String deleteManagerById(@PathVariable("id") int id)
	{
		return mservice.deleteManagerInfo(id);
	}
	
	@PutMapping("/updateManagerList")
	public List<Manager> updateManagerList(@RequestBody Manager manager)
	{
		return mservice.updateManagerData(manager);
	}
	
	// http://localhost:8081/updateManagerDetails/68/ScrumMaster
	@RequestMapping("/updateManagerDetails/{id}/{certification}")
	public List<Manager> updateManagerDetails(@PathVariable("id") int id,@PathVariable("certification") String cdertification)
	{
		return mservice.updateManagerCertification(id, cdertification);
	}
	
	@GetMapping("/getManagerDOJ/{id}")
	public String getManagerDOJById(@PathVariable("id") long id)
	{
		return mservice.getDOJById(id);
	}
	
	@GetMapping("/getManagerByQualification/{qualification}")
	public List<Manager> getManagerByQualification(@PathVariable("qualification") String qualification) 
			throws QualificationNotFoundException
	{
		return mservice.getByQualification(qualification);
	}
	
	@GetMapping("/getManagerByCertification/{certification}")
	public List<Manager> getManagerByCertification(@PathVariable("certification") String certification) 
			throws CertificationNotFoundException
	{
		return mservice.getByCertification(certification);
	}

}
