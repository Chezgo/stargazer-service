package com.example.stargazer_service.repository.detail.attribute;

import com.example.stargazer_service.model.detail.attribute.TelescopeDetailAttribute;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelescopeDetailAttributeRepository extends JpaRepository<TelescopeDetailAttribute, Long> {
    boolean existsByName(String name);
    boolean existsByNameAndIdNot(String name, Long id);
}
