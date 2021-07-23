package com.jforce.model;

public class Personel {

	private int personelId;
	
	private String firstName;
	
	private String lastName;
	
	private int experinceYear;
	
	public Personel() {
	}

	public Personel(String firstName, String lastName, int experinceYear) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.experinceYear = experinceYear;
	}

	public int getPersonelId() {
		return personelId;
	}

	public void setPersonelId(int personelId) {
		this.personelId = personelId;
	}

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

	public int getExperinceYear() {
		return experinceYear;
	}

	public void setExperinceYear(int experinceYear) {
		this.experinceYear = experinceYear;
	}

	@Override
	public String toString() {
		return "Personel [personelId=" + personelId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", experinceYear=" + experinceYear + "]";
	}
}
