package com.cg.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import org.springframework.stereotype.Service;
import com.cg.entities.Maintenance;
import com.cg.entities.Property;
import com.cg.exception.MaintenanceNotFoundException;
import com.cg.exception.PropertyNotFoundException;
import com.cg.repositories.MaintenanceRepository;
import com.cg.repositories.PropertyRepository;

@Service
public class MaintenanceService {
	
	@Autowired
	MaintenanceRepository maintenanceRepository;
	
	@Autowired
	PropertyRepository propertyRepository;
	
	
	public List<Maintenance> getAllMaintenance() throws MaintenanceNotFoundException
	{  
		 List<Maintenance>list =  maintenanceRepository.findAll();
		  if(list.size()==0)
			  throw new MaintenanceNotFoundException("No Record Found of Maintenance for any Property");
		  return list;
	}
	

	
	
	public Maintenance getMaintenance(long propertyId) throws  PropertyNotFoundException ,MaintenanceNotFoundException{
		
		if(!propertyRepository.existsById(propertyId)) {
			   throw new PropertyNotFoundException("No Property Found for ID =  "+ propertyId);
		   }
		List <Maintenance> list = maintenanceRepository.findAll();
		int count = 0 ; 
		for(int i = 0 ; i < list.size() ; i++) {
			Maintenance element = list.get(i);
			if(element.getPropertyId()==propertyId)
				count++;
				
		}
		if(count==0)
			throw new MaintenanceNotFoundException("No Maintenance Charges for Given Property!");
		
		   return maintenanceRepository.findByPropertyId(propertyId);
	}
	
	
	public String addMaintenance(Maintenance maintenance) throws MaintenanceNotFoundException, PropertyNotFoundException{
		List<Maintenance> maintenanceList = maintenanceRepository.findAll();
		for(int i = 0 ; i < maintenanceList.size() ; i++) {
			Maintenance element = maintenanceList.get(i);
			if(element.getPropertyId()==maintenance.getPropertyId())
				throw new MaintenanceNotFoundException("This Property Already having Maintenance Record Try to Update it!");
		}
		
		List<Property> propertyList = propertyRepository.findAll();
		int count = 0 ;
		for(int i = 0 ; i < propertyList.size() ; i++) {
		     Property property = propertyList.get(i);
		     if(property.getPropertyId()==maintenance.getPropertyId())
		    	 count++;
		}
		if(count == 0 )
			throw new PropertyNotFoundException("This Property Id Does Not Exist");
		maintenanceRepository.save(maintenance);
		return "Maintenance for Property Added";
	}
	

	
	
	public String  deleteMaintenanceById(long propertyId) throws  PropertyNotFoundException
	{   
		if(!propertyRepository.existsById(propertyId)) {
			   throw new PropertyNotFoundException("No Property Found to delete for ID =  "+ propertyId);
		   }
		Maintenance maintenance = maintenanceRepository.findByPropertyId(propertyId);
		maintenanceRepository.deleteById(maintenance.getMaintenanceId());
		return "Deleted Maintenance for Property";
	}
	
	
	public Maintenance updateMaintenanceCharges(long propertyId,double newCharge) throws PropertyNotFoundException
	{
		if(!propertyRepository.existsById(propertyId)) {
			   throw new PropertyNotFoundException("No Property Found for ID =  "+ propertyId);
		   }
	
		Maintenance maintenance = maintenanceRepository.findByPropertyId(propertyId);
		maintenance.setMaintenanceCharges(newCharge);
		maintenanceRepository.save(maintenance);
	    return maintenance;
	}
	
	
	public List<Maintenance> sortMaintenanceByPrice() throws MaintenanceNotFoundException
	{   List<Maintenance>list = maintenanceRepository.findAll(Sort.by("MaintenanceCharges"));
	  if(list.size()==0)
		  throw new MaintenanceNotFoundException("No Record Found of Maintenance for any Property");
	  return list;

	}
}
