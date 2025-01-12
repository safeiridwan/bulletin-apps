package com.bulletin.app.controller;

import com.bulletin.app.common.response.ResponseAPI;
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
    public String createPost() {
        return "create post";
    }

    @PutMapping("/{id}")
    public String modifyPost(@PathVariable String id) {
        return "modify post";
    }

    @DeleteMapping("/{id}")
    public String deletePost(@PathVariable String id) {
        return "delete post";
    }
}
