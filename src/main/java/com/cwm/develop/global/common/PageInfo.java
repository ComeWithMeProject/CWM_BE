package com.cwm.develop.global.common;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PageInfo {
    private int page;
    private int size;
    private long totalElements;
    private int totalPages;
}
