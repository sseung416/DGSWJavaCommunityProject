package kr.hs.dgsw.java.community.controller;

import kr.hs.dgsw.java.community.domain.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CommunityController {

    @RequestMapping("/")
    public String home(Model model) {
        List<Post> list = new ArrayList<>();
        Post p = new Post();
        p.setIdx(1);
        p.setContent("a");
        p.setTitle("w");
        p.setWriter("asdf");
        p.setWriteTime("sibal");
        list.add(p);

        model.addAttribute("postList", list);

        return "home";
    }

    @RequestMapping("")
    public String postDetail() {
        return "";
    }
}
