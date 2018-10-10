package com.demo.spring.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.demo.spring.entity.Emp;
import com.demo.spring.repo.EmpRepository;

@Service
@Transactional
public class HrService {

	@Autowired
	private EmpRepository empRepo;

	public Emp registerEmployee(Emp emp) {
		Emp resp = empRepo.save(emp);
		return resp;
	}

	public Emp displayEmpInfo(int id) {
		Optional<Emp> emp = empRepo.findById(id);
		if (emp.isPresent()) {
			System.out.println(emp.get());
			return emp.get();
		} else {
			return new Emp();
		}

	}
	
	public void empInRange(double sal1,double sal2) {
		empRepo.getEmpBwRange(sal1, sal2).stream().forEach((e)->System.out.println(e)); 
	}

	/*
	 * public List<Emp> getAllEmp(){
	 * empRepo.getAll().stream().forEach((e)->System.out.println(e)); return
	 * empRepo.getAll(); }
	 * 
	 * public void removeEmployee(int id) {
	 * System.out.println("Removing "+id+" from db.."); String
	 * response=empRepo.remove(id); System.out.println(response); }
	 */
}
