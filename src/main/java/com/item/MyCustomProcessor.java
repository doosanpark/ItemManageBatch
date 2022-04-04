package com.item;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.item.primary.ItemAcqirdMysql;
import com.item.secondary.ItemAcqirdOracle;

@Component
public class MyCustomProcessor implements ItemProcessor<ItemAcqirdMysql, ItemAcqirdOracle> {

	@Override
	public ItemAcqirdOracle process(ItemAcqirdMysql emp) throws Exception {
		System.out.println("MyBatchProcessor : Processing data : "+emp);
		ItemAcqirdOracle manager = new ItemAcqirdOracle();
		manager.setSeq(emp.getSeq());
		manager.setName(emp.getName().toUpperCase());
		manager.setCnt(emp.getCnt());
		manager.setAcqirdDate(emp.getAcqirdDate());
		return manager;
	}
}