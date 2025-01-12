package com.bulletin.app.service;

import com.bulletin.app.common.mapper.PostMapper;
import com.bulletin.app.common.response.ResponseAPI;
import com.bulletin.app.dto.request.CreatePostDTO;
import com.bulletin.app.dto.request.UpdatePostDTO;
import com.bulletin.app.dto.response.PostDTO;
import com.bulletin.app.entity.Post;
import com.bulletin.app.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final PostMapper mapper;

    public ResponseEntity<ResponseAPI> getListPost() {
        List<PostDTO> list = postRepository.findAllByStatus(true).stream().map(mapper::toDTO).toList();
        return ResponseEntity.ok(new ResponseAPI(200, "OK", null, list));
    }

    @Transactional
    public ResponseEntity<ResponseAPI> getDetailPost(Long id) {
        Post post = postRepository.findOneByIdAndStatus(id, true);
        if (post == null) {
            return ResponseEntity.ok(new ResponseAPI(400, "No data found.", null, null));
        }
        postRepository.incrementViewers(id);
        return ResponseEntity.ok(new ResponseAPI(200, "OK", null, mapper.toDetailDTO(post)));
    }

    public ResponseEntity<ResponseAPI> createPost(CreatePostDTO request) {
        Post post = mapper.toEntity(request);
        postRepository.save(post);
        return ResponseEntity.ok(new ResponseAPI(200, "OK", null, post));
    }

    public ResponseEntity<ResponseAPI> modifyingPost(Long id, UpdatePostDTO request) {
        Post post = postRepository.findById(id).orElse(null);
        if (post == null) {
            return ResponseEntity.ok(new ResponseAPI(400, "No data found.", null, null));
        }

        post = mapper.toEntity(request);
        postRepository.save(post);
        return ResponseEntity.ok(new ResponseAPI(200, "OK", null, post));
    }

    public ResponseEntity<ResponseAPI> deletePost(Long id) {
        Post post = postRepository.findById(id).orElse(null);
        if (post == null) {
            return ResponseEntity.ok(new ResponseAPI(400, "No data found.", null, null));
        }

        post.setStatus(false);
        return ResponseEntity.ok(new ResponseAPI(200, "OK", null, post));
    }
}
