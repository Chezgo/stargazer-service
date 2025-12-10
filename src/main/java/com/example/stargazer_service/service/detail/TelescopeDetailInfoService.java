package com.example.stargazer_service.service.detail;

import com.example.stargazer_service.dto.detail.PagedResponse;
import com.example.stargazer_service.dto.detail.TelescopeDetailInfoDto;
import com.example.stargazer_service.exception.NotFoundException;
import com.example.stargazer_service.model.detail.TelescopeDetailInfo;
import com.example.stargazer_service.repository.detail.TelescopeDetailInfoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TelescopeDetailInfoService {
    private final TelescopeDetailInfoRepository telescopeDetailInfoRepository;

    public TelescopeDetailInfoService(TelescopeDetailInfoRepository telescopeDetailInfoRepository) {
        this.telescopeDetailInfoRepository = telescopeDetailInfoRepository;
    }

    public TelescopeDetailInfoDto getDetailInfoById(Long id) {
        TelescopeDetailInfo detail = telescopeDetailInfoRepository.findByIdWithDetails(id);
        if (detail == null) {
            throw new NotFoundException("Деталь не найдена");
        }
        return mapToInfoDto(detail);
    }

    public PagedResponse<TelescopeDetailInfoDto> getAllDetails(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<TelescopeDetailInfo> detailPage = telescopeDetailInfoRepository.findAllWithDetails(pageable);

        List<TelescopeDetailInfoDto> content = detailPage.getContent().stream()
                .map(this::mapToInfoDto)
                .collect(Collectors.toList());

        return new PagedResponse<>(
                content,
                detailPage.getNumber(),
                detailPage.getSize(),
                detailPage.getTotalElements(),
                detailPage.getTotalPages()
        );
    }

    private TelescopeDetailInfoDto mapToInfoDto(TelescopeDetailInfo detail) {
        var dto = new TelescopeDetailInfoDto();
        dto.setNameDetail(detail.getName());
        dto.setDescription(detail.getDescription());

        if (detail.getTypeDetail() != null) {
            dto.setNameType(detail.getTypeDetail().getName());
        }

        if (detail.getBrandDetail() != null) {
            dto.setNameBrand(detail.getBrandDetail().getName());
        }

        return dto;
    }
}
