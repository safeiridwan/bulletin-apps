package com.bulletin.app.dto.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdatePostDTO {
    private String author;
    private String password;
    private String content;
}
