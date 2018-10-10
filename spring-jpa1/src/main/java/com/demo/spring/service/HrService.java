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
@Transactional
public class HrService {
	
	@Autowired
	@Qualifier("empDaoJpaImpl")
	private EmpDao empDao;
	
	
	public String registerEmployee(Emp emp) {
		String resp=empDao.save(emp);
		return resp;
	}
	
	public Emp displayEmpInfo(int id) {
		Emp emp = empDao.findById(id);
		System.out.println(emp);
		return emp;
	}
	
	public List<Emp> getAllEmp(){
		empDao.getAll().stream().forEach((e)->System.out.println(e));
		return empDao.getAll();
	}
	
	public void removeEmployee(int id) {
		System.out.println("Removing "+id+" from db..");
		String response=empDao.remove(id);
		System.out.println(response);
	}
}
