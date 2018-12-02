	package com.mzw.model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.json.JSONObject;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mzw.dao.ClientMessage;
import com.mzw.daoimpl.SelectPerson;
import com.mzw.mapper.PersonMapper;
import com.mzw.service.SelectPersonService;
import com.mzw.serviceimpl.SelectPersonImpl;


public class MyBatisTest {
	
	private ClientMessage cm;
	
	public ClientMessage getCm() {
		return cm;
	}
	public void setCm(ClientMessage cm) {
		this.cm = cm;
	}
	@Test
    public void testMyBatis() throws IOException {
    	Reader reader = Resources.getResourceAsReader("conf.xml");
    	SqlSessionFactory sqlf = new SqlSessionFactoryBuilder().build(reader);
    	SqlSession sqlSession = sqlf.openSession();
    	String statement = "com.mzw.model.personMapper.queryPersonById";	
    	Person person = sqlSession.selectOne(statement,1);
    	System.out.println(person.getName());
    	sqlSession.close();
    }
	@Test
    public void testMyBatisAdd() throws IOException {
    	Reader reader = Resources.getResourceAsReader("conf.xml");
    	SqlSessionFactory sqlf = new SqlSessionFactoryBuilder().build(reader);
    	SqlSession sqlSession = sqlf.openSession();
    	String statement = "com.mzw.model.personMapper.addStudent";	
    	Person person = new Person("ccc",3, 3);
    	sqlSession.insert(statement,person);
    	sqlSession.commit();
    	sqlSession.close();
    }
	@Test
    public void testMyBatisDelete() throws IOException {
    	Reader reader = Resources.getResourceAsReader("conf.xml");
    	SqlSessionFactory sqlf = new SqlSessionFactoryBuilder().build(reader);
    	SqlSession sqlSession = sqlf.openSession();
    	String statement = "com.mzw.model.personMapper.deletePersonById";	
    	sqlSession.delete(statement,1);
    	sqlSession.commit();
    	sqlSession.close();
    }
	@Test
    public void testMyBatisChange() throws IOException {
    	Reader reader = Resources.getResourceAsReader("conf.xml");
    	SqlSessionFactory sqlf = new SqlSessionFactoryBuilder().build(reader);
    	SqlSession sqlSession = sqlf.openSession();
    	String statement = "com.mzw.model.personMapper.updatePersonById";	
    	Person person = new Person();
    	person.setAge(1);
    	person.setId(3);
    	person.setName("aaa");
    	sqlSession.update(statement,person);
    	sqlSession.commit();
    	sqlSession.close();
    }
	@Test
    public void testMyBatisQueryAll() throws IOException {
    	Reader reader = Resources.getResourceAsReader("conf.xml");
    	SqlSessionFactory sqlf = new SqlSessionFactoryBuilder().build(reader);
    	SqlSession sqlSession = sqlf.openSession();
    	String statement = "com.mzw.model.personMapper.queryAll";	
    	List<Person> persons = sqlSession.selectList(statement);
    	for(Person person : persons) {
    		System.out.println(person.getName());
    	}
    	sqlSession.close();
    }
	@Test
    public void testMyBatisProxyQuery() throws IOException {
    	Reader reader = Resources.getResourceAsReader("conf.xml");
    	SqlSessionFactory sqlf = new SqlSessionFactoryBuilder().build(reader);
    	SqlSession session = sqlf.openSession();
    	PersonMapper personMapper =session.getMapper(PersonMapper.class);
    	Person person = personMapper.queryPersonById(2);
    	System.out.println(person.getName());
        session.close();
    }
	@Test
    public void testMyBatisProxyQueryAll() throws IOException {
    	Reader reader = Resources.getResourceAsReader("conf.xml");
    	SqlSessionFactory sqlf = new SqlSessionFactoryBuilder().build(reader);
    	SqlSession session = sqlf.openSession();
    	PersonMapper personMapper =session.getMapper(PersonMapper.class);
    	List<Person> persons = personMapper.queryAll();
    	session.commit();
    	for(Person person : persons) {
    		System.out.println(person.getName());
    	}
        session.close();
    }
	@Test
    public void testMyBatisProxyQueryAllWithConverter() throws IOException {
    	Reader reader = Resources.getResourceAsReader("conf.xml");
    	SqlSessionFactory sqlf = new SqlSessionFactoryBuilder().build(reader);
    	SqlSession session = sqlf.openSession();
    	PersonMapper personMapper =session.getMapper(PersonMapper.class);
    	Person person =personMapper.queryPersonById(3);
    	System.out.println(person.isSex());
    	session.commit();
    	
        session.close();
    }
	@Test
    public void testAddStudentWithConverter() throws IOException {
    	Reader reader = Resources.getResourceAsReader("conf.xml");
    	SqlSessionFactory sqlf = new SqlSessionFactoryBuilder().build(reader);
    	SqlSession session = sqlf.openSession();
    	PersonMapper personMapper =session.getMapper(PersonMapper.class);
    	Person person = new Person();
    	person.setSex(false);
    	personMapper.addStudentWithConverter(person);
    	session.commit();
        session.close();
    }
	@Test
    public void testQueryPersonByName() throws IOException {
    	Reader reader = Resources.getResourceAsReader("conf.xml");
    	SqlSessionFactory sqlf = new SqlSessionFactoryBuilder().build(reader);
    	SqlSession session = sqlf.openSession();
    	PersonMapper personMapper =session.getMapper(PersonMapper.class);
    	Person person = personMapper.queryPersonByName("aaa");
    	System.out.println(person.getId());
    	session.commit();
        session.close();
    }
	@Test
    public void testQueryAndSort() throws IOException {
    	Reader reader = Resources.getResourceAsReader("conf.xml");
    	SqlSessionFactory sqlf = new SqlSessionFactoryBuilder().build(reader);
    	SqlSession session = sqlf.openSession();
    	PersonMapper personMapper =session.getMapper(PersonMapper.class);
    	List<Person> persons = personMapper.queryAndSort("id");
    	for(Person person : persons) {
    	System.out.println(person.getId());
    	}
        session.close();
    }
	@Test
    public void testQueryWithDollar() throws IOException {
    	Reader reader = Resources.getResourceAsReader("conf.xml");
    	SqlSessionFactory sqlf = new SqlSessionFactoryBuilder().build(reader);
    	SqlSession session = sqlf.openSession();
    	PersonMapper personMapper =session.getMapper(PersonMapper.class);
    	Person person = new Person();
    	person.setId(2);
    	person.setName("a");
    	List<Person> persons = personMapper.queryWithDollar(person);
    	for(Person p : persons) {
    	System.out.println(p.getId());
    	}
        session.close();
    }
	@Test
    public void testQueryByAddress() throws IOException {
    	Reader reader = Resources.getResourceAsReader("conf.xml");
    	SqlSessionFactory sqlf = new SqlSessionFactoryBuilder().build(reader);
    	SqlSession session = sqlf.openSession();
    	PersonMapper personMapper =session.getMapper(PersonMapper.class);
    	Address address = new Address("a", "y");
    	address.setHomeAddress("a");
    	address.setSchoolAddress("v");
    	List<Person> persons = personMapper.queryPersonByAddress(address);
    	for(Person p : persons) {
    	System.out.println(p.getId());
    	}
        session.close();
    }
	@Test
    public void testQueryByAddressWithPersno() throws IOException {
    	Reader reader = Resources.getResourceAsReader("conf.xml");
    	SqlSessionFactory sqlf = new SqlSessionFactoryBuilder().build(reader);
    	SqlSession session = sqlf.openSession();
    	PersonMapper personMapper =session.getMapper(PersonMapper.class);
    	Address address = new Address("a", "y");
    	address.setHomeAddress("a");
    	address.setSchoolAddress("v");
    	Person person = new Person();
    	person.setAddress(address);
    	List<Person> persons = personMapper.queryPersonByAddressWithPerson(person);
    	for(Person p : persons) {
    	System.out.println(p.getId());
    	}
        session.close();
    }
	@Test
    public void queryPersonByNameWithHashMap() throws IOException {
    	Reader reader = Resources.getResourceAsReader("conf.xml");
    	SqlSessionFactory sqlf = new SqlSessionFactoryBuilder().build(reader);
    	SqlSession session = sqlf.openSession();
    	PersonMapper personMapper =session.getMapper(PersonMapper.class);
    	Map<String,Object> map = new HashMap<String,Object>();
    	map.put("schoolAddress", "w");
    	map.put("homeAddress", "a");
    	List<Person> persons = personMapper.queryPersonByNameWithHashMap(map);
    	for(Person p : persons) {
    	System.out.println(p.getId());
    	}
        session.close();
    }
	@Test
    public void queryPersonByNameOutWithHashMap() throws IOException {
    	Reader reader = Resources.getResourceAsReader("conf.xml");
    	SqlSessionFactory sqlf = new SqlSessionFactoryBuilder().build(reader);
    	SqlSession session = sqlf.openSession();
    	PersonMapper personMapper =session.getMapper(PersonMapper.class);
    	Map<String,Object> map = new HashMap<String,Object>();
    	map = personMapper.queryPersonByNameOutWithHashMap(5);
    	System.out.println(map.get("pNo"));
        session.close();
    }
	
