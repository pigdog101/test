package com.mzw.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.mzw.model.Address;
import com.mzw.model.Grade;
import com.mzw.model.Person;
import com.mzw.model.PersonAndPid;
import com.mzw.model.StudentClass;

public interface PersonMapper {
    public Person queryPersonById(int id) ;
    public List<Person> queryAll();
    public void addStudent(Person person);
    public void deletePersonById(int id);
    public void updatePersonById(int id);
    public Person queryPersonByIdWithConverter(int id);
    public void addStudentWithConverter(Person person);
    public Person queryPersonByName(String name);
    public List<Person> queryAndSort(String name);
    public List<Person> queryWithDollar(Person person);
    public List<Person> queryPersonByAddress(Address address);
    public List<Person> queryPersonByAddressWithPerson(Person person);
    public List<Person> queryPersonByNameWithHashMap(Map<String,Object> map);
    public HashMap<String,Object> queryPersonByNameOutWithHashMap(int id);
    public List<Person> queryPBNOWithSqlTag(Map<String, Object> map); 
    public List<Person> queryPBIdOWithArray(int[] ids); 
    public List<Person> queryPBIdOWithGrade(Grade grade); 
    public PersonAndPid queryPersonByIdWithFk(int id);
    public Person queryPersonByIdWithFkRe(int id);
    public StudentClass queryPAndClassByIdWithFkRe(int id);
}
