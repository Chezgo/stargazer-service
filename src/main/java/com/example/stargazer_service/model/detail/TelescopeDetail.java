package com.example.stargazer_service.model.detail;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Schema(description = "Полная информация о детали телескопа")
@Entity
@Table(name = "t_telescope_detail")
public class TelescopeDetail {
    @Schema(description = "Уникальный идентификатор детали", example = "123")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_telescope_detail")
    private Long id;
    @Schema(description = "Название детали", example = "Skyline BASE 50T")
    @Column(name = "name_detail")
    private String name;
    @Schema(description = "Уникальный идентификатор типа детали", example = "123")
    @Column(name = "id_type_detail")
    private Long idTypeDetail;
    @Schema(description = "Уникальный идентификатор бренда детали", example = "123")
    @Column(name = "id_telescope_brand_detail")
    private Long idBrandDetail;
    @Schema(description = "Описание детали", example = "Телескоп Levenhuk Skyline BASE 50T – легкий и простой в сборке рефрактор с просветленной оптикой.")
    private String description;

    public TelescopeDetail(Long id, String name, Long idTypeDetail, Long idBrandDetail, String description) {
        this.id = id;
        this.name = name;
        this.idTypeDetail = idTypeDetail;
        this.idBrandDetail = idBrandDetail;
        this.description = description;
    }

    public TelescopeDetail() {
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
}