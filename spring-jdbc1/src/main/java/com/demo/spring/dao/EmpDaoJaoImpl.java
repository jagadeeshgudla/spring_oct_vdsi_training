package com.demo.spring.dao;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Repository;

import com.demo.spring.entity.Emp;

@Repository
public class EmpDaoJaoImpl implements EmpDao {

	@Override
	public String save(Emp e) {
 		return e.getEmpId()+":"+e.getName()+" ... saved";
	}

	@Override
	public String remove(int empNo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Emp> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
