package com.item;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.item.secondary.Manager;
import com.item.secondary.ManagerRepository;


@Component
public class MyCustomWriter implements ItemWriter<Manager> {
	
	@Autowired
	ManagerRepository managerRepository ;
	
	@Override
	public void write(List<? extends Manager> list) throws Exception {
		for (Manager data : list) {
			data.setSeq(data.getSeq() + 1);
			System.out.println("MyCustomWriter    : Writing data    : " + data.getSeq()+" : "+data.getName()+" : "+data.getCnt());
			managerRepository.save(data);
		}
	}
}