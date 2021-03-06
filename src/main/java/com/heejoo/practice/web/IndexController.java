package com.heejoo.practice.web;

import com.heejoo.practice.config.auth.LoginUser;
import com.heejoo.practice.config.auth.dto.SessionUser;
import com.heejoo.practice.service.PostsService;
import com.heejoo.practice.web.dto.PostsResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class IndexController {

    private final PostsService postsService;

    @GetMapping("/")
    public String index(@LoginUser SessionUser loggedInUser, Model model) {
        model.addAttribute("posts", postsService.findAllDesc());

        if (loggedInUser != null) {
            model.addAttribute("userName", loggedInUser.getName());
        }
        return "index";
    }

    @GetMapping("/posts/save")
    public String postsSave() {
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsSave(@PathVariable Long id, Model model) {
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post", dto);
        return "posts-update";
    }
}
