package com.example.stargazer_service.model.detail;

import com.example.stargazer_service.model.detail.brand.TelescopeBrandDetail;
import com.example.stargazer_service.model.detail.type.TelescopeTypeDetail;
import jakarta.persistence.*;

@Entity
@Table(name = "t_telescope_detail")
public class TelescopeDetailInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_telescope_detail")
    private Long id;

    @Column(name = "name_detail")
    private String name;

    @Column(name = "id_type_detail")
    private Long idTypeDetail;

    @Column(name = "id_telescope_brand_detail")
    private Long idBrandDetail;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_type_detail", insertable = false, updatable = false)
    private TelescopeTypeDetail typeDetail;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_telescope_brand_detail", insertable = false, updatable = false)
    private TelescopeBrandDetail brandDetail;

    public TelescopeDetailInfo(Long id, String name, Long idTypeDetail, Long idBrandDetail, String description, TelescopeTypeDetail typeDetail, TelescopeBrandDetail brandDetail) {
        this.id = id;
        this.name = name;
        this.idTypeDetail = idTypeDetail;
        this.idBrandDetail = idBrandDetail;
        this.description = description;
        this.typeDetail = typeDetail;
        this.brandDetail = brandDetail;
    }

    public TelescopeDetailInfo() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getIdTypeDetail() {
        return idTypeDetail;
    }

    public void setIdTypeDetail(Long idTypeDetail) {
        this.idTypeDetail = idTypeDetail;
    }

    public Long getIdBrandDetail() {
        return idBrandDetail;
    }

    public void setIdBrandDetail(Long idBrandDetail) {
        this.idBrandDetail = idBrandDetail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TelescopeTypeDetail getTypeDetail() {
        return typeDetail;
    }

    public void setTypeDetail(TelescopeTypeDetail typeDetail) {
        this.typeDetail = typeDetail;
    }

    public TelescopeBrandDetail getBrandDetail() {
        return brandDetail;
    }

    public void setBrandDetail(TelescopeBrandDetail brandDetail) {
        this.brandDetail = brandDetail;
    }
}
