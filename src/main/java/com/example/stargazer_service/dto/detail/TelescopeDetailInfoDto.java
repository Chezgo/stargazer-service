package com.example.stargazer_service.dto.detail;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Schema(description = "Информация о детали телескопа")
public class TelescopeDetailInfoDto {
    @Schema(description = "Название детали", example = "Skyline BASE 100S")
    private String nameDetail;

    @Schema(description = "Название типа детали", example = "Оптическая труба")
    private String nameType;

    @Schema(description = "Название бренда детали", example = "Levenhuk")
    private String nameBrand;

    @Schema(description = "Описание детали")
    private String description;

    public String getNameDetail() {
        return nameDetail;
    }

    public void setNameDetail(String nameDetail) {
        this.nameDetail = nameDetail;
    }

    public String getNameType() {
        return nameType;
    }

    public void setNameType(String nameType) {
        this.nameType = nameType;
    }

    public String getNameBrand() {
        return nameBrand;
    }

    public void setNameBrand(String nameBrand) {
        this.nameBrand = nameBrand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
