package com.bulletin.app.service;

import com.bulletin.app.common.response.ResponseAPI;
import com.bulletin.app.dto.request.CreatePostDTO;
import com.bulletin.app.dto.request.UpdatePostDTO;
import org.springframework.http.ResponseEntity;


public interface PostService {
    ResponseEntity<ResponseAPI> getListPost();

    ResponseEntity<ResponseAPI> getDetailPost(Long id);

    ResponseEntity<ResponseAPI> createPost(CreatePostDTO request);

    ResponseEntity<ResponseAPI> modifyingPost(Long id, UpdatePostDTO request);

    ResponseEntity<ResponseAPI> deletePost(Long id);
}
