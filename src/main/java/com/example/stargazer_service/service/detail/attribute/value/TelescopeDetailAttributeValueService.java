package com.example.stargazer_service.service.detail.attribute.value;

import com.example.stargazer_service.dto.detail.attribute.CreateTelescopeDetailAttributeRequest;
import com.example.stargazer_service.dto.detail.attribute.TelescopeDetailAttributeUpdateRequest;
import com.example.stargazer_service.dto.detail.attribute.value.CreateTelescopeDetailAttributeValueRequest;
import com.example.stargazer_service.dto.detail.attribute.value.TelescopeDetailAttributeValueUpdateRequest;
import com.example.stargazer_service.exception.AlreadyExistsException;
import com.example.stargazer_service.exception.NotFoundException;
import com.example.stargazer_service.model.detail.attribute.TelescopeDetailAttribute;
import com.example.stargazer_service.model.detail.attribute.value.TelescopeDetailAttributeValue;
import com.example.stargazer_service.repository.detail.TelescopeDetailRepository;
import com.example.stargazer_service.repository.detail.attribute.TelescopeDetailAttributeRepository;
import com.example.stargazer_service.repository.detail.attribute.value.TelescopeDetailAttributeValueRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelescopeDetailAttributeValueService {
    private final TelescopeDetailAttributeValueRepository telescopeDetailAttributeValueRepository;
    private final TelescopeDetailAttributeRepository telescopeDetailAttributeRepository;
    private final TelescopeDetailRepository telescopeDetailRepository;

    public TelescopeDetailAttributeValueService(TelescopeDetailAttributeValueRepository telescopeDetailAttributeValueRepository, TelescopeDetailAttributeRepository telescopeDetailAttributeRepository, TelescopeDetailRepository telescopeDetailRepository) {
        this.telescopeDetailAttributeValueRepository = telescopeDetailAttributeValueRepository;
        this.telescopeDetailAttributeRepository = telescopeDetailAttributeRepository;
        this.telescopeDetailRepository = telescopeDetailRepository;
    }

    /**
     * Поиск всех значений характеристик деталей телескопа.
     *
     * @return найденный массив сущностей
     */
    public List<TelescopeDetailAttributeValue> findAllTelescopeDetailAttributeValue() {
        return telescopeDetailAttributeValueRepository.findAll();
    }

    /**
     * Поиск значение характеристики детали телескопа по ID.
     *
     * @param id ID значения характеристики детали телескопа
     * @throws NotFoundException если сущность не найдена
     * @return найденная сущность
     */
    public TelescopeDetailAttributeValue getTelescopeDetailAttributeValueById(Long id) {
        return telescopeDetailAttributeValueRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Значение характеристики детали не найдена"));
    }

    /**
     * Создаёт новое значение характеристики детали телескопа.
     * Проверяет на уровне сервиса:
     * наличие детали @idDetail
     * наличие характеристики @idDetailAttribute
     * Проверяет на уровне контроллера:
     * длину полей @value @description
     * обязательность полей @value @description @idDetail @idDetailAttribute
     * обязательность заполнения @value @description @idDetail @idDetailAttribute
     *
     * @return сохранённая сущность
     * @throws AlreadyExistsException если @idDetailAttribute или @idDetail не существуют
     */
    @Transactional
    public TelescopeDetailAttributeValue createTelescopeDetailAttributeValue(CreateTelescopeDetailAttributeValueRequest request) {
        if (!telescopeDetailAttributeRepository.existsById(request.idDetailAttribute())) {
            throw new AlreadyExistsException("Характеристика детали с ID " + request.idDetailAttribute() + " не существует");
        }

        if (!telescopeDetailRepository.existsById(request.idDetail())) {
            throw new AlreadyExistsException("Деталь с ID " + request.idDetail() + " не существует");
        }

        TelescopeDetailAttributeValue entity = new TelescopeDetailAttributeValue();
        entity.setIdDetailAttribute(request.idDetailAttribute());
        entity.setIdDetail(request.idDetail());
        entity.setValue(request.value());
        entity.setDescription(request.description());

        return telescopeDetailAttributeValueRepository.save(entity);
    }

    /**
     * Удаляет значение характеристики детали телескопа по ID.
     * Проверяет наличие данных для удаления.
     *
     * @param id ID значения харктеристики детали
     * @throws NotFoundException если сущность не найдена
     */
    @Transactional
    public void deleteTelescopeDetailAttributeValue(Long id) {
        if (!telescopeDetailAttributeValueRepository.existsById(id)) {
            throw new NotFoundException("Значение характеристики детали с ID " + id + " не найдено");
        }
        telescopeDetailAttributeValueRepository.deleteById(id);
    }

    /**
     * Обновляет значение характеристики детали телескопа по ID.
     * Проверяет на уровне сервиса:
     * наличие детали @idDetail
     * наличие характеристики @idDetailAttribute
     * Проверяет на уровне контроллера:
     * длину полей @value @description
     * обязательность полей @value @description @idDetail @idDetailAttribute
     * обязательность заполнения @value @description @idDetail @idDetailAttribute
     *
     * @param id ID значения характеристики детали
     * @return Обновлённая сущность
     * @throws AlreadyExistsException если @idDetailAttribute или @idDetail не существуют
     * @throws NotFoundException если сущность не найдена
     */
    @Transactional
    public TelescopeDetailAttributeValue updateTelescopeDetailAttributeValue(Long id, TelescopeDetailAttributeValueUpdateRequest request) {

        TelescopeDetailAttributeValue entity = telescopeDetailAttributeValueRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Значение характеристики детали телескопа не найдено"));

        if (!telescopeDetailAttributeRepository.existsById(request.idDetailAttribute())) {
            throw new AlreadyExistsException("Характеристика детали с ID " + request.idDetailAttribute() + " не существует");
        }

        if (!telescopeDetailRepository.existsById(request.idDetail())) {
            throw new AlreadyExistsException("Деталь с ID " + request.idDetail() + " не существует");
        }

        entity.setIdDetailAttribute(request.idDetailAttribute());
        entity.setIdDetail(request.idDetail());
        entity.setValue(request.value());
        entity.setDescription(request.description());

        return telescopeDetailAttributeValueRepository.save(entity);
    }

}
