package kr.hs.dgsw.java.community.service;

import kr.hs.dgsw.java.community.domain.Post;
import kr.hs.dgsw.java.community.mapper.CommunityMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommunityService implements CommunityMapper {

    @Override
    public List<Post> getPostList() {
        return new ArrayList<>();
    }

    @Override
    public void insert() {

    }

    @Override
    public void update(String content, String title, String writer) {

    }

    @Override
    public void delete() {

    }
}
