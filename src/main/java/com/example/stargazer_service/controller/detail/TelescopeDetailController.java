package com.example.stargazer_service.controller.detail;

import com.example.stargazer_service.dto.detail.CreateTelescopeDetailRequest;
import com.example.stargazer_service.dto.detail.TelescopeDetailUpdateRequest;
import com.example.stargazer_service.model.detail.TelescopeDetail;
import com.example.stargazer_service.service.detail.TelescopeDetailService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "v1/detail")
@Tag(name = "Telescope Detail API", description = "API для управления бизнес сущностью Детали")
public class TelescopeDetailController {

    private final TelescopeDetailService telescopeDetailService;

    public TelescopeDetailController(TelescopeDetailService telescopeDetailService) {
        this.telescopeDetailService = telescopeDetailService;
    }

    @GetMapping
    public List<TelescopeDetail> findAllTelescopeDetail(){
        return telescopeDetailService.findAllTelescopeDetail();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TelescopeDetail> getTelescopeDetailById(
            @PathVariable
            Long id
    )
    {
        TelescopeDetail detail = telescopeDetailService.getTelescopeDetailById(id);
        return ResponseEntity.ok(detail);
    }

    @PostMapping
    public TelescopeDetail createTelescopeDetail(
            @Valid
            @RequestBody
            CreateTelescopeDetailRequest request
    )
    {
        return telescopeDetailService.createTelescopeDetail(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTelescopeDetail(
            @PathVariable
            Long id
    )
    {
        telescopeDetailService.deleteTelescopeDetail(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TelescopeDetail> updateTelescopeDetail(
            @PathVariable
            Long id,
            @Valid
            @RequestBody
            TelescopeDetailUpdateRequest request
    )
    {
        TelescopeDetail updated = telescopeDetailService.updateTelescopeDetail(id, request);
        return ResponseEntity.ok(updated);
    }

}