package com.example.stargazer_service.controller.detail.attribute.value;

import com.example.stargazer_service.dto.detail.attribute.CreateTelescopeDetailAttributeRequest;
import com.example.stargazer_service.dto.detail.attribute.TelescopeDetailAttributeUpdateRequest;
import com.example.stargazer_service.dto.detail.attribute.value.CreateTelescopeDetailAttributeValueRequest;
import com.example.stargazer_service.dto.detail.attribute.value.TelescopeDetailAttributeValueUpdateRequest;
import com.example.stargazer_service.model.detail.attribute.TelescopeDetailAttribute;
import com.example.stargazer_service.model.detail.attribute.value.TelescopeDetailAttributeValue;
import com.example.stargazer_service.service.detail.attribute.value.TelescopeDetailAttributeValueService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "v1/detail-attribute-value")
@Tag(name = "Telescope Detail Attribute Value API", description = "API для управления бизнес сущностью Значение характеристики детали")
public class TelescopeDetailAttributeValueController {

    private final TelescopeDetailAttributeValueService telescopeDetailAttributeValueService;

    public TelescopeDetailAttributeValueController(TelescopeDetailAttributeValueService telescopeDetailAttributeValueService) {
        this.telescopeDetailAttributeValueService = telescopeDetailAttributeValueService;
    }

    @GetMapping
    public List<TelescopeDetailAttributeValue> findAllTelescopeDetailAttributeValue() {
        return telescopeDetailAttributeValueService.findAllTelescopeDetailAttributeValue();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TelescopeDetailAttributeValue> getTelescopeDetailAttributeValueById(
            @PathVariable Long id
    )
    {
        TelescopeDetailAttributeValue detailAttributeValue = telescopeDetailAttributeValueService.getTelescopeDetailAttributeValueById(id);
        return ResponseEntity.ok(detailAttributeValue);
    }

    @PostMapping
    public TelescopeDetailAttributeValue createTelescopeDetailAttributeValue(
            @Valid
            @RequestBody
            CreateTelescopeDetailAttributeValueRequest request
    )
    {
        return telescopeDetailAttributeValueService.createTelescopeDetailAttributeValue(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTelescopeDetailAttributeValue(
            @PathVariable
            Long id
    )
    {
        telescopeDetailAttributeValueService.deleteTelescopeDetailAttributeValue(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<TelescopeDetailAttributeValue> updateTelescopeDetailAttributeValue(
            @PathVariable
            Long id,
            @Valid
            @RequestBody
            TelescopeDetailAttributeValueUpdateRequest request
    )
    {
        TelescopeDetailAttributeValue updated = telescopeDetailAttributeValueService.updateTelescopeDetailAttributeValue(id, request);
        return ResponseEntity.ok(updated);
    }
}
