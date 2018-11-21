package com.mzw.model;

import java.util.List;

public class StudentClass {
    private int classId;
    private String className;
    private List<Person> pList;
	public int getClassId() {
		return classId;
	}
	public void setClassId(int classId) {
		this.classId = classId;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public List<Person> getpList() {
		return pList;
	}
	public void setpList(List<Person> pList) {
		this.pList = pList;
	}
}
