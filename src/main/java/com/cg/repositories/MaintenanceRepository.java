package com.cg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.entities.Maintenance;


@Repository
public interface MaintenanceRepository extends JpaRepository<Maintenance, Integer> {
	
	
	@Query("Select m From Maintenance m where m.propertyId =:pid")
	   public Maintenance findByPropertyId(@Param("pid") long pid);
	
	
}
