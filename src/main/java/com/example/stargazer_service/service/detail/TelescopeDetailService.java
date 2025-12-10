package com.example.stargazer_service.service.detail;

import com.example.stargazer_service.dto.detail.CreateTelescopeDetailRequest;
import com.example.stargazer_service.dto.detail.TelescopeDetailUpdateRequest;
import com.example.stargazer_service.exception.AlreadyExistsException;
import com.example.stargazer_service.exception.NotFoundException;
import com.example.stargazer_service.model.detail.TelescopeDetail;
import com.example.stargazer_service.repository.detail.TelescopeDetailRepository;
import com.example.stargazer_service.repository.detail.brand.TelescopeBrandDetailRepository;
import com.example.stargazer_service.repository.detail.type.TelescopeTypeDetailRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TelescopeDetailService {
    private final TelescopeDetailRepository telescopeDetailRepository;
    private final TelescopeTypeDetailRepository telescopeTypeDetailRepository;
    private final TelescopeBrandDetailRepository telescopeBrandDetailRepository;

    public TelescopeDetailService(
            TelescopeDetailRepository telescopeDetailRepository,
            TelescopeTypeDetailRepository typeDetailRepository, TelescopeBrandDetailRepository telescopeBrandDetailRepository) {
        this.telescopeDetailRepository = telescopeDetailRepository;
        this.telescopeTypeDetailRepository = typeDetailRepository;
        this.telescopeBrandDetailRepository = telescopeBrandDetailRepository;
    }

    /**
     * Поиск всех деталей телескопа.
     *
     * @id739365412 (@return) найденный массив сущностей
     */
    public List<TelescopeDetail> findAllTelescopeDetail() {
        return telescopeDetailRepository.findAll();
    }

    /**
     * Поиск детали телескопа по ID.
     *
     * @param id ID детали
     * @throws NotFoundException если сущность не найдена
     * @id739365412 (@return) найденная сущность
     */
    public TelescopeDetail getTelescopeDetailById(Long id) {
        return telescopeDetailRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Деталь не найдена"));
    }

    /**
     * Создаёт новую деталь телескопа.
     * Проверяет на уровне сервиса:
     * уникальность имени @name
     * наличие типа детали @idTypeDetail
     * Проверяет на уровне контроллера:
     * длину полей @name @description
     * обязательность полей @name @description @idTypeDetail
     * обязательность заполнения @name @description @idTypeDetail
     *
     * @id739365412 (@return) сохранённая сущность
     * @throws AlreadyExistsException если имя уже занято
     */
    @Transactional
    public TelescopeDetail createTelescopeDetail(CreateTelescopeDetailRequest request) {
        if (telescopeDetailRepository.existsByName(request.name())) {
            throw new AlreadyExistsException("Деталь телескопа с таким именем уже существует");
        }

        if (!telescopeTypeDetailRepository.existsById(request.idTypeDetail())) {
            throw new AlreadyExistsException("Тип детали с ID " + request.idTypeDetail() + " не существует");
        }
        if (!telescopeBrandDetailRepository.existsById(request.idBrandDetail())) {
            throw new AlreadyExistsException("Бренд детали с ID " + request.idBrandDetail() + " не существует");
        }

        TelescopeDetail entity = new TelescopeDetail();
        entity.setName(request.name());
        entity.setIdTypeDetail(request.idTypeDetail());
        entity.setIdBrandDetail(request.idBrandDetail());
        entity.setDescription(request.description());

        return telescopeDetailRepository.save(entity);

    }

    /**
     * Удаляет тип детали телескопа по ID.
     * Проверяет наличие данных для удаления.
     *
     * @param id ID детали
     * @throws NotFoundException если сущность не найдена
     */
    @Transactional
    public void deleteTelescopeDetail(Long id) {
        if (!telescopeDetailRepository.existsById(id)) {
            throw new NotFoundException("Деталь с ID " + id + " не найдена");
        }
        telescopeDetailRepository.deleteById(id);
    }

    /**
     * Обновляет тип детали телескопа по ID.
     * Проверяет уникальность имени и корректность данных.
     *
     * @param id ID типа детали
     * @id739365412 (@return) Обновлённая сущность
     * @throws AlreadyExistsException если имя уже занято
     * @throws NotFoundException если сущность не найдена
     */
    @Transactional
    public TelescopeDetail updateTelescopeDetail(Long id, TelescopeDetailUpdateRequest request) {

        TelescopeDetail entity = telescopeDetailRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Деталь не найдена"));

        if (telescopeDetailRepository.existsByNameAndIdNot(request.name(), id)) {
            throw new AlreadyExistsException("Деталь телескопа с таким именем уже существует");
        }
        if (!telescopeTypeDetailRepository.existsById(request.idTypeDetail())) {
            throw new AlreadyExistsException("Тип детали с ID " + request.idTypeDetail() + " не существует");
        }
        if (!telescopeBrandDetailRepository.existsById(request.idBrandDetail())) {
            throw new AlreadyExistsException("Бренд детали с ID " + request.idBrandDetail() + " не существует");
        }

        entity.setIdTypeDetail(request.idTypeDetail());
        entity.setIdBrandDetail(request.idBrandDetail());
        entity.setName(request.name());
        entity.setDescription(request.description());

        return telescopeDetailRepository.save(entity);
    }

}
