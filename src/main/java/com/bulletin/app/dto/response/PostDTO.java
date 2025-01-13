package com.bulletin.app.dto.response;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class PostDTO {
    private Long id;
    private Long sequence;
    private String title;
    private String author;
    private Integer viewers;
    private LocalDateTime createdAt;
}
