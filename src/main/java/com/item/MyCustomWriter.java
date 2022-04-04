package com.item;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.item.secondary.ItemAcqirdOracle;
import com.item.secondary.ItemAcqirdOracleRepository;


@Component
public class MyCustomWriter implements ItemWriter<ItemAcqirdOracle> {
	
	@Autowired
	ItemAcqirdOracleRepository managerRepository ;
	
	@Override
	public void write(List<? extends ItemAcqirdOracle> list) throws Exception {
		for (ItemAcqirdOracle data : list) {
			System.out.println("MyCustomWriter    : Writing data    : " + data.getSeq()+" : "+data.getName()+" : "+data.getCnt()+" : "+data.getAcqirdDate());
			managerRepository.save(data);
			//managerRepository.updtItms(data.getSeq(), data.getName(), data.getCnt(), data.getAcqirdDate());
			//managerRepository.saveItms(data.getSeq(), data.getName(), data.getCnt());
		}
	}
}