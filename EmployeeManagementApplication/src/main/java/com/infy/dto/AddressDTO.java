package com.infy.dto;

import com.infy.domain.Address;

public class AddressDTO {

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
	public AddressDTO() {
		super();
	}
	
	public AddressDTO(int addressId, String city, String pincode) {
		super();
		this.addressId = addressId;
		this.city = city;
		this.pincode = pincode;
	}
		
	@Override
	public String toString() {
		return "Address [addressId=" + addressId + ", city=" + city + ", pincode=" + pincode + "]";
	}
	public static Address prepareAddressEntity(AddressDTO addressDTO) {
		return new Address(addressDTO.getAddressId(), addressDTO.getCity(), addressDTO.getPincode());
	}
}
