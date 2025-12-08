package com.example.stargazer_service.service.detail.attribute;

import com.example.stargazer_service.dto.detail.attribute.CreateTelescopeDetailAttributeRequest;
import com.example.stargazer_service.dto.detail.attribute.TelescopeDetailAttributeUpdateRequest;
import com.example.stargazer_service.exception.AlreadyExistsException;
import com.example.stargazer_service.exception.NotFoundException;
import com.example.stargazer_service.model.detail.attribute.TelescopeDetailAttribute;
import com.example.stargazer_service.repository.detail.attribute.TelescopeDetailAttributeRepository;
import com.example.stargazer_service.repository.detail.type.TelescopeTypeDetailRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TelescopeDetailAttributeService {
    private final TelescopeDetailAttributeRepository telescopeDetailAttributeRepository;
    private final TelescopeTypeDetailRepository telescopeTypeDetailRepository;

    public TelescopeDetailAttributeService(TelescopeDetailAttributeRepository telescopeDetailAttributeRepository,
                                           TelescopeTypeDetailRepository telescopeTypeDetailRepository) {
        this.telescopeDetailAttributeRepository = telescopeDetailAttributeRepository;
        this.telescopeTypeDetailRepository = telescopeTypeDetailRepository;
    }

    /**
     * Поиск всех характеристик деталей телескопа.
     *
     * @return найденный массив сущностей
     */
    public List<TelescopeDetailAttribute> findAllTelescopeDetailAttribute() {
        return telescopeDetailAttributeRepository.findAll();
    }

    /**
     * Поиск характеристики детали телескопа по ID.
     *
     * @param id ID характеристики детали телескопа
     * @throws NotFoundException если сущность не найдена
     * @return найденная сущность
     */
    public TelescopeDetailAttribute getTelescopeDetailAttributeById(Long id) {
        return telescopeDetailAttributeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Характеристика детали не найдена"));
    }

    /**
     * Создаёт новую характеристику детали телескопа.
     * Проверяет на уровне сервиса:
     * уникальность имени @name
     * наличие типа детали @idTypeDetail
     * Проверяет на уровне контроллера:
     * длину полей @name @description
     * обязательность полей @name @description @idTypeDetail
     * обязательность заполнения @name @description @idTypeDetail
     *
     * @return сохранённая сущность
     * @throws AlreadyExistsException если имя уже занято
     */
    @Transactional
    public TelescopeDetailAttribute createTelescopeDetailAttribute(CreateTelescopeDetailAttributeRequest request) {
        if (telescopeDetailAttributeRepository.existsByName(request.name())) {
            throw new AlreadyExistsException("Характеристика детали телескопа с таким именем уже существует");
        }

        if (!telescopeTypeDetailRepository.existsById(request.idTypeDetail())) {
            throw new AlreadyExistsException("Тип детали с ID " + request.idTypeDetail() + " не существует");
        }

        TelescopeDetailAttribute entity = new TelescopeDetailAttribute();
        entity.setName(request.name());
        entity.setIdTypeDetail(request.idTypeDetail());
        entity.setDescription(request.description());

        return telescopeDetailAttributeRepository.save(entity);

    }

    /**
     * Удаляет характеристику детали телескопа по ID.
     * Проверяет наличие данных для удаления.
     *
     * @param id ID харктеристики детали
     * @throws NotFoundException если сущность не найдена
     */
    @Transactional
    public void deleteTelescopeDetailAttribute(Long id) {
        if (!telescopeDetailAttributeRepository.existsById(id)) {
            throw new NotFoundException("Характеристика с ID " + id + " не найдена");
        }
        telescopeDetailAttributeRepository.deleteById(id);
    }

    /**
     * Обновляет характеристику детали телескопа по ID.
     * Проверяет уникальность имени и корректность данных.
     *
     * @param id ID характеристика детали
     * @return Обновлённая сущность
     * @throws AlreadyExistsException если имя уже занято
     * @throws NotFoundException если сущность не найдена
     */
    @Transactional
    public TelescopeDetailAttribute updateTelescopeDetailAttribute(Long id, TelescopeDetailAttributeUpdateRequest request) {

        TelescopeDetailAttribute entity = telescopeDetailAttributeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Характеристика детали телескопа не найдена"));

        if (telescopeDetailAttributeRepository.existsByNameAndIdNot(request.name(), id)) {
            throw new AlreadyExistsException("Характеристика детали телескопа с таким именем уже существует");
        }
        if (!telescopeTypeDetailRepository.existsById(request.idTypeDetail())) {
            throw new AlreadyExistsException("Тип детали с ID " + request.idTypeDetail() + " не существует");
        }

        entity.setIdTypeDetail(request.idTypeDetail());
        entity.setName(request.name());
        entity.setDescription(request.description());

        return telescopeDetailAttributeRepository.save(entity);
    }
}
