package com.example.stargazer_service.controller.detail;

import com.example.stargazer_service.dto.detail.PagedResponse;
import com.example.stargazer_service.dto.detail.TelescopeDetailInfoDto;
import com.example.stargazer_service.service.detail.TelescopeDetailInfoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Telescope Detail", description = "API для работы с деталями телескопа")
@RestController
@RequestMapping("/api/v1/telescope-details")
public class TelescopeDetailInfoController {
    private final TelescopeDetailInfoService telescopeDetailInfoService;

    public TelescopeDetailInfoController(TelescopeDetailInfoService telescopeDetailInfoService) {
        this.telescopeDetailInfoService = telescopeDetailInfoService;
    }

    @Operation(summary = "Получить деталь по ID", description = "Получить информацию о детали с типом и брендом")
    @GetMapping("/{id}")
    public ResponseEntity<TelescopeDetailInfoDto> getTelescopeDetailInfo(@PathVariable Long id) {
        TelescopeDetailInfoDto detail = telescopeDetailInfoService.getDetailInfoById(id);
        return ResponseEntity.ok(detail);
    }

    @Operation(summary = "Получить список деталей", description = "Получить пагинированный список всех деталей")
    @GetMapping
    public ResponseEntity<PagedResponse<TelescopeDetailInfoDto>> getAllTelescopeDetails(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        PagedResponse<TelescopeDetailInfoDto> response = telescopeDetailInfoService.getAllDetails(page, size);
        return ResponseEntity.ok(response);
    }


}
