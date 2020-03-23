package com.quan.blog.controller;


import com.quan.blog.dto.BlogQuery;
import com.quan.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * Created by limi on 2017/10/23.
 */
@Controller
public class ArchiveShowController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/archives")
    public String archives(Model model) {
        Long count = blogService.count();
        List<BlogQuery> allBlog = blogService.getAllBlog();
        model.addAttribute("count",count);
        model.addAttribute("allBlog",allBlog);

        return "user/archives";
    }
}
