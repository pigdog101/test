package com.mzw.model;

public class User {
private int id;
private String username;
private String password;

public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}

public String getUsername() {
	return username;
}
public void setUsername(String userName) {
	this.username = userName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public User() {
	super();
}
public User(String username, String password) {
	super();
	this.username = username;
	this.password = password;
}
public User(int id, String username, String password) {
	super();
	this.id = id;
	this.username = username;
	this.password = password;
}

}
