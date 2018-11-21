package com.mzw.serviceimpl;

import java.util.List;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mzw.dao.ClientMessage;
import com.mzw.daoimpl.SelectPerson;
import com.mzw.mapper.PersonMapper;
import com.mzw.model.Person;
import com.mzw.service.SelectPersonService;
@Component("spi")
public class SelectPersonImpl implements SelectPersonService{
	private PersonMapper pm;
	
	public PersonMapper getPm() {
		return pm;
	}
	@Autowired
	public void setPm(PersonMapper pm) {
		this.pm = pm;
	}

	private SqlSessionFactory ssf;
	
    public SqlSessionFactory getSsf() {
		return ssf;
	}
    @Autowired
	public void setSsf(SqlSessionFactory ssf) {
		this.ssf = ssf;
	}

	private ClientMessage cm;
    
	public ClientMessage getCm() {
		return cm;
	}
    @Resource(name="iti")
	public void setCm(ClientMessage cm) {
		this.cm = cm;
	}

	public List<Person> select(int id) throws Exception {
		return null; 
	}

	public void IocService() {
		System.out.println(this.pm.queryPersonById(3).getName());
	}
   
}
