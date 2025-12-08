package com.example.stargazer_service.dto.detail;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record TelescopeDetailUpdateRequest (
        @Schema(description = "Название детали", example = "Skyline BASE 50T", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotNull(message = "Имя не должно быть null")
        @NotBlank(message = "Имя обязательно для заполнения")
        @Size(min = 3,max = 50, message = "Имя должно быть от 3 до 50 символов")
        String name,

        @Schema(description = "Уникальный идентификатор типа детали", example = "123", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotNull(message = "Идентификатор типа детали обязателен")
        @Positive(message = "Идентификатор типа детали должен быть положительным")
        Long idTypeDetail,

        @Schema(description = "Уникальный идентификатор бренад детали", example = "123", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotNull(message = "Идентификатор бренда детали обязателен")
        @Positive(message = "Идентификатор бренда детали должен быть положительным")
        Long idBrandDetail,

        @Schema(description = "Описание детали", example = "Телескоп Levenhuk Skyline BASE 50T – легкий и простой в сборке рефрактор с просветленной оптикой.", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotNull(message = "Описание детали не должно быть null")
        @NotBlank(message = "Описание детали обязательно для заполнения")
        @Size(min = 3,max = 255, message = "Описание детали должно быть от 3 до 255 символов")
        String description
){}
