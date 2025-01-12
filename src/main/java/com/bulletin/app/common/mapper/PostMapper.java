package com.bulletin.app.common.mapper;

import com.bulletin.app.dto.response.PostDTO;
import com.bulletin.app.entity.Post;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostMapper {
    PostDTO toDTO(Post post);
}
