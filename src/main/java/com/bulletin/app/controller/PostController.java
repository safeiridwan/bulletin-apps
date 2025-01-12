package com.bulletin.app.controller;

import com.bulletin.app.common.response.ResponseAPI;
import com.bulletin.app.dto.request.CreatePostDTO;
import com.bulletin.app.dto.request.UpdatePostDTO;
import com.bulletin.app.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("post")
public class PostController {
    private final PostService service;

    @GetMapping
    public ResponseEntity<ResponseAPI> getListPost() {
        return service.getListPost();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseAPI> getDetailPost(@PathVariable Long id) {
        return service.getDetailPost(id);
    }

    @PostMapping
    public ResponseEntity<ResponseAPI> createPost(@RequestBody CreatePostDTO request) {
        return service.createPost(request);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseAPI> modifyPost(@PathVariable Long id, @RequestBody UpdatePostDTO dto) {
        return service.modifyingPost(id, dto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseAPI> deletePost(@PathVariable Long id) {
        return service.deletePost(id);
    }
}
