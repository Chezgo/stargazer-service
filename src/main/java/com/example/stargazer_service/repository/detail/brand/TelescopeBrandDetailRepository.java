package com.example.stargazer_service.repository.detail.brand;

import com.example.stargazer_service.model.detail.brand.TelescopeBrandDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelescopeBrandDetailRepository extends JpaRepository<TelescopeBrandDetail, Long> {
    boolean existsByName(String name);
}
