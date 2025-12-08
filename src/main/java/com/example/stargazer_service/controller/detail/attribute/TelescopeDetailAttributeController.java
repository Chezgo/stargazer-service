package com.example.stargazer_service.controller.detail.attribute;

import com.example.stargazer_service.dto.ApiErrorResponse;
import com.example.stargazer_service.dto.detail.attribute.ApiErrorExamplesDetailAttribute;
import com.example.stargazer_service.dto.detail.attribute.CreateTelescopeDetailAttributeRequest;
import com.example.stargazer_service.dto.detail.attribute.TelescopeDetailAttributeUpdateRequest;
import com.example.stargazer_service.model.detail.attribute.TelescopeDetailAttribute;
import com.example.stargazer_service.service.detail.attribute.TelescopeDetailAttributeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "v1/detail-attribute")
@Tag(name = "Telescope Detail Attribute API", description = "API для управления бизнес сущностью Характеристики детали")
public class TelescopeDetailAttributeController {
    private final TelescopeDetailAttributeService telescopeDetailAttributeService;

    public TelescopeDetailAttributeController(TelescopeDetailAttributeService telescopeDetailAttributeService) {
        this.telescopeDetailAttributeService = telescopeDetailAttributeService;
    }

    @Operation(summary = "Получить все характеристики деталей телескопов")
    @ApiResponse(
            responseCode = "200",
            description = "Список характеристик деталей телескопа успешно получен",
            content = @Content(
                    mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = TelescopeDetailAttribute.class))
            )
    )
    @ApiResponse(
            responseCode = "401",
            description = "Ошибка авторизации",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ApiErrorResponse.class),
                    examples = @ExampleObject(
                            name = "Authorization error",
                            value = ApiErrorExamplesDetailAttribute.UNAUTHORIZED_ERROR
                    )
            )
    )
    @GetMapping
    public List<TelescopeDetailAttribute> findAllTelescopeDetailAttribute() {
        return telescopeDetailAttributeService.findAllTelescopeDetailAttribute();
    }

    @Operation(summary = "Получить информацию о характеристике детали по ID")
    @ApiResponse(
            responseCode = "200",
            description = "Характеристика детали успешно найдена",
            content = @Content(schema = @Schema(implementation = TelescopeDetailAttribute.class))
    )
    @ApiResponse(
            responseCode = "401",
            description = "Ошибка авторизации",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ApiErrorResponse.class),
                    examples = @ExampleObject(
                            name = "Authorization error",
                            value = ApiErrorExamplesDetailAttribute.UNAUTHORIZED_ERROR
                    )
            )
    )
    @ApiResponse(
            responseCode = "404",
            description = "Характеристика детали телескопа с указанным ID не найдена",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ApiErrorResponse.class),
                    examples = @ExampleObject(
                            name = "Not Found",
                            value = ApiErrorExamplesDetailAttribute.NOT_FOUND_ERROR
                    )
            )
    )
    @GetMapping("/{id}")
    public ResponseEntity<TelescopeDetailAttribute> getTelescopeDetailAttributeById(
            @Parameter(description = "Уникальный идентификатор характеристики детали", example = "1")
            @PathVariable Long id
    )
    {
        TelescopeDetailAttribute detailAttribute = telescopeDetailAttributeService.getTelescopeDetailAttributeById(id);
        return ResponseEntity.ok(detailAttribute);
    }

    @PostMapping
    public TelescopeDetailAttribute createTelescopeDetailAttribute(
            @Valid
            @RequestBody
            CreateTelescopeDetailAttributeRequest request
    )
    {
        return telescopeDetailAttributeService.createTelescopeDetailAttribute(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTelescopeDetailAttribute(
            @PathVariable
            Long id
    )
    {
        telescopeDetailAttributeService.deleteTelescopeDetailAttribute(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TelescopeDetailAttribute> updateTelescopeDetailAttribute(
            @PathVariable
            Long id,
            @Valid
            @RequestBody
            TelescopeDetailAttributeUpdateRequest request
    )
    {
        TelescopeDetailAttribute updated = telescopeDetailAttributeService.updateTelescopeDetailAttribute(id, request);
        return ResponseEntity.ok(updated);
    }
}
