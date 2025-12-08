package com.example.stargazer_service.dto.detail.type;

public class ApiErrorExamplesTypeDetail {
    public static final String VALIDATION_ERROR = """
        {
          "error": "Validation Failed",
          "errorMessage": {
            "name": "Название типа детали не должно быть null"
          }
        }
        """;

    public static final String CONFLICT_ERROR = """
        {
          "error": "Conflict",
          "errorMessage": {
            "message": "Название типа детали с таким именем уже существует"
          }
        }
        """;

    public static final String NOT_FOUND_ERROR = """
        {
          "error": "Not Found",
          "errorMessage": {
            "message": "Название типа детали не найдено"
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

    private ApiErrorExamplesTypeDetail() {}
}
