package com.item;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.item.primary.Employee;


@Component
public class MyCustomReader extends JdbcCursorItemReader<Employee> implements ItemReader<Employee>{
	
	public MyCustomReader(@Autowired DataSource primaryDataSource) {
		setDataSource(primaryDataSource);
		setSql("SELECT itm_seq, itm_nm, itm_cnt FROM item_acqird");
		setFetchSize(100);
		setRowMapper(new EmployeeRowMapper());
	}
	
	public class EmployeeRowMapper implements RowMapper<Employee> {
		@Override
		public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
			Employee employee  = new Employee();
			employee.setSeq(rs.getInt("itm_seq"));
			employee.setName(rs.getString("itm_nm"));
			employee.setCnt(rs.getInt("itm_cnt"));
			return employee;
		}
	}
}