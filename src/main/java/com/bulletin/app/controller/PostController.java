package com.bulletin.app.controller;

import com.bulletin.app.dto.response.PostDTO;
import com.bulletin.app.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("post")
public class PostController {
    private final PostService service;

    @GetMapping
    public ResponseEntity<List<PostDTO>> getListPost() {
        List<PostDTO> list = service.getListPost();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public String getDetailPost(@PathVariable String id) {
        return "detail post";
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
