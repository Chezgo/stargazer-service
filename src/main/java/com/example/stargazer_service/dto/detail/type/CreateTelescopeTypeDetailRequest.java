package com.example.stargazer_service.dto.detail.type;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CreateTelescopeTypeDetailRequest(
        @Schema(description = "Название типа детали", example = "Окуляр", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotBlank(message = "Название типа детали обязательно для заполнения")
        @NotNull(message = "Название типа детали не должно быть null")
        @Size(max = 50, message = "Название типа детали не может быть длиннее 50 символов")
        String name,

        @Schema(description = "Описание типа детали", example = "Окуляр телескопа — это ключевой элемент, который определяет итоговое увеличение, поле зрения и качество изображения.", requiredMode = Schema.RequiredMode.REQUIRED)
        @NotBlank(message = "Описание типа детали обязательно для заполнения")
        @NotNull(message = "Описание типа детали не должно быть null")
        @Size(max = 255, message = "Описание типа детали не может быть длиннее 255 символов")
        String description
) {}
