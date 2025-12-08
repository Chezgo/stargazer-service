package com.example.stargazer_service.service.detail.brand;

import com.example.stargazer_service.dto.detail.brand.CreateTelescopeBrandDetailRequest;
import com.example.stargazer_service.dto.detail.brand.TelescopeBrandDetailUpdateRequest;
import com.example.stargazer_service.exception.AlreadyExistsException;
import com.example.stargazer_service.exception.NotFoundException;
import com.example.stargazer_service.model.detail.brand.TelescopeBrandDetail;
import com.example.stargazer_service.repository.detail.brand.TelescopeBrandDetailRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelescopeBrandDetailService {
    private final TelescopeBrandDetailRepository telescopeBrandDetailRepository;

    public TelescopeBrandDetailService(TelescopeBrandDetailRepository telescopeBrandDetailRepository) {
        this.telescopeBrandDetailRepository = telescopeBrandDetailRepository;
    }

    /**
     * Поиск всех наименований брендов деталей телескопа.
     * (@return) Найденный массив сущностей
     */
    public List<TelescopeBrandDetail> findAllTelescopeBrandDetail(){
        return telescopeBrandDetailRepository.findAll();
    }

    /**
     * Поиск брендов детали телескопа по ID.
     *
     * @param id ID бренда детали
     * @throws NotFoundException если сущность не найдена
     * @id739365412 (@return) найденная сущность
     */
    public TelescopeBrandDetail getTelescopeBrandDetailById(Long id) {
        return telescopeBrandDetailRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Бренд не найден"));
    }

    /**
     * Создаёт новый бренд детали телескопа.
     * Проверяет на уровне сервиса:
     * наличие уникальность имени @name
     * Проверяет на уровне контроллера:
     * длину полей @name @description
     * обязательность полей @name @description
     * обязательность заполнения @name @description
     *
     * @id739365412 (@return) сохранённая сущность
     * @throws AlreadyExistsException если имя уже занято
     */
    @Transactional
    public TelescopeBrandDetail createTelescopeBrandDetail(CreateTelescopeBrandDetailRequest request) {

        if (telescopeBrandDetailRepository.existsByName(request.name())) {
            throw new AlreadyExistsException("Бренд детали телескопа с таким именем уже существует");
        }

        TelescopeBrandDetail entity = new TelescopeBrandDetail();
        entity.setName(request.name());
        entity.setDescription(request.description());

        return telescopeBrandDetailRepository.save(entity);

    }

    /**
     * Удаляет бренд детали телескопа по ID.
     * Проверяет наличие данных для удаления.
     *
     * @param id ID бренда детали
     * @throws NotFoundException если сущность не найдена
     */
    @Transactional
    public void deleteTelescopeBrandDetail(Long id) {
        if (!telescopeBrandDetailRepository.existsById(id)) {
            throw new NotFoundException("Бренд детали с ID " + id + " не найден");
        }
        telescopeBrandDetailRepository.deleteById(id);
    }

    /**
     * Обновляет бренд детали телескопа по ID.
     * Проверяет на уровне сервиса:
     * наличие детали @id
     * Проверяет на уровне контроллера:
     * длину полей @name @description
     * обязательность полей @name @description
     * обязательность заполнения @name@description
     *
     * @param id ID бренда детали
     * @id739365412 (@return) Обновлённая сущность
     * @throws NotFoundException если сущность не найдена
     */
    @Transactional
    public TelescopeBrandDetail updateTelescopeBrandDetail(Long id, TelescopeBrandDetailUpdateRequest request) {

        TelescopeBrandDetail entity = telescopeBrandDetailRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Бренд детали не найден"));

        entity.setName(request.name());
        entity.setDescription(request.description());

        return telescopeBrandDetailRepository.save(entity);
    }




}
