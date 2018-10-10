package com.demo.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.spring.dao.EmpDao;
import com.demo.spring.entity.Emp;

@Service
public class HrService {
	
	@Autowired
	@Qualifier("empDaoJdbcImpl")
	private EmpDao empDao;
	
	@Transactional
	public String registerEmployee(Emp emp) {
		String resp=empDao.save(emp);
		return resp;
	}
	
	public String displayEmpInfo(int id) {
		String emp = empDao.findById(id);
		System.out.println(emp);
		return emp;
	}
	
	public List<Emp> getALlEmployees(){
		empDao.getAll().stream().forEach((e)->System.out.println(e));

		return empDao.getAll();
	}
	
	public void removeEmployee(int id) {
		System.out.println("Removing "+id+" from db..");
		String response=empDao.remove(id);
		System.out.println(response);
	}
}
