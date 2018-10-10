package com.demo.spring;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.entity.Emp;
import com.demo.spring.repo.EmpRepository;

@RestController
public class EmpController {
	@Autowired
	EmpRepository empRepo;

	@RequestMapping(path="/getEmp/{id}",method=RequestMethod.GET,produces="application/json")
	public Emp findEmpById(@PathVariable int id) {
		Optional<Emp> emp=empRepo.findById(id);
		if(emp.isPresent()) {
			return emp.get();
		}
		else {
			throw new RuntimeException("No Data Found");
		}
	}
	
	@RequestMapping(path="/getAllEmp",method=RequestMethod.GET,produces="application/json")
	public List<Emp>   getAllEmp() {
		List<Emp> empList=empRepo.findAll();
		return empList;
	}

}
