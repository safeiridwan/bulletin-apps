package com.bulletin.app.dto.response;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DetailPostDTO {
    private Long id;
    private String title;
    private String author;
    private String content;
    private Integer viewers;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
