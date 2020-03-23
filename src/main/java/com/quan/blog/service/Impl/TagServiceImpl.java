package com.quan.blog.service.Impl;


import com.quan.blog.dao.TagDao;
import com.quan.blog.entity.Tag;
import com.quan.blog.service.TagService;
import com.quan.blog.utils.ToList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagDao tagDao;

    @Override
    public int saveTag(Tag tag) {
        return tagDao.saveTag(tag);
    }

    @Override
    public int deleteTag(Long id) {
        return tagDao.deleteTag(id);
    }

    @Override
    public int updateTag(Tag tag) {
        return tagDao.updateTag(tag);
    }

    @Override
    public Tag getById(Long id) {
        return tagDao.getById(id);
    }

    @Override
    public Tag getByName(String name) {
        return tagDao.getByName(name);
    }

    @Override
    public List<Tag> getAllTag() {
        return tagDao.getAllTag();
    }

    @Override
    public List<Tag> getTagByString(String text) {
        List<Tag> tags = new ArrayList<>();
        List<Long> longs = ToList.convertToLongList(text);
        for (Long aLong : longs) {
            tags.add(tagDao.getById(aLong));
        }
        return tags;
    }

    @Override
    public List<Tag> getAdminTag() {
        return tagDao.getAdminTag();
    }
}
