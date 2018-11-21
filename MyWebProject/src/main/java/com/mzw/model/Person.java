package com.mzw.model;

import java.io.Serializable;

public class Person implements Serializable{
private String name;
private int id;
private int age;
private boolean sex;
private Address address;
private int cardid;
private PersonId pid;
public Person(String name, int id, int age, boolean sex, Address address, int cardid, PersonId pid) {
	super();
	this.name = name;
	this.id = id;
	this.age = age;
	this.sex = sex;
	this.address = address;
	this.cardid = cardid;
	this.pid = pid;
}

public PersonId getPid() {
	return pid;
}

public void setPid(PersonId pid) {
	this.pid = pid;
}

public int getCardid() {
	return cardid;
}

public Person(String name, int id, int age, boolean sex, Address address, int cardid) {
	super();
	this.name = name;
	this.id = id;
	this.age = age;
	this.sex = sex;
	this.address = address; 
	this.cardid = cardid;
}

public void setCardid(int cardid) {
	this.cardid = cardid;
}

public Person(String name, int id, int age, boolean sex, Address address) {
	super();
	this.name = name;
	this.id = id;
	this.age = age;
	this.sex = sex;
	this.address = address;
}

public Address getAddress() {
	return address;
}

public void setAddress(Address address) {
	this.address = address;
}

public Person(String name, int id, int age, boolean sex) {
	super();
	this.name = name;
	this.id = id;
	this.age = age;
	this.sex = sex;
}

public Person(String name, int id, int age) {
	super();
	this.name = name;
	this.id = id;
	this.age = age;
}

public boolean isSex() {
	return sex;
}

public void setSex(boolean sex) {
	this.sex = sex;
}

public Person() {
	super();
}

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}

}
