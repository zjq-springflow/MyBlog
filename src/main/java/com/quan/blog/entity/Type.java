package com.quan.blog.entity;

import com.quan.blog.dto.QianTypeOfBlog;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 张金泉
 * @create 2020-03-19 17:38
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Type {
    private Long id;
    @NotBlank(message = "分类名称不能为空")
    private String name;

    private List<QianTypeOfBlog> blogs;
}
