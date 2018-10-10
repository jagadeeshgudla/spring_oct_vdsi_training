package com.demo.spring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.demo.spring.entity.Emp;

@Repository
public class EmpDaoJpaImpl implements EmpDao {
	
	@PersistenceContext
	EntityManager em;

	@Override
	public String save(Emp e) {
		em.persist(e);
		return "Emp Saved";
	}

	@Override
	public String remove(int empNo) {
		em.remove(findById(empNo));
		return "Emp Deleted";
	}

	@Override
	public Emp  findById(int id) {
		Emp e= em.find(Emp.class, id);
		return e;
	}

	@Override
	public List<Emp> getAll() {
		Query qry=em.createQuery("select e from Emp e");
		return qry.getResultList();
	}

}
