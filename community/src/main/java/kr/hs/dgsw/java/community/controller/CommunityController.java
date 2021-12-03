package kr.hs.dgsw.java.community.controller;

import kr.hs.dgsw.java.community.domain.Post;
import kr.hs.dgsw.java.community.mapper.CommunityMapper;
import kr.hs.dgsw.java.community.service.CommunityService;
import org.apache.coyote.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CommunityController {

    @Autowired
    private CommunityService communityService;

    @Autowired
    private CommunityMapper communityMapper;

    @RequestMapping("/")
    public String home(Model model) {
        List<Post> postList = communityMapper.getPostList();

        model.addAttribute("postList", postList);

        return "home";
    }

    @RequestMapping("/detail/{idx}")
    public String postDetail(@PathVariable("idx") int idx, Model model) {
        return "post-detail";
    }

//    @PutMapping("/{idx}")
//    public RequestEntity<?> putPost(@PathVariable("idx") int idx, @RequestBody Post post) {
//        return new RequestEntity<Post>("{}", HttpStatus.OK);
//    }
//
//    @DeleteMapping("/{idx}")
//    public RequestEntity<?> deletePost(@PathVariable("idx") int idx) {
//        return new RequestEntity<>("{}", HttpStatus.OK);
//    }
}
