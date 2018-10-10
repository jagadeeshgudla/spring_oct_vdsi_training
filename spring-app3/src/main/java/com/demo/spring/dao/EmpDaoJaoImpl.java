package com.demo.spring.dao;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

import com.demo.spring.entity.Emp;

@Repository
public class EmpDaoJaoImpl implements EmpDao {

	@Override
	public String save(Emp e) {
 		return e.getEmpId()+":"+e.getName()+" ... saved";
	}

}
