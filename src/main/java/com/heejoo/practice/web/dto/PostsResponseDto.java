package com.heejoo.practice.web.dto;

import com.heejoo.practice.domain.posts.Posts;
import lombok.Getter;

@Getter
public class PostsResponseDto {

    private Long id;
    private String title;
    private String content;
    private String author;

    //Entity 의 필드중 일부만 사용하므로 생성자로 엔티티를 받아 필드에 값을 할당
    public PostsResponseDto(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
    }
}
