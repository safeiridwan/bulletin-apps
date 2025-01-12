package com.bulletin.app.service;

import com.bulletin.app.common.response.ResponseAPI;
import org.springframework.http.ResponseEntity;


public interface PostService {
    ResponseEntity<ResponseAPI> getListPost();
    ResponseEntity<ResponseAPI> getDetailPost(Long id);
}
