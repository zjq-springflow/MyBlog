package com.quan.blog.controller;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.quan.blog.dto.DetailedBlog;
import com.quan.blog.dto.FirstPageBlog;
import com.quan.blog.dto.RecommendBlog;
import com.quan.blog.entity.Comment;
import com.quan.blog.entity.Tag;
import com.quan.blog.entity.Type;
import com.quan.blog.service.BlogService;
import com.quan.blog.service.CommentService;
import com.quan.blog.service.TagService;
import com.quan.blog.service.TypeService;
import com.quan.blog.utils.ToList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;


@Controller
public class IndexController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private TagService tagService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private CommentService commentService;

    @GetMapping("/")
    public String index(Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) {
        PageHelper.startPage(pageNum, 4);
        List<FirstPageBlog> allFirstPageBlog = blogService.getAllFirstPageBlog();
        //转换tags
        for (FirstPageBlog firstPageBlog : allFirstPageBlog) {
            List<Long> tagIds = ToList.convertToLongList(firstPageBlog.getTagIds());
            List<String> tagNames = new ArrayList<>();
            for (Long tagId : tagIds) {
                tagNames.add(tagService.getById(tagId).getName());
            }
            firstPageBlog.setTrueTagIds(tagNames);
        }

        List<Type> allType = typeService.getAllType();

        List<Tag> allTag = tagService.getAllTag();

        List<RecommendBlog> recommendedBlog = blogService.getRecommendedBlog();
        PageInfo<FirstPageBlog> pageInfo = new PageInfo<>(allFirstPageBlog);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("tags", allTag);
        model.addAttribute("types", allType);
        model.addAttribute("recommendedBlogs", recommendedBlog);
        return "user/index";
    }

    @GetMapping("/search")
    public String search(Model model,
                         @RequestParam(defaultValue = "1", value = "pageNum") Integer pageNum,
                         @RequestParam String query) {
        PageHelper.startPage(pageNum, 4);
        List<FirstPageBlog> searchBlogs = blogService.getSearchBlog(query);
        //转换tags
        for (FirstPageBlog searchBlog : searchBlogs) {
            List<Long> tagIds = ToList.convertToLongList(searchBlog.getTagIds());
            List<String> tagNames = new ArrayList<>();
            for (Long tagId : tagIds) {
                tagNames.add(tagService.getById(tagId).getName());
            }
            searchBlog.setTrueTagIds(tagNames);
        }
        PageInfo<FirstPageBlog> pageInfo = new PageInfo<>(searchBlogs);
        model.addAttribute("pageInfo", pageInfo);
        model.addAttribute("query", query);
        return "user/search";
    }


    @GetMapping("/blog/{id}")
    public String blog(@PathVariable Long id, Model model) {
        blogService.addViews(id);
        DetailedBlog detailedBlog = blogService.getDetailedBlog(id);
        List<Comment> comments = commentService.listCommentByBlogId(id);
        model.addAttribute("comments", comments);
        model.addAttribute("blog", detailedBlog);
        return "user/blog";
    }
}
