package com.bulletin.app.service;

import com.bulletin.app.dto.response.PostDTO;

import java.util.List;

public interface PostService {
    List<PostDTO> getListPost();
}
