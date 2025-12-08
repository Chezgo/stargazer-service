package com.example.stargazer_service.dto.detail;

public class ApiErrorExamplesDetail {
    public static final String VALIDATION_ERROR = """
        {
          "error": "Validation Failed",
          "errorMessage": {
            "name": "Название детали не должно быть null"
          }
        }
        """;

    public static final String CONFLICT_ERROR = """
        {
          "error": "Conflict",
          "errorMessage": {
            "message": "Название детали с таким именем уже существует"
          }
        }
        """;

    public static final String NOT_FOUND_ERROR = """
        {
          "error": "Not Found",
          "errorMessage": {
            "message": "Деталь не найдена"
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

    private ApiErrorExamplesDetail() {}
}
