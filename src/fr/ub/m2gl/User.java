package fr.ub.m2gl;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class User {
	private final String NA = "N/A";
	private String _firstName;
	private String _lastName;
	@JsonIgnore
	private String _id;
	
	public User () {
		_firstName = NA;
		_lastName = NA;
		_id = "";
	}
	
	public User (String firstName, String lastName) {
		_firstName = firstName;
		_lastName = lastName;
		_id= "";
	}

	@JsonProperty("FirstName")
	public void setFirstName (String firstName) {
		_firstName = firstName;
	}
	

	@JsonProperty("LastName")
	public void setLastName (String lastName) {
		_lastName = lastName;
	}
	
	@JsonIgnore
	public void setId (String id) {
		_id = id;
	}

	@JsonProperty("FirstName")
	public String getFirstName() {
		return _firstName;
	}

	@JsonProperty("LastName")
	public String getLastName() {
		return _lastName;
	}

	@JsonProperty
	public String getId() {
		return _id;
	}
	
	
	
	public String toString () {
		StringBuffer sb = new StringBuffer (_firstName);
		sb.append(" ").append(_lastName);
		return sb.toString();
	}
}	
