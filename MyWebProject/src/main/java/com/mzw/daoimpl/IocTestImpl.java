package com.mzw.daoimpl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.mzw.dao.ClientMessage;
import com.mzw.model.Person;
@Component("iti")
public class IocTestImpl implements ClientMessage{

	public List<Person> selectPersonById(int id) throws Exception {
		// TODO 自动生成的方法存根
		return null;
	}

	public void iocTest() {
		System.out.println("test");
	}

}