	@Test
    public void queryPBNOWithSqlTag() throws IOException {
    	Reader reader = Resources.getResourceAsReader("conf.xml");
    	SqlSessionFactory sqlf = new SqlSessionFactoryBuilder().build(reader);
    	SqlSession session = sqlf.openSession();
    	PersonMapper personMapper =session.getMapper(PersonMapper.class);
    	Map<String,Object> map = new HashMap<String,Object>();
    	map.put("id", 0);
    	map.put("name", "aaa");
    	List<Person> list =personMapper.queryPBNOWithSqlTag(map);
    	System.out.println(list.get(0).getName());
        session.close();
    }
	@Test
    public void queryPBIdOWithGrade() throws IOException {
    	Reader reader = Resources.getResourceAsReader("conf.xml");
    	SqlSessionFactory sqlf = new SqlSessionFactoryBuilder().build(reader);
    	SqlSession session = sqlf.openSession();
    	PersonMapper personMapper =session.getMapper(PersonMapper.class);
    	Grade grade = new Grade();
    	List<Integer> list = new ArrayList<Integer>();
    	list.add(2);
    	list.add(3);
    	grade.setIds(list); 
    	List<Person> person = personMapper.queryPBIdOWithGrade(grade);
    	System.out.println(person.get(0).getName());
        session.close();
    }
//	@Test
//    public void queryPBIdOWithArray() throws IOException {
//    	Reader reader = Resources.getResourceAsReader("conf.xml");
//    	SqlSessionFactory sqlf = new SqlSessionFactoryBuilder().build(reader);
//    	SqlSession session = sqlf.openSession();
//    	PersonMapper personMapper =session.getMapper(PersonMapper.class);
//    	int[] ids = {2,3};
//    	List<Person> person = personMapper.queryPBIdOWithArray(ids);
//    	System.out.println(person.get(0).getName());
//        session.close();
//    }
	@Test
    public void queryPersonByIdWithFk() throws IOException {
    	Reader reader = Resources.getResourceAsReader("conf.xml");
    	SqlSessionFactory sqlf = new SqlSessionFactoryBuilder().build(reader);
    	SqlSession session = sqlf.openSession();
    	PersonMapper personMapper =session.getMapper(PersonMapper.class);
    	PersonAndPid ppid = personMapper.queryPersonByIdWithFk(2);
    	System.out.println(ppid.getPerinfo());
    	
        session.close();
    }
	@Test
    public void queryPersonByIdWithFkRe() throws IOException {
    	Reader reader = Resources.getResourceAsReader("conf.xml");
    	SqlSessionFactory sqlf = new SqlSessionFactoryBuilder().build(reader);
    	SqlSession session = sqlf.openSession();
    	PersonMapper personMapper =session.getMapper(PersonMapper.class);
    	Person ppid = personMapper.queryPersonByIdWithFkRe(2);
    	System.out.println(ppid.getPid().getPerinfo());
    	
        session.close();
    }
	@Test
    public void queryPAndClassByIdWithFkRe() throws IOException {
    	Reader reader = Resources.getResourceAsReader("conf.xml");
    	SqlSessionFactory sqlf = new SqlSessionFactoryBuilder().build(reader);
    	SqlSession session = sqlf.openSession();
    	PersonMapper personMapper =session.getMapper(PersonMapper.class);
    	StudentClass ppid = personMapper.queryPAndClassByIdWithFkRe(5);
    	System.out.println(ppid.getClassName());
    	
        session.close();
    }
	
