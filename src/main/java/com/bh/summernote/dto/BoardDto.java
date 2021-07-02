package com.bh.summernote.dto;

import com.bh.summernote.domain.Board;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class BoardDto {

    private Long id;
    private String title;
    private String content;

    public Board toEntity(){
        Board build = Board.builder()
                .title(title)
                .content(content)
                .build();
        return build;
    }

    @Builder
    public BoardDto(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }
}
