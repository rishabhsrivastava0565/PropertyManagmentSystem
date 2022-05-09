package com.cg.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.entities.Buyer;

public interface BuyerRepository extends JpaRepository<Buyer,Long>{

}
