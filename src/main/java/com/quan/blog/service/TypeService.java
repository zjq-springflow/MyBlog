package com.quan.blog.service;


import com.quan.blog.entity.Type;

import java.util.List;


public interface TypeService {

    int saveType(Type type);

    Type getType(Long id);

    List<Type> getAllType();

    List<Type> getAdminType();

    Type getTypeByName(String name);

    int updateType(Long id,Type type);

    int deleteType(Long id);


}
