package com.quan.blog.dto;

import com.quan.blog.entity.Tag;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FirstPageBlog {
    //Blog
    private Long id;
    private String title;
    private String firstPicture;
    private Integer views;
    private Date updateTime;
    private String description;
    private String tagIds;
    private List<String> trueTagIds;

    //Type
    private String typeName;

    //User
    private String nickname;
    private String avatar;
}
