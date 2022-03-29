package com.item;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.item.primary.Employee;
import com.item.secondary.Manager;

@Component
public class MyCustomProcessor implements ItemProcessor<Employee, Manager> {

	@Override
	public Manager process(Employee emp) throws Exception {
		System.out.println("MyBatchProcessor : Processing data : "+emp);
		Manager manager = new Manager();
		manager.setSeq(emp.getSeq());
		manager.setName(emp.getName().toUpperCase());
		manager.setCnt(emp.getCnt());
		return manager;
	}
}