	@Test
	public void springTest() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		SelectPerson sp = context.getBean(SelectPerson.class);
		sp.selectPersonById(1);
		SelectPersonService sps = (SelectPersonService)context.getBean("spi");
		sps.IocService();
		sp.iocTest();
	}
	@Test
	public void springTest2() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		SelectPersonService sps = (SelectPersonService)context.getBean("spi");
		sps.IocService();
	}
	@Test
	public void jsonTest() {
		User u = new User();
		u.setId(1);
		u.setUsername("mao");
		u.setPassword("mzw");
       JSONObject json = new JSONObject(u);
       System.out.println(json);
	}
	@Test
	public void jsonTest01() throws IOException {
		String s =FileUtils.readFileToString(new File("D:\\gitRepository\\MyWebProject\\src\\main\\resources\\user.json"));
		JSONObject json = new JSONObject(s);
		System.out.println(json);
	}
	@Test
	public void jsonTest03() throws IOException {
		InputStream is = super.getClass().getClassLoader().getResourceAsStream("user.json");
		StringBuffer sb = new StringBuffer();
		int len = -1;
		byte[] data = new byte[10];
		while(-1!=(len = is.read(data))) {
			String str =  new String (data);
			sb.append(str);
			
		};
		String s = sb.toString();
		JSONObject json = new JSONObject(s);
		System.out.println(json);
		 
	}
	@Test
	public void jsontest04() throws IOException {
		User u = new User(1,"mm","zz");
		JSONObject json = new JSONObject(u);
		Writer writer = new FileWriter("");
		json.write(writer);
		writer.flush();
	} 
}
