package com.item.secondary;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ItemAcqirdOracleRepository extends JpaRepository<ItemAcqirdOracle, Long> {

	
    @Query(value = "insert into item_acqird (itm_seq, itm_nm, itm_cnt) VALUES (:itm_seq,:itm_nm,:itm_cnt)", nativeQuery = true)
    void saveItms(@Param("itm_seq") int itm_seq, @Param("itm_nm") String itm_nm, @Param("itm_cnt") int itm_cnt);
    
    @Query(value = "       MERGE INTO item_acqird I\r\n"
    		+ "    		   USING DUAL\r\n"
    		+ "    		   ON (I.ITM_SEQ = :itm_seq)\r\n"
    		+ "    		   WHEN MATCHED THEN\r\n"
    		+ "                    UPDATE SET \r\n"
    		+ "    					I.ITM_NM = :itm_nm\r\n"
    		+ "    					,I.ITM_CNT = :itm_cnt\r\n"
    		+ "    					,I.ACQIRD_DATE = :acqird_date\r\n"
    		+ "    		    WHEN NOT MATCHED THEN\r\n"
    		+ "    		    		INSERT (I.ITM_SEQ, I.ITM_NM, I.ITM_CNT, I.ACQIRD_DATE)\r\n"
    		+ "    		    		VALUES (:itm_seq, :itm_nm, :itm_cnt, :acqird_date)", nativeQuery = true)
    void updtItms(@Param("itm_seq") int itm_seq, @Param("itm_nm") String itm_nm, @Param("itm_cnt") int itm_cnt, @Param("acqird_date") Date acqird_date);
}