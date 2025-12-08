package com.example.stargazer_service.dto.detail.attribute;

public class ApiErrorExamplesDetailAttribute {
    public static final String VALIDATION_ERROR = """
        {
          "error": "Validation Failed",
          "errorMessage": {
            "name": "Название характеристики детали не должно быть null",
            "idTypeDetail":"Идентификатор типа детали обязателен для заполнения",
            "description":"Описание характеристики детали должно быть от 3 до 255 символов"
          }
        }
        """;

    public static final String CONFLICT_ERROR = """
        {
          "error": "Conflict",
          "errorMessage": {
            "message": "Название характеристики детали телескопа с таким именем уже существует"
          }
        }
        """;

    public static final String NOT_FOUND_ERROR = """
        {
          "error": "Not Found",
          "errorMessage": {
            "message": "Характеристика детали не найдена"
          }
        }
        """;

    public static final String UNAUTHORIZED_ERROR = """
        {
          "error": "Authorization error",
          "errorMessage": {
            "message": "Ошибка авторизации"
          }
        }
        """;

    public static final String FORBIDDEN_ERROR = """
        {
          "error": "Forbidden",
          "errorMessage": {
            "message": "Ошибка доступа"
          }
        }
        """;


    private ApiErrorExamplesDetailAttribute() {}
}
