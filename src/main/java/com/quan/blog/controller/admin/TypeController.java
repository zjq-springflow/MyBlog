package com.quan.blog.controller.admin;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.quan.blog.entity.Type;
import com.quan.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Controller
@RequestMapping("admin")
public class TypeController {

    @Autowired
    private TypeService typeService;

    //列表页
    @GetMapping("/types")
    public String list(Model model,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) {
        PageHelper.startPage(pageNum, 3);
        List<Type> allType = typeService.getAdminType();
        //得到分页结果对象
        PageInfo<Type> pageInfo = new PageInfo<>(allType);
        model.addAttribute("pageInfo", pageInfo);
        return "admin/types";
    }

    //去新增页面
    @GetMapping("/types/input")
    public String toAdd() {
        return "admin/types-input";
    }


    //Add
    @PostMapping("/types/add")
    public String Add(Type type, RedirectAttributes attributes) {
        Type typeByName = typeService.getTypeByName(type.getName());
        if (typeByName != null) {
            attributes.addFlashAttribute("message", "不能添加重复的类");
            return "redirect:/admin/types/input";
        } else{
            //添加操作
            typeService.saveType(type);
            attributes.addFlashAttribute("message", "添加成功");
            return "redirect:/admin/types";
        }
    }


    //到修改页面
    @GetMapping("/types/input/{id}")
    public String editInput(@PathVariable Long id, Model model) {
        Type type = typeService.getType(id);
        model.addAttribute("type", type);
        return "admin/types-input";
    }

    //进行修改
    @PostMapping("/types/update")
    public String editPost(Type type,RedirectAttributes attributes) {
        Type typeByName = typeService.getTypeByName(type.getName());
        String name = typeService.getType(type.getId()).getName();
        if (name.equals(type.getName()) || typeByName != null) {
            attributes.addFlashAttribute("message", "修改的分类名已存在，请重新修改");
            attributes.addFlashAttribute("type", type);
            return "redirect:/admin/types/input";
        } else{
            //修改操作
            typeService.updateType(type.getId(),type);
            attributes.addFlashAttribute("message", "修改成功");
            return "redirect:/admin/types";
        }
    }


    //删除
    @GetMapping("/types/delete/{id}")
    public String delete(@PathVariable Long id, RedirectAttributes attributes) {
        typeService.deleteType(id);
        attributes.addFlashAttribute("message", "删除成功");
        return "redirect:/admin/types";
    }
}
