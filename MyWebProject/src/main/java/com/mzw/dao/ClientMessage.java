package com.mzw.dao;

import java.util.List;

import com.mzw.model.Person;

public interface ClientMessage {
    public List<Person> selectPersonById(int id) throws Exception;
    public void iocTest();
}
 