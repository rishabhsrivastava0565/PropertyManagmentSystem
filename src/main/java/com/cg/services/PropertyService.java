package com.cg.services;

import java.util.List;
import java.util.Properties;

import org.slf4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.entities.Owner;
import com.cg.entities.Property;
import com.cg.exception.PropertyNotFoundException;
import com.cg.entities.Person;
import com.cg.repositories.OwnerRepository;
//import com.cg.logger.utility.GlobalLogger;
import com.cg.repositories.PropertyRepository;



@Service
public class PropertyService {
	

	@Autowired
   private PropertyRepository pr;
	@Autowired 
	private OwnerRepository or;
   
   
   public ResponseEntity<Object> getAllProperty() throws PropertyNotFoundException{
	   List list =  pr.findAll();
		  if(list.size()==0)
			  throw new PropertyNotFoundException("No Property Found");
		  return new ResponseEntity<>(list,HttpStatus.OK);
   }

   public String addProperty(Property property) {
  	    pr.save(property);
  	  return "Added Property";
   }
   
   
   public ResponseEntity<Object> findProperty(long id) throws PropertyNotFoundException{
	   if(!pr.existsById(id)) {
		   throw new PropertyNotFoundException("No Property Found for ID =  "+ id);
	   }
	   return new ResponseEntity<>(pr.findById(id).get(),HttpStatus.OK);
   }
   
   public ResponseEntity<Object> findPropertyType( String type )throws PropertyNotFoundException{
	  List list =  pr.findByType(type); 
	  if(list.size()==0)
		  throw new PropertyNotFoundException("No Property Found for '" + type + "' Type");
	  return new ResponseEntity<>(pr.findByType(type),HttpStatus.OK);
   }
   
   public ResponseEntity<Object> findPropertyAvalability( String purpose )throws PropertyNotFoundException{
	   List list =  pr.findByType(purpose); 
		  if(list.size()==0)
			  throw new PropertyNotFoundException("No Property Found for '" + purpose + "' purpose");
		  return new ResponseEntity<>(pr.findByType(purpose),HttpStatus.OK);
   }
 
   public ResponseEntity<Object> findPropertyByPrice( String purpose , String type , double price)throws PropertyNotFoundException{

	   List list =  pr.findByType(purpose); 
		  if(list.size()==0)
			  throw new PropertyNotFoundException("No Property Below  '" + (int)price + "' for "+purpose);
		  return new ResponseEntity<>(pr.findByType(purpose),HttpStatus.OK);
   }
   
   public List<Property> getAllPropertySortedByPrice(){
		 return pr.findAll(Sort.by("price"));
   }
   
   public List<Property> getAllPropertySortedBySize(){

	  	 return pr.findAll(Sort.by("sizeOfApartment"));
	   }
   
   public String deleteProperty( long  id) throws PropertyNotFoundException{
	   if(!pr.existsById(id)) {
		   throw new PropertyNotFoundException("No Property Found for ID =  "+ id);
	   }
  	 pr.deleteById(id);
  	 return "Deleted SucessFully";
   }
   
   public Property getPropertyByName(String name)
   {
	   return pr.findByPropertyName(name);
   }
   
   public String setPropertySold(long id, String sold)
   {
	   pr.findById(id).get().setSellOrRent(sold);
	   
	   return "status changed";
   }
   
   


   
}