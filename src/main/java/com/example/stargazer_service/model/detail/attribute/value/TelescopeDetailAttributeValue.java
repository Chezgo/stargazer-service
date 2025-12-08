package com.example.stargazer_service.model.detail.attribute.value;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Schema(description = "Полная информация о значениях характеристик деталей телескопа")
@Entity
@Table(name = "t_telescope_detail_attribute_value")
public class TelescopeDetailAttributeValue {
    @Schema(description = "Уникальный идентификатор значения характеристики детали", example = "123")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_telescope_detail_attribute_value")
    private Long id;
    @Schema(description = "Уникальный идентификатор характеристики детали", example = "123")
    @Column(name = "id_detail_attribute")
    private Long idDetailAttribute;
    @Schema(description = "Уникальный идентификатор детали", example = "123")
    @Column(name = "id_telescope_detail")
    private Long idDetail;
    @Schema(description = "Значение характеристики детали", example = "123")
    @Column(name = "telescope_detail_attribute_value")
    private String value;
    @Schema(description = "Уникальный идентификатор значения характеристики детали", example = "123")
    @Column(name = "description")
    private String description;

    public TelescopeDetailAttributeValue(Long id, Long idDetailAttribute, Long idDetail, String value, String description) {
        this.id = id;
        this.idDetailAttribute = idDetailAttribute;
        this.idDetail = idDetail;
        this.value = value;
        this.description = description;
    }

    public TelescopeDetailAttributeValue() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdDetailAttribute() {
        return idDetailAttribute;
    }

    public void setIdDetailAttribute(Long idDetailAttribute) {
        this.idDetailAttribute = idDetailAttribute;
    }

    public Long getIdDetail() {
        return idDetail;
    }

    public void setIdDetail(Long idDetail) {
        this.idDetail = idDetail;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
