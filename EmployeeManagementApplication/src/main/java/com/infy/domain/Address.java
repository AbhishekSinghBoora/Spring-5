package com.infy.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.infy.dto.AddressDTO;

@Entity
public class Address {
	@Id
	private int addressId;
	private String city;
	private String pincode;
	
	// getter and setter methods
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	// constructors
	public Address() {}
	
	public Address(int addressId, String city, String pincode) {
		super();
		this.addressId = addressId;
		this.city = city;
		this.pincode = pincode;
	}
	
	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", city=" + city + ", pincode=" + pincode + "]";
	}
	
	public static AddressDTO prepareAddressDTO(Address addressEntity) {
		return new AddressDTO(addressEntity.getAddressId(), addressEntity.getCity(), addressEntity.getPincode());
	}
	
	
}
