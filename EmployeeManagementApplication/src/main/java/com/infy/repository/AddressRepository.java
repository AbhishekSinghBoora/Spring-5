package com.infy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.infy.domain.Address;

public interface AddressRepository extends JpaRepository<Address, Integer>{

}
