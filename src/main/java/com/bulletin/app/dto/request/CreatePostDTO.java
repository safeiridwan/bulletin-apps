package com.bulletin.app.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreatePostDTO {
    private String author;
    private String password;
    private String title;
    private String content;
}
