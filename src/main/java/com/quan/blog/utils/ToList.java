package com.quan.blog.utils;

import com.quan.blog.dto.FirstPageBlog;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 张金泉
 * @create 2020-03-20 23:55
 */
public class ToList {
    public static List<Long> convertToLongList(String ids) {
        List<Long> list = new ArrayList<>();
        if (!"".equals(ids) && ids != null) {
            String[] idarray = ids.split(",");
            for (int i=0; i < idarray.length;i++) {
                list.add(new Long(idarray[i]));
            }
        }
        return list;
    }

    public static List<String> convertToStringList(String ids) {
        List<String> list = new ArrayList<>();
        if (!"".equals(ids) && ids != null) {
            String[] idarray = ids.split(",");
            for (int i=0; i < idarray.length;i++) {
                list.add(new String(idarray[i]));
            }
        }
        return list;
    }
}
