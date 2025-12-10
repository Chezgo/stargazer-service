package com.example.stargazer_service.dto.detail;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Schema(description = "Пагинированный ответ")
public class PagedResponse<T> {
    @Schema(description = "Список элементов")
    private List<T> content;

    @Schema(description = "Номер страницы")
    private int page;

    @Schema(description = "Размер страницы")
    private int size;

    @Schema(description = "Общее количество элементов")
    private long totalElements;

    @Schema(description = "Общее количество страниц")
    private long totalPages;

    public PagedResponse(List<T> content, int page, int size, long totalElements, long totalPages) {
        this.content = content;
        this.page = page;
        this.size = size;
        this.totalElements = totalElements;
        this.totalPages = totalPages;
    }

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public long getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(long totalPages) {
        this.totalPages = totalPages;
    }
}
