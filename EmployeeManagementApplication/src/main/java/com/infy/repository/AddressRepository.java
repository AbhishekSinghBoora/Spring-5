package com.infy.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.infy.domain.Address;

public interface AddressRepository extends JpaRepository<Address, Integer>{

	// method to update the address details in DB
	@Transactional
	@Modifying
	@Query(value = "update Address set city=?, pincode=? "+" where address_id = ?", nativeQuery = true)
	public void updateAddress(String city, String pincode, Integer addressId);
}
