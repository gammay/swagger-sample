package com.gammay.example.swagger_sample;

public class ContactDTO {
	private Integer id;
	
	private String name;
	private String contactText;
	private String contactType;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getContactText() {
		return contactText;
	}
	public void setContactText(String contact) {
		this.contactText = contact;
	}
	public String getContactType() {
		return contactType;
	}
	public void setContactType(String contactType) {
		this.contactType = contactType;
	}
}
