package com.jsen17.money.domain.repository;

import com.jsen17.money.domain.po.BillRecord;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Husen
 * @since 2022/11/28 21:08
 */
public interface BillRecordRepository extends JpaRepository<BillRecord, Long> {
}
