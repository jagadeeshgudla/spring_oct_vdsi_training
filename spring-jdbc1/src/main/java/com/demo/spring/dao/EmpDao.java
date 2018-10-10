package com.demo.spring.dao;

import java.util.List;

import com.demo.spring.entity.Emp;

public interface EmpDao {
	 String save(Emp e);
	 String remove(int empNo);
	 String findById(int id);
	 List<Emp> getAll();
}
