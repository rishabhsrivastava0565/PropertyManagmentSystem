package com.cg.services;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.entities.Buyer;
import com.cg.entities.Property;
import com.cg.entities.Tenant;
import com.cg.entities.TransactionDetails;
import com.cg.repositories.BuyerRepository;
import com.cg.repositories.PropertyRepository;
import com.cg.repositories.TenantRepository;
import com.cg.repositories.TransactionRepository;

@Service
public class TransactionService {
	
	
	@Autowired
	PropertyRepository propertyRepos;
	
	@Autowired
	PropertyService propertyService;
	
	@Autowired
	TransactionRepository transactionRepos;
	
	@Autowired
	TransactionService transactionService;
	
	@Autowired
	BuyerService buyerService;
	
	@Autowired
	BuyerRepository buyerRepos;
	
	@Autowired
	TenantRepository tenantrepos;
	
	
	public Object buyProperty(long buyerId ,long propertyId) 
	{
	     Property property=propertyRepos.findById(propertyId).get();
		Buyer buyer=buyerRepos.findById(buyerId).get();
		buyer.setProperty(property);
		
		if(!property.getSellOrRent().equals("sold") )
		{
		
		TransactionDetails transactionDetails=new TransactionDetails();
		transactionDetails.setPropertyName(property.getPropertyName());
		transactionDetails.setAmmount(property.getPrice());
		transactionDetails.setBuyerName(buyer.getPersonName());
		transactionDetails.setOwnerName(property.getOwner().getPersonName());
		transactionDetails.setProperty(property);
		String buydate=LocalDate.now().toString();
		transactionDetails.setTransactionDate(buydate);
		
		
		propertyService.setPropertySold(propertyId, "sold");
		
		
		return transactionRepos.save(transactionDetails);
		
		}
		return "its already sold";
		
		
	}
	
	public Object rentProperty(long tenantId ,long propertyId) 
	{
		
	
		
		Property property=propertyRepos.findById(propertyId).get();
		Tenant tenant=tenantrepos.findById(tenantId).get();
		tenant.setProperty(property);
		
		if(!property.getSellOrRent().equals("sold") && !property.getSellOrRent().equals("Rented"))
		{
		
		TransactionDetails transactionDetails=new TransactionDetails();
		transactionDetails.setPropertyName(property.getPropertyName());
		transactionDetails.setAmmount(property.getPrice());
		transactionDetails.setTenantName(tenant.getPersonName());
		transactionDetails.setOwnerName(property.getOwner().getPersonName());
		transactionDetails.setProperty(property);
		String buydate=LocalDate.now().toString();
		transactionDetails.setTransactionDate(buydate);
		
		
		propertyService.setPropertySold(propertyId, "Rented");
		
		return transactionRepos.save(transactionDetails);
		
		}
		return "its already sold or Rented";
		
		
	}
	
	public List<Property> getAllProperty()
	{
		return propertyRepos.findAll().stream().filter(f -> f.getSellOrRent().
				equals("forSale")).collect(Collectors.toList());
	}
	
	public List<TransactionDetails> getAllTransactionDetails()
	{
		return transactionRepos.findAll();
	}
	
	public double getAllMoney()
	{
		return transactionRepos.findAll().stream().map(tr -> tr.getAmmount()).reduce(Double :: sum).get();
	}
	
	public double getAllRentMoney()
	{
		return transactionRepos.findAll().stream().filter(tf -> tf.getTenantName()!=null).map(tr -> tr.getAmmount()).reduce(Double :: sum).get();
	}
	
	

}
