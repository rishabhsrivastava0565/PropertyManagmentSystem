package com.cg.controllers;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entities.Maintenance;
import com.cg.exception.MaintenanceNotFoundException;
import com.cg.exception.PropertyNotFoundException;
import com.cg.services.MaintenanceService;
import com.cg.services.PropertyService;

@RestController
public class MaintenanceController {
	
	@Autowired
	MaintenanceService maintenanceService;
	
	@Autowired
	PropertyService propertyService;
	
	@GetMapping("/allMaintenance") 
	public ResponseEntity<Object> getAllMaintenance() throws MaintenanceNotFoundException
	{  
		List<Maintenance>  list  = maintenanceService.getAllMaintenance();
		
		return new ResponseEntity<>(list,HttpStatus.OK);
		
	}
	
	 @GetMapping("/allProperties")
     public ResponseEntity<Object> getAllProperty() throws PropertyNotFoundException{

    	 return propertyService.getAllProperty();
     }
 
	
	@GetMapping("/findMaintenance/{propertyId}")
	
	public ResponseEntity<Object>  getMaintenance(@PathVariable("propertyId") long propertyId ) throws MaintenanceNotFoundException , PropertyNotFoundException{
		
		Maintenance maintenance =   maintenanceService.getMaintenance(propertyId);
		return new ResponseEntity<>(maintenance,HttpStatus.OK);
	}
	
	
	
	@PostMapping("/addMaintenance")
	public ResponseEntity<?>  addMaintenance(@Valid @RequestBody Maintenance maintenance) throws MaintenanceNotFoundException, PropertyNotFoundException{
		
		Object addedMaintenance= maintenanceService.addMaintenance(maintenance);
  		return new ResponseEntity<Object>(addedMaintenance,HttpStatus.CREATED);
	   
	}
	
	
	
	@DeleteMapping("/deleteMaintenance/{propertyId}")
	public ResponseEntity<?>  deleteMaintenance(@PathVariable("propertyId") long propertyId) throws PropertyNotFoundException
	{
		return new ResponseEntity<Object>(maintenanceService.deleteMaintenanceById(propertyId),HttpStatus.CREATED);
	}
	
	
	
	@GetMapping("/updateMaintenanceCharge/{propertyId}/{newCharge}")
	public ResponseEntity<Object> updateMaintenanceCharges(@PathVariable("propertyId") long propertyId, @PathVariable("newCharge") double newCharge) throws PropertyNotFoundException
	{  
		Maintenance maintenance = maintenanceService.updateMaintenanceCharges(propertyId,newCharge);
		return new ResponseEntity<>(maintenance , HttpStatus.OK);
	}
	
	
	
	@GetMapping("/sortMaintenanceByPrice") 
	public ResponseEntity<Object> sortMaintenanceByPrice() throws MaintenanceNotFoundException
	{
		List<Maintenance> maintenanceList =  maintenanceService.sortMaintenanceByPrice();
		return new ResponseEntity<>(maintenanceList ,HttpStatus.OK);
	}
	
	
	

}
