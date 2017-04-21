package com.cubic.vo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CustomerVO {
	
	private Long pk;
	private String firstName;
	private String lastName;
	
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Long getPk() {
		return pk;
	}
	public void setPk(Long pk) {
		this.pk = pk;
	}
	@Override
	public String toString() {
		return "CustomerVO [pk=" + pk + ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	

}
