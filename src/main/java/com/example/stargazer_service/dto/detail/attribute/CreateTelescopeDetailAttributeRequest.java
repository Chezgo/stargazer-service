package com.example.stargazer_service.dto.detail.attribute;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record CreateTelescopeDetailAttributeRequest(
        @Schema(description = "Название характеристики детали", example = "Апертура", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotNull(message = "Название характеристики детали не должно быть null")
        @NotBlank(message = "Название характеристики детали обязательно для заполнения")
        @Size(min = 3,max = 50, message = "Название характеристики детали должно быть от 3 до 50 символов")
        String name,

        @Schema(description = "Идентификатор типа детали", example = "3", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotNull(message = "Идентификатор типа детали обязателен для заполнения")
        @Positive(message = "Идентификатор типа детали должен быть положительным")
        Long idTypeDetail,

        @Schema(description = "Описание характеристики детали", example = "Апертура телескопа — это диаметр его главного оптического элемента, который может быть линзой или зеркалом.", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotNull(message = "Описание характеристики детали не должно быть null")
        @NotBlank(message = "Описание характеристики детали обязательно для заполнения")
        @Size(min = 3,max = 255, message = "Описание характеристики детали должно быть от 3 до 255 символов")
        String description
) {
}