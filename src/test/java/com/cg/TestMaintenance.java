package com.cg;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cg.entities.Address;
import com.cg.entities.Maintenance;
import com.cg.entities.Owner;
import com.cg.entities.Property;
import com.cg.exception.MaintenanceNotFoundException;
import com.cg.exception.PropertyNotFoundException;
import com.cg.repositories.MaintenanceRepository;
import com.cg.repositories.PropertyRepository;
import com.cg.services.MaintenanceService;

@SpringBootTest
public class TestMaintenance {
     
	 @MockBean
	 MaintenanceRepository maintenanceRepository;
	 
	 @MockBean
	 PropertyRepository propertyRepository;
	 
	 @Autowired
	 MaintenanceService maintenanceService;
	 
	 @Test
		public void testAllMaintenance() throws MaintenanceNotFoundException {
		 
		
			Maintenance m1 = new Maintenance();
			m1.setMaintenanceType("service");
			m1.setMonths(12);
			m1.setPropertyId(27);
			m1.setPropertyName("Assert Reality");
			m1.setMaintenanceCharges(3000);
			
			Maintenance m2 = new Maintenance();
			m2.setMaintenanceType("Security");
			m2.setMonths(18);
			m2.setPropertyId(30);
			m2.setPropertyName("Galaxy");
			m2.setMaintenanceCharges(5000);
			
			when(maintenanceRepository.findAll()).thenReturn(Stream.of(m1,m2).collect(Collectors.toList()));
			assertEquals(2,  maintenanceService.getAllMaintenance().size());
		}
	 

	
}
