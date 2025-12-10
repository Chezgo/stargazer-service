package com.example.stargazer_service.repository.detail;

import com.example.stargazer_service.model.detail.TelescopeDetailInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TelescopeDetailInfoRepository extends JpaRepository<TelescopeDetailInfo,Long> {

    @Query("SELECT td FROM TelescopeDetailInfo td " +
            "LEFT JOIN FETCH td.typeDetail " +
            "LEFT JOIN FETCH td.brandDetail " +
            "WHERE td.id = :id")
    TelescopeDetailInfo findByIdWithDetails(@Param("id") Long id);

    @Query("SELECT td FROM TelescopeDetailInfo td " +
            "LEFT JOIN FETCH td.typeDetail " +
            "LEFT JOIN FETCH td.brandDetail")
    Page<TelescopeDetailInfo> findAllWithDetails(Pageable pageable);
}
