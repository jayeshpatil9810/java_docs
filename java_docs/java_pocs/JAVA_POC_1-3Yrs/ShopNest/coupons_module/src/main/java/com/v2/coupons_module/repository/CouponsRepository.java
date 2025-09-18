package com.v2.coupons_module.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.v2.coupons_module.entity.CouponsEntity;

public interface CouponsRepository extends JpaRepository<CouponsEntity, Long>{

	Optional<CouponsEntity> findByCouponCode(String code);
	
	List<CouponsEntity> findByUserId(String userId);

    List<CouponsEntity> findByValidTillBeforeAndIsUsedFalse(LocalDateTime now);
}
