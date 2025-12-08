package com.example.stargazer_service.model.detail.type;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Schema(description = "Полная информация о типе детали телескопа")
@Entity
@Table(name = "t_telescope_type_detail")
public class TelescopeTypeDetail {
    @Schema(description = "Уникальный идентификатор типа детали", example = "123")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_telescope_type_detail")
    private Long id;
    @Schema(description = "Название типа детали", example = "Окуляр")
    @Column(name = "name_telescope_type_detail")
    private String name;
    @Schema(description = "Название типа детали", example = "Окуляр телескопа — это ключевой элемент, который определяет итоговое увеличение, поле зрения и качество изображения.")
    private String description;


    public TelescopeTypeDetail(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public TelescopeTypeDetail() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
