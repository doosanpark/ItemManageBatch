package com.item.secondary;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="item_acqird")
public class ItemAcqirdOracle {
	@Id
	private int itm_seq;
	private String itm_nm;
	private int itm_cnt;
	private Date acqird_date;
	
	public int getSeq() {
		return itm_seq;
	}
	public void setSeq(int itm_seq) {
		this.itm_seq = itm_seq;
	}
	public String getName() {
		return itm_nm;
	}
	public void setName(String name) {
		this.itm_nm = name;
	}
	public int getCnt() {
		return itm_cnt;
	}
	public void setCnt(int itm_cnt) {
		this.itm_cnt = itm_cnt;
	}	
	public Date getAcqirdDate() {
		return acqird_date;
	}
	public void setAcqirdDate(Date acqird_date) {
		this.acqird_date = acqird_date;
	}	
}