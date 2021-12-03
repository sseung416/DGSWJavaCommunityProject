package kr.hs.dgsw.java.community.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Post {
    private int idx;

    private String title;

    private String content;

    private String writer;

    private String writeTime;
}
