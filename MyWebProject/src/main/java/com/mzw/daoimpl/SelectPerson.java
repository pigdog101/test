package com.mzw.daoimpl;

import java.security.Permissions;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.mzw.dao.ClientMessage;
import com.mzw.mapper.PersonMapper;
import com.mzw.model.Person;

public class SelectPerson extends SqlSessionDaoSupport implements ClientMessage{
    

	public List<Person> selectPersonById(int id) throws Exception {
		System.out.println("aaa");
		SqlSession ssf =super.getSqlSession();
		return null;
	}

	public void iocTest() {
		SqlSession session = super.getSqlSession();
		PersonMapper pm = session.getMapper(PersonMapper.class);
		System.out.println(pm.queryPersonById(3).getName());
	}

}
