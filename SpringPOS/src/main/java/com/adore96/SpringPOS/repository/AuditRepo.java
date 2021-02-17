package com.adore96.SpringPOS.repository;

import com.adore96.SpringJWT.model.Audit;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author kasun_k ON 1/26/21
 * @project SpringJWT
 */

public interface AuditRepo extends JpaRepository<Audit,Integer> {

}
