package com.bulletin.app.service;

import com.bulletin.app.common.mapper.PostMapper;
import com.bulletin.app.common.response.ResponseAPI;
import com.bulletin.app.dto.response.PostDTO;
import com.bulletin.app.entity.Post;
import com.bulletin.app.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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

    public ResponseEntity<ResponseAPI> getDetailPost(Long id) {
        Post post = postRepository.findOneByIdAndStatus(id, true);
        if (post == null) {
            return ResponseEntity.ok(new ResponseAPI(400, "No data found.", null, null));
        }
        return ResponseEntity.ok(new ResponseAPI(200, "OK", null, mapper.toDetailDTO(post)));
    }
}
