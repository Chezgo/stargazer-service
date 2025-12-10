package com.example.stargazer_service.model.detail.attribute;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Schema(description = "Полная информация о характеристиках деталей телескопа")
@Entity
@Table(name = "t_telescope_detail_attribute")
public class TelescopeDetailAttribute {
    @Schema(description = "Уникальный идентификатор характеристики детали", example = "123")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_detail_attribute")
    private Long id;
    @Schema(description = "Название характеристики детали", example = "Апертура")
    @Column(name = "name_detail_attribute")
    private String name;
    @Schema(description = "Уникальный идентификатор типа детали", example = "3")
    @Column(name = "id_type_detail")
    private Long idTypeDetail;
    @Schema(description = "Описание характеристики детали", example = "Апертура телескопа — это диаметр его главного оптического элемента, который может быть линзой или зеркалом.")
    private String description;

    public TelescopeDetailAttribute(Long id, String name, Long idTypeDetail, Long idBrandDetail, String description) {
        this.id = id;
        this.name = name;
        this.idTypeDetail = idTypeDetail;
        this.description = description;
    }

    public TelescopeDetailAttribute() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
