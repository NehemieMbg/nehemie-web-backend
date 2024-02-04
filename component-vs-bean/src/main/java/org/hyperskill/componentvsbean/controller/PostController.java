package org.hyperskill.componentvsbean.controller;

import org.hyperskill.componentvsbean.service.PostService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    
    private final PostService postService;
    private final RestTemplate restTemplate;
    
    public PostController(PostService postService, RestTemplate restTemplate) {
        this.postService = postService;
        this.restTemplate = restTemplate;
    }
    
    @GetMapping
    public String findAll() {
        return postService.findAll();
    }
    
    @GetMapping("/load")
    public String loadPosts() {
        return "load-posts";
    }
}
