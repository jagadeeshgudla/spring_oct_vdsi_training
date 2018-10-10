package com.demo.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.demo.spring.dao.EmpDao;
import com.demo.spring.entity.Emp;

@Service
public class HrService {
	
	@Autowired
	@Qualifier("empDaoJdbcImpl")
	private EmpDao empDao;
	
	
	
	
	/*public void setEmpDao(EmpDao empDao) {
		this.empDao = empDao;
	}*/




	public String registerEmployee(int id,String name,String city,double salary) {
		String resp=empDao.save(new Emp(id,name,city,salary));
		return resp;
	}
}
