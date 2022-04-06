package com.item;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.item.primary.ItemAcqirdMysql;


@Component
public class ItemManageReader extends JdbcCursorItemReader<ItemAcqirdMysql> implements ItemReader<ItemAcqirdMysql>{
	
	public ItemManageReader(@Autowired DataSource primaryDataSource) {
		setDataSource(primaryDataSource);
		setSql("SELECT itm_seq, itm_nm, itm_cnt, acqird_date FROM item_acqird");
		setFetchSize(100);
		setRowMapper(new ItemAcqirdRowMapper());
	}
	
	public class ItemAcqirdRowMapper implements RowMapper<ItemAcqirdMysql> {
		@Override
		public ItemAcqirdMysql mapRow(ResultSet rs, int rowNum) throws SQLException {
			ItemAcqirdMysql itemAcqirdMysql  = new ItemAcqirdMysql();
			itemAcqirdMysql.setSeq(rs.getInt("itm_seq"));
			itemAcqirdMysql.setName(rs.getString("itm_nm"));
			itemAcqirdMysql.setCnt(rs.getInt("itm_cnt"));
			itemAcqirdMysql.setAcqirdDate(rs.getString("acqird_date"));
			
			return itemAcqirdMysql;
		}
	}
}