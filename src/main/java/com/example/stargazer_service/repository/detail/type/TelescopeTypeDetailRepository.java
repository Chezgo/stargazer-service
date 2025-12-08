package com.example.stargazer_service.repository.detail.type;

import com.example.stargazer_service.model.detail.type.TelescopeTypeDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelescopeTypeDetailRepository extends JpaRepository<TelescopeTypeDetail, Long> {
    boolean existsByName(String name);
}
