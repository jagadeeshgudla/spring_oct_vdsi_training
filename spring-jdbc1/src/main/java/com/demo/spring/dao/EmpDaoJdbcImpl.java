package com.demo.spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.demo.spring.entity.Emp;

@Repository
public class EmpDaoJdbcImpl implements EmpDao {
	
	@Autowired
	JdbcTemplate jt;

	@Override
	public String save(Emp e) {
		
		String response="";
		
		try {
			String insertSql = "insert into emp(empno,name,address,salary) values (?,?,?,?)";
			int count = jt.update(new PreparedStatementCreator() {

				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					PreparedStatement pst = con.prepareStatement(insertSql);
					pst.setInt(1, e.getEmpId());
					pst.setString(2, e.getName());
					pst.setString(3, e.getCity());
					pst.setDouble(4, e.getSalary());
					return pst;
				}
			});
			System.out.println("ROWs Effected:" + count);
			response= "  Saved";
		
		}catch(DuplicateKeyException dke) {
			response= " Not Saved";
			throw dke;
		}
		
		
		
		
		
	
 		return e.getEmpId()+":"+e.getName()+response;
	}

	@Override
	public String remove(int empNo) {
		String insertSql = "delete from emp where empno=?";
		int count = jt.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pst = con.prepareStatement(insertSql);
				pst.setInt(1, empNo);				 
				return pst;
			}
		});
		System.out.println("ROWs Effected:" + count);
		return "Removed "+empNo;
	}

	@Override
	public String findById(int id) {
		String empResponse;
		try {
			Emp emp=jt.queryForObject("select empno,name,address,salary from emp where empno="+id, new RowMapper<Emp>() {

				@Override
				public Emp mapRow(ResultSet rs, int rowNum) throws SQLException {			
					return new Emp(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4));
				}
			});	
			empResponse=emp.toString();
		}catch(EmptyResultDataAccessException e) {
			empResponse= "No Employee Found";
		}
			
		return empResponse;
	}

	@Override
	public List<Emp> getAll() {
		List<Emp> empList=jt.query("select * from emp", new RowMapper<Emp>() {

			@Override
			public Emp mapRow(ResultSet rs, int rowNum) throws SQLException {			
				return new Emp(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getDouble(4));
			}
		});
		return empList;
	}

}
