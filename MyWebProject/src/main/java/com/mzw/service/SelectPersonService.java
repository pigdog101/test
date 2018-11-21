package com.mzw.service;

import java.util.List;

import com.mzw.model.Person;

public interface SelectPersonService {
    public List<Person> select(int id) throws Exception;
    public void IocService();
}
