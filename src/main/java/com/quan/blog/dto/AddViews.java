package com.quan.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author 张金泉
 * @create 2020-03-21 13:49
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddViews {
    private Long id;
    private Integer views;
}
