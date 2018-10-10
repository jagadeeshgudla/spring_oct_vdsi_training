package com.demo.spring;

import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

public class JdbcMain1 {

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(DaoConfig.class);
		JdbcTemplate jt = ctx.getBean(JdbcTemplate.class);

		String insertSql = "insert into emp(empno,name,address,salary) values (?,?,?,?)";
		int count = jt.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement pst = con.prepareStatement(insertSql);
				pst.setInt(1, 12);
				pst.setString(2, "Jagadeesh");
				pst.setString(3, "New York");
				pst.setDouble(4, 36000);
				return pst;
			}
		});
		System.out.println("ROWs Effected:" + count);

		// lambda
		int countL = jt.update((con) -> {
			PreparedStatement pst = con.prepareStatement(insertSql);
			pst.setInt(1, 13);
			pst.setString(2, "Jag");
			pst.setString(3, "New York");
			pst.setDouble(4, 36000);
			return pst;

		});
		System.out.println("ROWs Effected:" + countL);
	}

}
