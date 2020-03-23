package com.quan.blog.controller.admin;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.quan.blog.entity.Tag;
import com.quan.blog.entity.Type;
import com.quan.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping("/tags")
    public String list(Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) {
        PageHelper.startPage(pageNum, 4);
        List<Tag> allTag = tagService.getAdminTag();
        PageInfo<Tag> pageInfo = new PageInfo<>(allTag);
        model.addAttribute("pageInfo", pageInfo);
        return "admin/tags";
    }

    //去新增页面
    @GetMapping("/tags/input")
    public String toAdd() {
        return "admin/tags-input";
    }

    @PostMapping("/tags/add")
    public String add(Tag tag, RedirectAttributes attributes) {
        Tag tag1 = tagService.getByName(tag.getName());
        if (tag1 != null) {
            //不为空说明数据库已有
            attributes.addFlashAttribute("message", "已有这个标签，不能添加重复");
            return "redirect:/admin/tags/input";
        }else{
            //添加操作
            tagService.saveTag(tag);
            attributes.addFlashAttribute("message", "添加成功");
            return "redirect:/admin/tags";
        }

    }

    @GetMapping("/tags/input/{id}")
    public String editInput(@PathVariable Long id,Model model) {
        model.addAttribute("tag", tagService.getById(id));
        return "admin/tags-input";
    }

    //进行修改
    @PostMapping("/tags/update")
    public String editPost(Tag tag,RedirectAttributes attributes) {
        Tag tagName = tagService.getByName(tag.getName());
        String name = tagService.getById(tag.getId()).getName();
        if (name.equals(tag.getName()) || tagName != null) {
            attributes.addFlashAttribute("message", "修改的标签名已存在，请重新修改");
            attributes.addFlashAttribute("tag", tag);
            return "redirect:/admin/tags/input";
        } else{
            //修改操作
            tagService.updateTag(tag);
            attributes.addFlashAttribute("message", "修改成功");
            return "redirect:/admin/tags";
        }
    }

    @GetMapping("/tags/delete/{id}")
    public String delete(@PathVariable Long id) {
        tagService.deleteTag(id);
        return "redirect:/admin/tags";
    }
}
