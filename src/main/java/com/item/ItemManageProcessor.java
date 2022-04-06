package com.item;

import java.text.SimpleDateFormat;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.item.primary.ItemAcqirdMysql;
import com.item.secondary.ItemAcqirdOracle;

@Component
public class ItemManageProcessor implements ItemProcessor<ItemAcqirdMysql, ItemAcqirdOracle> {

	@Override
	public ItemAcqirdOracle process(ItemAcqirdMysql itemAcqirdMysql) throws Exception {
		System.out.println("MyBatchProcessor : Processing data : "+itemAcqirdMysql);
		ItemAcqirdOracle itemAcqirdOracle = new ItemAcqirdOracle();
		itemAcqirdOracle.setSeq(itemAcqirdMysql.getSeq());
		itemAcqirdOracle.setName(itemAcqirdMysql.getName().toUpperCase());
		itemAcqirdOracle.setCnt(itemAcqirdMysql.getCnt());
		itemAcqirdOracle.setAcqirdDate(itemAcqirdMysql.getAcqirdDate());
		return itemAcqirdOracle;
	}
}