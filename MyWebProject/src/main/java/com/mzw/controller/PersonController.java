package com.mzw.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.method.annotation.JsonViewResponseBodyAdvice;

import com.mzw.model.Person;
import com.mzw.model.PersonId;
import com.mzw.model.User;
import com.mzw.service.SelectPersonService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller
public class PersonController {
	//mytest
	private SelectPersonService selectPersonService;
	
	public SelectPersonService getSelectPersonService() {
		return selectPersonService;
	}

	public void setSelectPersonService(SelectPersonService selectPersonService) {
		this.selectPersonService = selectPersonService;
	}

	@RequestMapping(value="test",produces = "application/json;charset=UTF-8")//@ResponseBody把返回String类型的数据编码全部默认转换成iso-8859-1的编码格式,produces = "application/json;charset=UTF-8"
	@ResponseBody
	public String testPerson(@RequestParam("key") String key,ModelMap mm) {
		return key;   
	} 
	   
	@RequestMapping("mavtest")
	public ModelAndView mavTest() {
		ModelAndView mav = new ModelAndView("login");
		Person p = new Person();
		p.setAge(1);
		p.setName("老师");
		Person p1 = new Person();
		p1.setAge(1);
		p1.setName("学生");
		List<Person> pList = new ArrayList<Person>();
		pList.add(p);
		pList.add(p1);
		
		mav.addObject("list", pList);
		
		return mav;
		
	}
	@RequestMapping("ajaxTest")
	public String ajaxTest(@RequestParam("pNum") String pNum) {
		System.out.println(pNum);  
		return "index"; 
		
	}
	@RequestMapping("TestModelMap")
	public String TestModelMap(ModelMap mm,@RequestParam("pName") String pName) {
		mm.put("pName", pName);
		System.out.println(pName);
		return "index"; 
	}
    @RequestMapping("ssmTest")
    public String ssmTest(@RequestParam("ssm") String ssm) throws Exception {
		return "index";
    	
    }
}
