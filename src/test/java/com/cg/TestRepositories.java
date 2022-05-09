package com.cg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.entities.Address;
import com.cg.entities.Buyer;
import com.cg.entities.Maintenance;
import com.cg.entities.Manager;
import com.cg.entities.Owner;
import com.cg.entities.Staff;
import com.cg.entities.Tenant;
import com.cg.exception.MaintenanceNotFoundException;
import com.cg.repositories.BuyerRepository;
import com.cg.repositories.MaintenanceRepository;
import com.cg.repositories.ManagerRepository;
import com.cg.repositories.OwnerRepository;
import com.cg.repositories.StaffRepository;
import com.cg.repositories.TenantRepository;
import com.cg.services.BuyerService;
import com.cg.services.MaintenanceService;
import com.cg.services.ManagerService;
import com.cg.services.OwnerService;
import com.cg.services.StaffService;
import com.cg.services.TenantService;

@SpringBootTest
public class TestRepositories {
	
	@Autowired
	OwnerService ownerService;
	
	@Autowired
	MaintenanceService ms;
	
	@MockBean
	OwnerRepository ownerRepository;
	
	@MockBean
	MaintenanceRepository mr;
	
	
	
//	@Test
//	public void testFindAllOwner()
//	{
//		Owner owner1=new Owner();
//		owner1.setPersonName("Aman");
//		owner1.setSaleOrRent("sale");
//		
//		Owner owner2=new Owner();
//		owner2.setPersonName("Rahul");
//		owner2.setSaleOrRent("rent");
//		
//		
//		when(ownerRepository.findAll()).thenReturn(Stream.of(owner1,owner2).collect(Collectors.toList()));
//		
//		
//		assertEquals(2, ownerService.getAllOwner().size());
//		
//	}
	
//	
//	@Test
//	public void testFindByNameOwner()
//	{
//		Owner owner1=new Owner();
//		owner1.setPersonName("owner1");
//		
//		ownerRepository.save(owner1);
//		
//		when(ownerRepository.findByPersonName("owner1")).thenReturn(owner1);
//		
//		assertEquals(ownerRepository.findByPersonName("owner1"),owner1);
//		
//	}
	
//	@Test
//	public void testSaveOwner()
//	{
//		Owner owner=new Owner();
//		Address address=new Address();
//		address.setCity("rkt");
//		owner.setAddress(address);
//		
//		when(ownerRepository.save(owner)).thenReturn(owner);
//		
//		assertNotNull(ownerService.addOwner(owner));
//		
//		assertEquals(ownerService.addOwner(owner), owner);
//		
//		assertEquals(ownerService.addOwner(owner).getAddress(), address);
//	}
//	
//
//	@Mock
//	BuyerRepository buyerRepository;
//	
//	@InjectMocks
//	BuyerService buyerService;
//	
//	@Mock
//	StaffRepository staffRepository; 
//	
//	@InjectMocks
//	StaffService staffService;
//	
//	@Mock
//	TenantRepository tenantRepository;
//	
//	@InjectMocks
//	TenantService tenantService;
//	
//	@Mock
//	ManagerRepository managerRepository;
//	
//	@InjectMocks
//	ManagerService managerService;
//	
//	@Test
//	public void testGetAllManager() 
//	{
//		
//		List<Manager> allManager = managerService.getAll();
//		
//		verify(managerRepository,times(1)).findAll();
//		
//	}	
//	
//	@Test
//	public void addManager()
//	{
//		   
//		Manager manager = new Manager();
//		String message = managerService.addManager(manager);  
//		
//		
//
//	    Mockito.verify(managerRepository, Mockito.times(1)).save(Mockito.any());
//	    
//		assertEquals(message ,"Manager added sucessfully");
//	}
//	
//	@Test
//	public void testGetAllStaff() 
//	{
//		
//		List<Staff> allStaff = staffService.getAllStaff();
//		
//		verify(staffRepository,times(1)).findAll();
//		
//	}	
//	
//	@Test
//	public void addStaff()
//	{
//		   
//		Staff staff=new Staff();
//		String message = staffService.addStaff(staff);  
//		
//		
//
//	    Mockito.verify(staffRepository, Mockito.times(1)).save(Mockito.any());
//	    
//		assertEquals(message , "New Staff Added");
//	}
//	
//	@Test
//	public void testGetAllBuyer() 
//	{
//		
//		List<Buyer> allBuyers = buyerService.getAllBuyers();
//		
//		verify(buyerRepository,times(1)).findAll();
//		
//	}	
//	
//	@Test
//	public void testAddBuyer() {
//		
//		Buyer buyer = new Buyer();
//		String message = buyerService.addBuyer(buyer);
//		
//		Mockito.verify(buyerRepository, Mockito.times(1)).save(Mockito.any());
//		
//		assertEquals(message,"New Buyer added successfully");
//	}
//	
//	@Test
//	public void testAddTenant() {
//		Tenant tenant = new Tenant();
//		String message = tenantService.addTenant(tenant);
//		
//		Mockito.verify(tenantRepository, Mockito.times(1)).save(Mockito.any());
//		
//		assertEquals(message,"New Tenant added successfully");
//	}
//	
//	@Test
//	public void testGetAllTenants() 
//	{
//		
//		List<Tenant> allTenants = tenantService.getAllTenant();
//		
//		verify(tenantRepository,times(1)).findAll();
//		
//	}	
}