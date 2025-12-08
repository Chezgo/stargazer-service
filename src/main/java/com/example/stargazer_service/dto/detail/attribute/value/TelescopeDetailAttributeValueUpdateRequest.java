package com.example.stargazer_service.dto.detail.attribute.value;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record TelescopeDetailAttributeValueUpdateRequest(
        @Schema(description = "Идентификатор характеристики детали", example = "3", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotNull(message = "Идентификатор характеристики детали обязателен для заполнения")
        @Positive(message = "Идентификатор характеристики детали должен быть положительным")
        Long idDetailAttribute,

        @Schema(description = "Идентификатор детали", example = "3", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotNull(message = "Идентификатор детали обязателен для заполнения")
        @Positive(message = "Идентификатор детали должен быть положительным")
        Long idDetail,

        @Schema(description = "Значение характеристики детали", example = "Апертура", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotNull(message = "Значение характеристики детали не должно быть null")
        @NotBlank(message = "Значение характеристики детали обязательно для заполнения")
        @Size(min = 1,max = 50, message = "Значение характеристики детали должно быть от 3 до 50 символов")
        String value,

        @Schema(description = "Описание значения характеристики детали", example = "Апертура телескопа — это диаметр его главного оптического элемента, который может быть линзой или зеркалом.", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotNull(message = "Описание значения характеристики детали не должно быть null")
        @NotBlank(message = "Описание значения характеристики детали обязательно для заполнения")
        @Size(min = 1,max = 255, message = "Описание значения характеристики детали должно быть от 3 до 255 символов")
        String description
) {
}
