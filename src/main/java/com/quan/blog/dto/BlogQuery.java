package com.quan.blog.dto;

import com.quan.blog.entity.Type;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 博客列表页显示数据所使用的类
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogQuery {
    private Long id;
    private String title;
    private String flag;
    private Date updateTime;
    private Integer recommend;
    private Long typeId;
    private Integer published;

    private Type type;
}
