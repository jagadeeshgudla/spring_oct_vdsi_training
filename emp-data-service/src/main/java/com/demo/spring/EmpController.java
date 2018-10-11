package com.demo.spring;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.entity.Emp;
import com.demo.spring.repo.EmpRepository;

@RestController
public class EmpController {
	@Autowired
	EmpRepository empRepo;

	@RequestMapping(path = "/getEmp/{id}", method = RequestMethod.GET, produces = "application/json")
	public Emp findEmpById(@PathVariable int id) {
		Optional<Emp> emp = empRepo.findById(id);
		if (emp.isPresent()) {
			return emp.get();
		} else {
			throw new RuntimeException("No Data Found");
		}
	}

	@RequestMapping(path = "/getAllEmp", method = RequestMethod.GET, produces = "application/json")
	public List<Emp> getAllEmp() {
		List<Emp> empList = empRepo.findAll();
		return empList;
	}

	@RequestMapping(path = "/save", method = RequestMethod.POST, produces = "text/plain", consumes = "application/json")
	public String addEmp(@RequestBody  Emp e) {
		if(empRepo.existsById(e.getEmpId())) {
			return "Emp Already Exists";
		}else {
			empRepo.save(e);
		}
		return "Created Successfully";
	}
	
	
	@RequestMapping(path = "/update", method = RequestMethod.PUT, produces = "text/plain", consumes = "application/json")
	public String updateEmp(@RequestBody Emp e) {
		empRepo.save(e);
		return "Emp Updated Successfully";
	}
	
	
	@RequestMapping(path = "/delete", method = RequestMethod.DELETE, produces = "text/plain")
	public String deleteEmp(@RequestParam  int id) {
		if(empRepo.existsById(id)) {
			empRepo.deleteById(id); 
			return "Emp deleted";
		}
		
		return "No Emp Found";
	}

}
