package com.quan.blog.service.Impl;


import com.quan.blog.dao.TypeDao;
import com.quan.blog.entity.Type;
import com.quan.blog.exception.NotFountException;
import com.quan.blog.service.TypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {

    @Autowired
    private TypeDao typeDao;

    //事务注解
    @Transactional
    @Override
    public int saveType(Type type) {
        return typeDao.saveType(type);
    }

    @Transactional
    @Override
    public Type getType(Long id) {
        return typeDao.getTypeById(id);
    }

    @Transactional
    @Override
    public List<Type> getAllType() {
        return typeDao.getAllType();
    }

    @Override
    public List<Type> getAdminType() {
        return typeDao.getAdminType();
    }

    @Transactional
    @Override
    public Type getTypeByName(String name) {
        return typeDao.getTypeByName(name);
    }

    @Transactional
    @Override
    public int updateType(Long id,Type type) {
        Type typeById = typeDao.getTypeById(id);
        if (typeById == null){
            throw new NotFountException("不存在该分类");
        }
        BeanUtils.copyProperties(type,typeById);
        return typeDao.updateType(typeById);
    }

    @Transactional
    @Override
    public int deleteType(Long id) {
        return typeDao.deleteType(id);
    }

}
