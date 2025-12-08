package com.example.stargazer_service.controller.detail.type;

import com.example.stargazer_service.dto.ApiErrorResponse;
import com.example.stargazer_service.dto.detail.type.ApiErrorExamplesTypeDetail;
import com.example.stargazer_service.dto.detail.type.CreateTelescopeTypeDetailRequest;
import com.example.stargazer_service.dto.detail.type.TelescopeTypeDetailUpdateRequest;
import com.example.stargazer_service.model.detail.type.TelescopeTypeDetail;
import com.example.stargazer_service.service.detail.type.TelescopeTypeDetailService;
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
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping(path = "v1/type-detail")
@Tag(name = "Telescope Type Detail API", description = "API для управления бизнес сущностью Тип детали")
public class TelescopeTypeDetailController {

    private final TelescopeTypeDetailService telescopeTypeDetailService;

    public TelescopeTypeDetailController(TelescopeTypeDetailService telescopeTypeDetailService) {
        this.telescopeTypeDetailService = telescopeTypeDetailService;
    }

    @Operation(summary = "Получить все типы деталей телескопов")
    @ApiResponse(
            responseCode = "200",
            description = "Список типов деталей успешно получен",
            content = @Content(
                    mediaType = "application/json",
                    array = @ArraySchema(schema = @Schema(implementation = TelescopeTypeDetail.class))
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
                            value = ApiErrorExamplesTypeDetail.UNAUTHORIZED_ERROR
                    )
            )
    )
    @GetMapping
    public List<TelescopeTypeDetail> findTelescopeAllTypeDetail() {
        return telescopeTypeDetailService.findAllTelescopeTypeDetail();
    }

    @Operation(summary = "Получить тип детали телескопа по id")
    @ApiResponse(
            responseCode = "200",
            description = "Тип детали успешно получен",
            content = @Content(schema = @Schema(implementation = TelescopeTypeDetail.class))
    )
    @ApiResponse(
            responseCode = "401",
            description = "Ошибка авторизации",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ApiErrorResponse.class),
                    examples = @ExampleObject(
                            name = "Authorization error",
                            value = ApiErrorExamplesTypeDetail.UNAUTHORIZED_ERROR
                    )
            )
    )
    @ApiResponse(
            responseCode = "404",
            description = "Тип детали не найден",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ApiErrorResponse.class),
                    examples = @ExampleObject(
                            name = "Not Found",
                            value = ApiErrorExamplesTypeDetail.NOT_FOUND_ERROR
                    )
            )
    )
    @GetMapping("/{id}")
    public ResponseEntity<TelescopeTypeDetail> getTelescopeTypeDetailById(@PathVariable Long id) {
        Optional<TelescopeTypeDetail> typeDetail = telescopeTypeDetailService.findTelescopeTypeDetail(id);
        return typeDetail.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Создать новый тип детали телескопа")
    @ApiResponse(
            responseCode = "200",
            description = "Тип детали успешно создан",
            content = @Content(schema = @Schema(implementation = TelescopeTypeDetail.class))
    )
    @ApiResponse(
            responseCode = "401",
            description = "Ошибка авторизации",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ApiErrorResponse.class),
                    examples = @ExampleObject(
                            name = "Authorization error",
                            value = ApiErrorExamplesTypeDetail.UNAUTHORIZED_ERROR
                    )
            )
    )
    @ApiResponse(
            responseCode = "403",
            description = "Ошибка доступа",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ApiErrorResponse.class),
                    examples = @ExampleObject(
                            name = "Forbidden",
                            value = ApiErrorExamplesTypeDetail.FORBIDDEN_ERROR
                    )
            )
    )
    @ApiResponse(
            responseCode = "400",
            description = "Ошибки валидации: пустое имя, недопустимая длина и т.п.",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ApiErrorResponse.class),
                    examples = @ExampleObject(
                            name = "Validation Error",
                            value = ApiErrorExamplesTypeDetail.VALIDATION_ERROR
                    )
            )
    )
    @ApiResponse(
            responseCode = "409",
            description = "Тип детали с таким именем уже существует",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ApiErrorResponse.class),
                    examples = @ExampleObject(
                            name = "Conflict Error",
                            value = ApiErrorExamplesTypeDetail.CONFLICT_ERROR
                    )
            )
    )
    @PostMapping
    public TelescopeTypeDetail createTelescopeTypeDetail(
            @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Данные для создания типа детали",
            required = true,
            content = @Content(
                    schema = @Schema(implementation = CreateTelescopeTypeDetailRequest.class)
            )
    )
            @Valid @RequestBody CreateTelescopeTypeDetailRequest request) {
        return telescopeTypeDetailService.createTelescopeTypeDetail(request);
    }

    @Operation(summary = "Удалить тип детали телескопа по ID")
    @ApiResponse(
            responseCode = "204",
            description = "Тип детали успешно удалён",
            content = @Content()
    )
    @ApiResponse(
            responseCode = "401",
            description = "Ошибка авторизации",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ApiErrorResponse.class),
                    examples = @ExampleObject(
                            name = "Authorization error",
                            value = ApiErrorExamplesTypeDetail.UNAUTHORIZED_ERROR
                    )
            )
    )
    @ApiResponse(
            responseCode = "403",
            description = "Ошибка доступа",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ApiErrorResponse.class),
                    examples = @ExampleObject(
                            name = "Forbidden",
                            value = ApiErrorExamplesTypeDetail.FORBIDDEN_ERROR
                    )
            )
    )
    @ApiResponse(
            responseCode = "404",
            description = "Тип детали не найден",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ApiErrorResponse.class),
                    examples = @ExampleObject(
                            name = "Not Found",
                            value = ApiErrorExamplesTypeDetail.NOT_FOUND_ERROR
                    )
            )
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTelescopeTypeDetail(
            @Parameter(description = "Уникальный идентификатор удаляемого типа детали", example = "5")
            @PathVariable Long id) {
        telescopeTypeDetailService.deleteTelescopeTypeDetail(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Обновить тип детали телескопа по ID")
    @ApiResponse(
            responseCode = "200",
            description = "Тип детали успешно обновлен",
            content = @Content(schema = @Schema(implementation = TelescopeTypeDetail.class))
    )
    @ApiResponse(
            responseCode = "401",
            description = "Ошибка авторизации",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ApiErrorResponse.class),
                    examples = @ExampleObject(
                            name = "Authorization error",
                            value = ApiErrorExamplesTypeDetail.UNAUTHORIZED_ERROR
                    )
            )
    )
    @ApiResponse(
            responseCode = "403",
            description = "Ошибка доступа",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ApiErrorResponse.class),
                    examples = @ExampleObject(
                            name = "Forbidden",
                            value = ApiErrorExamplesTypeDetail.FORBIDDEN_ERROR
                    )
            )
    )
    @ApiResponse(
            responseCode = "400",
            description = "Ошибки валидации: пустое имя, недопустимая длина и т.п.",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ApiErrorResponse.class),
                    examples = @ExampleObject(
                            name = "Validation Error",
                            value = ApiErrorExamplesTypeDetail.VALIDATION_ERROR
                    )
            )
    )
    @ApiResponse(
            responseCode = "404",
            description = "Тип детали не найден",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ApiErrorResponse.class),
                    examples = @ExampleObject(
                            name = "Not Found",
                            value = ApiErrorExamplesTypeDetail.NOT_FOUND_ERROR
                    )
            )
    )
    @ApiResponse(
            responseCode = "409",
            description = "Тип детали с таким именем уже существует",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = ApiErrorResponse.class),
                    examples = @ExampleObject(
                            name = "Conflict Error",
                            value = ApiErrorExamplesTypeDetail.CONFLICT_ERROR
                    )
            )
    )
    @PutMapping("/{id}")
    public ResponseEntity<TelescopeTypeDetail> updateTelescopeTypeDetail(
            @Parameter(description = "Уникальный идентификатор обновлемого типа детали", example = "5")
            @PathVariable Long id,
            @Valid @RequestBody TelescopeTypeDetailUpdateRequest request) {
        TelescopeTypeDetail updated = telescopeTypeDetailService.updateTelescopeTypeDetail(id, request);
        return ResponseEntity.ok(updated);
    }
}
