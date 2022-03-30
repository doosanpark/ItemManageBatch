package com.item.secondary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface ManagerRepository extends JpaRepository<Manager, Long> {

	
	@Modifying
    @Query(value = "insert into item_acqird (itm_seq, itm_nm, itm_cnt) VALUES (:itm_seq,:itm_nm,:itm_cnt)", nativeQuery = true)
    @Transactional
    void saveItms(@Param("itm_seq") int itm_seq, @Param("itm_nm") String itm_nm, @Param("itm_cnt") int itm_cnt);
}