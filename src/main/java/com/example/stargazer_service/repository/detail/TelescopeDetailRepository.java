package com.example.stargazer_service.repository.detail;

import com.example.stargazer_service.model.detail.TelescopeDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelescopeDetailRepository extends JpaRepository<TelescopeDetail, Long> {
    boolean existsByName(String name);
    boolean existsByNameAndIdNot(String name, Long id);
}
