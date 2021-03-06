package kr.hs.dgsw.java.community.controller;

import kr.hs.dgsw.java.community.domain.Post;
import kr.hs.dgsw.java.community.mapper.CommunityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;

@Controller
public class CommunityController {

    @Autowired
    private CommunityMapper communityMapper;

    @RequestMapping("/")
    public String home(Model model) {
        List<Post> postList = communityMapper.getPostList();

        model.addAttribute("postList", postList);

        return "home";
    }

    @RequestMapping("/detail")
    public String postDetail(@RequestParam(value = "idx") Integer idx, Model model) {
        Post post = communityMapper.getPost(idx);

        model.addAttribute("post", post);

        return "detail";
    }

    @GetMapping("/write")
    public String write(@RequestParam(value = "idx", required = false) Integer idx, Model model) {
        // @RequestParam 에 int 값 넣으면 url 에서 null 반환함 -> Integer 로 변경
        Post post;

        if (idx == null) {
            post = new Post();
        } else {
            post = communityMapper.getPost(idx);
        }

        model.addAttribute("post", post);

        return "write";
    }

    @RequestMapping("/write/fin")
    public String writeFinish(Post post) {
        Calendar cal = Calendar.getInstance();
        java.sql.Date writeDate = new java.sql.Date(cal.getTimeInMillis());

        if (post.getIdx() == null) {
            communityMapper.insert(
                    post.getTitle(),
                    post.getContent(),
                    post.getWriter(),
                    writeDate
            );
        } else {
            communityMapper.update(
                    post.getIdx(),
                    post.getContent(),
                    post.getTitle(),
                    post.getWriter()
            );
        }

        return "redirect:/";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam(value = "idx") Integer idx) {
        communityMapper.delete(idx);
        return "redirect:/";
    }
}
