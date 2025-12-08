package com.example.stargazer_service.dto.detail.attribute.value;

public class ApiErrorExamplesDetailAttributeValue {
    public static final String VALIDATION_ERROR = """
        {
          "error": "Validation Failed",
          "errorMessage": {
            "value": "Значение характеристики детали не должно быть null",
            "idDetail":"Идентификатор детали обязателен для заполнения",
            "idDetailAttribute":"Идентификатор атрибута детали обязателен для заполнения",
            "description":"Описание характеристики детали должно быть от 1 до 255 символов"
          }
        }
        """;

    public static final String CONFLICT_ERROR = """
        {
          "error": "Conflict",
          "errorMessage": {
            "message": "Значение характеристики детали телескопа с таким именем уже существует"
          }
        }
        """;

    public static final String NOT_FOUND_ERROR = """
        {
          "error": "Not Found",
          "errorMessage": {
            "message": "Значение характеристики детали не найдена"
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


    private ApiErrorExamplesDetailAttributeValue() {}
}
