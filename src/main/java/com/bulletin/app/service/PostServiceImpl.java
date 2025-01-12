package com.bulletin.app.service;

import com.bulletin.app.common.mapper.PostMapper;
import com.bulletin.app.dto.response.PostDTO;
import com.bulletin.app.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final PostMapper mapper;

    public List<PostDTO> getListPost() {
        return postRepository.findAllByStatus(true).stream().map(mapper::toDTO).toList();
    }
}
